package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure {
    /*
    A screenshot is captured only on failure in any test
    Screenshots are stored in a folder named "screenshots" and each new screenshot is named "ScreenshotFailure + test name.png"
    */
    public static void TakingScreenshot(WebDriver driver, String screenshotname) throws IOException {

        File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotfile, new File("C:\\Users\\gordi\\aleksandar gajic\\imdb-testing2\\screenshots./ScreenshotFailure_" + screenshotname + ".png"));
    }
}