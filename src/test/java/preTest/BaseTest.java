package preTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @Test
     void t000_setup(){
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        this.driver = new ChromeDriver();
        //this.driver =new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/market/index.asp");
        driver.manage().window().maximize();

    }

    @AfterAll
    void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }

        // Take a screenshot in case of test failure
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            try {
                // Capture the screenshot as a file
                Path screenshotPath = Paths.get("C:\\dev\\Maven\\ProjetMaven\\ScreenShot\\screenshot.png");
                Files.copy(screenshotDriver.getScreenshotAs(OutputType.FILE).toPath(), screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
