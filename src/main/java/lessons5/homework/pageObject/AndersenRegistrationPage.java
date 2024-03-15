package lessons5.homework.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndersenRegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name=\"dateOfBirth\"]")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//input[@placeholder=\"Enter email\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder=\"Enter password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@name=\"passwordConfirmation\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href=\"/editAccount\"]")
    private WebElement editAccountIcon;

    public AndersenRegistrationPage() {
        super();
    }

    @Step("Enter first name")
    public AndersenRegistrationPage enterFirstName(String enterFirstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).
                sendKeys(enterFirstName);
        return this;
    }

    @Step("Enter last name")
    public AndersenRegistrationPage enterLastName(String enterLastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).
                sendKeys(enterLastName);
        return this;
    }

    @Step("Enter date of birth")
    public AndersenRegistrationPage enterDateOfBirth(String enterDateOfBirth) {
        wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth)).
                sendKeys(enterDateOfBirth);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Enter email")
    public AndersenRegistrationPage enterEmail(String enterEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).
                sendKeys(enterEmail);
        return this;
    }

    @Step("Enter password")
    public AndersenRegistrationPage enterPassword(String enterPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(password)).
                sendKeys(enterPassword);
        return this;
    }

    @Step("Enter confirm password")
    public AndersenRegistrationPage enterConfirmPassword(String enterConfirmPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).
                sendKeys(enterConfirmPassword);
        return this;
    }

    @Step("Click on the submit button")
    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        submitButton.click();
    }

    @Step("Get element after successful registration")
    public WebElement getElementAfterSuccessfulRegistration() {
        return wait.until(ExpectedConditions.elementToBeClickable(editAccountIcon));
    }
}

