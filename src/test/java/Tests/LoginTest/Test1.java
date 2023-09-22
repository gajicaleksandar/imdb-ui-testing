package Tests.LoginTest;

import Pages.Header;
import Pages.LoginPage;
import TestBase.TestBase;
import Utility.ScreenShotOnFailure;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class Test1 extends TestBase {
    Header header;
    LoginPage loginPage;

    @BeforeTest
    public void setUpTest() {
        header = new Header();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenShotOnFailure.TakingScreenshot(driver, result.getName());
            String testMessageFailed = "- The test " + getClass() + " failed!";
                System.out.println(testMessageFailed);
                Allure.step(testMessageFailed);
        }
        else {
            String testMessageNoErrors = "- No errors";
                System.out.println(testMessageNoErrors);
                Allure.step(testMessageNoErrors);
        }
        /*
        A screenshot is captured only on failure in any test
        Screenshots are stored in a folder named "screenshots" and each new screenshot is named "ScreenshotFailure + test name.png"
        */
    }

    @Test
    public void test1() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://www.imdb.com/";
            System.out.println("Expected URL: " + expectedUrl);

        Assert.assertTrue(Objects.equals(currentUrl, expectedUrl));
        if (currentUrl.equals(expectedUrl)) {
            String testMessage1 = "URL is correct!";
                System.out.println(testMessage1);
                Allure.step(testMessage1);
            }
        header.clickOnButtonSignIn();
        loginPage.clickOnSignInWithImdb();
        loginPage.clickButtonDetails();
        Assert.assertTrue(loginPage.checkBoxDetails_ISDP());
        loginPage.clickButtonCloseDetails();
        //credentials
        loginPage.inputFieldEmail("alexandar0702@gmail.com"); //login email = correct
        loginPage.inputFieldPassword("Alexandar0702@"); //login password = correct
        loginPage.clickButtonCheckKeepSignedIn();
        loginPage.clickButtonAcceptSignIn();
        Thread.sleep(1000);
        Assert.assertTrue(header.checkButtonUserProfile_ISDP());
        header.clickButtonUserProfile();
        header.clickOnButtonSignOut();
        Assert.assertTrue(header.checkButtonSignIn_ISDP());
    }
}