package preTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
     void setup(){
        this.driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/index.htm");

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
                Path screenshotPath = Paths.get("path/to/screenshot.png");
                Files.copy(screenshotDriver.getScreenshotAs(OutputType.FILE).toPath(), screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
