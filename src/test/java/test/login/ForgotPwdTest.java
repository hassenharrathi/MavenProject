package test.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.ForgotPwd;
import pages.LoginMail;
import preTest.BaseTest;
import resources.Configuration;
import java.time.Duration;


class ForgotPwdTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ForgotPwdTest.class);
    Configuration configuration = new Configuration("src/main/java/resources/config.properties");
    String username = configuration.getUsername("username");
    String password = configuration.getPassword("password");
    String mail = configuration.getMail("mail");

    @Test
    @BeforeEach
    void recoverPwd() {

        ForgotPwd forgotPwd = new ForgotPwd(driver);
        AcceuilPage acceuilPage = new AcceuilPage(driver);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOf(acceuilPage.getConnectionButton())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getForgotPwd())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getForgotPwdPanel())).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getForgotPwdSubmit())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Enregistrement d'un message avec Log4j");

    }

    @Test
    @AfterEach
    void getCodeByMail() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        LoginMail loginmail = new LoginMail(driver);
        ForgotPwd forgotPwd = new ForgotPwd(driver);

        // Exécuter du code JavaScript pour ouvrir un nouvel onglet
        ((JavascriptExecutor) driver).executeScript("window.open();");

        // Obtenir les identifiants des onglets
        String mainTab = driver.getWindowHandle();
        String newTab = driver.getWindowHandles().stream().filter(handle -> !handle.equals(mainTab)).findFirst().orElse("");

        // Changer de focus vers le nouvel onglet
        driver.switchTo().window(newTab);

        // Faire des actions sur le nouvel onglet
        driver.get(mail);

        wait.until(ExpectedConditions.visibilityOf(loginmail.getConnectButton())).click();
        wait.until(ExpectedConditions.visibilityOf(loginmail.getUserNamePanel())).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(loginmail.getUserNameSignin())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginmail.getPwdPanel())).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginmail.getPwdButton())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@Class='yX xY ']")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginmail.getOpenEmail())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String text = wait.until(ExpectedConditions.visibilityOf(loginmail.getGetCode())).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();
        // Revenir à l'onglet principal
        driver.switchTo().window(mainTab);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getEnterCode())).sendKeys(text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getSubmitCode())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getNewPwd())).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getNewPwd())).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(forgotPwd.getSubmitNewPwd())).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

