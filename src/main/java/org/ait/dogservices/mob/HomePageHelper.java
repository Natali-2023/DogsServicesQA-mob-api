package org.ait.dogservices.mob;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(AndroidDriver driver) {
        super(driver);
    }
    public void tapOnLoginButton() {


        tap(By.xpath("//button[contains(text(),'Betreten')]"));
    }

    public void enterEmail(String email) {    //android.widget.EditText[@resource-id='name-input']
        type(By.xpath("//input[@id='name-input']"),email);
    }

    public void enterPassword(String password) {   //android.widget.EditText[@resource-id='password-input']
        type(By.xpath("//input[@id='password-input']"),password);
    }

    public void tapOnLoginSubmit() {
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
      //          driver.findElement(By.xpath("//*[@id='modal-avtorisation']/div/div[2]/form/button")));
                                                 //form[@class='auth-form']//button[@type='submit']
     //   tap(By.xpath("//*[@id='modal-avtorisation']/div/div[2]/form/button"));

       // waitForElementAndTap(By.xpath("//button[@type='submit' and contains(text(), 'Betreten')]"),20);
        swipeInElement(By.xpath("//form[@class='auth-form']//button[@type='submit']"),0.8,0.4);
    }

    public void tapLogoutButton() {

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

    public void getAbout() {
         tap(By.xpath("//a[contains(text(),'Um')]"));
    }
    public void getContact() {
        tap(By.xpath("//a[contains(text(),'Kontakt')]"));
    }
    public void getKennels() {             //android.widget.TextView[@text="Kennels"]
        tap(By.xpath("//a[contains(text(),'Kennels')]"));
    }
    public void getClinics(){              //android.widget.TextView[@text="Clinics"]
        tap(By.xpath("//a[contains(text(),'Clinics')]"));
    }


    public void tapOnRegistrationButton() {      //button[contains(text(),'Anmeldung')]
        tap(By.xpath("//*[@id='basic-navbar-nav']/div[3]/div/button"));
    }

    public void fillRegistrationForm(String firstname, String lastname, String username,
                                     String city, String zip,String email, String password,String repeatPassword) {
        type(By.xpath("//input[@id='name-input' and @name='firstName']"),firstname);
        type(By.xpath("//input[@id='name-input' and @name='lastName']"),lastname);
        type(By.xpath("//input[@id='name-input' and @name='userName']"),username);
        pause(300);
        type(By.xpath("//input[@id='name-input' and @name='city']"),city);
        type(By.xpath("//input[@id='name-input' and @name='zip']"),zip);
        pause(300);
        type(By.xpath("//input[@id='name-input' and @name='username']"),email);
        swipe(0.8,0.3);
      //  tap(By.xpath("//*[@id='modal-registration']/div/div[2]/form/div[4]/div/div/button"));
        type(By.xpath("//input[@id='password-input']"),password);
        pause(2000);
        swipe(0.8,0.3);
        swipeInElement(By.xpath("//*[@id='modal-registration']/div/div[2]/form/div[5]/div/div/button"),0.8,0.3);
        type(By.xpath("//input[@id='password-repeat-input']"),repeatPassword);

    }

    public void tapCheckbox() {
        tap(By.xpath("//*[@id='validationCustom01']"));
    }

    public String selectSizeDog(int index) {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='size-input']"));
        dropdown.click();

        List<WebElement> options = driver.findElements(By.xpath("//*[@id='size-input']/option[3]"));
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
            return options.get(index).getText();
        }

        return null;

    }

    public void tapOnRegistrationSubmit() {
        tap(By.xpath("//*[@id='modal-registration']/div/div[2]/form/button"));

    }

    public boolean isMessagePresent() {                          //html/body/div[3]/div/div/div[2]
        return isElementPresent(By.xpath("//div[contains(text(),'Ende der Registrierung')]"));
    }

    public boolean isErrorPresent() {                           //*[@id="modal-registration"]/div/div[2]/form/div[1]
        return isElementPresent(By.xpath("//div[contains(text(),'Cannot read properties of undefined (reading 'forE')]"));
    }
}
