package TestBase;

import MainBase.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class StartDriverSession {

    private static AndroidDriver driver;

    public static AndroidDriver initializeDriver(String browser, String uuid, String platFormName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");

        String browserPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe";

        desiredCapabilities.setCapability("chromedriverExecutable", browserPath);
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("appium:uuid", "UGYDN7X88TT47HLB");
        URL remoteUrl;
        try {
            remoteUrl = new URL(Constants.APPIUM_SERVER);
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().deleteAllCookies();

        return driver;
    }


}
