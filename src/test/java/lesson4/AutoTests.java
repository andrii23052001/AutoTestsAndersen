package lesson4;

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AutoTests extends WebDriverSetup {

    static final By ICON_COMPANY = By.cssSelector("div[tabindex=\"Company\"]");
    static final By ICON_ABOUT_US = By.xpath("(//a[text()=\"About us\"])[1]");
    static final By BUTTON_ACCEPT_COOKIES = By.xpath("//button[text()=\"Accept all cookies\"]");
    static final By ICON_ANDERSEN = By.cssSelector("div[aria-label=\"Andersen logo\"]");

    static final String ANDREDSENLAB_SITE_URL = "https://andersenlab.com/";
    static final String ABOUT_US_PAGE_URL = ("https://andersenlab.com/about-us");

    @Test(description = "Проверка перехода на страницу 'About Us'")
    public void transitionToAboutUsPage() {
        driver.get(ANDREDSENLAB_SITE_URL);
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated((BUTTON_ACCEPT_COOKIES)))).click().perform();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated((ICON_COMPANY)))).perform();
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated((ICON_ABOUT_US)))).perform();
        actions.click().perform();
        Assert.assertEquals(driver.getCurrentUrl(), ABOUT_US_PAGE_URL, "URL страницы не совпадает с ожидаемой");
    }

    @Test(description = "Проверка видимости элемента 'Andersen' на странице")
    public void testElementVisibility() {
        driver.get(ANDREDSENLAB_SITE_URL);
        Assert.assertNotNull(driver.findElement(ICON_ANDERSEN), "Элемент 'Andersen' не найден на странице");
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

