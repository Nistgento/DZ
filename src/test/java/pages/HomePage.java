package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[contains(., 'Онлайн пополнение')]")
    private WebElement onlinePaymentTitle;

    @FindBy(xpath = "//a[contains(., 'Подробнее о сервисе')]")
    private WebElement detailsLink;

    @FindBy(xpath = "//button[contains(., 'Услуги связи')]")
    private WebElement communicationServicesButton;

    @FindBy(xpath = "//div[contains(@class,'pay__wrapper')]")
    private WebElement paymentWrapper;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.mts.by");
        handleCookies();
        handlePopups();
    }

    public boolean isOnlinePaymentTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(onlinePaymentTitle)).isDisplayed();
    }

    public void clickDetailsLink() {
        safeClick(detailsLink);
    }

    public void clickCommunicationServicesButton() {
        safeClick(communicationServicesButton);
    }

    public boolean isPaymentWrapperDisplayed() {
        return paymentWrapper.isDisplayed();
    }

    private void handleCookies() {
        try {
            By[] cookieSelectors = {
                    By.xpath("//button[contains(., 'Принять') or contains(., 'Accept')]"),
                    By.cssSelector(".cookie-accept, .cookies-accept, #cookie-accept"),
                    By.id("cookie-accept")
            };

            for (By selector : cookieSelectors) {
                try {
                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
                    shortWait.until(ExpectedConditions.elementToBeClickable(selector)).click();
                    System.out.println("Cookies приняты с использованием селектора: " + selector);
                    return;
                } catch (Exception e) {
                    // Ignore and try next selector
                }
            }
        } catch (Exception e) {
            System.out.println("Принятие cookies не требуется или не найдено: " + e.getMessage());
        }
    }

    private void handlePopups() {
        try {
            By popupClose = By.xpath("//*[contains(@class,'close') or contains(@class,'popup-close')]");
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.elementToBeClickable(popupClose)).click();
            System.out.println("Всплывающее окно закрыто");
        } catch (Exception e) {
        }
    }
}