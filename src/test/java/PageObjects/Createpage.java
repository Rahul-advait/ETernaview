package PageObjects;

import MainBase.BasePage;
import MainBase.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Createpage extends BasePage {
    private WebDriver driver;
    private String CREATE_LINK = "cssSelector=>header li:nth-child(2) a:nth-child(1)";
    private String CREATE_MY_ETERNAVIEW = "cssSelector=>div[class='btn7'] button[class='btn']";
    private String DIRECTION_CONTINUE = "css=>.continue-button";
    private String DIRECTION_TITLE = "css=>.doiect_outer h4";
    private String START_RECORDING_BTN = "css=>.custom_t6 .btn";

    public Createpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean createPaidEternaview() {
        waitThenClick(CREATE_LINK, 10, "CREATE_LINK");
        Util.sleep(3000);
        waitThenClick(CREATE_MY_ETERNAVIEW, 10, "CREATE_MY_ETERNAVIEW");
        WebElement diretionElement = waitForElement(DIRECTION_TITLE, 5, "Direction text");
        if (!diretionElement.getText().contains("Directions")) {
            Pricingpage pricingpage = new Pricingpage(driver);
            CheckoutStripe checkoutStripe = pricingpage.clickPurchaseBtn();
            boolean isPaySucc = checkoutStripe.enterBillingDetails();
            if (isPaySucc) {
                checkoutStripe.clickContinueOnThankYou();
                return true;
            } else {
                return false;
            }
        } else if (diretionElement.getText().contains("Directions")) {
            javascriptScrollToView(DIRECTION_CONTINUE, "Direction Continure Btn");
            elementClick(DIRECTION_CONTINUE, "DIRECTION_CONTINUE");
            WebElement element = waitForElement(START_RECORDING_BTN, 20, "Start Recording Btn");
            String btnText = element.getText();
            return Util.verifyTextMatch(btnText, "START RECORDING");
        } else {
            return false;
        }
    }

}
