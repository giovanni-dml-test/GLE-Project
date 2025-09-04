package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserManagementEditPage {

    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By phoneInput = By.id("phone");
    private By emailInput = By.id("email");
    private By roleDropdown = By.id("role");
    private Select select = new Select((WebElement) roleDropdown);
    private By backButton = By.xpath("//button[text()='Back']");
    private By deleteButton = By.xpath("//button[text()='DELETE']");
    private By updateButton = By.xpath("//button[text()='UPDATE']");
    private By successMessage = By.xpath("//div[@class='p-toast-detail' and contains(text(),'User type save successfully')]");
    private By errorMessage = By.xpath("//div[@class='p-toast-detail' and contains(text(),'This user cannot be updated')]");
    private By yes_button = By.xpath("//button[text()='Yes']");
    private By no_button = By.xpath("//button[text()='No']");

    public UserManagementEditPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickDelete() {
        driver.findElement(deleteButton).click();
    }

    public boolean isUserInfoDisplayed(String testuser) {
        return driver.getPageSource().contains(testuser);
    }

    public void clickEdit() {
    }

    public void updateFirstName(String updatedFirstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(updatedFirstName);
    }

    public void updateLastName(String updatedLastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(updatedLastName);
    }

    public void updateEmail(String newemail) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(newemail);
    }

    public void updatePhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void updateRole(String role) {
        select.selectByValue(role);
    }

    public void clickUpdate() {
        driver.findElement(updateButton).click();
    }

    public String getEmail() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public String getFirstName() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameInput).getAttribute("value");
    }
    public String getPhone() {
        return driver.findElement(phoneInput).getAttribute("value");
    }


    public boolean isRoleAssigned(String manager) {
        return select.getFirstSelectedOption().getText().equals(manager);
    }

    public void confirmDelete() {
        driver.findElement(deleteButton).click();
        driver.findElement(yes_button).click();

    }

    public void openRolesTab() {
        driver.findElement(By.id("role")).click();
    }
}
