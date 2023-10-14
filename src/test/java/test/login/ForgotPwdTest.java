package test.login;

import io.qameta.allure.junit5.AllureJunit5;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.ForgotPwd;
import pages.LoginMail;
import preTest.BaseTest;
import resources.Configuration;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(AllureJunit5.class)
public class ForgotPwdTest extends BaseTest {
    //private static final Logger logger = LogManager.getLogger(ForgotPwdTest.class);
    Configuration configuration = new Configuration("src/main/java/resources/config.properties");
    String username = configuration.getUsername("username");
    String password = configuration.getPassword("password");
    String mail = configuration.getMail("mail");
    private final String locatorMessage = "locator is null";

    @Test
    void t001_recoverPwd() {

        ForgotPwd forgotPwd = new ForgotPwd(driver);
        AcceuilPage acceuilPage = new AcceuilPage(driver);


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(acceuilPage.getConnectionButton1()));
        acceuilPage.getConnectionButton().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getForgotPwd1()));
        assertNotNull(forgotPwd.getForgotPwd(),locatorMessage);
        forgotPwd.getForgotPwd().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getForgotPwdPanel1()));
        assertNotNull(forgotPwd.getForgotPwdPanel(),locatorMessage);
        forgotPwd.getForgotPwdPanel().sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getForgotPwdSubmit1()));
        assertNotNull(forgotPwd.getForgotPwdSubmit(),locatorMessage);
        forgotPwd.getForgotPwdSubmit().click();


        String pageContent = driver.findElement(By.tagName("body")).getText();
        String expectedText = "Max attempts reached";
        boolean isTextPresent = pageContent.contains(expectedText);
        if (isTextPresent){
            driver.quit();
            return;
        }
        //logger.info("Enregistrement d'un message avec Log4j");
    }

    @Test
    void t002_getCodeByMail() throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            LoginMail loginmail = new LoginMail(driver);
            ForgotPwd forgotPwd = new ForgotPwd(driver);
            Actions actions = new Actions(driver);

            // Exécuter du code JavaScript pour ouvrir un nouvel onglet
            ((JavascriptExecutor) driver).executeScript("window.open();");

            // Obtenir les identifiants des onglets                                                                             //String newTab = driver.getWindowHandles().stream().filter(e -> !e.equals(mainTab)).findFirst().orElse("");
            String[] allTabs = driver.getWindowHandles().toArray(new String[driver.getWindowHandles().size()]);                 //String mainTab = driver.getWindowHandle();

            // Changer de focus vers le nouvel onglet
            driver.switchTo().window(allTabs[1]);                                                                               //driver.switchTo().window(newTab);)

            // Faire des actions sur le nouvel onglet
            driver.get(mail);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getConnectButton1()));
            loginmail.getConnectButton().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getUserNamePanel1()));
            loginmail.getUserNamePanel().sendKeys(username);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getUserNameSignin1()));
            loginmail.getUserNameSignin().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getPwdPanel1()));
            loginmail.getPwdPanel().sendKeys(password);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getPwdButton1()));
            loginmail.getPwdButton().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getOpenEmail1()));
            loginmail.getOpenEmail().click();

            //Get Code from Email
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getGetCode1()));
            String text = loginmail.getGetCode().getText();

            actions.moveByOffset(272, 78).click().build().perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getSelectEmail1()));
            actions.click().build().perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginmail.getDeleteEmail1()));
            //actions.click().build().perform();
            loginmail.getDeleteEmail().click();
            Thread.sleep(5000);

            // Revenir à l'onglet principal
            driver.switchTo().window(allTabs[0]);

            //Input Code
            wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getEnterCode1()));
            assertNotNull(forgotPwd.getEnterCode(),locatorMessage);
            forgotPwd.getEnterCode().sendKeys(text);

            wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getSubmitCode1()));
            assertNotNull(forgotPwd.getSubmitCode(),locatorMessage);
            forgotPwd.getSubmitCode().click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getNewPwd1()));
            assertNotNull(forgotPwd.getNewPwd(),locatorMessage);
            forgotPwd.getNewPwd().clear();
            forgotPwd.getNewPwd().sendKeys(password);

            wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getConfirmPsw1()));
            assertNotNull(forgotPwd.getConfirmPsw(),locatorMessage);
            forgotPwd.getConfirmPsw().clear();
            forgotPwd.getConfirmPsw().sendKeys(password);

            wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPwd.getSubmitNewPwd1()));
            assertNotNull(forgotPwd.getSubmitNewPwd(),locatorMessage);
            forgotPwd.getSubmitNewPwd().click();
        }

}

