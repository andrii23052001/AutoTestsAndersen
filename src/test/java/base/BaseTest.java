package base;

import WebDriverSetup.WebDriverSetup;
import lessons5.homework.pageObject.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest extends WebDriverSetup {

    protected GooglePage googlePage;
    protected W3schoolsPage w3schoolsPage;
    protected GuinnessPage guinnessPage;
    protected HyrtutorialsPage hyrtutorialsPage;
    protected AndersenLoginPage andersenLoginPage;
    protected AndersenRegistrationPage andersenRegistrationPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSetup.getInstance().setupDriver();
        googlePage = new GooglePage();
        w3schoolsPage = new W3schoolsPage();
        guinnessPage = new GuinnessPage();
        hyrtutorialsPage = new HyrtutorialsPage();
        andersenLoginPage = new AndersenLoginPage();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

