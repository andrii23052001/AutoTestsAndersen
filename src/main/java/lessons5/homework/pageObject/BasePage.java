package lessons5.homework.pageObject;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    public BasePage() {
        this.driver = WebDriverSetup.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToNewTab(List<String> tabs, String title) throws NoSuchWindowException {
        try {
            for (String tab : tabs) {
                driver.switchTo().window(tab);
                if (driver.getTitle().equals(title)) {
                    return;
                }
            }
        } catch (NoSuchWindowException e) {
            throw new NoSuchWindowException(String.format("There is no tab with title: [%s]", title));
        }
    }
}