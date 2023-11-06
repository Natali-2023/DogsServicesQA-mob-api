package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBaseMob {

    @Test
    public  void  launchAppTest(){
        Assert.assertTrue(app.getMainScreen().isMainScreenMessagePresent());
    }
}
