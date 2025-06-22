package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import base.BaseTest;

public class BlockTitleTest extends BaseTest {

    @Test
    public void testTitle() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        boolean isTitleDisplayed = homePage.isOnlinePaymentTitleDisplayed();
        Assert.assertTrue(isTitleDisplayed, "Title 'Онлайн пополнение' not displayed");
    }
}