package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.DashboardPage;
import pages.UserManagementEditPage;
import pages.UserManagementPage;

import static org.junit.Assert.*;

public class AdminUserSteps {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserManagementPage userManagementPage;
    UserManagementEditPage userManagementEditPage;

    @Given("User has valid Admin credentials")
    public void user_has_valid_admin_credentials() {
        // Normally you’d load these from config
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userManagementPage = new UserManagementPage(driver);
        userManagementEditPage = new UserManagementEditPage(driver);
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        driver.get("http://yourappurl.com/login"); // replace with real URL
    }

    @When("I enter valid Admin username and password")
    public void i_enter_valid_admin_username_and_password() {
        loginPage.login("admin_username", "admin_password"); // config-driven
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        if (buttonName.equals("Login")) {
            loginPage.clickLogin();
        } else if (buttonName.equals("Delete User")) {
            userManagementEditPage.clickDelete();
        }
    }

    @Then("Admin is successfully logged in and redirected to the Admin dashboard")
    public void admin_is_successfully_logged_in_and_redirected_to_the_admin_dashboard() {
        assertTrue(dashboardPage.isAdminDashboardDisplayed());
    }

    // --- TC_02: View created user ---
    @Given("At least one user account exists in the system")
    public void at_least_one_user_account_exists_in_the_system() {
        // Ideally DB check or setup fixture
        // For now assume one exists
    }

    @Given("I am logged in as Admin")
    public void i_am_logged_in_as_admin() {
        i_navigate_to_the_login_page();
        i_enter_valid_admin_username_and_password();
        loginPage.clickLogin();
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String section) {
        if (section.equals("User Management")) {
            dashboardPage.goToUserManagement();
        }
    }

    @When("I select the created user")
    public void i_select_the_created_user() {
        userManagementPage.openUser("testuser"); // user parameterizable
    }

    @Then("Created user's information is displayed correctly")
    public void created_user_information_is_displayed_correctly() {
        assertTrue(userManagementEditPage.isUserInfoDisplayed("testuser"));
    }

    // --- TC_03: Update user ---
    @When("I navigate to the created user's profile")
    public void i_navigate_to_the_created_users_profile() {
        userManagementPage.openUser("testuser");
    }

    @When("I click on {string} or {string} button")
    public void i_click_on_edit_or_update_button(String editBtn, String updateBtn) {
        userManagementEditPage.clickEdit();
    }

    @When("I modify one or more fields \\(e.g., email, phone number)")
    public void i_modify_one_or_more_fields() {
        userManagementEditPage.updateEmail("newemail@test.com");
        userManagementEditPage.updatePhone("123456789");
    }

    @When("I save the changes")
    public void i_save_the_changes() {
        userManagementEditPage.clickSave();
    }

    @Then("User information is successfully updated and visible in the system")
    public void user_information_is_successfully_updated_and_visible_in_the_system() {
        assertEquals("newemail@test.com", userManagementEditPage.getEmail());
    }

    // --- TC_04: Assign roles ---
    @When("I open the created user's profile")
    public void i_open_the_created_users_profile() {
        userManagementPage.openUser("testuser");
    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String section) {
        if (section.equals("Roles")) {
            userManagementEditPage.openRolesTab();
        }
    }

    @When("I select and assign roles \\(Manager, Customer, or Admin)")
    public void i_select_and_assign_roles() {
        userManagementEditPage.assignRole("Manager");
    }

    @Then("The user is successfully assigned the selected roles")
    public void the_user_is_successfully_assigned_the_selected_roles() {
        assertTrue(userManagementEditPage.isRoleAssigned("Manager"));
    }

    // --- TC_05: Delete user ---
    @When("I confirm the deletion")
    public void i_confirm_the_deletion() {
        userManagementEditPage.confirmDelete();
    }

    @Then("User account is permanently deleted and no longer visible in the system")
    public void user_account_is_permanently_deleted_and_no_longer_visible_in_the_system() {
        assertFalse(userManagementPage.isUserPresent("testuser"));
        driver.quit();
    }
}
