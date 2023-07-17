package PageObjects;

import MainBase.BasePage;
import MainBase.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStripe extends BasePage {
    private String STRIPE_PAGE = "stripe";
    private String PAYMENT_THANK_YOU_PAGE = "thank-you-plan";
    private WebDriver driver;
    private String PHONE_FIELD = "css=>input#phoneNumber";
    private String CARD_FIELD = "css=>input#cardNumber";
    private String CARD_EXP = "css=>input#cardExpiry";
    private String CARD_CVV = "css=>input#cardCvc";
    private String BILLING_NAME = "css=>input#billingName";
    private String SUBMIT_BTN = "css=>button[type='submit']";
    private String THANK_YOU_CONTINUE = "css=>.login-btn-h.login-button.signup-h";

    public CheckoutStripe(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        return isOpen(STRIPE_PAGE, 5);
    }

    public boolean enterBillingDetails() {
        WebElement element = waitForElement(PHONE_FIELD, 15, "phone number field");
        sendData(element, Constants.PHONE_NUM, "Phone number field");
        sendData(CARD_FIELD, Constants.STRIPE_TEST_CARD, "Card number");
        sendData(CARD_EXP, Constants.STRIPE_TEST_EXP, "Expiry date field");
        sendData(CARD_CVV, Constants.STRIPE_TEST_CVV, "Cvv number field");
        sendData(BILLING_NAME, Constants.STRIPE_TEST_NAME, "Billing Name");
        elementClick(SUBMIT_BTN, "Submit stripe card details btn");
        return isOpen(PAYMENT_THANK_YOU_PAGE, 15);
    }

    public void clickContinueOnThankYou() {
        elementClick(THANK_YOU_CONTINUE, ".login-btn-h.login-button.signup-h");
    }
}
