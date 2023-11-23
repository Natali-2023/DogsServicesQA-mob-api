package org.ait.dogservices.mob;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AndroidDriver<MobileElement> driver;
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

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", false);
        capabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS, chromeOptions);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

      //  driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
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
