package com.boardgamegeek;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class UserGameCollectionPage {



    @Test
    public UserGameCollectionPage check(String gameName, String username) {
        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(": Board Game Collection"));
        $(By.xpath("//div[@class='fl sf']")).shouldHave(Condition.text(username));
        $(By.xpath("//div[@id='results_objectname1']")).shouldHave(Condition.text(gameName));
        //wyrzucic do find by
        return this;
    }
}
