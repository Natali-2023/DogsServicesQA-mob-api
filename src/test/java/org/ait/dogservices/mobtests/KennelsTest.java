package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KennelsTest extends TestBaseMob{

    @BeforeMethod
    public void precondition(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().getKennels();
    }
    @Test
     public void getAllKennelsTest(){
        app.getKennelPageHelper().tabOnButtonShow();
        Assert.assertTrue(app.getKennelPageHelper().isKennelsPresent());
    }
    @Test
    public void getKennelsByCityTest(){
        app.getKennelPageHelper().swipe(0.8,0.4);
        app.getKennelPageHelper().selectCity(1);
        app.getKennelPageHelper().tabOnButtonFind();
        Assert.assertTrue(app.getKennelPageHelper().isKennelPresent());
    }
}
