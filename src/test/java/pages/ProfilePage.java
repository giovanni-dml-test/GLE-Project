package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    WebDriver driver;

    // Locators (replace with your app’s real IDs/XPaths)
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By phoneField = By.id("phone");
    private By saveButton = By.id("btnSave");
    private By confirmationMessage = By.cssSelector(".alert-success");
    private By errorMessage = By.cssSelector(".alert-danger");

    private By changePasswordButton = By.id("btnChangePassword");
    private By currentPasswordField = By.id("currentPassword");
    private By newPasswordField = By.id("newPassword");
    private By confirmPasswordField = By.id("confirmPassword");

    private By profilePhotoButton = By.id("btnProfilePhoto");
    private By profilePhotoUpload = By.id("profileImageUpload");
    private By profileImage = By.cssSelector("img.profile-picture");

    private By deleteAccountButton = By.id("btnDeleteAccount");
    private By confirmDeleteButton = By.id("btnConfirmDelete");

    // Constructor
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Profile Info =====
    public boolean isProfileInfoDisplayed() {
        return driver.findElement(firstNameField).isDisplayed();
    }

    public void updateProfile(String firstName, String lastName, String phone) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "save":
                driver.findElement(saveButton).click();
                break;
            case "change password":
                driver.findElement(changePasswordButton).click();
                break;
            case "profile photo":
                driver.findElement(profilePhotoButton).click();
                break;
            case "delete account":
                driver.findElement(deleteAccountButton).click();
                break;
            default:
                throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // ===== Password Change =====
    public void changePassword(String currentPass, String newPass, String confirmPass) {
        driver.findElement(currentPasswordField).sendKeys(currentPass);
        driver.findElement(newPasswordField).sendKeys(newPass);
        driver.findElement(confirmPasswordField).sendKeys(confirmPass);
    }

    // ===== Profile Picture =====
    public void uploadProfilePicture(String filePath) {
        driver.findElement(profilePhotoUpload).sendKeys(filePath);
    }

    public boolean isProfilePictureDisplayed() {
        return driver.findElement(profileImage).isDisplayed();
    }

    // ===== Account Deletion =====
    public void confirmAccountDeletion() {
        driver.findElement(confirmDeleteButton).click();
    }

    public boolean isAccountDeleted() {
        // Example: check if redirect to login page after deletion
        return driver.getCurrentUrl().contains("/login");
    }
}
