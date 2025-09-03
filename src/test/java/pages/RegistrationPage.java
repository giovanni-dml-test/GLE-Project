package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By phoneInput = By.name("phone");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By confirmPasswordInput = By.name("confirmPassword");
    private By termsCheckbox = By.id("terms");
    private By registerButton = By.xpath("//button[text()='Register']");
    private By errorMessage = By.xpath("//div[@class='p-toast-detail' and text()='E-mail already exists.']");
    private By successMessage = By.xpath("//div[@class='p-toast-detail' and text()='Your registration has been completed successfully. Please to activate your account, click on the activation link sent to your e-mail.']");
    private By firstNameError = By.xpath("//span[text()='First name is required']");
    private By lastNameError = By.xpath("//span[text()='Last name is required']");
    private By phoneError = By.xpath("//span[text()='Phone is required']");
    private By emailError = By.xpath("//span[text()='Email is required']");
    private By passwordError = By.xpath("//span[text()='Password is required']");
    private By confirmPasswordError = By.xpath("//span[text()='Confirm password is required']");

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

    public void open() {
        driver.get("http://64.227.123.49/register"); // Replace with actual URL
    }
}
