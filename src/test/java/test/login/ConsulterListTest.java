package test.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.CookiesPage;
import pages.LoginPage;
import pages.MenuPage;
import preTest.BaseTest;
import resources.Configuration;

import java.time.Duration;

public class ConsulterListTest extends BaseTest {

    @Test
    void testList() throws InterruptedException {
        //Instanciation
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        Configuration configuration = new Configuration();
        String username = configuration.getUsername("username");
        String password = configuration.getPassword("password");

        LoginPage loginPage = new LoginPage(driver);
        AcceuilPage acceuilPage = new AcceuilPage(driver);
        MenuPage menu = new MenuPage(driver);
        CookiesPage cookiesPage = new CookiesPage(driver);

        // Attente explicite pour l'affichage du panneau de cookies
        try{
            wait.until(ExpectedConditions.elementToBeClickable(cookiesPage.getCookiesPanel())).click();
        }catch (NoSuchElementException e){}

        // Attente explicite pour l'affichage du panneau de connexion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.tutorialspoint.com/market/login.asp']")));
        wait.until(ExpectedConditions.elementToBeClickable(acceuilPage.getConnectionPanel())).click();

        // Saisie des identifiants de connexion
        loginPage.getLoginEmailPanel().sendKeys(username);
        loginPage.getLoginPswPanel().sendKeys(password);
        loginPage.getSubmitPanel().click();

        // Attente explicite pour la fermeture de la fenêtre contextuelle
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Skip']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
