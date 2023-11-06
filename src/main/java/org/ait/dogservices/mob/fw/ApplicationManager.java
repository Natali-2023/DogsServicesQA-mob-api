package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreen;


    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:platformVersion","8.0");
        capabilities.setCapability("appium:automationName","Appium");
        // для тестирования сайта
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability( "appium:deviceName", "mob");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://hunde24.online/");//URL сайта
        mainScreen = new MainScreenHelper(driver);

    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }


    public void stop() {
        driver.quit();
    }
}
