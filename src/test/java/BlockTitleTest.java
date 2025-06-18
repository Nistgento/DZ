import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlockTitleTest extends BaseTest {
    @Test
    public void testTitle() {
        boolean isTitleDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(., 'Онлайн пополнение')]")
        )).isDisplayed();

        Assert.assertTrue(isTitleDisplayed, "Title 'Онлайн пополнение' not displayed");
    }
}