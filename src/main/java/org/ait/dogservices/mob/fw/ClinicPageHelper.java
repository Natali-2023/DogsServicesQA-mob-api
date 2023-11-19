package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClinicPageHelper extends BaseHelper{

    public ClinicPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public String selectCity(int index) {
        //android.view.View[@text="City"]
        WebElement dropdown = driver.findElement(By.xpath("//*/div[2]/div[2]/div/form/div[1]/select"));
        dropdown.click();

        List<WebElement> options = driver.findElements(By.xpath("//*/div[2]/div[2]/div/form/div[1]/select/option"));
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
            return options.get(index).getText();
        }

        return null;

    }

    public void tabOnButtonFind() {
        tap(By.xpath("//button[contains(text(),'Find clinics')]"));
    }

    public void tabOnButtonShow() {
        tap(By.xpath("//button[contains(text(),'Show clinic list')]"));
    }

    public boolean isClinicPresent() {
        return isElementPresent(By.xpath("//*/div/ul/li[2]"));
    }

    public boolean isClinicsPresent() {
        return isElementPresent(By.xpath("//*/div/ul"));
    }

//android.view.View[@text="City"]

//android.widget.CheckedTextView[@resource-id="android:id/text1" and @text="Berlin"]

//android.widget.Button[@text="Find clinics"]

//android.widget.ListView/android.view.View[1]

//android.widget.Button[@text="Show clinic list"]
    //android.widget.ListView/android.view.View[3]
}
