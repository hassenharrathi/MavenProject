package test.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AcceuilPage;
import pages.CookiesPage;
import pages.LoginPage;
import preTest.BaseTest;
import resources.Configuration;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @Test
    void testLogin () {

            // Temps d'attente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

            Configuration configuration = new Configuration("src/main/java/resources/config.properties");
            String username = configuration.getUsername("username");
            String password = configuration.getPassword("password");

            // Instanciation
            AcceuilPage acceuilPage = new AcceuilPage(driver);
            CookiesPage cookiesPage = new CookiesPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            // Attente explicite pour l'affichage du panneau de cookies
//        WebElement cookiePopup = cookiesPage.getCloseCookies();
//        if (cookiePopup.isDisplayed()) {
//            // Fermer la pop-up de cookies en cliquant sur un élément approprié (par exemple, un bouton "Accepter")
//            //WebElement acceptButton = cookiePopup.findElement(By.id());
//            //acceptButton.click();
//            cookiePopup.click();
//        }

            // Attente explicite pour l'affichage du panneau de connexion
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.tutorialspoint.com/market/login.asp']")));
            wait.until(ExpectedConditions.elementToBeClickable(acceuilPage.getConnectionButton())).click();

            // Saisie des identifiants de connexion
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            loginPage.getLoginEmail().sendKeys(username);
            loginPage.getLoginPsw().sendKeys(password);
            loginPage.getSubmit().click();

            // Attente explicite pour la fermeture de la fenêtre contextuelle
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Skip']")));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPopUp())).click();

            // Déconnexion
            acceuilPage.getLogOut().click();
            acceuilPage.getSignOut().click();
    }

}
