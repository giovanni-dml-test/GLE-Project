package stepDefinitions.UI;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import utils.ConfigReader;
import utils.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static org.junit.Assert.*;


public class UserProfileSteps {
    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

        loginPage = new LoginPage();
        homepage = new HomePage();
        profilePage = new ProfilePage();

        Driver.getDriver().get(ConfigReader.getProperty("GLE_login_page"));
        loginPage.login(ConfigReader.getProperty("customer_username"), ConfigReader.getProperty("customer_password"));
        Thread.sleep(5000);
        assertEquals("http://64.227.123.49/", Driver.getDriver().getCurrentUrl());
    }

    @When("the user navigates to the dashboard")
    public void the_user_navigates_to_the_dashboard() {
        homepage.profileIcon.click();
        homepage.myProfile.click();
        assertTrue(Driver.getDriver().getCurrentUrl().contains("/my-profile"));
    }




    @Given("the profile page is open")
    public void the_profile_page_is_open() {
        homepage.profileIcon.click();
        homepage.myProfile.click();

        assertTrue(Driver.getDriver().getCurrentUrl().contains("/my-profile"));
    }

    @When("the user updates profile fields")
    public void the_user_updates_profile_fields() throws InterruptedException {
        updateProfile();
    }

    @When("the user clicks the update button")
    public void the_user_clicks_update_button() {
        profilePage.updateButton.click();
    }






    @When("the user enters current password, new password, and confirms new password")
    public void the_user_enters_current_password_new_password_and_confirms_new_password() throws InterruptedException {

//        profilePage.currentPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//
//        Thread.sleep(1000);

        profilePage.currentPasswordField.sendKeys(ConfigReader.getProperty("current_password"));

        Thread.sleep(1000);

        profilePage.currentPasswordField.sendKeys(Keys.TAB);


//        profilePage.newPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//
//        Thread.sleep(1000);

        profilePage.newPasswordField.sendKeys(ConfigReader.getProperty("different_password"));

        Thread.sleep(1000);

        profilePage.newPasswordField.sendKeys(Keys.TAB);



//        profilePage.confirmPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//
//        Thread.sleep(1000);

        profilePage.confirmPasswordField.sendKeys(ConfigReader.getProperty("different_password"));

//        Thread.sleep(1000);
//
//        profilePage.confirmPasswordField.sendKeys(Keys.TAB);


    }



    @When("the user uploads a valid image file")
    public void the_user_uploads_a_valid_image_file() {
        uploadProfilePicture();
    }


    @When("the user tries uploading an invalid file type")
    public void the_user_tries_uploading_an_invalid_file_type() {
        uploadInvalidProfilePicture();
    }


    @When("the user confirms deletion")
    public void the_user_confirms_deletion() throws InterruptedException {
        profilePage.btn_DeleteButton.click();
        profilePage.btn_ConfirmDeletion.click();
    }

    @And("the user clicks on the Done button")
    public void theUserClicksOnTheDoneButton() {
        profilePage.done_Button.click();
    }



    @When("the user clicks Delete Account")
    public void theUserClicksDeleteAccount() {
        profilePage.deleteAccountButton.click();
    }

    public void updateProfile() throws InterruptedException {

        Thread.sleep(1000);

        profilePage.firstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        Thread.sleep(1000);

        profilePage.firstNameField.sendKeys(ConfigReader.getProperty("first_name"));

        Thread.sleep(1000);

        profilePage.firstNameField.sendKeys(Keys.TAB);

        Thread.sleep(1000);

        profilePage.lastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        profilePage.lastNameField.sendKeys(ConfigReader.getProperty("last_name"));

        profilePage.lastNameField.sendKeys(Keys.TAB);

        Thread.sleep(1000);

//        profilePage.phoneField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        profilePage.phoneField.sendKeys(ConfigReader.getProperty("phone_number"));
//        profilePage.phoneField.sendKeys("3432623411");
//        profilePage.phoneField.sendKeys(Keys.TAB);
//
//        Thread.sleep(1000);

    }

    @And("the user enters the password")
    public void theUserEntersThePassword() {
        profilePage.enter_your_password_on_delete.sendKeys(ConfigReader.getProperty("customer_password"));
    }

    @When("the user clicks Change Password")
    public void theUserClicksChangePassword() {
        homepage.profileIcon.click();
        homepage.myProfile.click();

        profilePage.changePasswordButton.click();
    }

    @And("the user clicks on the Change button")
    public void theUserClicksOnTheChangeButton() {
        profilePage.changeButton.click();
    }

    @When("the user clicks on Profile Photo")
    public void theUserClicksOnProfilePhoto() {
        profilePage.profilePhotoButton.click();
    }


    // ===== Profile Picture =====
    public void uploadProfilePicture() {

        // Load properties
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("configuration.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Get the relative path
        String relativePath = props.getProperty("profile_picture_path");

// Convert to ABSOLUTE path (important!)
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();


        profilePage.profileImage.sendKeys(absolutePath);
    }

    public void uploadInvalidProfilePicture() {
        // Load properties
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("configuration.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Get the relative path
        String relativePath = props.getProperty("invalid_profile_picture_path");

// Convert to ABSOLUTE path (important!)
        String absolutePath = Paths.get(relativePath).toAbsolutePath().toString();


        profilePage.profileImage.sendKeys(absolutePath);
        profilePage.done_Button.click();
        profilePage.saveButton.click();
    }

    @Then("the profile picture is displayed correctly")
    public void the_profile_picture_is_displayed_correctly() {

        profilePage.btn_profileImagePreview.click();
        // get the src attribute
        String srcValue = profilePage.image_preview.getAttribute("src");
        assertNotNull("Profile image src is null", srcValue);
        assertFalse("Profile image src is empty", srcValue.trim().isEmpty());
    }


    @And("the save button is disabled")
    public void theSaveButtonIsDisabled() {
        assertFalse(profilePage.saveButton.isEnabled());
    }

    @And("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        assertEquals(profilePage.confirmationMessage.getText(), "Profile updated successfully");
    }

    @Then("the password is updated successfully and a confirmation message is displayed")
    public void the_password_is_updated_successfully() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("Password updated successfully!", profilePage.confirmationMessage.getText());
    }


    public boolean isAccountDeleted() {
        // Example: check if redirect to login page after deletion
        return Driver.getDriver().getCurrentUrl().contains("/login");
    }

   @Then("the user is logged out")
    public void the_user_is_logged_out() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("/login"));
    }

    @Then("the account is deleted")
    public void the_account_is_deleted() {
        assertTrue(isAccountDeleted());
    }

    @Then("the account cannot be accessed anymore")
    public void the_account_cannot_be_accessed_anymore() {
        loginPage.login(ConfigReader.getProperty("gio_customer_username"), ConfigReader.getProperty("gio_customer_password"));
        assertTrue(loginPage.emailErrorMessage.isDisplayed());
        Driver.closeDriver();
    }


    @Then("an error message appears")
    public void anErrorMessageAppears() {

        assertTrue(profilePage.errorMessage.isDisplayed());
    }


    @Then("the profile is updated successfully")
    public void the_profile_is_updated_successfully() {
        assertTrue(profilePage.confirmationMessage.getText().toLowerCase().contains("profile updated successfully"));
    }

    @Then("the profile information is displayed")
    public void the_profile_information_is_displayed() {

        assertNotNull(profilePage.firstNameField.getText());
        assertNotNull(profilePage.lastNameField.getText());
        assertNotNull(profilePage.emailField.getText());
        assertNotNull(profilePage.phoneField.getText());

    }




}
