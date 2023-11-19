package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class FooterPageHelper extends BaseHelper{
    public FooterPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public void isFacebookComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver
                .findElement(By.xpath("//body/div[@id='root']/footer[1]/div[1]/div[1]/div[2]/a[1]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());

        }


       tap(By.xpath("//body/div[@id='root']/footer[1]/div[1]/div[1]/div[2]/a[1]"));
    }

    public void isInstagramComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver
                .findElement(By.xpath("//body/div[@id='root']/footer[1]/div[1]/div[1]/div[2]/a[2]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        tap(By.xpath("/html[1]/body[1]/div[1]/footer[1]/div[1]/div[1]/div[2]/a[2]"));
    }

    public void isYoutubeComponentClickable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver
                .findElement(By.xpath("//body/div[@id='root']/footer[1]/div[1]/div[1]/div[2]/a[2]")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tap(By.xpath("//*[@id='root']/footer/div[1]/div[1]/div[2]/a[3]"));

    }
}
