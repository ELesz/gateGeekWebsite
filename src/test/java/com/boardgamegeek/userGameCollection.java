package com.boardgamegeek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userGameCollection {

    private WebDriver driver;
    private String username = "testuserr";
    private String gameName = "carcassonne";
    private String gameID = "822";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void gameCollectionOfUserTest(String username) {
        String url = "https://boardgamegeek.com/collection/user/"+username;
        goTo(url);

        WebElement title = driver.findElement(By.xpath("//div[@class='fl sf']"));
        Assert.assertTrue(title.getText().contains(": Board Game Collection")
                            &&title.getText().contains(username));

        WebElement gameName = driver.findElement(By.xpath("//div[@id='results_objectname1']"));
        Assert.assertTrue(gameName.getText().contains("Carcassonne"));
    }

    @Test
    public void findUser(String username){
        String url = "https://boardgamegeek.com/";
        goTo(url);

        WebElement communityButton = driver.findElement(By.className("btn btn-sm ng-binding dropdown-toggle"));
        communityButton.click();
        WebElement findUsers = driver.findElement(By.xpath("//a[@href='/users.php']"));
        findUsers.click();
        WebElement userSearch = driver.findElement(By.xpath("//a[@href='/searchform/user']"));
        userSearch.click();
        WebElement input = driver.findElement(By.xpath("//input[@id='geeksearch']")),
                goButton = driver.findElement(By.xpath("//input[@name='B1']"));
        input.sendKeys(username);
        WebElement userLink = driver.findElement(By.xpath("//a[@href='/user/"+username+"']"));
        userLink.click();

        WebElement title = driver.findElement(By.xpath("//div[@class='fl sf']"));
        Assert.assertTrue(title.getText().contains(": Board Game Collection")
                &&title.getText().contains(username));

        WebElement gameName = driver.findElement(By.xpath("//div[@id='results_objectname1']"));
        Assert.assertTrue(gameName.getText().contains("Carcassonne"));
    }

    @Test
    public void goToGamePageTest(String gameName) {
        String url = "https://boardgamegeek.com/boardgame/" + gameID + "/" + gameName;
        goTo(url);

        WebElement title = driver.findElement(By.xpath("//div[@class='game-header-title-info']"));
        Assert.assertTrue(title.getText().contains("Carcassonne"));

    }

    @Test
    public void findGame(String gameName, String gameID){
        String url = "https://boardgamegeek.com/";
        goTo(url);

        WebElement searchIcon = driver.findElement(By.xpath("//i[@class='fi-magnifying-glass'"));
        searchIcon.click();
        WebElement searchInput = driver.findElement(By.xpath("//input[@class='site-search'"));
        searchInput.sendKeys("carcassonne");
        WebElement searchResult = driver.findElement(By.xpath("//a[@title='Carcassonne']"));
        searchResult.click();

        //Assert.assertEquals(driver.getCurrentUrl(), String url = "https://boardgamegeek.com/boardgame/" + gameID + "/" + gameName);
        WebElement title = driver.findElement(By.xpath("//div[@class='game-header-title-info']"));
        Assert.assertTrue(title.getText().contains("Carcassonne"));
    }




    private void goTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
   /* 3.	Step 3  API Check the information about the game
   - look for poll results about Language Dependence.
4.	Step 4 WEB Verify that the most voted Language Dependence
level is presented on the game's page.
*/



}
