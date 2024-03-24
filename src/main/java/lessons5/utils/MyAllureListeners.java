package lessons5.utils;

import WebDriverSetup.WebDriverSetup;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyAllureListeners implements ITestListener {
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot) WebDriverSetup.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES));
    }
}