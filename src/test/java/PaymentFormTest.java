import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaymentFormTest extends BaseTest {
    @Test
    public void testForm() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Услуги связи')]")
        )).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Номер телефона']")
        )).sendKeys("297777777");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Сумма']")
        )).sendKeys("100");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Продолжить')]")
        )).click();

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")
        ));
        driver.switchTo().frame(iframe);

        WebElement appWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'app-wrapper')]")
        ));

                Assert.assertTrue(appWrapper.isDisplayed(), "Element app-wrapper not found");
        driver.switchTo().defaultContent();
    }
}