package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {
    public HomePage()
    {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement Home;

    @FindBy(xpath = "//a[text()='Properties']")
    public WebElement properties;

    @FindBy(xpath = "//a[text()='About']")
    public WebElement About;

    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement Contact;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement Login;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement Register;

    @FindBy(xpath = "//div[class='language-dropdown nav-item show dropdown']")
    public WebElement languageDropdown;

    @FindBy(xpath= "//input[@placeholder='Search']")
    public  WebElement searchbar;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement searchIcon;

    @FindBy(xpath ="(//button[text()='Rent'])[1]")
    public WebElement RentTab;

    @FindBy(xpath = "//button[text()='Sale']")
    public WebElement SaleTab;

    @FindBy(xpath = "//button[text()='HOUSE']")
    public WebElement houseTab;

    @FindBy(xpath = "//button[text()='APARTMENT']")
    public WebElement ApartmentTab;

    @FindBy(xpath = "//button[text()='VILLA']")
    public WebElement villaTab;

    @FindBy(xpath = "//button[text()='OFFICE']")
    public WebElement OfficeTab;

    @FindBy(xpath = "//button[text()='VILLA']")
    public WebElement VillaTab;

    @FindBy(xpath = "//button[text()='LAND']")
    public WebElement landTab;

    @FindBy(xpath = "//button[text()='SHOP']")
    public WebElement ShopTab;




}
