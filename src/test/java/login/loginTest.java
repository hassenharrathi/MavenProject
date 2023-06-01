package login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.LoginPage;
import pages.MenuPage;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest {
    @Test
    void testLogin ()  {

        //Déclaration attributs
        String username = "hassenharrathi@yahoo.fr";
        String password = "Ch*1982*";

        //WebDriver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));

        //Instanciation
        LoginPage loginPage = new LoginPage(driver);
        AcceuilPage acceuilPage = new AcceuilPage(driver);

        //Adresse site web
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

        //Attente explicite pour l'affichage du panneau de connexion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.tutorialspoint.com/market/login.asp']")));
        wait.until(ExpectedConditions.elementToBeClickable(acceuilPage.getConnectionPanel())).click();

        // Saisie des identifiants de connexion
        loginPage.getLoginEmailPanel().sendKeys(username);
        loginPage.getLoginPswPanel().sendKeys(password);
        loginPage.getSubmitPanel().click();

        // Attente explicite pour la fermeture de la fenêtre contextuelle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Skip']")));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPopUpPanel())).click();

        // Déconnexion
        acceuilPage.getLogOut().click();
        acceuilPage.getSignOut().click();

        //Fermer navigateur
        driver.quit();
    }

}
