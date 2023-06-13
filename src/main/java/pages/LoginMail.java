package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMail {

    private WebDriver driver;
    private final By connectButton = By.xpath("//*[text()='Connexion']");
    private final By userNamePanel = By.id("identifierId");
    private final By userNameSignin = By.xpath("//*[@id=\"identifierNext\"]/div/button");                                   //*[text()='Suivant']
    private final By pwdPanel = By.xpath("//input[@aria-label='Saisissez votre mot de passe' or @aria-label='Enter your password']");
    private final By pwdButton = By.xpath("//button[span[text()='Suivant' or text()='Next']]");
    private final By openTask = By.xpath("//div[div/span/a[text()='Test']]");
    private final By openEmail = By.xpath("//td[@Class='yX xY ']");
    private final By getCode = By.xpath("//tr[5]/td/p");
    private final By checkBox = By.xpath("//input[@type='checkbox']");


    public LoginMail(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getConnectButton() {
        return driver.findElement(connectButton);
    }

    public WebElement getUserNamePanel() {
        return driver.findElement(userNamePanel);
    }

    public WebElement getUserNameSignin() {
        return driver.findElement(userNameSignin);
    }

    public WebElement getPwdPanel() {
        return driver.findElement(pwdPanel);
    }

    public WebElement getPwdButton() {
        return driver.findElement(pwdButton);
    }

    public WebElement getOpenTask() {
        return driver.findElement(openTask);
    }

    public WebElement getOpenEmail() {
        return driver.findElement(openEmail);
    }

    public WebElement getGetCode() {
        return driver.findElement(getCode);
    }

    public WebElement getCheckBox() {
        return driver.findElement(checkBox);
    }
}
