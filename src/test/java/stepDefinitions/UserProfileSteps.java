package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;
import static org.junit.Assert.*;

public class UserProfileSteps {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        profilePage = new ProfilePage(driver);

        driver.get("http://64.227.123.49/login");
        loginPage.login("testuser", "password123");
        //assertTrue(dashboardPage.isDashboardDisplayed());
    }

//    @When("the user navigates to the dashboard")
//    public void the_user_navigates_to_the_dashboard() {
//        assertTrue(dashboardPage.isDashboardDisplayed());
//    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String menuOption) {
        dashboardPage.navigateTo(menuOption);
    }

    @Then("the profile information \\(name, email, phone, etc.) is displayed")
    public void the_profile_information_is_displayed() {
        assertTrue(profilePage.isProfileInfoDisplayed());
    }

    @Given("the profile page is open")
    public void the_profile_page_is_open() {
        dashboardPage.navigateTo("My Profile");
        assertTrue(profilePage.isProfileInfoDisplayed());
    }

    @When("the user updates profile fields \\(e.g., first name, last name, phone number)")
    public void the_user_updates_profile_fields() {
        profilePage.updateProfile("John", "Doe", "1234567890");
    }

    @When("the user clicks {string}")
    public void the_user_clicks(String button) {
        profilePage.clickButton(button);
    }

    @Then("the profile is updated successfully")
    public void the_profile_is_updated_successfully() {
        assertEquals("Profile updated successfully!", profilePage.getConfirmationMessage());
    }

    @When("the user opens {string}")
    public void the_user_opens(String section) {
        dashboardPage.navigateTo(section);
    }

    @When("the user clicks {string}")
    public void the_user_clicks_button(String button) {
        profilePage.clickButton(button);
    }

    @When("the user enters current password, new password, and confirms new password")
    public void the_user_enters_current_password_new_password_and_confirms_new_password() {
        profilePage.changePassword("oldPass123!", "NewPass123!", "NewPass123!");
    }

    @Then("the password is updated successfully")
    public void the_password_is_updated_successfully() {
        assertEquals("Password updated successfully!", profilePage.getConfirmationMessage());
    }

    @When("the user uploads a valid image file \\(e.g., .jpg, .png)")
    public void the_user_uploads_a_valid_image_file() {
        profilePage.uploadProfilePicture("C:/testdata/profile.jpg");
    }

    @Then("the profile picture is uploaded")
    public void the_profile_picture_is_uploaded() {
        assertTrue(profilePage.isProfilePictureDisplayed());
    }

    @Then("the profile picture is displayed correctly")
    public void the_profile_picture_is_displayed_correctly() {
        assertTrue(profilePage.isProfilePictureDisplayed());
    }

    @When("the user tries uploading an invalid file type \\(e.g., .exe, .pdf)")
    public void the_user_tries_uploading_an_invalid_file_type() {
        profilePage.uploadProfilePicture("C:/testdata/virus.exe");
    }

    @Then("an error message appears {string}")
    public void an_error_message_appears(String expectedMessage) {
        assertEquals(expectedMessage, profilePage.getErrorMessage());
    }

    @When("the user clicks {string}")
    public void the_user_clicks_delete_account(String button) {
        profilePage.clickButton(button);
    }

    @When("the user confirms deletion")
    public void the_user_confirms_deletion() {
        profilePage.confirmAccountDeletion();
    }

    @Then("the account is deleted")
    public void the_account_is_deleted() {
        assertTrue(profilePage.isAccountDeleted());
    }

//    @Then("the user is logged out")
//    public void the_user_is_logged_out() {
//        assertTrue(loginPage.isLoginPageDisplayed());
//    }
//
//    @Then("the account cannot be accessed anymore")
//    public void the_account_cannot_be_accessed_anymore() {
//        loginPage.login("testuser", "password123");
//        assertEquals("Invalid credentials", loginPage.getErrorMessage());
//        driver.quit();
//    }
}
