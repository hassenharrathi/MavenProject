package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private WebDriver driver;
    private final By menuPanel = By.xpath("//a[text()='eBooks']");
    private final By listPanel = By.xpath("//a[contains(@href,'https://www.tutorialspoint.com/market/student/ebookLists.jsp?')]");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getMenuPanel() { 
        return driver.findElement(menuPanel);
    }

    public WebElement getListPanel() {
        return driver.findElement(listPanel);
    }
}
