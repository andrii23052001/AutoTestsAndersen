package lesson3.homework.dataProvider;

//aqaandriikovalstudentt@gmail.com
//qwerty12
//
//
//        koval23052001aaaffdfdsifa@gmail.com
//23052001A
//
//        koval23052003231aaafifa@gmail.com
//23052001A

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"aqaandriikovalstudentt@gmail.com", "qwerty12"},
                {"koval23052001aaaffdfdsifa@gmail.com", "23052001A"},
                {"koval23052003231aaafifa@gmail.com", "23052001A"}
        };
    }

    @Test(dataProvider = "testData")
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
