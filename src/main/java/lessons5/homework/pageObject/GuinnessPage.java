package lessons5.homework.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GuinnessPage extends BasePage {

    @FindBy(xpath = "(//input[@class=\"input-large\"])[1]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id=\"FirstName\"]")
    private WebElement firstName;

    @FindBy(xpath = " //input[@placeholder=\"DD\"]")
    private WebElement dayOfMonth;

    @FindBy(xpath = "//input[@name=\"DateOfBirthMonth\"]")
    private WebElement mounthOfYear;

    @FindBy(xpath = "//input[@name=\"DateOfBirthYear\"]")
    private WebElement yearOfYear;

    @FindBy(xpath = "//select[@id='Country']")
    private WebElement country;

    @FindBy(xpath = "//input[contains(@class, 'input-large create-application-name')]")
    private WebElement state;

    @FindBy(xpath = "(//input[@class=\"input-xxlarge\"])[1]")
    private WebElement email;

    @FindBy(xpath = "(//input[@class=\"input-xxlarge\"])[2]")
    private WebElement confirmEmail;

    @FindBy(xpath = "//input[@name=\"Password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@name=\"ConfirmPassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "(//span[@class=\"field-validation-error\"])[1]")
    private WebElement passwordErrorText;

    public GuinnessPage() {
        super();
    }

    public GuinnessPage enterLastName(String lastname) {
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(lastname);
        return this;
    }

    public GuinnessPage enterFirstName(String firstname) {
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(firstname);
        return this;
    }

    public GuinnessPage enterDate(String day, String mouth, String year) {
        wait.until(ExpectedConditions.elementToBeClickable(dayOfMonth))
                .sendKeys(day);
        wait.until(ExpectedConditions.elementToBeClickable(mounthOfYear))
                .sendKeys(mouth);
        wait.until(ExpectedConditions.elementToBeClickable(yearOfYear))
                .sendKeys(year);
        return this;
    }

    public GuinnessPage enterCountry(String countryName) {
        Select countries = new Select(wait.until(ExpectedConditions.elementToBeClickable(country)));
        countries.selectByValue(countryName);
        return this;
    }

    public GuinnessPage enterCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(state)).sendKeys(city);
        return this;
    }

    public GuinnessPage enterEmail(String enterEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(enterEmail);
        return this;
    }

    public GuinnessPage confirmEnterEmail(String enterEmail) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmEmail)).sendKeys(enterEmail);
        return this;
    }

    public GuinnessPage enterPassword(String enterPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(enterPassword);
        return this;
    }

    public GuinnessPage enterConfirmPasswordAndClick(String enterConfirmPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys(enterConfirmPassword);
        confirmPassword.sendKeys(Keys.ENTER);
        return this;
    }

    public String passwordGetErrorText() {
        return wait.until(ExpectedConditions.elementToBeClickable(passwordErrorText)).getText();
    }
}

