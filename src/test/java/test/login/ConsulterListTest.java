package test.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.LoginPage;
import pages.MenuPage;
import preTest.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConsulterListTest extends BaseTest {
    @Test
    void testList() throws InterruptedException {

        //Déclaration attributs
        String username = "hassenharrathi@yahoo.fr";
        String password = "Ch*1982*";

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));

        //Instanciation
        LoginPage loginPage = new LoginPage(driver);
        AcceuilPage acceuilPage = new AcceuilPage(driver);
        MenuPage menu = new MenuPage(driver);

        // Attente explicite pour l'affichage du panneau de connexion
        wait.until(ExpectedConditions.elementToBeClickable(acceuilPage.getConnectionPanel())).click();

        // Saisie des identifiants de connexion
        loginPage.getLoginEmailPanel().sendKeys(username);
        loginPage.getLoginPswPanel().sendKeys(password);
        loginPage.getSubmitPanel().click();

        // Attente explicite pour la fermeture de la fenêtre contextuelle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Skip']")));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPopUpPanel())).click();

        // Navigation dans le menu
        menu.getMenuPanel().click();
        menu.getListPanel().click();

        // Déconnexion
        Thread.sleep(5000);
        acceuilPage.getLogOut().click();
        acceuilPage.getSignOut().click();

    }
}
