package WebDriverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSetup {

    protected WebDriver driver;
    private static WebDriverSetup instance;
    protected WebDriverWait wait;
    protected Actions actions;

    public WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        return driver;
    }

    public static WebDriverSetup getInstance() {
        if (instance == null)
           instance = new WebDriverSetup();
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}