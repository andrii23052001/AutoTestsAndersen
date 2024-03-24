package lesson5.homework;

import base.BaseTest;
import io.qameta.allure.*;
import lessons5.utils.MyAllureListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({MyAllureListeners.class})
public class AndersonPageAutoTests extends BaseTest {

    private final String loginPageUrl = "https://qa-course-01.andersenlab.com/login";
    private final String registrationPageUrl = "https://qa-course-01.andersenlab.com/registration";
    private final String assertUrlMesage = "Actual url does not match expected url";
    private final String assertInvalidMessage = "Invalid massage was not found";
    private final String assertRequiredElementMessage = "The required element was not found";

    @Test(description = "Verify opening of the login page")
    @Description("This is positive test:verify opening of the login page!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Page opening functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void checkLoginPageOpen() {
         driver.get(loginPageUrl);
       Assert.assertEquals(driver.getCurrentUrl(),
                loginPageUrl, assertUrlMesage);

    }


    @Test(description = "Check user can successfully authorization  with valid personal data")
    @Description("This is positive test:successfully authorization  with valid personal data!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Check user successfully authorization functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void authorizationWithValidData() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("aqaandriikovalstudentt@gmail.com")
                .enterPassword("qwerty12")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenLoginPage.getElementAfterSuccessfulAuthorization().isDisplayed(), "The required element was not found");
    }

    @Test(description = "Сheck inability to authorization with invalid personal data")
    @Description("This is negative test:inability to authorization with invalid personal data!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Check user unsuccessful authorization functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void authorizationWithInvalidData() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("InvalidEmail@gmail.com")
                .enterPassword("InvalidPassword")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", assertInvalidMessage);
    }

    @Test(description = "Сheck inability to authorization with valid personal data, but email in UPERCASE")
    @Description("This is negative test:inability to authorization with valid personal data, but email in UPERCASE!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Check user unsuccessful authorization functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void authorizationWithValidDataButEmailInUpperCase() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("AQAANDRIIKOVALSTUDENTT@gmail.com")
                .enterPassword("qwerty12")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", assertInvalidMessage);
    }

    @Test(description = "Check user can't authorization successfully with valid personal data, but password in UPERCASE")
    @Description("This is negative test:inability to authorization with valid personal data,but password in UPERCASE!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Check user unsuccessful authorization functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void authorizationWithValidDataButPasswordInUpperCase() {
        driver.get(loginPageUrl);
        andersenLoginPage.enterEmail("aqaandriikovalstudentt@gmail.com")
                .enterPassword("QWERTY12")
                .clickOnSubmitButton();
        Assert.assertEquals(andersenLoginPage.getEmailAndPasswordErrorText(), "Email or password is not valid", assertInvalidMessage);
    }

    @Test(description = "Check redirected to the registration page")
    @Description("This is positive test:redirected to the registration page!")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Redirected to the registration page functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    public void redirectedToTheRegistrationPage() {
        driver.get(loginPageUrl);
        andersenLoginPage.redirectedToTheRegistrationPage();
        Assert.assertEquals(driver.getCurrentUrl(), registrationPageUrl, assertUrlMesage);
    }

    @Test(description = "Successful registration of a new user with valid data")
    @Description("This is positive test:successful registration of a new user with valid data")
    @Severity(SeverityLevel.NORMAL)
    @Feature(value = "Successful new user registration functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    @Flaky
    public void newUserSuccessfulRegistration() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("Koval")
                .enterDateOfBirth("05/23/2001")
                .enterEmail("koval303@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenRegistrationPage.getElementAfterSuccessfulRegistration().isDisplayed(), assertRequiredElementMessage);
    }

    @Test(description = "Verify successful registration with future date of birth")
    @Description("This is positive test:successful registration with future date of birth")
    @Severity(SeverityLevel.CRITICAL)
    @Feature(value = "Successful new user registration functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    @Flaky
    public void successfulRegistrationWithFutureDateOfBirth() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("Koval")
                .enterDateOfBirth("05/23/2050")
                .enterEmail("koval203@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenRegistrationPage.getElementAfterSuccessfulRegistration().isDisplayed(), assertRequiredElementMessage);
    }

    @Test(description = "Successful registration of a new user with lowercase last name")
    @Description("This is positive test:successful registration of a new user with lowercase last name")
    @Severity(SeverityLevel.CRITICAL)
    @Feature(value = "Successful new user registration functionality")
    @Owner(value = "AQA specialist:Andrii Koval")
    @Flaky
    public void successfulRegistrationWithLowercaseLastName() {
        driver.get(registrationPageUrl);
        andersenRegistrationPage.
                enterFirstName("Andrii")
                .enterLastName("lowercase")
                .enterDateOfBirth("05/23/2050")
                .enterEmail("koval103@gmail.com")
                .enterPassword("ValidPassword")
                .enterConfirmPassword("ValidPassword")
                .clickOnSubmitButton();
        Assert.assertTrue(andersenRegistrationPage.getElementAfterSuccessfulRegistration().isDisplayed(), assertRequiredElementMessage);
    }
}