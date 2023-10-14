package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private final By loginEmailPanel = By.id("user_email");
    private final By loginPswPanel = By.id("user_password");
    private final By submitPanel = By.id("user_login");
    private final By popUpPanel = By.xpath("//a[text()='Skip']");


    public LoginPage(WebDriver driver) {
    this.driver = driver;

    }

    public WebElement getLoginEmail() {
        return driver.findElement(loginEmailPanel) ;
    }

    public WebElement getLoginPsw() {
        return driver.findElement(loginPswPanel) ;
    }

    public WebElement getSubmit() {
        return driver.findElement(submitPanel);
    }

    public WebElement getPopUp() {
        return driver.findElement(popUpPanel);
    }

}

