package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
        tap(By.xpath("//*/form/div[3]/div/div/div[1]"));
        waitForElementAndTap(By.xpath("//*/form/div[4]/button"),20);

    }

    public boolean isDogSittersPresent() {
        return isElementPresent(By.xpath("//*/div/div[2]/div/ul/li[1]"));
    }
}