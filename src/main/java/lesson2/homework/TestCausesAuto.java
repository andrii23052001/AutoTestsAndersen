package lesson2.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//TASK1
/*
Authorization with correct email address and password:
1. Navigates to the user login page: https://qa-course-01.andersenlab.com/login;
2. Enter the correct Email;
3. Enter the correct Password;
4. Press the "Sign in" button.

Email: aqaandriikovalstudentt@gmail.com
Password: qwerty12
*/

/*
Registration:
1. Go to the registration page (https://qa-course-01.andersenlab.com/registration);
2. Fill "First Name";
3. Fill "Last Name";
4. Fill "Date of birth";
5. Fill Email;
6. Fill "Password";
7. Fill "Confirm password";
8. Press the "Submit" button.

Details:
- First Name: Andrii
- Last Name: Koval
- Email: koval2653633@gmail.com; // Можно также изменить его немного, чтобы запустить программу еще раз
- Date of birth: 05.23.2001
- Password: qwerty12
*/

public class TestCausesAuto {

    private static final String LOGIN_URL = "https://qa-course-01.andersenlab.com/login";
    private static final String EMAIL_INPUT_SELECTOR = "input[name=\"email\"]";
    private static final String PASSWORD_INPUT_SELECTOR = "input[type=\"password\"]";
    private static final String SUBMIT_BUTTON_SELECTOR = "button[type=\"submit\"]";
    private static final String EMAIL = "aqaandriikovalstudentt@gmail.com";
    private static final String PASSWORD = "qwerty12";

    private static final String REGISTRATION_URL = "https://qa-course-01.andersenlab.com/registration";
    private static final By FIRST_NAME_INPUT_SELECTOR = By.cssSelector("input[name=\"firstName\"]");
    private static final By LAST_NAME_INPUT_SELECTOR = By.cssSelector("[placeholder=\"Last Name\"]");
    private static final By DATE_OF_BIRTH_INPUT_SELECTOR = By.cssSelector("[name=\"dateOfBirth\"]");
    private static final By EMAIL_INPUT_SELECTOR_REG = By.cssSelector("[name='email']");
    private static final By PASSWORD_INPUT_SELECTOR_REG = By.xpath("//*[@type=\"password\"][1]");
    private static final By CONFIRM_PASSWORD_INPUT_SELECTOR = By.xpath("//*[@placeholder=\"Confirm Password\"]");
    private static final By REGISTER_BUTTON_SELECTOR = By.xpath("//*[@type=\"submit\"]");
    private static final String FIRST_NAME = "Andrii";
    private static final String LAST_NAME = "Koval";
    private static final String DATE_OF_BIRTH = "05/23/2001";
    private static final String NEW_EMAIL = "kovaal2653df@gmail.com";
    private static final String NEW_PASSWORD = "1234356aa1";

    public static void main(String[] args) {

        WebDriver driver = setupDriver();
        // Выполнение первой задачи (вход на сайт)
        driver.get(LOGIN_URL);
        driver.findElement(By.cssSelector(EMAIL_INPUT_SELECTOR)).sendKeys(EMAIL);
        driver.findElement(By.cssSelector(PASSWORD_INPUT_SELECTOR)).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector(SUBMIT_BUTTON_SELECTOR)).click();
        driver.quit(); // Закрываем драйвер после выполнения первой задачи

        // Создание нового экземпляра драйвера и выполнение второй задачи
        WebDriver secondDriver = setupDriver();
        secondDriver.get(REGISTRATION_URL);
        secondDriver.findElement(FIRST_NAME_INPUT_SELECTOR).sendKeys(FIRST_NAME);
        secondDriver.findElement(LAST_NAME_INPUT_SELECTOR).sendKeys(LAST_NAME);
        secondDriver.findElement(DATE_OF_BIRTH_INPUT_SELECTOR).sendKeys(DATE_OF_BIRTH);
        secondDriver.findElement(EMAIL_INPUT_SELECTOR_REG).click();
        secondDriver.findElement(EMAIL_INPUT_SELECTOR_REG).sendKeys(NEW_EMAIL);
        secondDriver.findElement(PASSWORD_INPUT_SELECTOR_REG).sendKeys(NEW_PASSWORD);
        secondDriver.findElement(CONFIRM_PASSWORD_INPUT_SELECTOR).sendKeys(NEW_PASSWORD);
        secondDriver.findElement(REGISTER_BUTTON_SELECTOR).click();

    }

    public static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

/*
    private static final String REGISTER_BUTTON_SELECTOR = "//*[@type=\"submit\"]";
    Использование строки в качестве селектора может быть удобным,
    если нет необходимости использовать дополнительные методы из класса By,
    такие как By.xpath(), и если селектор представляет собой простой CSS- или XPath-путь.*/
