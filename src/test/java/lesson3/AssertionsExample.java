package lesson3;

import lessons3.FluentWaitExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertionsExample {
    WebDriver driver = FluentWaitExample.setupDriver();


    @Test
    public void checkWebSiteTitle() {
        WebDriver driver = FluentWaitExample.setupDriver();
        driver.get("https://andersenlab.com/");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Software Development Company – Andersen");
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div[2]/div/div/div/button")).isDisplayed());

    }

    @BeforeMethod
    public void afterMethod() {
        driver.quit();
    }
}
