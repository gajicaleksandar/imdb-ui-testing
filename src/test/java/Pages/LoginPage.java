package Pages;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

   /* By fieldYourName = By.xpath("//input[@id= 'ap_customer_name']");
    public void inputFieldYourName(String input) throws InterruptedException {
        WebElement FieldYourName = driver.findElement(fieldYourName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldYourName);
        Thread.sleep(1000);
        FieldYourName.clear();
        FieldYourName.sendKeys(input);
    }*/

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

 /*   By fieldReEnterPassword = By.xpath("//input[@id= 'ap_password']");
    public void inputFieldReEnterPassword (String input) throws InterruptedException {
        WebElement FieldRePassword = driver.findElement(fieldReEnterPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldRePassword);
        Thread.sleep(1000);
        FieldRePassword.clear();
        FieldRePassword.sendKeys(input);
    }*/

    By buttonAcceptSignIn = By.xpath("//span[@id = 'a-autoid-0']");
    public void clickButtonAcceptSignIn() throws InterruptedException {
        WebElement AcceptCreateAccount = driver.findElement(buttonAcceptSignIn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AcceptCreateAccount);
        Thread.sleep(1000);
        AcceptCreateAccount.click();
    }

}
