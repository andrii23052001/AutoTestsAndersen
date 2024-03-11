package lessons5.homework.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class W3schoolsPage extends BasePage {

    @FindBy(xpath = "//div[@id=\"accept-choices\"]")
    private WebElement acceptAllButton;

    @FindBy(xpath = "//input[@id=\"fname\"]")
    private WebElement firstNamefield;

    @FindBy(xpath = "//input[@id=\"lname\"]")
    private WebElement lastNamefield;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"w3-panel w3-pale-yellow w3-leftbar w3-border-yellow\"]")
    private WebElement noteText;


    public W3schoolsPage() {
        super();
    }

    public void acceptAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllButton));
        acceptAllButton.click();
    }

    public W3schoolsPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNamefield));
        actions.moveToElement(firstNamefield).doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(firstName).build().perform();
        return this;
    }

    public W3schoolsPage enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNamefield));
        actions.moveToElement(lastNamefield).doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(lastName).build().perform();
        return this;
    }

    public W3schoolsPage clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }

    public String getNoteText() {
        return wait.until(ExpectedConditions.elementToBeClickable(noteText)).getText();
    }
}

