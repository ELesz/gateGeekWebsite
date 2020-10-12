package com.boardgamegeek;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class UsersPage {



    @Test
    public UserGameCollectionPage findUser(String username){
        $(By.xpath("//a[@href='/searchform/user']")).click();
        $(By.xpath("//input[@id='geeksearch']")).setValue(username);
        $(By.xpath("//input[@name='B1']")).click();
        $(By.xpath("//a[@href='/user/"+username+"']")).click();
        //wyrzucic do find by
        return new UserGameCollectionPage();
    }
}
