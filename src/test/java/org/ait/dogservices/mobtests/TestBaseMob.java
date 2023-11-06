package org.ait.dogservices.mobtests;

import org.ait.dogservices.mob.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBaseMob {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod

    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }


}
