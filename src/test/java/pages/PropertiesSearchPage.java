package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PropertiesSearchPage {
    public PropertiesSearchPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "q")
    public WebElement search;

    @FindBy(id = "ps")
    public WebElement minPrice;

    @FindBy(id = "pe")
    public WebElement maxPrice;

    @FindBy(xpath = "//select[@id='at']")
    public WebElement advertTypeDropdown;

    @FindBy(xpath = "//select[@id='c']")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//select[@id='ctry']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='city']")
    public WebElement cityDropdown;

    @FindBy(xpath = "//select[@id='dist']")
    public WebElement districtDropdown;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement SearchButton;





}

