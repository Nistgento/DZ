package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PaymentPage;
import base.BaseTest;

public class PaymentFormTest extends BaseTest {

    @Test
    public void testForm() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickCommunicationServicesButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterAmount("100");
        paymentPage.clickContinueButton();

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")
        ));
        paymentPage.switchToPaymentFrame();
        Assert.assertTrue(paymentPage.isAppWrapperDisplayed(), "Payment form not displayed");
        paymentPage.switchToDefaultContent();
    }

    @Test
    public void testPlaceholders() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickCommunicationServicesButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterAmount("100");
        paymentPage.clickContinueButton();

        paymentPage.switchToPaymentFrame();

        Assert.assertEquals(paymentPage.getCardNumberPlaceholder(), "Номер карты");
        Assert.assertEquals(paymentPage.getExpiryDatePlaceholder(), "Срок действия");
        Assert.assertEquals(paymentPage.getCvvPlaceholder(), "CVV");

        paymentPage.switchToDefaultContent();
    }

    @Test
    public void testPaymentDetails() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickCommunicationServicesButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterAmount("100");
        paymentPage.clickContinueButton();

        paymentPage.switchToPaymentFrame();

        Assert.assertEquals(paymentPage.getDisplayedPhoneNumber(), "297777777");
        Assert.assertEquals(paymentPage.getDisplayedAmount(), "100 BYN");
        Assert.assertTrue(paymentPage.getContinueButtonText().contains("Оплатить 100 BYN"));
        Assert.assertTrue(paymentPage.areAllPaymentLogosDisplayed());

        paymentPage.switchToDefaultContent();
    }
}