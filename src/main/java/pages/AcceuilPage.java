package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AcceuilPage {
    public WebDriver driver;
    private final By connectionPanel = By.xpath("//*[@href='https://www.tutorialspoint.com/market/login.asp']");
    private final By logOut = By.id("profileMenu");
    private final By signOut = By.xpath("//a[@class='logout']");

    public AcceuilPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getConnectionPanel() {
        return driver.findElement(connectionPanel);
    }

    public WebElement getLogOut() {
        return driver.findElement(logOut);
    }

    public WebElement getSignOut() {
        return driver.findElement(signOut);
    }
}
