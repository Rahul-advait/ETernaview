package PageObjects;

import MainBase.BasePage;
import org.openqa.selenium.WebDriver;

public class Pricingpage extends BasePage {
    private WebDriver driver;
    private String PURCHASE_BTN = "linkText=>Purchase Now";

    public Pricingpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CheckoutStripe clickPurchaseBtn() {
        waitThenClick(PURCHASE_BTN, 5, "Purchase Now");
        return new CheckoutStripe(driver);
    }
}
