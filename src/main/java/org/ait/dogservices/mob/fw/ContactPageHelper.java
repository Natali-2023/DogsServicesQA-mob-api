package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.nio.charset.Charset;

public class ContactPageHelper extends BaseHelper{
    public ContactPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public String verifyContactElement() {                         //android.widget.TextView[@text="Petscare@gmail.com"]
        return driver.findElement(By.xpath("//body/div[@id='root']/div/section[1]/div[1]/div[3]/span[2]")).getText();
    }
}
