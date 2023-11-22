package org.ait.dogservices.mob;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ContactPageHelper extends BaseHelper{
    public ContactPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public String verifyContactElement() {
        return driver.findElement(By.xpath("//body/div[@id='root']/div/section[1]/div[1]/div[3]/span[2]")).getText();
    }
}
