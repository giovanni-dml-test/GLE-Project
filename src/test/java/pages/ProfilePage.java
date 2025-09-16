package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ProfilePage {


    // Locators (replace with your app’s real IDs/XPaths)


    @FindBy(name = "firstName")
    public WebElement firstNameField;

    @FindBy(name = "lastName")
    public WebElement lastNameField;

    @FindBy(name = "phone")
    public WebElement phoneField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(xpath = "//button[text()='UPDATE']")
    public WebElement updateButton;

    @FindBy(xpath = "//div[text()='Profile updated successfully']")
    public WebElement confirmationMessage;

    @FindBy(css = ".alert-danger")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@data-rr-ui-event-key='change-password']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//button[text()='CHANGE']")
    public WebElement changeButton;

    @FindBy(name = "currentPassword")
    public WebElement currentPasswordField;

    @FindBy(name = "newPassword")
    public WebElement newPasswordField;

    @FindBy(name = "repeatNewPassword")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@data-rr-ui-event-key='profile-photo']")
    public WebElement profilePhotoButton;

    @FindBy(className = "p-image-preview-indicator")
    public WebElement btn_profileImagePreview;

    @FindBy(css = "img[alt='profile-image']")
    public WebElement image_preview;

    @FindBy(className = "p-image-preview")
    public WebElement profileImagePreview;

    @FindBy(xpath = "//button[text()='SELECT']")
    public WebElement profilePhotoSelect;

    @FindBy(xpath = "//button[text()='SAVE']")
    public WebElement saveButton;

    @FindBy(css = "input[type='file'][accept='image/*']")
    public WebElement profileImage;

    @FindBy(xpath = "//*[@data-rr-ui-event-key='delete-account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//div[@class='form-submit-button']//button[contains(.,'DELETE ACCOUNT')]")
    public WebElement btn_DeleteButton;

    @FindBy(xpath = "//*[@aria-label='Yes']")
    public WebElement btn_ConfirmDeletion;

    @FindBy(css = ".p-confirm-dialog-reject.p-button-text.p-button.p-component")
    public WebElement btn_RejectDeletion;

    @FindBy(xpath = "//button[text()='DONE']")
    public WebElement done_Button;

    @FindBy(name = "password")
    public WebElement enter_your_password_on_delete;


    // Constructor
    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}