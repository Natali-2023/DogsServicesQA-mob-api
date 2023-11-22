package org.ait.dogservices.mob;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper{
    public MainScreenHelper(AndroidDriver driver) {
        super(driver);
    }
                                                           //android.widget.TextView[@text="Dogs Services"]
    public boolean isMainScreenMessagePresent() {
        return isElementPresent(By.tagName("h1"));
    }


    public void tapOnHamburger() {
                                       //android.widget.Button[@text='Toggle navigation']
         waitForElementAndTap(By.xpath("//*[@id='root']/nav/div/button"),20);
    }


    public void getDogSittersByCity(String city) {
        swipe(0.8,0.2);
        type(By.xpath("//*/form/div[2]/div/input"),city);
        tap(By.xpath("//*/form/div[3]/div/div/div[3]"));
        waitForElementAndTap(By.xpath("//*/form/div[4]/button"),20);

    }

    public boolean isDogSittersPresent() {
        swipe(0.8,0.3);
        return isElementPresent(By.xpath("//*/div/div[2]/div/ul/li[1]"));
    }
}