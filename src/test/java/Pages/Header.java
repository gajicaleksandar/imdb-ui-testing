package Pages;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

public class Header extends TestBase {

    public Header() {
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    By buttonSignIn = By.xpath("//a[@class = 'ipc-btn ipc-btn--single-padding ipc-btn--center-align-content ipc-btn--default-height ipc-btn--core-baseAlt " +
            "ipc-btn--theme-baseAlt ipc-btn--on-textPrimary ipc-text-button imdb-header__signin-text']");
        public void clickOnButtonSignIn() throws InterruptedException {
            WebElement ButtonSignIn = driver.findElement(buttonSignIn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonSignIn);
            Thread.sleep(1000);
            ButtonSignIn.click();
        }
    public boolean checkButtonSignIn_ISDP() throws InterruptedException {
        WebElement CheckButtonSignIn = driver.findElement(buttonSignIn);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", CheckButtonSignIn);
        Thread.sleep(1000);
        return CheckButtonSignIn.isDisplayed();
    }

    By buttonUserProfile = By.xpath("//span[@class= 'imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle navbar__user-name navbar__user-menu-toggle__name navbar__user-menu-toggle--desktop']");
    public void clickButtonUserProfile() throws InterruptedException {
        WebElement ButtonUserProfile = driver.findElement(buttonUserProfile);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonUserProfile);
        Thread.sleep(1000);
        ButtonUserProfile.click();
    }
    public boolean checkButtonUserProfile_ISDP() throws InterruptedException {
        WebElement CheckButtonUserProfile = driver.findElement(buttonUserProfile);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", CheckButtonUserProfile);
        Thread.sleep(1000);
        return CheckButtonUserProfile.isDisplayed();
    }

    By buttonSignOut = By.xpath("//span[text()= 'Sign out']"); //there may be problems in "translation testing"
    public void clickOnButtonSignOut() throws InterruptedException {
        WebElement ButtonSignOut = driver.findElement(buttonSignOut);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonSignOut);
        Thread.sleep(1000);
        ButtonSignOut.click();
    }

    By buttonWatchlist = By.xpath("//div[@class= 'sc-gScZFl jVzBBm imdb-header__watchlist-button']");
    public void clickOnButtonWatchlist() throws InterruptedException {
        WebElement ButtonWatchlist = driver.findElement(buttonWatchlist);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonWatchlist);
        Thread.sleep(1000);
        ButtonWatchlist.click();
    }
}