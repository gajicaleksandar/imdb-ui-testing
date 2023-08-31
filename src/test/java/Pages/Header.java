package Pages;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    By buttonProfileMenu = By.xpath("//span[@class = 'imdb-header__account-toggle--logged-in imdb-header__accountmenu-toggle navbar__user-name" +
            " navbar__user-menu-toggle__name navbar__user-menu-toggle--desktop']");
    public void clickOnButtonProfileMenu() throws InterruptedException {
        WebElement ButtonProfileMenu = driver.findElement(buttonProfileMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ButtonProfileMenu);
        Thread.sleep(1000);
        ButtonProfileMenu.click();
    }

}