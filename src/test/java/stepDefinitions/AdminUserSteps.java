package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
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

        loginPage.login(ConfigReader.getProperty("admin_username"), ConfigReader.getProperty("admin_password"));
    }

    @Given("Admin is logged in, and user information exists")
    public void admin_is_logged_in_and_user_information_exists() {
        loginPage.login(ConfigReader.getProperty("admin_username"), ConfigReader.getProperty("admin_password"));
        Driver.getDriver().get("http://64.227.123.49/dashboard/users");
        userManagementPage.searchBox.clear();
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_name"));
        userManagementPage.searchButton.click();
        assertFalse(userManagementPage.firstUserEmail.getText().isEmpty());
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        driver.get("http://yourappurl.com/login"); // replace with real URL
    }

    @When("I enter valid Admin username and password")
    public void i_enter_valid_admin_username_and_password() {
        loginPage.login("admin_username", "admin_password"); // config-driven
    }

    @When("I click on the Login button")
    public void i_click_on_the_button() {
        loginPage.clickLoginButton();
    }

    @When("I click on the edit button")
    public void i_click_on_the_edit_button() {
        userManagementPage.actionButtons.get(1).click(); // parameterizable
    }

    @Then("Admin is successfully logged in and redirected to the Admin dashboard")
    public void admin_is_successfully_logged_in_and_redirected_to_the_admin_dashboard() {
        assertEquals("http://64.227.123.49/dashboard", Driver.getDriver().getCurrentUrl());
    }

    // --- TC_02: View created user ---
    @Given("At least one user account exists in the system")
    public void at_least_one_user_account_exists_in_the_system() {
        Driver.getDriver().get("http://64.227.123.49/dashboard/users");
        userManagementPage.searchBox.clear();
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("user_name"));
        userManagementPage.searchButton.click();
        assertFalse(userManagementPage.firstUserEmail.getText().isEmpty());
    }

    @Given("I am logged in as Admin")
    public void i_am_logged_in_as_admin() {
        i_navigate_to_the_login_page();
        i_enter_valid_admin_username_and_password();
        loginPage.clickLoginButton();
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String section) {
        if (section.equals("User Management")) {
            Driver.getDriver().get("http://64.227.123.49/dashboard/users");
        }
    }

    @When("I select the created user")
    public void i_select_the_created_user() {
        userManagementPage.actionButtons.get(1); // user parameterizable
    }

    @Then("Created user's information is displayed correctly")
    public void created_user_information_is_displayed_correctly() {
        assertFalse(userManagementEditPage.firstNameInput.getText().isEmpty());
    }

    // --- TC_03: Update user ---
    @When("I navigate to the created user's profile")
    public void i_navigate_to_the_created_users_profile() {
        userManagementPage.actionButtons.get(1).click();
    }

    @When("I click on {string} or {string} button")
    public void i_click_on_edit_or_update_button() {
        userManagementPage.actionButtons.get(1).click();
    }

    @When("I modify one or more fields \\(e.g., email, phone number)")
    public void i_modify_one_or_more_fields() {
        userManagementEditPage.firstNameInput.sendKeys(ConfigReader.getProperty("updated_first_name"));
        userManagementEditPage.lastNameInput.sendKeys(ConfigReader.getProperty("updated_last_name"));
        userManagementEditPage.emailInput.sendKeys(ConfigReader.getProperty("updated_email"));
        userManagementEditPage.phoneInput.sendKeys(ConfigReader.getProperty("updated_phone"));
        Select roleSelect = new Select(userManagementEditPage.roleDropdown);
        roleSelect.selectByValue("ADMIN");
    }

    @When("I save the changes")
    public void i_save_the_changes() {
        userManagementEditPage.updateButton.click();
    }

    @Then("User information is successfully updated and visible in the system")
    public void user_information_is_successfully_updated_and_visible_in_the_system() {
        assertEquals(ConfigReader.getProperty("updated_email"), userManagementEditPage.emailInput.getText());
    }

    // --- TC_04: Assign roles ---
    @When("I open the created user's profile")
    public void i_open_the_created_users_profile() {
        userManagementPage.actionButtons.get(1).click();
    }

    @When("I navigate to the Roles section")
    public void i_navigate_to_the_section() {
        userManagementEditPage.roleDropdown.click();
    }

    @When("I select and assign roles \\(Manager, Customer, or Admin)")
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
        userManagementPage.searchBox.clear();
        userManagementPage.searchBox.sendKeys(ConfigReader.getProperty("updated_email")); // parameterizable
        assertFalse(userManagementPage.firstUserEmail.getText().contains(ConfigReader.getProperty("updated_email")));
        driver.quit();
    }

    @And("I click on {string}")
    public void iClickOn(String arg0) {
        userManagementEditPage.deleteButton.click();
        throw new PendingException();
    }
}
