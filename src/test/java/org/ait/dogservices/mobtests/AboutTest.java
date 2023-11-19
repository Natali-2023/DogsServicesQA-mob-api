package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutTest extends TestBaseMob{
    @BeforeMethod
    public void precondition(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().getAbout();
    }

    @Test
    public void isAboutComponentPresentTest(){
        Assert.assertTrue(app.getAboutPageHelper().verifyAboutElement().contains("Find"));
    }
}
