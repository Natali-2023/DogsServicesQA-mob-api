package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestMob extends TestBaseMob{

    @Test
    public void loginPositiveTest(){

        app.getMainScreen().tapOnHamburger();
        app.getMainScreen().tapOnLoginButton();
        app.getMainScreen().enterEmail("bodnata.o@gmail.com");
        app.getMainScreen().enterPassword("Aqwert008!");
        app.getMainScreen().tapOnLoginSubmit();

        Assert.assertTrue(app.getMainScreen().isLogoutPresent());

    }
}
