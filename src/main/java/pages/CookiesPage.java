package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiesPage {
    private WebDriver driver;
    private final By cookiesPanel = By.id("banner-accept");

    public CookiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCookiesPanel() {
        return driver.findElement(cookiesPanel);
    }
}
