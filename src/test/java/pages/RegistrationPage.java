package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By phoneInput = By.id("phone");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By termsCheckbox = By.id("terms");
    private By registerButton = By.id("registerBtn");
    private By errorMessage = By.cssSelector(".error-message");
    private By successMessage = By.cssSelector(".success-message");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInput).clear();
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
    }

    public void checkTermsAndConditions() {
        WebElement checkbox = driver.findElement(termsCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheckTermsAndConditions() {
        WebElement checkbox = driver.findElement(termsCheckbox);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    // Validation methods
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public boolean isTermsUncheckedByDefault() {
        return !driver.findElement(termsCheckbox).isSelected();
    }
}
