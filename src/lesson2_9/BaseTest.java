package lesson2_9;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        options.addArguments(
                "--remote-allow-origins=*",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-blink-features=AutomationControlled",
                "--start-maximized",
                "--disable-extensions",
                "--disable-infobars",
                "--disable-notifications",
                "--lang=ru"
        );

        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.cookies", 1);
        options.setExperimentalOption("prefs", prefs);

        try {
            driver = new ChromeDriver(options);
            js = (JavascriptExecutor) driver;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://www.mts.by");

            waitForPageLoad();

            handleCookies();
            handlePopups();

        } catch (Exception e) {
            System.err.println("Ошибка при инициализации драйвера: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }

    protected void waitForPageLoad() {
        wait.until(webDriver ->
                js.executeScript("return document.readyState").equals("complete"));
    }

    protected void handleCookies() {
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
                }
            }
        } catch (Exception e) {
            System.out.println("Принятие cookies не требуется или не найдено: " + e.getMessage());
        }
    }

    protected void handlePopups() {
        try {
            By popupClose = By.xpath("//*[contains(@class,'close') or contains(@class,'popup-close')]");
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.elementToBeClickable(popupClose)).click();
            System.out.println("Всплывающее окно закрыто");
        } catch (Exception e) {
        }
    }

    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected void safeClick(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollToElement(element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            js.executeScript("arguments[0].click();", element);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}