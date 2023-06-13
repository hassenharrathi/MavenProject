package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPwd {

    private WebDriver driver;
    private final By forgotPwd = By.id("spanForgot");
    private final By forgotPwdPanel = By.id("txtForgotEmailId");
    private final By forgotPwdSubmit = By.id("validate_forgot_otp");
    private final By enterCode = By.id("txtEmailMobileValidateMobileOTP");
    private final By submitCode = By.id("validateEmailMobileOtp");
    private final By newPwd = By.id("forgot_user_password");
    private final By submitNewPwd = By.xpath("//button[@id='forgot_pwd']");
    private final By searchPanel = By.id("search-strings");


    public ForgotPwd(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getForgotPwd() {
        return driver.findElement(forgotPwd);
    }

    public WebElement getForgotPwdPanel() {
        return driver.findElement(forgotPwdPanel);
    }

    public WebElement getForgotPwdSubmit() {
        return driver.findElement(forgotPwdSubmit);
    }

    public WebElement getEnterCode() {
        return driver.findElement(enterCode);
    }

    public WebElement getSubmitCode() {
        return driver.findElement(submitCode);
    }

    public WebElement getNewPwd() {
        return driver.findElement(newPwd);
    }

    public WebElement getSubmitNewPwd() {
        return driver.findElement(submitNewPwd);
    }

    public WebElement getSearchPanel() {
        return driver.findElement(searchPanel);
    }
}
