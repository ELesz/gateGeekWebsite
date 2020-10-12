package com.boardgamegeek;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    @FindBy(className = "btn btn-sm ng-binding dropdown-toggle")
    private WebElement communityDropdown;

    @FindBy(xpath = "//a[@href='/users.php']")
    private WebElement findUsers;

    @FindBy(xpath = "//i[@class='fi-magnifying-glass'")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@class='site-search'")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@title='Carcassonne']")
    private WebElement gameTitle;

    public HomePage(){
        //Page Factory??? web driver?
    }

    @Before
    public void setupTest() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        String url = "https://boardgamegeek.com/";
        open(url);
    }

    @Test
    public UsersPage findUsersCollection(String username){
        communityDropdown.click();
        findUsers.click();

        return new UsersPage();
    }

    @Test
    public GamePage findGame(String gameName){
        searchIcon.click();
        searchInput.click();
        gameTitle.click();

        return new GamePage();
    }









}
