package TestBase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static JavascriptExecutor js;
    public static WebDriver driver;

    protected static ExtentReports extent;
    protected ExtentTest test;



    @BeforeTest
    public void setUp() {
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
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
