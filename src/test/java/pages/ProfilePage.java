package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ProfilePage {

    WebDriver driver;

    // Locators (replace with your app’s real IDs/XPaths)

    @FindBy(xpath = "//button[text()='Profile']")
    public WebElement profileTab;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "phone")
    public WebElement phoneField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "btnUpdateProfile")
    public WebElement updateButton;

    @FindBy(css = ".alert-success")
    public WebElement confirmationMessage;

    @FindBy(css = ".alert-danger")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[text()='Change Password']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//button[text()='CHANGE']")
    public WebElement saveButton;

    @FindBy(id = "currentPassword")
    public WebElement currentPasswordField;

    @FindBy(id = "newPassword")
    public WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[text()='Profile Photo']")
    public WebElement profilePhotoButton;

    @FindBy(className = "p-image-preview-indicator")
    public WebElement btn_profileImagePreview;

    @FindBy(className = "p-image-preview")
    public WebElement profileImagePreview;

    @FindBy(xpath = "//button[text()='SELECT']")
    public WebElement profilePhotoSelect;

    @FindBy(css = "input[type='file'][accept='image/*']")
    public WebElement profileImage;

    @FindBy(xpath = "//button[text()='Delete Account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//button[text()='DELETE ACCOUNT']")
    public WebElement btn_DeleteButton;

    @FindBy(css = ".p-confirm-dialog-accept.p-button.p-component")
    public WebElement btn_ConfirmDeletion;

    @FindBy(css = ".p-confirm-dialog-reject.p-button-text.p-button.p-component")
    public WebElement btn_RejectDeletion;


    // Constructor
    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}