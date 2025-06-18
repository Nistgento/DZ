import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class PaymentLogosTest extends BaseTest {
    @Test
    public void testLogos() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'pay__wrapper')]")
        ));

        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[contains(@class,'pay__wrapper')]//img")
        ));

        Assert.assertFalse(logos.isEmpty(), "No payment system logos were found");

        for(WebElement logo : logos) {
            Assert.assertTrue(logo.isDisplayed(), "The logo is not displayed on the page");
        }
    }
}