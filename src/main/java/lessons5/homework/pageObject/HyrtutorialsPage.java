package lessons5.homework.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HyrtutorialsPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label=\"Consent\"]")
    private WebElement acceptButton;

    @FindBy(xpath = "//button[@onclick=\"alertFunction()\"]")
    private WebElement buttonOne;

    @FindBy(xpath = "//button[@id=\"confirmBox\"]")
    private WebElement buttonTwo;

    @FindBy(xpath = "//button[@onclick=\"promptFunction()\"]")
    private WebElement buttonThree;

    @FindBy(xpath = "//div[@id=\"output\"]")
    private WebElement text;


    public HyrtutorialsPage() {
        super();
    }

    public HyrtutorialsPage acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
        return this;
    }

    public HyrtutorialsPage clickButtonOne() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonOne)).click();
        return this;
    }

    public HyrtutorialsPage acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    public String getPopUpText() {
        return wait.until(ExpectedConditions.visibilityOf(text)).getText();
    }

    public HyrtutorialsPage clickButtonTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonTwo)).click();
        return this;
    }

    public HyrtutorialsPage dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        return this;
    }

    public HyrtutorialsPage clickButtonThree() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonThree)).click();
        return this;
    }

    public HyrtutorialsPage enterAlertMessage(String message) {
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(message);
        return this;
    }
}
