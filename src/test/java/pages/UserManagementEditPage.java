package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

public class UserManagementEditPage {



    // Locators
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "role")
    public WebElement roleDropdown;  // Use this WebElement with new Select(roleDropdown)

    @FindBy(xpath = "//button[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//button[text()='DELETE']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()='UPDATE']")
    public WebElement updateButton;

    @FindBy(xpath = "//div[@class='p-toast-detail' and contains(text(),'User type save successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='p-toast-detail' and contains(text(),'This user cannot be updated')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@aria-label='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//button[text()='No']")
    public WebElement noButton;

    public UserManagementEditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}