package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    // Locators (replace with your real app’s values)
    private By usernameField = By.name("email");
    private By passwordField = By.name("password");
    private By emailerrorMessage = By.xpath("//div[contains(text(),'Invalid email')]");
    private By passwordRequiredMessage = By.xpath("//div[contains(text(),'Password is required')]");
    //private By invalidLoginMessage = By.xpath("//div[contains(text(), 'Invalid username or password')]");
    private By invalidLoginMessage =By.cssSelector("div.p-toast-detail");
    //private By loginButton = By.cssSelector("submit-button.btn.btn-secondary");
    private By loginButton=By.xpath("//button[text()='LOGIN']");


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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the message is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage));
        return driver.findElement(invalidLoginMessage).getText();
    }

    public void clickOnPasswordField() {

        driver.findElement(passwordField).click();
    }
    public void clickOnEmailField() {

        driver.findElement(usernameField).click();
    }
    public boolean isPasswordErrorDisplayed() {
        try {
            return driver.findElement(passwordRequiredMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
