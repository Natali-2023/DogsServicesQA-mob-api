package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AboutPageHelper extends BaseHelper{
    public AboutPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public String verifyAboutElement() {           //android.view.View[@content-desc='Find']
        return driver.findElement(By.xpath("//*[@id='root']/div/div/a")).getText();
    }

}
