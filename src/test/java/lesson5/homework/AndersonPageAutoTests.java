package lesson5.homework;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndersonPageAutoTests extends BaseTest {

    private final String loginPageUrl = "https://qa-course-01.andersenlab.com/login";
    private final String registrationPageUrl = "https://qa-course-01.andersenlab.com/registration";
    private final String assertUrlMesage = "Actual url does not match expected url";

    @Test(description = "Verify opening of the login page")
    public void checkLoginPageOpen() {
        driver.get(loginPageUrl);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa-course-01.andersenlab.com/login", assertUrlMesage);
    }


    @Test(description = "Check user can authorization successfully with valid personal data")
    public void authorizationWithValidData() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("aqaandriikovalstudentt@gmail.com")
                .enterPassword("qwerty12")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenLoginPage.getElementAfterSuccessfulAuthorization().isDisplayed(), "The required element was not found");
    }

    @Test(description = "Check user can authorization successfully with invalid personal data")
    public void authorizationWithInvalidData() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("InvalidEmail@gmail.com")
                .enterPassword("InvalidPassword")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", "Invalid massage was not found");
    }

    @Test(description = "Check user can authorization successfully with valid personal data, but email in UPERCASE")
    public void authorizationWithValidDataButEmailInUpperCase() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("AQAANDRIIKOVALSTUDENTT@gmail.com")
                .enterPassword("qwerty12")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", "Invalid massage was not found");
    }

    @Test(description = "Check user can authorization successfully with valid personal data, but password in UPERCASE")
    public void authorizationWithValidDataButPasswordInUpperCase() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("aqaandriikovalstudentt@gmail.com")
                .enterPassword("QWERTY12")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", "Invalid massage was not found");
    }

    @Test(description = "Check redirected to the registration page")
    public void redirectedToTheRegistrationPage() {
        driver.get(loginPageUrl);
        andersenLoginPage.redirectedToTheRegistrationPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa-course-01.andersenlab.com/registration", assertUrlMesage);
    }

    @Test(description = "successful registration of a new user with valid data")
    public void newUserSuccesfulRegistration() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("Koval")
                .enterDateOfBirth("05/23/2001")
                .enterEmail("koval26@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenLoginPage.getElementAfterSuccessfulAuthorization().isDisplayed(), "The required element was not found");
    }

    @Test(description = "Verify successful registration with future date of birth")
    public void successfulRegistrationWithFutureDateOfBirth() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("Koval")
                .enterDateOfBirth("05/23/2050")
                .enterEmail("koval36@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenLoginPage.getElementAfterSuccessfulAuthorization().isDisplayed(), "The required element was not found");
    }

    @Test(description = "Successful registration of a new user with lowercase last name")
    public void successfulRegistrationWithLowercaseLastName() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("lowercase")
                .enterDateOfBirth("05/23/2050")
                .enterEmail("koval46@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenLoginPage.getElementAfterSuccessfulAuthorization().isDisplayed(), "The required element was not found");
    }
}