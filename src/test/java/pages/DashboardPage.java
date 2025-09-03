package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    // Locators
    private By submenuLink = By.id("subMenu");
    private By myProfileLink = By.linkText("My Profile");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfile() {
        driver.findElement(myProfileLink).click();
    }

    public void navigateTo(String menuOption) {
        switch (menuOption.toLowerCase()) {
            case "my profile":
                driver.findElement(myProfileLink).click();
                break;
            // Add more cases for other menu options as needed
            default:
                throw new IllegalArgumentException("Unknown menu option: " + menuOption);
        }
    }

    public boolean isAdminDashboardDisplayed() {
        boolean isDisplayed = false;
        try {
            isDisplayed = driver.getCurrentUrl().equals("http://64.227.123.49/dashboard");
        } catch (Exception e) {
            isDisplayed = false;
    }
        return isDisplayed;
    }
}
