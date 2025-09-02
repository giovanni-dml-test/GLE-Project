package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators (replace with your real app’s values)
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("btnLogin");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }
}
