package lessons5.homework.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//textarea[@name=\"q\"]")
    private WebElement searchField;

    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "(//h3[@class=\"LC20lb MBeuO DKV0Md\"])[1]")
    private WebElement newTabElement;

    @FindBy(xpath = "(//input[@tabindex=\"0\"])[2]")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@role=\"button\"])[1]")
    private WebElement cleanSearchField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement searchIconButton;

    public GooglePage() {
        super();
    }

    public GooglePage openNewTab() {
        actions.moveToElement(newTabElement)
                .keyDown(Keys.CONTROL)
                .click()
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        return this;
    }

    public GooglePage fillSearchField(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(text);
        return this;
    }

    public GooglePage acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        return this;
    }

    public GooglePage clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public GooglePage cleanSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(cleanSearchField)).click();
        return this;
    }

    public GooglePage clickSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIconButton)).click();
        return this;
    }
}
