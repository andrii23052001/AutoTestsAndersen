package lessons5.homework.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndersenLoginPage extends BasePage {

    @FindBy(xpath = "//a[@href=\"/registration\"]")
    private WebElement registrationButton;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder=\"Enter password\"]")
    private WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "(//span[@class=\"absolute right-0 text-rose-500 text-sm\"])[1]")
    private WebElement emailAndPasswordErrorText;

    @FindBy(xpath = "//a[@href=\"/editAccount\"]")
    private WebElement editAccountIcon;

    public AndersenLoginPage() {
        super();
    }

    public void redirectedToTheRegistrationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }

    public AndersenLoginPage enterEmail(String enterEmail) {
        wait.until(ExpectedConditions.visibilityOf(email));
        wait.until(ExpectedConditions.elementToBeClickable(email))
                .sendKeys(enterEmail);
        return this;
    }

    public AndersenLoginPage enterPassword(String enterPassword) {
        wait.until(ExpectedConditions.visibilityOf(password));
        wait.until(ExpectedConditions.elementToBeClickable(password))
                .sendKeys(enterPassword);
        return this;
    }

    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();
    }

    public String getEmailAndPasswordErrorText() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailAndPasswordErrorText)).getText();
    }

    public WebElement getElementAfterSuccessfulAuthorization() {
        return wait.until(ExpectedConditions.elementToBeClickable(editAccountIcon));
    }
}