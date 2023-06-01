package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ressources.Variables;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private final By loginEmailPanel = By.id("user_email");
    private final By loginPswPanel = By.id("user_password");
    private final By submitPanel = By.id("user_login");
    private final By popUpPanel = By.xpath("//a[text()='Skip']");
    public LoginPage(WebDriver driver) {
    this.driver = driver;

    }

    public WebElement getLoginEmailPanel() {
        return driver.findElement(loginEmailPanel) ;
    }

    public WebElement getLoginPswPanel() {
        return driver.findElement(loginPswPanel) ;
    }

    public WebElement getSubmitPanel() {
        return driver.findElement(submitPanel);
    }

    public WebElement getPopUpPanel() {
        return driver.findElement(popUpPanel);
    }

}

