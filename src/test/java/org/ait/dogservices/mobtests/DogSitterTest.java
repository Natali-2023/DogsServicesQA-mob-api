package org.ait.dogservices.mobtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DogSitterTest extends TestBaseMob{

    @Test
    public void getDogSittersByCityTest(){
        app.getMainScreen().getDogSittersByCity("Berlin");
        Assert.assertTrue(app.getMainScreen().isDogSittersPresent());
    }
}
