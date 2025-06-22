package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import base.BaseTest;

public class PaymentLogosTest extends BaseTest {

    @Test
    public void testLogos() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertTrue(homePage.isPaymentWrapperDisplayed(),
                "Payment wrapper not displayed");
    }
}