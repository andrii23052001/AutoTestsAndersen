package lessons5.homework.pageObject;

import io.qameta.allure.Step;
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

    @Step("Redirected to the registration page")
    public void redirectedToTheRegistrationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }

    @Step("Enter email")
    public AndersenLoginPage enterEmail(String enterEmail) {
        wait.until(ExpectedConditions.visibilityOf(email));
        wait.until(ExpectedConditions.elementToBeClickable(email))
                .sendKeys(enterEmail);
        return this;
    }

    @Step("Enter password")
    public AndersenLoginPage enterPassword(String enterPassword) {
        wait.until(ExpectedConditions.visibilityOf(password));
        wait.until(ExpectedConditions.elementToBeClickable(password))
                .sendKeys(enterPassword);
        return this;
    }

    @Step("Click on submit button")
    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();
    }

    @Step("Get email and password error text")
    public String getEmailAndPasswordErrorText() {
        return wait.until(ExpectedConditions.elementToBeClickable(emailAndPasswordErrorText)).getText();
    }

    @Step("Get element after successful authorization")
    public WebElement getElementAfterSuccessfulAuthorization() {
        return wait.until(ExpectedConditions.elementToBeClickable(editAccountIcon));
    }
}