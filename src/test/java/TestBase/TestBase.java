package TestBase;

import Utility.ScreenShotOnFailure;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public static JavascriptExecutor js;
    public static WebDriver driver;

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
        System.out.println("Starting test: " + getClass());
    }

    @AfterTest
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            System.out.println("The test " + getClass() + " was successfully finished");
            driver.quit();
        }
    }
}