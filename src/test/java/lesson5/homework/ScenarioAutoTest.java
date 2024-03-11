package lesson5.homework;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ScenarioAutoTest extends BaseTest {

    private final String name = "Andrii";
    private final String lastName = "Koval";
    private final String email = "koval23052001aaafifa@gmail.com";
    private final String assertMessage = "Actual message does not match expected message";

    @Test(description = "Check Autoscript")
    public void checkAutoScript() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.google.com/");
        googlePage.acceptCookies()
                .fillSearchField("https://www.guinnessworldrecords.com/account/register")
                .clickSearch()
                .openNewTab()
                .cleanSearchField()
                .fillSearchField("https://www.hyrtutorials.com/p/alertsdemo.html")
                .clickSearchIcon()
                .openNewTab();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        w3schoolsPage.acceptAllButton();
        driver.switchTo().frame("iframeResult");
        w3schoolsPage.enterFirstName(name)
                .enterLastName(lastName)
                .clickSubmitButton();
        System.out.println(w3schoolsPage.getNoteText());
        softAssert.assertEquals(w3schoolsPage.getNoteText(), "Note: This tutorial will not teach you how servers are processing input. Processing input is explained in our PHP tutorial.", assertMessage);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        w3schoolsPage.switchToNewTab(tabs, "Create account | Guinness World Records");
        guinnessPage.enterLastName(name)
                .enterFirstName(lastName)
                .enterDate("23", "05", "2001")
                .enterCountry("UA")
                .enterCity("Chernihiv")
                .enterEmail(email)
                .confirmEnterEmail(email)
                .enterPassword("somePassword")
                .enterConfirmPasswordAndClick("failedPassword");
        System.out.println(guinnessPage.passwordGetErrorText());
        softAssert.assertEquals(guinnessPage.passwordGetErrorText(), "'Confirm password' and 'Password' do not match.", assertMessage);

        guinnessPage.switchToNewTab(tabs, "AlertsDemo - H Y R Tutorials");
        hyrtutorialsPage.acceptCookies()
                .clickButtonOne()
                .acceptAlert();
        System.out.println(hyrtutorialsPage.getPopUpText());
        softAssert.assertEquals(hyrtutorialsPage.getPopUpText(), "You selected alert popup", assertMessage);

        hyrtutorialsPage.clickButtonTwo()
                .dismissAlert();
        System.out.println(hyrtutorialsPage.getPopUpText());
        softAssert.assertEquals(hyrtutorialsPage.getPopUpText(), "You pressed Cancel in confirmation popup", assertMessage);

        hyrtutorialsPage.clickButtonThree()
                .enterAlertMessage("Final step of this task")
                .acceptAlert();
        System.out.println(hyrtutorialsPage.getPopUpText());
        softAssert.assertEquals(hyrtutorialsPage.getPopUpText(), "You entered text Final step of this task in propmt popup", assertMessage);
        softAssert.assertAll();
    }
}
