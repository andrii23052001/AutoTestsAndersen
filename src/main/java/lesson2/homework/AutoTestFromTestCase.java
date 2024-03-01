package lesson2.homework;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTestFromTestCase {

    static WebDriver driver = WebDriverSetup.setupDriver();

    private static final String STORE_URL = "http://www.automationpractice.pl/index.php";
    private static final By ENTRY_FIELD = By.xpath("//input[@id='search_query_top']");
    private static final String INFORMATION_FOR_SEARCHING_DRESS = "Printed chiffon dress";
    private static final By SEARCH_BUTTON = By.xpath("//button[@class='btn btn-default button-search']");
    private static final By PRODUCTS_SORTING_BUTTON = By.cssSelector(".icon-th-list");
    private static final By ADD_TO_COMPARE_BUTTON = By.xpath("//a[@data-id-product=\"7\"]");
    private static final By WOMEN_BUTTON = By.xpath("//a[text()=\"Women\"]");
    private static final String INFORMATION_FOR_SEARCHING_FADED_SHORT = "Faded Short";
    private static final By ADD_TO_COMPARE_BUTTON1 = By.xpath("//a[@data-id-product=\"1\"]");
    private static final By COMPARE_BUTTON = By.xpath("(//button[contains(.,'Compare')])[1]");


    public static void main(String[] args) throws InterruptedException {

        driver.get(STORE_URL);

        WebElement firstSearch = driver.findElement(ENTRY_FIELD);
        firstSearch.click();
        firstSearch.sendKeys(INFORMATION_FOR_SEARCHING_DRESS);
        firstSearch.findElement(SEARCH_BUTTON).click();

        WebElement sortingButton = driver.findElement(PRODUCTS_SORTING_BUTTON);
        sortingButton.click();

        WebElement addToCompareButton = driver.findElement(ADD_TO_COMPARE_BUTTON);
        Thread.sleep(3000);
        addToCompareButton.click();

        WebElement womenButton = driver.findElement(WOMEN_BUTTON);
        Thread.sleep(3000);
        womenButton.click();

        WebElement secondSearch = driver.findElement(ENTRY_FIELD);
        secondSearch.sendKeys(INFORMATION_FOR_SEARCHING_FADED_SHORT);
        secondSearch.findElement(SEARCH_BUTTON).click();

        WebElement addToCompareButton1 = driver.findElement(ADD_TO_COMPARE_BUTTON1);
        addToCompareButton1.click();

        WebElement compareItemsButton = driver.findElement(COMPARE_BUTTON);
        compareItemsButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

    }
}