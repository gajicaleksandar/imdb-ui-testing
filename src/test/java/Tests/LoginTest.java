package Tests;

import Pages.Header;
import Pages.LoginPage;
import TestBase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    Header header;
    LoginPage loginPage;

    @BeforeTest
    public void setUpTest() {
        header = new Header();
        loginPage = new LoginPage();
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void test() throws InterruptedException {
        header.clickOnButtonSignIn();
        loginPage.clickOnSignInWithImdb();
        //credentials
            loginPage.inputFieldEmail("alexandar0702@gmail.com"); //login email
            loginPage.inputFieldPassword("DelijeSever1989"); //login password
        //credentials
        loginPage.clickButtonAcceptSignIn();
        Thread.sleep(1000);



    }
}