package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(AndroidDriver driver) {
        super(driver);
    }
    public void tapOnLoginButton() {

                                           //android.widget.Button[@text="Betreten"]
        tap(By.xpath("//button[contains(text(),'Betreten')]"));
    }

    public void enterEmail(String email) {    //android.widget.EditText[@resource-id='name-input']
        type(By.xpath("//input[@id='name-input']"),email);
    }

    public void enterPassword(String password) {   //android.widget.EditText[@resource-id='password-input']
        type(By.xpath("//input[@id='password-input']"),password);
    }

    public void tapOnLoginSubmit() {
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
             //   driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Betreten')]"))); (//android.widget.Button[@text='Betreten'])[2]
                                                 //form[@class='auth-form']//button[@type='submit']
        waitForElementAndTap(By.xpath("//button[@type='submit' and contains(text(), 'Betreten')]"),20);

       // waitForElementAndTap(By.xpath("//button[@type='submit' and contains(text(), 'Betreten')]"),20);
    }

    public void tapLogoutButton() {
                                                     //android.widget.Button[@text="Log Out"]
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//button[contains(text(),'Log Out')]")));

        tap(By.xpath("//button[contains(text(),'Log Out')]"));
    }


    public boolean isHelloPresent(){                 //android.widget.TextView[@text='Hallo, Nata']
        return isElementPresent(By.xpath("//*[@id='basic-navbar-nav']/div[2]"));
    }

    public void tapOnHamburger2() {       //html/body/div/nav/div/button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.xpath("//body/div[@id='root']/nav[1]/div[1]/button[1]")));
        tap(By.xpath("//body/div[@id='root']/nav[1]/div[1]/button[1]"));


    }
                                                 //android.widget.TextView[@text='Um']
    public void getAbout() {
         tap(By.xpath("//a[contains(text(),'Um')]"));
    }

                                             //android.widget.TextView[@text="Kontakt"]
    public void getContact() {
        tap(By.xpath("//a[contains(text(),'Kontakt')]"));
    }

    public void getKennels() {             //android.widget.TextView[@text="Kennels"]
        tap(By.xpath("//a[contains(text(),'Kennels')]"));
    }
    public void getClinics(){              //android.widget.TextView[@text="Clinics"]
        tap(By.xpath("//a[contains(text(),'Clinics')]"));
    }


    //android.widget.Image[@text="dog_9"]
    //android.widget.ListView/android.view.View[1]
    //android.widget.Button[@text="Wählen Sie einen Hundesitter"]
    //android.widget.TextView[@text="bis 5 kg"]
    //android.view.View[@resource-id="_mainSection_h9egr_1"]/android.view.View/android.widget.EditText
}
