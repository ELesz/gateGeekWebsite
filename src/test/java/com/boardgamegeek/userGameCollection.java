package com.boardgamegeek;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class userGameCollection {

    private WebDriver driver;
    private String username = "testuserr";
    private String gameName = "carcassonne";
    private String gameID = "822";

    @Before
    public void setupTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }

    @After
    public void teardown() {

    }

    @Test
    public void gameCollectionOfUserTest(String username) {
        String url = "https://boardgamegeek.com/collection/user/"+username;
        open(url);

        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(": Board Game Collection"));
        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(username));
        $(By.xpath("//div[@id='results_objectname1']")).shouldHave(Condition.text("Carcassonne"));
    }

    @Test
    public void findUser(String username){
        String url = "https://boardgamegeek.com/";
        open(url);

        $(By.className("btn btn-sm ng-binding dropdown-toggle")).click();
        $(By.xpath("//a[@href='/users.php']")).click();
        $(By.xpath("//a[@href='/searchform/user']")).click();
        $(By.xpath("//input[@id='geeksearch']")).setValue(username);
        $(By.xpath("//input[@name='B1']")).click();
        $(By.xpath("//a[@href='/user/"+username+"']")).click();


        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(": Board Game Collection"));
        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(username));
        $(By.xpath("//div[@id='results_objectname1']")).shouldHave(Condition.text("Carcassonne"));
    }

    @Test
    public void goToGamePageTest(String gameName) {
        String url = "https://boardgamegeek.com/boardgame/" + gameID + "/" + gameName;
        open(url);
        $(By.xpath("//div[@class='game-header-title-info']")).shouldHave(Condition.text("Carcassonne"));

    }

    @Test
    public void findGame(String gameName, String gameID){
        String url = "https://boardgamegeek.com/";
        open(url);

        $(By.xpath("//i[@class='fi-magnifying-glass'")).click();
        $(By.xpath("//input[@class='site-search'")).setValue("carcassonne");
        $(By.xpath("//a[@title='Carcassonne']")).click();


        $(By.xpath("//div[@class='game-header-title-info']")).shouldHave(Condition.text("Carcassonne"));
    }

    /* 3.	Step 3  API Check the information about the game
   - look for poll results about Language Dependence.
4.	Step 4 WEB Verify that the most voted Language Dependence
level is presented on the game's page.
*/

//jak podac argumenty dla funkcji

}
