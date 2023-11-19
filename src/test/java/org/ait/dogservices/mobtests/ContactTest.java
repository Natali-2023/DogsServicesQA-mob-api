package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends TestBaseMob{
    @BeforeMethod
    public void precondition(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().getContact();
    }

    @Test
    public void isContactComponentPresentTest(){
        Assert.assertTrue(app.getContactPageHelper().verifyContactElement().contains("Petscare@gmail.com"));
    }
}
