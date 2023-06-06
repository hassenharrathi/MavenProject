package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiesPage {
    private WebDriver driver;
    By cookies = By.id("banner-accept");

    public CookiesPage(WebDriver driver) {
        this.driver = driver;
   }
    public WebElement getCloseCookies() {
        return driver.findElement(cookies);
    }
//
//    public WebElement getCookies() {
//        return driver.findElement(cookies);
//    }
}
