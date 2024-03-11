package lesson4;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RegistrationAutoTest extends WebDriverSetup {

    private static final By FIRST_NAME_INPUT_SELECTOR = By.cssSelector("input[name=\"firstName\"]");
    private static final By LAST_NAME_INPUT_SELECTOR = By.cssSelector("[placeholder=\"Last Name\"]");
    private static final By DATE_OF_BIRTH_INPUT_SELECTOR = By.cssSelector("[name=\"dateOfBirth\"]");
    private static final By EMAIL_INPUT_SELECTOR_REG = By.cssSelector("[name='email']");
    private static final By PASSWORD_INPUT_SELECTOR_REG = By.xpath("//*[@type=\"password\"][1]");
    private static final By CONFIRM_PASSWORD_INPUT_SELECTOR = By.xpath("//*[@placeholder=\"Confirm Password\"]");

    private static final String REGISTRATION_URL = "https://qa-course-01.andersenlab.com/registration";
    private static final String FIRST_NAME = "Andrii";
    private static final String LAST_NAME = "Koval";
    private static final String DATE_OF_BIRTH = "05/23/2001";
    private static final String NEW_EMAIL = "kovaal2653df@gmail.com";
    private static final String NEW_PASSWORD = "1234356aa1";

    @Test
    public void registration() {
        driver.get(REGISTRATION_URL);
        waitForInputFields();
        actions.sendKeys(driver.findElement(FIRST_NAME_INPUT_SELECTOR), FIRST_NAME)
                .sendKeys(driver.findElement(LAST_NAME_INPUT_SELECTOR), LAST_NAME)
                .sendKeys(driver.findElement(DATE_OF_BIRTH_INPUT_SELECTOR), DATE_OF_BIRTH)
                .sendKeys(driver.findElement(EMAIL_INPUT_SELECTOR_REG), NEW_EMAIL)
                .sendKeys(driver.findElement(PASSWORD_INPUT_SELECTOR_REG), NEW_PASSWORD)
                .sendKeys(driver.findElement(CONFIRM_PASSWORD_INPUT_SELECTOR), NEW_PASSWORD)
                .build().perform();

        assertInputFieldValuesIsNotEmpty();
    }

    private void waitForInputFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_INPUT_SELECTOR));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_INPUT_SELECTOR));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DATE_OF_BIRTH_INPUT_SELECTOR));
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_INPUT_SELECTOR_REG));
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT_SELECTOR_REG));
        wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_PASSWORD_INPUT_SELECTOR));
    }

    private void assertInputFieldValuesIsNotEmpty() {
        WebElement firstNameInput = driver.findElement(FIRST_NAME_INPUT_SELECTOR);
        WebElement lastNameInput = driver.findElement(LAST_NAME_INPUT_SELECTOR);
        WebElement dateOfBirthInput = driver.findElement(DATE_OF_BIRTH_INPUT_SELECTOR);
        WebElement emailInput = driver.findElement(EMAIL_INPUT_SELECTOR_REG);
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_SELECTOR_REG);
        WebElement confirmPasswordInput = driver.findElement(CONFIRM_PASSWORD_INPUT_SELECTOR);

        Assert.assertEquals(firstNameInput.getAttribute("value"), FIRST_NAME, "Поле First Name не соответствует нашим данным" + ":" + FIRST_NAME);
        Assert.assertEquals(lastNameInput.getAttribute("value"), LAST_NAME, "Поле Last Name не соответствует нашим данным" + ":" + LAST_NAME);
        Assert.assertEquals(dateOfBirthInput.getAttribute("value"), DATE_OF_BIRTH, "Поле Date of Birth не соответствует нашим данным" + ":" + DATE_OF_BIRTH);
        Assert.assertEquals(emailInput.getAttribute("value"), NEW_EMAIL, "Поле Email не соответствует нашим данным" + ":" + NEW_EMAIL);
        Assert.assertEquals(passwordInput.getAttribute("value"), NEW_PASSWORD, "Поле Password не соответствует нашим данным" + ":" + NEW_PASSWORD);
        Assert.assertEquals(confirmPasswordInput.getAttribute("value"), NEW_PASSWORD, "Поле Confirm Password не соответствует нашим данным" + ":" + NEW_PASSWORD);
    }
    @AfterTest
    public void after() {
        driver.quit();
    }
}

