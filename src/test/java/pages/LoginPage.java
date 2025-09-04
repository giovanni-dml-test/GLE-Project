package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class LoginPage {
    //  Constructor
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //  Locators
    @FindBy(name = "email")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Invalid email')]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Password is required')]")
    private WebElement passwordRequiredMessage;

    @FindBy(css = "div.p-toast-detail")
    private WebElement invalidLoginMessage;


    //  Page Methods
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getInvalidEmailMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordRequiredMessage() {
        return passwordRequiredMessage.getText();
    }

    public String getInvalidLoginMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(invalidLoginMessage));
        return invalidLoginMessage.getText();
    }

    public void clickOnPasswordField() {
        passwordField.click();
    }

    public void clickOnEmailField() {
        usernameField.click();
    }

    public boolean isPasswordErrorDisplayed() {
        try {
            return passwordRequiredMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
