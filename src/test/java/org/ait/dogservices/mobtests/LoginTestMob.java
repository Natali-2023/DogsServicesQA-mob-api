package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestMob extends TestBaseMob{

    @Test
    public void loginPositiveTest(){

        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnLoginButton();
        app.getHomePageHelper().enterEmail("bodnata.o@gmail.com");
        app.getHomePageHelper().enterPassword("Aqwert008!");
        app.getHomePageHelper().pause(1000);
        app.getHomePageHelper().tapOnLoginSubmit();

        Assert.assertTrue(app.getHomePageHelper().isHelloPresent());

    }
}
