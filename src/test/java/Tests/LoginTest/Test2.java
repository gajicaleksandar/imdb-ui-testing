package Tests.LoginTest;

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

public class Test2 extends TestBase {
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
        }
        /*
        A screenshot is captured only on failure in any test
        Screenshots are stored in a folder named "screenshots" and each new screenshot is named "ScreenshotFailure + test name.png"
        */
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://www.imdb.com/";
        System.out.println("Expected URL: " + expectedUrl);

        Assert.assertTrue(Objects.equals(currentUrl, expectedUrl));
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct: " + currentUrl);
        }

        header.clickOnButtonSignIn();
        loginPage.clickOnSignInWithImdb();
        loginPage.clickButtonDetails();
        Assert.assertTrue(loginPage.checkBoxDetails_ISDP());
        loginPage.clickButtonCloseDetails();
        //credentials
        loginPage.inputFieldEmail("wrongemail@gmail.com"); //login email = wrong
        loginPage.inputFieldPassword("DelijeSever1989"); //login password = correct
        loginPage.clickButtonCheckKeepSignedIn();
        loginPage.clickButtonAcceptSignIn();
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.checkBoxAuthErrorLogin_ISDP());
        header.clickButtonUserProfile();
        header.clickOnButtonSignOut();
    }
}