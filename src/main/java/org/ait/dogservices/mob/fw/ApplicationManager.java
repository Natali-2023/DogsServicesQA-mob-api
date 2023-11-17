package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AndroidDriver driver;
   // AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreen;


    public void init() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
       // capabilities.setCapability( "deviceName", "mob");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://hunde24.online/front/");

        mainScreen = new MainScreenHelper(driver);

    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }


    public void stop() {
        driver.quit();
    }
}
