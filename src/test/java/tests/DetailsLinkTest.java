package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpPage;
import pages.HomePage;
import base.BaseTest;

public class DetailsLinkTest extends BaseTest {

    @Test
    public void testLink() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickDetailsLink();

        HelpPage helpPage = new HelpPage(driver);
        Assert.assertTrue(helpPage.isHelpPageLoaded(),
                "URL does not contain the expected fragment 'help'");

        driver.navigate().back();
        waitForPageLoad();
    }
}