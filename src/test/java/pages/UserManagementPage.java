package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class UserManagementPage {



    // --- Locators ---
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='search-button btn btn-outline-secondary']")
    public WebElement searchButton;

    // User table itself
    @FindBy(css = "div.tr-datatable table.p-datatable-table")
    public WebElement userTable;

    // Table rows (list of all users)
    @FindBy(css = "tbody.p-datatable-tbody tr")
    public List<WebElement> userRows;

    // First row Name
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr[1]/td[1]")
    public WebElement firstUserName;

    // First row Email
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr[1]/td[2]")
    public WebElement firstUserEmail;

    // All Names in the Name column
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr/td[1]")
    public List<WebElement> allUserNames;

    // All Emails in the Email column
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr/td[2]")
    public List<WebElement> allUserEmails;

    // Action buttons (edit/delete) in each row
    @FindBy(css = "tbody.p-datatable-tbody tr td:last-child .operationsButton button")
    public List<WebElement> actionButtons;

    // Example: Delete button in first row
    @FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//tr[1]//button)[1]")
    public WebElement firstRowDeleteButton;

    // Example: Delete button in first row
    @FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//tr[1]//button)[2]")
    public WebElement firstRowEditButton;

    @FindBy(xpath = "//div[text()='User type save successfully']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[text()='User deleted successfully']")
    public WebElement success_deletion_message;

    // --- Constructor ---
    public UserManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // --- Actions ---


}
