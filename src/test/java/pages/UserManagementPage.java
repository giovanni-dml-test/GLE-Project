package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserManagementPage {

    WebDriver driver;

    // --- Locators ---
    private By userTable = By.id("userTable"); // replace with actual locator
    private By searchBox = By.id("searchUser"); // optional, if search exists
    private By userRow(String username) {
        return By.xpath("//table[@id='userTable']//tr[td[text()='" + username + "']]");
    }
    private By openUserButton(String username) {
        return By.xpath("//table[@id='userTable']//tr[td[text()='" + username + "']]//a[text()='View']");
    }

    // --- Constructor ---
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Actions ---

    /** Navigate directly to User Management page */
    public void goToUserManagementPage(String url) {
        driver.get(url); // e.g., "http://yourappurl.com/admin/users"
    }

    /** Search for a user by username */
    public void searchUser(String username) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(username);
        searchInput.submit(); // or click a search button if required
    }

    /** Open a specific user profile */
    public void openUser(String username) {
        WebElement userLink = driver.findElement(openUserButton(username));
        userLink.click();
    }

    /** Check if a user exists in the list */
    public boolean isUserPresent(String username) {
        try {
            return driver.findElement(userRow(username)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
