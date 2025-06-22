package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePage;

import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[contains(., 'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]")
    private WebElement paymentIframe;

    @FindBy(xpath = "//div[contains(@class, 'app-wrapper')]")
    private WebElement appWrapper;

    @FindBy(xpath = "//div[contains(@class,'pay__wrapper')]//img")
    private List<WebElement> paymentLogos;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterPhoneNumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        safeClick(continueButton);
    }

    public void switchToPaymentFrame() {
        driver.switchTo().frame(paymentIframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public boolean isAppWrapperDisplayed() {
        return appWrapper.isDisplayed();
    }

    public List<WebElement> getPaymentLogos() {
        return paymentLogos;
    }

    public boolean areAllPaymentLogosDisplayed() {
        return paymentLogos.stream().allMatch(WebElement::isDisplayed);
    }

    public String getCardNumberPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Номер карты']")
        )).getAttribute("placeholder");
    }

    public String getExpiryDatePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='ММ/ГГ']")
        )).getAttribute("placeholder");
    }

    public String getCvvPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='CVV']")
        )).getAttribute("placeholder");
    }

    public String getDisplayedPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'payment-info')]//div[contains(., 'Номер телефона')]/following-sibling::div")
        )).getText();
    }

    public String getDisplayedAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'payment-info')]//div[contains(., 'Сумма')]/following-sibling::div")
        )).getText();
    }

    public String getContinueButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'submit-button')]")
        )).getText();
    }
}