package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementEditPage {

    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By phoneInput = By.id("phone");
    private By emailInput = By.id("email");
    private By roleDropdown = By.id("role");
    private By backButton = By.xpath("//button[text()='Back']");
    private By deleteButton = By.xpath("//button[text()='DELETE']");
    private By updateButton = By.xpath("//button[text()='UPDATE']");
    private By successMessage = By.xpath("//div[@class='p-toast-detail' and contains(text(),'User type save successfully')]");
    private By errorMessage = By.xpath("//div[@class='p-toast-detail' and contains(text(),'This user cannot be updated')]");

    public UserManagementEditPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickDelete() {
        driver.findElement(deleteButton).click();
    }
}
