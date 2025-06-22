package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class HelpPage extends BasePage {

    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isHelpPageLoaded() {
        return driver.getCurrentUrl().contains("help");
    }
}