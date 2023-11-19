package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClinicTests extends TestBaseMob{

    @BeforeMethod
    public void precondition(){
        app.getMainScreen().tapOnHamburger();
        app.getHomePageHelper().getClinics();
    }
    @Test
    public void getAllClinicsTest(){
        app.getClinicPageHelper().tabOnButtonShow();
        Assert.assertTrue(app.getClinicPageHelper().isClinicsPresent());
    }
    @Test
    public void getClinicsByCityTest(){
        app.getClinicPageHelper().selectCity(1);
        app.getClinicPageHelper().tabOnButtonFind();
        Assert.assertTrue(app.getClinicPageHelper().isClinicPresent());
    }
}
