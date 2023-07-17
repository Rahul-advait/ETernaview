package PageObjects;

import MainBase.BasePage;

import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {
    private WebDriver driver;
    private String ALLOW_COOKIES = "id=>rcc-confirm-button";
    private String NAVBAR_TOGGLE = "class=>navbar-toggler";
    private String LOGIN_REG_BTN = "linkText=>Login/Register";

    public Homepage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void alllowCookies(){
        elementClick(ALLOW_COOKIES, "Allow Cookies");
    }

    public Loginpage clickLoginBtn(){
        elementClick(NAVBAR_TOGGLE, "NAVBAR_TOGGLE btn");
        waitThenClick(LOGIN_REG_BTN, 10, "Login/Register Btn");
        return new Loginpage(driver);
    }
}
