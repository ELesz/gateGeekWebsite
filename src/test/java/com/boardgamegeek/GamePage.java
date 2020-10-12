package com.boardgamegeek;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class GamePage {

    @FindBy(xpath = "//div[@class='game-header-title-info']")
    private WebElement gameHeader;


    @Test
    public GamePage checkGame(String gameName){
        $(gameHeader).shouldHave(Condition.text("Carcassonne"));
        return this;
    }
}
