import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DetailsLinkTest extends BaseTest {
    @Test
    public void testLink() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(., 'Подробнее о сервисе')]")
        )).click();

        wait.until(ExpectedConditions.urlContains("help"));
        Assert.assertTrue(driver.getCurrentUrl().contains("help"),
                "URL does not contain the expected fragment 'help'");

        driver.navigate().back();
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
}