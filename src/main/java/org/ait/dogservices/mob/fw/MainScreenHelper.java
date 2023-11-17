package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainScreenHelper extends BaseHelper{
    public MainScreenHelper(AndroidDriver driver) {
        super(driver);
    }

    public boolean isMainScreenMessagePresent() {
        return isElementPresent(By.tagName("h1"));
    }


    public String isDogServicesTitlePresent() {
        return  driver.findElement(By.tagName("h1")).getText();
    }


    public void tapOnHamburger() {
        waitForElementAndTap(By.xpath("//button[@class='navbar-toggler']"),30);
    }

    public void tapOnLoginButton() {
        tap(By.xpath("//button[contains(text(),'Log In')]"));
    }

    public void enterEmail(String email) {
        type(By.id("name-input"),email);
    }

    public void enterPassword(String password) {
        type(By.id("password-input"),password);
    }

    public void tapOnLoginSubmit() {
        tap(By.xpath("//button[contains(text(),'Войти')]"));
    }

    public boolean isLogoutPresent() {
        tapOnHamburger();
        return isElementPresent(By.xpath("//button[contains(text(),'Log Out')]"));
    }
}