package lesson4;

/*2.	Необходимо автоматизировать сценарий, который показан на видео “Сценарий для автоматизации Лекция 12.mp4”.
        •	1)Для этого открыть поиск гугл: https://www.google.com/search
        •	2) После ввести в поисковую строку следующую ссылку: https://www.guinnessworldrecords.com/account/register?
        Открыть подходящую ссылку в новом окне, которая будет отображаться в результатах.
        •	3) После ввести в поисковую строку следующую ссылку: https://www.hyrtutorials.com/p/alertsdemo.html
        Открыть подходящую ссылку в новом окне, которая будет отображаться в результатах.
        •	4) Открыть в активном окне следующую ссылку: https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
        •	В открытом окне заполнить поля своим именем и фамилией и нажать кнопку ‘Submit’.*/

import WebDriverSetup.WebDriverSetup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture12AutomationScenario extends WebDriverSetup {

    static final By BUTTON_ACCEPT_COOKIES = By.xpath("(//div[@class=\"QS5gu sy4vM\"])[2]");
    static final By SEARCH_FIELD = By.cssSelector(".gLFyf:nth-of-type(1)");
    static final By NEW_TAB_ELEMENT = By.xpath("(//h3[@class=\"LC20lb MBeuO DKV0Md\"])[1]");

    static final By BUTTON_TO_DELETE_DATA_FROM_THE_SEARCH_FIELD = By.cssSelector("span[class=\"ExCKkf z1asCe rzyADb\"]");
    static final By SEARCH_FIELD1 = By.cssSelector("textarea[class=\"gLFyf\"]");
    static final By BUTTON_ACCEPT_ALL = By.cssSelector("#accept-choices");

    static final By FIRST_NAME_FIELD = By.cssSelector("input[name=fname]");
    static final By FAMILY_NAME_FIELD = By.cssSelector("input[name=lname]");
    static final By BUTTON_SUBMIT = By.cssSelector("input[type=\"submit\"]");

    static final By BUTTON_LAST_NAME = By.xpath("(//input[@class=\"input-large\"])[1]");
    static final By BUTTON_FIRST_NAME = By.xpath("//input[@id=\"FirstName\"]");
    static final By DATE_OF_BIRTHDAY = By.cssSelector("#DateOfBirthDay");

    static final By DATE_OF_BIRTH_MONTH = By.xpath("//input[@name=\"DateOfBirthMonth\"]");
    static final By DATE_OF_BIRTH_YEAR = By.xpath("//input[@name=\"DateOfBirthYear\"]");
    static final By SELECT_COUNTRY = By.cssSelector("select[name=\"Country\"]");

    static final By FIELD_STATE = By.xpath("//input[contains(@class, 'input-large create-application-name')]");
    static final By FIELD_EMAIL = By.cssSelector("input[name=\"EmailAddress\"]");
    static final By CONFIRM_EMAIL = By.cssSelector("input[id=\"ConfirmEmailAddress\"]");

    static final By PASSWORD_FIELD = By.cssSelector("input[id=\"Password\"]");
    static final By CONFIRM_PASSWORD_FIELD = By.cssSelector("input[id=\"ConfirmPassword\"]");
    static final By BUTTON_CONSENT = By.cssSelector(" button[aria-label=\"Consent\"]");

    static final By BUTTON_CLICK_ME1 = By.xpath("//button[@onclick=\"alertFunction()\"]");
    static final By BUTTON_CLICK_ME2 = By.cssSelector("button[onclick=\"alertFunction()\"]");
    static final By BUTTON_CLICK_ME3 = By.cssSelector("button[onclick=\"promptFunction()\"]");
    static final By NOTE_TEXT = By.cssSelector("div[class=\"w3-panel w3-pale-yellow w3-leftbar w3-border-yellow\"]");
    static final By PASSWORD_ERROR_TEXT = By.xpath("(//span[@class=\"field-validation-error\"])[1]");

    static final String GOOGLE_URL = "https://www.google.com/";
    static final String INFO_FOR_SEARCH_FIELD_URL2 = "https://www.hyrtutorials.com/p/alertsdemo.html";
    static final String INFO_FOR_SEARCH_FIELD_URL1 = "https://www.guinnessworldrecords.com/account/register";
    static final String W3SCHOOLS_SITE_URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";
    static final String IFRAME = "iframeResult";
    static final String NAME = "Andrii";
    static final String FAMILY_NAME = "Koval";
    static final String NAME_OF_COUNTRY = "Ukraine";
    static final String YEAR = "2001";
    static final String MONTH = "05";
    static final String DATE = "23";
    static final String PASSWORD = "23052001AA";
    static final String CONFIRM_PASSWORD = "23052001a";
    static final String STATE = "Chernihiv";
    static final String Email = "koval23052001aaafifa@gmail.com";
    static final By POP_UP_TEXT = By.cssSelector("div[id=\"output\"]");


    @Test()
    public void scenarioFromVideo() {
        driver.get(GOOGLE_URL);
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_ACCEPT_COOKIES))))
                .click()
                .moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEARCH_FIELD))))
                .click()
                .sendKeys(INFO_FOR_SEARCH_FIELD_URL1)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        openNewTab();
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_TO_DELETE_DATA_FROM_THE_SEARCH_FIELD))))
                .click()
                .moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEARCH_FIELD1))))
                .click()
                .sendKeys(INFO_FOR_SEARCH_FIELD_URL2)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        openNewTab();

        driver.get(W3SCHOOLS_SITE_URL);
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_ACCEPT_ALL))))
                .click()
                .perform();

        driver.switchTo().frame(IFRAME);
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FIRST_NAME_FIELD))))
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(NAME)
                .moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FAMILY_NAME_FIELD))))
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys(FAMILY_NAME)
                .moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_SUBMIT))))
                .click()
                .build()
                .perform();
        System.out.println(driver.findElement(NOTE_TEXT).getText());
        driver.switchTo().window(tabs.get(1));
        fillPersonalInformation();
        driver.switchTo().window(tabs.get(2));

        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_CONSENT))))
                .click()
                .moveToElement(driver.findElement(BUTTON_CLICK_ME1))
                .click()
                .perform();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println(driver.findElement(POP_UP_TEXT).getText());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_CLICK_ME2))))
                .click()
                .perform();
        alert.dismiss();
        System.out.println(driver.findElement(POP_UP_TEXT).getText());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_CLICK_ME3))))
                .click()
                .perform();
        alert.sendKeys("Final step of this task");
        alert.accept();
        System.out.println(driver.findElement(POP_UP_TEXT).getText());
    }

    public void openNewTab() {
        actions.moveToElement((driver.findElement(NEW_TAB_ELEMENT)))
                .keyDown(Keys.CONTROL)
                .click()
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

    private void fillPersonalInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_LAST_NAME)))
                .sendKeys(FAMILY_NAME);
        Assert.assertEquals(driver.findElement(BUTTON_LAST_NAME).getAttribute("value"), FAMILY_NAME);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(BUTTON_FIRST_NAME)))
                .sendKeys(NAME);
        Assert.assertEquals(driver.findElement(BUTTON_FIRST_NAME).getAttribute("value"), NAME);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(DATE_OF_BIRTHDAY)))
                .sendKeys(DATE);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(DATE_OF_BIRTH_MONTH)))
                .sendKeys(MONTH);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(DATE_OF_BIRTH_YEAR)))
                .sendKeys(YEAR);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONFIRM_PASSWORD_FIELD)))
                .sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SELECT_COUNTRY)))
                .sendKeys(NAME_OF_COUNTRY);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FIELD_EMAIL)))
                .sendKeys(Email);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONFIRM_EMAIL)))
                .sendKeys(Email);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PASSWORD_FIELD)))
                .sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONFIRM_PASSWORD_FIELD)))
                .sendKeys(CONFIRM_PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(FIELD_STATE)))
                .sendKeys(STATE);

        System.out.println(driver.findElement(PASSWORD_ERROR_TEXT).getText());
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
