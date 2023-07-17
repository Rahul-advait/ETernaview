package TestBase;

import MainBase.Constants;
import PageObjects.Homepage;
import PageObjects.Loginpage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    protected WebDriver driver;
    protected Loginpage loginpage;

    @BeforeClass
    public void beforeSetUp() {
        driver = StartDriverSession.initializeDriver(Constants.BROWSER_NAME, Constants.DEVICE_UUID, Constants.PLATFORM_NAME);
        driver.get(Constants.BASE_URL);
        Homepage homepage = new Homepage(driver);
        homepage.alllowCookies();
        loginpage = homepage.clickLoginBtn();
        loginpage.login();
        loginpage.closeAlert();
    }

    @BeforeMethod
    public void methodSetUp() {
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
