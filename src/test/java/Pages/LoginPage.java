package Pages;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

public class LoginPage extends TestBase {

    public LoginPage() {
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    By buttonSignInWithImdb = By.xpath("(//span[@class = 'auth-provider-text'])[1]");
    public void clickOnSignInWithImdb() throws InterruptedException {
        WebElement SignInWithImdb = driver.findElement(buttonSignInWithImdb);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SignInWithImdb);
        Thread.sleep(1000);
        SignInWithImdb.click();
    }

    By buttonCreateNewAccount = By.xpath("//a[@class = 'list-group-item create-account ']");
    public void clickButtonCreateNewAccount() throws InterruptedException {
        WebElement ButtonCreateAccount = driver.findElement(buttonCreateNewAccount);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonCreateAccount);
        Thread.sleep(1000);
        ButtonCreateAccount.click();
    }

    By fieldEmail = By.xpath("//input[@id= 'ap_email']");
    public void inputFieldEmail (String input) throws InterruptedException {
        WebElement FieldEmail = driver.findElement(fieldEmail);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldEmail);
        Thread.sleep(1000);
        FieldEmail.clear();
        FieldEmail.sendKeys(input);
    }

    By fieldPassword = By.xpath("//input[@id= 'ap_password']");
    public void inputFieldPassword (String input) throws InterruptedException {
        WebElement FieldPassword = driver.findElement(fieldPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldPassword);
        Thread.sleep(1000);
        FieldPassword.clear();
        FieldPassword.sendKeys(input);
    }

    By fieldRePassword = By.xpath("//input[@id= 'ap_password_check']");
    public void inputFieldRePassword (String input) throws InterruptedException {
        WebElement FieldRePassword = driver.findElement(fieldRePassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldRePassword);
        Thread.sleep(1000);
        FieldRePassword.clear();
        FieldRePassword.sendKeys(input);
    }

    By fieldYourName = By.xpath("//input[@id= 'ap_customer_name']");
    public void inputFieldYourName (String input) throws InterruptedException {
        WebElement FieldYourName = driver.findElement(fieldYourName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldYourName);
        Thread.sleep(1000);
        FieldYourName.clear();
        FieldYourName.sendKeys(input);
    }

    By buttonAcceptSignIn = By.xpath("//span[@id = 'a-autoid-0']");
    public void clickButtonAcceptSignIn() throws InterruptedException {
        WebElement AcceptCreateAccount = driver.findElement(buttonAcceptSignIn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AcceptCreateAccount);
        Thread.sleep(1000);
        AcceptCreateAccount.click();
    }

    By boxAuthErrorLogin = By.xpath("//div[@id= 'auth-error-message-box']");
    public boolean checkBoxAuthErrorLogin_ISDP() throws InterruptedException {
        WebElement CheckBoxAuthErrorLoginISDP = driver.findElement(boxAuthErrorLogin);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", CheckBoxAuthErrorLoginISDP);
        Thread.sleep(1000);
        return CheckBoxAuthErrorLoginISDP.isDisplayed();
    }

    By buttonDetails = By.xpath("//a[@id= 'remember_me_learn_more_link']");
    public void clickButtonDetails() throws InterruptedException {
        WebElement ButtonDetails = driver.findElement(buttonDetails);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonDetails);
        Thread.sleep(1000);
        ButtonDetails.click();
    }

    By boxDetails = By.xpath("//div[@id= 'a-popover-1']");
    public boolean checkBoxDetails_ISDP() throws InterruptedException {
        WebElement CheckBoxDetails = driver.findElement(boxDetails);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", CheckBoxDetails);
        Thread.sleep(1000);
        return CheckBoxDetails.isDisplayed();
    }

    By buttonCloseDetails = By.xpath("//button[@class= 'a-button-close  a-declarative']");
    public void clickButtonCloseDetails() throws InterruptedException {
        WebElement ButtonCloseDetails = driver.findElement(buttonCloseDetails);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonCloseDetails);
        Thread.sleep(1000);
        ButtonCloseDetails.click();
    }

    By buttonCheckKeepSignedIn = By.xpath("//input[@name= 'rememberMe']");
    public void clickButtonCheckKeepSignedIn() throws InterruptedException {
        WebElement ButtonCheckKeepSignedIn = driver.findElement(buttonCheckKeepSignedIn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonCheckKeepSignedIn);
        Thread.sleep(1000);
        ButtonCheckKeepSignedIn.click();
    }

    By h1VerifyEmail = By.xpath("//h1[text()= 'Verify email address']");
    public boolean checkH1VerifyEmail_ISDP() throws InterruptedException {
        WebElement CheckH1VerifyEmail = driver.findElement(h1VerifyEmail);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", CheckH1VerifyEmail);
        Thread.sleep(1000);
        return CheckH1VerifyEmail.isDisplayed();
    }
}