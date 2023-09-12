package Tests.SmokeTest;

import Pages.Header;
import Pages.LoginPage;
import TestBase.TestBase;
import Utility.ScreenShotOnFailure;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class SmokeTest extends TestBase {
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
            System.out.println("- The test " + getClass() + " failed!");
        }
        else {
            System.out.println("- No errors");
        }
        /*
        A screenshot is captured only on failure in any test
        Screenshots are stored in a folder named "screenshots" and each new screenshot is named "ScreenshotFailure + test name.png"
        */
    }

    @Test
    public void LoginTest() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://www.imdb.com/";
            System.out.println("Expected URL: " + expectedUrl);

        Assert.assertTrue(Objects.equals(currentUrl, expectedUrl));
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct!");
        }
        header.clickOnButtonSignIn();
        loginPage.clickOnSignInWithImdb();
        loginPage.clickButtonDetails();
        Assert.assertTrue(loginPage.checkBoxDetails_ISDP());
        loginPage.clickButtonCloseDetails();
        //credentials
        loginPage.inputFieldEmail("alexandar0702@gmail.com");
        loginPage.inputFieldPassword("Alexandar0702@");
        loginPage.clickButtonCheckKeepSignedIn();
        loginPage.clickButtonAcceptSignIn();
        Thread.sleep(1000);
        Assert.assertTrue(header.checkButtonUserProfile_ISDP());
    }

    @Test
    public void test() throws InterruptedException {

        //step 2, this will continue - Watchlist test, translate test, search test, check pages, play video...

    }

}