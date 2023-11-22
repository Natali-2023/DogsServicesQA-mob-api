package org.ait.dogservices.mob;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClinicPageHelper extends BaseHelper{

    public ClinicPageHelper(AndroidDriver driver) {
        super(driver);
    }

    public String selectCity(int index) {
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
        //  swipe(0.8,0.3);
        // pause(1000);
        //  swipe(0.8,0.3);
        //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
        //     driver.findElement(By.xpath("//button[contains(text(),'Find clinics')]")));
       // waitForElementAndTap(By.xpath("//button[contains(text(),'Find clinics')]"),30);
      //  WebDriverWait wait = new WebDriverWait(driver, 30);
      //  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Find clinics')]")));
      //  element.click();
        swipeInElement(By.xpath("//button[contains(text(),'Find clinics')]"),0.8,0.3);
    }



    public void tabOnButtonShow() {
//        swipe(0.8,0.3);
//        pause(1000);
//        swipe(0.8,0.3);
        pause(1000);      //*[@id='root']/div/section[2]/div/div[1]/button
        swipeInElement(By.xpath("//button[contains(text(),'Show clinic list')]"),0.8,0.3);
    }

    public boolean isClinicPresent() {
        return isElementPresent(By.xpath("//*/div/ul/li[2]"));
    }

    public boolean isClinicsPresent() {
        return isElementPresent(By.xpath("//*/div/ul"));
    }


}
