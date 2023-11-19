package org.ait.dogservices.mobtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBaseMob {

    @BeforeMethod
    public void precondition() {
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnLoginButton();
        app.getHomePageHelper().enterEmail("bodnata.o@gmail.com");
        app.getHomePageHelper().enterPassword("Aqwert008!");
        app.getHomePageHelper().tapOnLoginSubmit();
    }

    @Test
    public void logoutPositiveTest() {
        app.getHomePageHelper().tapOnHamburger2();
        app.getHomePageHelper().tapLogoutButton();
    }

}