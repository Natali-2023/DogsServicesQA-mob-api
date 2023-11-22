package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestMob extends TestBaseMob{

    @Test
    public void registrationDogSitterPositiveTest(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Olya","Brick", "Olya",
                "Bonn","23123","olbrick@gmail.de","Dsaqwe222!","Dsaqwe222!");
        app.getHomePageHelper().tapCheckbox();
        app.getHomePageHelper().pause(200);
        app.getHomePageHelper().selectSizeDog(3);
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isMessagePresent());
    }
    @Test
    public void registrationDogLoverPositiveTest(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Vika","Groy","Viki",
                "Kiel","45234","viki4@gmail.com","Viki7777!","Viki7777!");
        app.getHomePageHelper().pause(200);
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isMessagePresent());
    }
    @Test
    public void registrationExistedDogLoverNegativeTest(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().tapOnRegistrationButton();
        app.getHomePageHelper().fillRegistrationForm("Vika","Groy","Viki",
                "Kiel","45234","viki4@gmail.com","Viki7777!","Viki7777!");
        app.getHomePageHelper().tapOnRegistrationSubmit();

        Assert.assertTrue(app.getHomePageHelper().isErrorPresent());
    }

}
