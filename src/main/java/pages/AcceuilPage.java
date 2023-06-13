package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AcceuilPage {

    public WebDriver driver;
    private final By connectionButton = By.xpath("//a[contains(text(),'Login')]");
    private final By logOut = By.id("profileMenu");
    private final By signOut = By.xpath("//a[@class='logout']");

    public AcceuilPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getConnectionButton() {
        return driver.findElement(connectionButton);
    }

    public WebElement getLogOut() {
        return driver.findElement(logOut);
    }

    public WebElement getSignOut() {
        return driver.findElement(signOut);
    }
}
