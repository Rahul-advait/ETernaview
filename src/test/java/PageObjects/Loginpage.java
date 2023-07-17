package PageObjects;

import MainBase.BasePage;
import MainBase.Constants;
import MainBase.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage extends BasePage {
    private WebDriver driver;
    private String EMAIL = "cssSelector=>input[name='email']";
    private String PASS = "cssSelector=>input[name='password']";
    private String LOGIN_SUBMIT = "cssSelector=>form button[type='submit']";
    private String SUCCESS_LOGIN_ALERT = "cssSelector=>div[role='alert']";

    private String SUCC_ALERT_CLOSE = "cssSelector=>button[aria-label='close']";
    private String NAV_BAR = "cssSelector=>.navbar-toggler-icon";

    public Loginpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login() {
        sendData(EMAIL, Constants.VALID_EMAIL, "Email Field");
        sendData(PASS, Constants.VALID_PASS, "Pass Field");
        elementClick(LOGIN_SUBMIT, "LOGIN_SUBMIT");
    }

    public boolean isAlertPresent() {
        WebElement element = waitForElement(SUCCESS_LOGIN_ALERT, 15, "Success Login Alert");
        String alertText = element.getText();
        return Util.verifyTextContains(alertText, Constants.LOGIN_SUCCESS_ALERT);
    }

    public void closeAlert() {
        waitThenClick(SUCC_ALERT_CLOSE, 15, "SUCC_ALERT_CLOSE");
    }

    public Createpage navigateToCreatePage() {
        elementClick(NAV_BAR, "Toggle bar");
        return new Createpage(driver);

    }

}
