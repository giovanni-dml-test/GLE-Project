package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    // Locators
    private By submenuLink = By.id("subMenu");
    private By myProfileLink = By.linkText("My Profile");
    private By backToSite =By.xpath("//span[text()='Back to Site']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfile() {
        driver.findElement(myProfileLink).click();
    }

    public void goBackTosite(){
        driver.findElement(backToSite).click();
    }
}
