package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPwd {

    private WebDriver driver;
    private final By forgotPwd = By.id("spanForgot");
    private final By forgotPwdPanel = By.id("mobile_email");                                 //("txtForgotEmailId");
    private final By forgotPwdSubmit = By.id("forgotgetOtp");                                //("validate_forgot_otp");
    private final By enterCode = By.xpath("//input[contains(@class,'otp-input')]");
    private final By submitCode = By.id("forgotOtpNextBtn");
    private final By newPwd = By.id("password");
    private final By confirmPsw = By.id("confirm-password");
    private final By submitNewPwd = By.id("forgotChangePasswordBtn");
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
    public WebElement getConfirmPsw(){
        return driver.findElement(confirmPsw);
    }

    public WebElement getSubmitNewPwd() {
        return driver.findElement(submitNewPwd);
    }

    public WebElement getSearchPanel() {
        return driver.findElement(searchPanel);
    }
    public By getForgotPwd1(){
        return forgotPwd;
    }
    public By getForgotPwdPanel1(){
        return forgotPwdPanel;
    }
    public By getForgotPwdSubmit1(){
        return forgotPwdSubmit;
    }
    public By getEnterCode1(){
        return enterCode;
    }
    public By getSubmitCode1(){
        return submitCode;
    }
    public By getNewPwd1(){
        return newPwd;
    }
    public By getConfirmPsw1(){
        return confirmPsw;
    }
    public By getSubmitNewPwd1(){
        return submitNewPwd;
    }
}
