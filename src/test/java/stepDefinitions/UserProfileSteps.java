package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.ConfigReader;
import utils.Driver;

import static org.junit.Assert.*;

public class UserProfileSteps {
    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        loginPage = new LoginPage();
        homepage = new HomePage();
        profilePage = new ProfilePage();

        Driver.getDriver().get("http://64.227.123.49/login");
        loginPage.login("testuser", "password123");
        assertEquals("http://64.227.123.49", Driver.getDriver().getCurrentUrl());
    }

    @When("the user navigates to the dashboard")
    public void the_user_navigates_to_the_dashboard() {
        homepage.myProfile.click();
        assertTrue(Driver.getDriver().getCurrentUrl().contains("/my-profile"));
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String menuOption) {
        clickButton(menuOption);
    }

    @Then("the profile information \\(name, email, phone, etc.) is displayed")
    public void the_profile_information_is_displayed() {

        assertTrue(profilePage.firstNameField.getText().length() > 0);
        assertTrue(profilePage.lastNameField.getText().length() > 0);
        assertTrue(profilePage.emailField.getText().length() > 0);
        assertTrue(profilePage.phoneField.getText().length() > 0);

    }

    @Given("the profile page is open")
    public void the_profile_page_is_open() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("my-profile"));
    }

    @When("the user updates profile fields \\(e.g., first name, last name, phone number)")
    public void the_user_updates_profile_fields() {
        updateProfile();
    }

    @When("the user clicks {string}")
    public void the_user_clicks(String button) {
        clickButton(button);
    }

    @Then("the profile is updated successfully")
    public void the_profile_is_updated_successfully() {
        assertEquals("Profile updated successfully!", profilePage.confirmationMessage);
    }

    @When("the user opens {string}")
    public void the_user_opens(String section) {
        clickButton(section);
    }

    @When("the user clicks {string}")
    public void the_user_clicks_button(String button) {
        clickButton(button);
    }

    @When("the user enters current password, new password, and confirms new password")
    public void the_user_enters_current_password_new_password_and_confirms_new_password() {
        profilePage.currentPasswordField.sendKeys(ConfigReader.getProperty("current_password"));
        profilePage.newPasswordField.sendKeys(ConfigReader.getProperty("new_password"));
        profilePage.confirmPasswordField.sendKeys(ConfigReader.getProperty("new_password"));
    }

    @Then("the password is updated successfully")
    public void the_password_is_updated_successfully() {
        assertEquals("Password updated successfully!", profilePage.confirmationMessage);
    }

    @When("the user uploads a valid image file \\(e.g., .jpg, .png)")
    public void the_user_uploads_a_valid_image_file() {
        uploadProfilePicture();
    }

    @Then("the profile picture is uploaded")
    public void the_profile_picture_is_uploaded() {
        assertTrue(isProfilePictureDisplayed());
    }

    @Then("the profile picture is displayed correctly")
    public void the_profile_picture_is_displayed_correctly() {
        assertTrue(isProfilePictureDisplayed());
    }

    @When("the user tries uploading an invalid file type \\(e.g., .exe, .pdf)")
    public void the_user_tries_uploading_an_invalid_file_type() {
        uploadProfilePicture();
    }

    @Then("an error message appears {string}")
    public void an_error_message_appears(String expectedMessage) {
        assertEquals(expectedMessage, profilePage.errorMessage);
    }

    @When("the user clicks {string}")
    public void the_user_clicks_delete_account(String button) {
        clickButton(button);
    }

    @When("the user confirms deletion")
    public void the_user_confirms_deletion() {
        profilePage.btn_ConfirmDeletion.click();
    }

    @Then("the account is deleted")
    public void the_account_is_deleted() {
        assertTrue(isAccountDeleted());
    }

    public void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "update":
                (profilePage.updateButton).click();
                break;
            case "change password":
                (profilePage.changePasswordButton).click();
                break;
            case "profile photo":
                (profilePage.profilePhotoButton).click();
                break;
            case "delete account":
                (profilePage.deleteAccountButton).click();
                break;
            case "profile":
                profilePage.profileTab.click();
                break;
            default:
                throw new IllegalArgumentException("Button not recognized: " + buttonName);
        }
    }

    public void updateProfile() {
        profilePage.firstNameField.clear();
        profilePage.firstNameField.sendKeys(ConfigReader.getProperty("first_name"));

        profilePage.lastNameField.clear();
        profilePage.lastNameField.sendKeys(ConfigReader.getProperty("last_name"));

        profilePage.phoneField.clear();
        profilePage.phoneField.sendKeys(ConfigReader.getProperty("phone_number"));
    }

    // ===== Profile Picture =====
    public void uploadProfilePicture() {
        profilePage.profileImage.sendKeys(ConfigReader.getProperty("profile_picture_path"));
    }

    public void uploadInvalidProfilePicture() {
        profilePage.profileImage.sendKeys(ConfigReader.getProperty("invalid_profile_image_path"));
    }
    public boolean isProfilePictureDisplayed() {
        return profilePage.profileImage.isDisplayed();
    }

    @And("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        assertEquals(profilePage.confirmationMessage.getText(), "Profile updated successfully!");
        throw new PendingException();
    }

    public boolean isAccountDeleted() {
        // Example: check if redirect to login page after deletion
        return Driver.getDriver().getCurrentUrl().contains("/login");
    }

   @Then("the user is logged out")
    public void the_user_is_logged_out() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("/login"));
    }

    @Then("the account cannot be accessed anymore")
    public void the_account_cannot_be_accessed_anymore() {
        loginPage.login(ConfigReader.getProperty("gio_customer_username"), ConfigReader.getProperty("gio_customer_password"));
        assertTrue(loginPage.emailErrorMessage.isDisplayed());
        Driver.closeDriver();
    }
}
