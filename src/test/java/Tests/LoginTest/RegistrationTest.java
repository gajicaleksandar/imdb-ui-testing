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
import java.util.Random;

import java.io.IOException;
import java.util.Objects;

public class RegistrationTest extends TestBase {
    Header header;
    LoginPage loginPage;

    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

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
    public void test1() throws InterruptedException {

        String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
        String expectedUrl = "https://www.imdb.com/";
            System.out.println("Expected URL: " + expectedUrl);

        Assert.assertTrue(Objects.equals(currentUrl, expectedUrl));
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("URL is correct!");
        }
        header.clickOnButtonSignIn();
        loginPage.clickButtonCreateNewAccount();
        loginPage.inputFieldYourName("Test123");
            String randomEmail = generateRandomString(5) + "@gmail.com";
            System.out.println("Generated email is: " + randomEmail);
        loginPage.inputFieldEmail(randomEmail);
            String randomPassword = generateRandomString(10);
            System.out.println("Generated password is: " + randomPassword);
        loginPage.inputFieldPassword(randomPassword);
        loginPage.inputFieldRePassword(randomPassword);
        loginPage.clickButtonAcceptSignIn();
        Assert.assertTrue(loginPage.checkH1VerifyEmail_ISDP());
        Thread.sleep(2000);
    }
}