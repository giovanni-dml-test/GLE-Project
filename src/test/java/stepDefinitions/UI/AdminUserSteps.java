package stepDefinitions.UI;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.DashboardPage;
import pages.UserManagementEditPage;
import pages.UserManagementPage;
import utils.ConfigReader;
import utils.Driver;

import static org.junit.Assert.*;

public class AdminUserSteps {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserManagementPage userManagementPage;
    UserManagementEditPage userManagementEditPage;

    @Given("User has valid Admin credentials")
    public void user_has_valid_admin_credentials() {


        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        userManagementPage = new UserManagementPage();
        userManagementEditPage = new UserManagementEditPage();

        Driver.getDriver().get(ConfigReader.getProperty("GLE_login_page"));

    }

    @Given("Admin is logged in, and user information exists")
    public void admin_is_logged_in_and_user_information_exists() {

        Driver.getDriver().get(ConfigReader.getProperty("GLE_login_page"));
        loginPage.login(ConfigReader.getProperty("gio_admin_username"), ConfigReader.getProperty("gio_admin_password"));
        Driver.getDriver().get("http://64.227.123.49/dashboard/users");
        userManagementPage.searchBox.clear();
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_name"));
        userManagementPage.searchButton.click();
        assertFalse(userManagementPage.firstUserEmail.getText().isEmpty());
    }


    @When("I click on the edit button")
    public void i_click_on_the_edit_button() {

        userManagementPage.firstRowEditButton.click();

    }

    @Then("Admin is successfully logged in and redirected to the Admin dashboard")
    public void admin_is_successfully_logged_in_and_redirected_to_the_admin_dashboard() {
        assertEquals("http://64.227.123.49/dashboard", Driver.getDriver().getCurrentUrl());
    }

    // --- TC_02: View created user ---
    @Given("At least one user account exists in the system")
    public void at_least_one_user_account_exists_in_the_system() throws InterruptedException {
        loginPage = new LoginPage();
        userManagementPage = new UserManagementPage();
        userManagementEditPage = new UserManagementEditPage();
        Driver.getDriver().get(ConfigReader.getProperty("GLE_login_page"));
        loginPage.login(ConfigReader.getProperty("gio_admin_username"), ConfigReader.getProperty("gio_admin_password"));
        Thread.sleep(5000);

    }

    @When("I navigate to User Management")
    public void iNavigateToUserManagement() {
        Driver.getDriver().get("http://64.227.123.49/dashboard/users");
    }


    @When("I select the created user")
    public void i_select_the_created_user() throws InterruptedException {
        Thread.sleep(1000);
        userManagementPage.searchBox.clear();
        Thread.sleep(1000);
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_name"));
        Thread.sleep(1000);
        userManagementPage.searchButton.click();
        Thread.sleep(1000);
        userManagementPage.firstRowEditButton.click();
    }

    @Then("Created user's information is displayed correctly")
    public void created_user_information_is_displayed_correctly() throws InterruptedException {
        Thread.sleep(3000);
        assertNotNull(userManagementEditPage.firstNameInput.getText());

    }

    // --- TC_03: Update user ---
    @When("I navigate to the created user's profile")
    public void i_navigate_to_the_created_users_profile() throws InterruptedException {

        userManagementPage.searchBox.clear();
        Thread.sleep(2000);
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_name"));
        Thread.sleep(2000);
        userManagementPage.searchButton.click();
        Thread.sleep(2000);

    }



    @When("I modify one or more fields")
    public void i_modify_one_or_more_fields() {
        userManagementEditPage.firstNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userManagementEditPage.firstNameInput.sendKeys(ConfigReader.getProperty("updated_first_name"));
        userManagementEditPage.firstNameInput.sendKeys(Keys.TAB);
        userManagementEditPage.lastNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userManagementEditPage.lastNameInput.sendKeys(ConfigReader.getProperty("updated_last_name"));
        userManagementEditPage.lastNameInput.sendKeys(Keys.TAB);
        userManagementEditPage.emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userManagementEditPage.emailInput.sendKeys(ConfigReader.getProperty("updated_email"));
        userManagementEditPage.emailInput.sendKeys(Keys.TAB);
        userManagementEditPage.phoneInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userManagementEditPage.phoneInput.sendKeys(ConfigReader.getProperty("updated_phone_number"));
        userManagementEditPage.phoneInput.sendKeys(Keys.TAB);
        Select roleSelect = new Select(userManagementEditPage.roleDropdown);
        roleSelect.selectByValue("ADMIN");
    }

    @When("I save the changes")
    public void i_save_the_changes() {

        userManagementEditPage.updateButton.click();
    }

    @Then("User information is successfully updated and visible in the system")
    public void user_information_is_successfully_updated_and_visible_in_the_system() {
        assertTrue(userManagementPage.successMessage.isDisplayed());
    }

    // --- TC_04: Assign roles ---

    @When("I select and assign roles")
    public void i_select_and_assign_roles() {
        userManagementEditPage.roleDropdown.click();
        Select roleSelect = new Select(userManagementEditPage.roleDropdown);
        roleSelect.selectByValue("MANAGER");
    }

    @Then("The user is successfully assigned the selected roles")
    public void the_user_is_successfully_assigned_the_selected_roles() {
        assertTrue(new Select(userManagementEditPage.roleDropdown).getFirstSelectedOption().getText().contains("MANAGER"));
    }

    // --- TC_05: Delete user ---
    @When("I confirm the deletion")
    public void i_confirm_the_deletion() {

        userManagementEditPage.yesButton.click();
    }

    @Then("User account is permanently deleted and no longer visible in the system")
    public void user_account_is_permanently_deleted_and_no_longer_visible_in_the_system() {
        assertTrue(userManagementPage.success_deletion_message.isDisplayed());
        driver.quit();
    }



    @When("the user enters his credentials and login")
    public void theUserEntersHisCredentialsAndLogin() throws InterruptedException {
        loginPage.login(ConfigReader.getProperty("gio_admin_username"), ConfigReader.getProperty("gio_admin_password"));
        Thread.sleep(2000);

    }


    @And("I select a user to delete")
    public void iSelectAUserToDelete() throws InterruptedException {
        userManagementPage.searchBox.clear();
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_to_be_deleted"));
        userManagementPage.searchButton.click();
        Thread.sleep(2000);
        userManagementPage.firstRowEditButton.click();
    }

    @And("I click on DELETE")
    public void iClickOnDELETE() {
        userManagementEditPage.deleteButton.click();

    }
}
