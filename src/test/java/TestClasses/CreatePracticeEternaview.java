package TestClasses;

import PageObjects.Createpage;
import PageObjects.Pricingpage;
import TestBase.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreatePracticeEternaview extends Hooks {
    Createpage createpage;
    Pricingpage pricingpage;

    @Test
    public void sampleTest() {
        createpage = loginpage.navigateToCreatePage();
        Assert.assertTrue(createpage.createPaidEternaview());

    }
}
