package TestBase;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public static JavascriptExecutor js;
    public static WebDriver driver;
    String currentClass = String.valueOf(getClass());

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/gordi/aleksandar gajic/libs/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        js = new JavascriptExecutor() {
            @Override
            public Object executeScript(String script, Object... args) {
                return null;
            }
            @Override
            public Object executeAsyncScript(String script, Object... args) {
                return null;
            }
        };
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        String baseURL = "https://www.imdb.com/";
        driver.get(baseURL);
        String testMessage1 = "- The Test " + currentClass + " is started!";
            System.out.println(testMessage1);
            Allure.step(testMessage1);
    }

    @AfterTest
    public void tearDown() {
        String testMessage = "- The test " + currentClass + " was finished!";
            System.out.println(testMessage);
            Allure.step(testMessage);
        driver.quit();
    }
}