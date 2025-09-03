package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    // Locators (replace with your real app’s values)
    private By usernameField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button.btn.btn-primary");
    private By emailerrorMessage = By.xpath("//div[text()='Invalid email']");
    private By passwordRequiredMessage = By.xpath("//div[text()='Password is required']");
    private By invalidLoginmessage= By.xpath("//div[text()='Invalid email or password. Please check your credentials and try again.']");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public String getInvalidEmailMessage() {
        return driver.findElement(emailerrorMessage).getText();
    }

    public String passwordRequiredMessage() {
        return driver.findElement(passwordRequiredMessage).getText();
    }

    public String getInvalidLoginMessage(){
        return  driver.findElement(invalidLoginmessage).getText();
    }
}
