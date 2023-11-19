package org.ait.dogservices.mob.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AndroidDriver driver;
    //AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreen;
    AboutPageHelper aboutPageHelper;
    ClinicPageHelper clinicPageHelper;
    KennelPageHelper kennelPageHelper;
    ContactPageHelper contactPageHelper;
    HomePageHelper homePageHelper;
    FooterPageHelper footerPageHelper;




    public void init() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability( MobileCapabilityType.DEVICE_NAME, "19273c29");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://hunde24.online/front/");

        mainScreen = new MainScreenHelper(driver);
        homePageHelper = new HomePageHelper(driver);
        aboutPageHelper = new AboutPageHelper(driver);
        clinicPageHelper = new ClinicPageHelper(driver);
        kennelPageHelper = new KennelPageHelper(driver);
        contactPageHelper = new ContactPageHelper(driver);
        footerPageHelper = new FooterPageHelper(driver);


    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }

    public AboutPageHelper getAboutPageHelper() {
        return aboutPageHelper;
    }

    public ClinicPageHelper getClinicPageHelper() {
        return clinicPageHelper;
    }

    public KennelPageHelper getKennelPageHelper() {
        return kennelPageHelper;
    }

    public ContactPageHelper getContactPageHelper() {
        return contactPageHelper;
    }

    public FooterPageHelper getFooterPageHelper() {
        return footerPageHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public void stop() {
        driver.quit();
    }
}
