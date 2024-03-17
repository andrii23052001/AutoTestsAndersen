package lesson3.homework.parameters;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {

    private WebDriver driver;

    private static final String LOGIN_URL = "https://qa-course-01.andersenlab.com/login";
    private static final String EMAIL_INPUT_SELECTOR = "input[name=\"email\"]";
    private static final String PASSWORD_INPUT_SELECTOR = "input[type=\"password\"]";
    private static final String SUBMIT_BUTTON_SELECTOR = "button[type=\"submit\"]";

    private static final String LOGOUT_BUTTON = "//p[text()=\"Logout\"]";


    @BeforeMethod
    public void before() {
        driver = WebDriverSetup.getInstance().setupDriver();
        driver.get(LOGIN_URL);
    }

    @Test
    @Parameters({"username", "password"})
    public void checkLogin(String userName, String password) {
        driver.findElement(By.cssSelector(EMAIL_INPUT_SELECTOR)).sendKeys(userName);
        driver.findElement(By.cssSelector(PASSWORD_INPUT_SELECTOR)).sendKeys(password);
        driver.findElement(By.cssSelector(SUBMIT_BUTTON_SELECTOR)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LOGOUT_BUTTON)).isDisplayed());
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

}
