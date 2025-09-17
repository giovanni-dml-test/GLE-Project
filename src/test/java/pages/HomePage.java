package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='user-logo-nav navbar-nav']")
    public WebElement profileIcon;
    //dropdown
    @FindBy(xpath = "//span[text()='My Profile']")
    public WebElement myProfile;

    @FindBy(xpath = "//span[text()='My Adverts']")
    public WebElement myAdverts;

    @FindBy(xpath = "//span[text()='My Favorites']")
    public WebElement myFavorites;

    @FindBy(xpath = "//span[text()='My Tour Requests']")
    public WebElement myTourRequests;

    @FindBy(xpath = "//span[text()='Control Panel']")
    public WebElement controlPanel;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout;


    @FindBy(xpath = "//a[text()='Home']")
    public WebElement home;

    @FindBy(xpath = "//a[text()='Properties']")
    public WebElement properties;

    @FindBy(xpath = "//a[text()='About']")
    public WebElement about;

    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement contact;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement login;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//div[class='language-dropdown nav-item show dropdown']")
    public WebElement languageDropdown;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchbar;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement searchIcon;

    @FindBy(xpath = "(//button[text()='Rent'])[1]")
    public WebElement rentTab;

    @FindBy(xpath = "//button[text()='Sale']")
    public WebElement saleTab;

    @FindBy(xpath = "//button[text()='HOUSE']")
    public WebElement houseTab;

    @FindBy(xpath = "//button[text()='APARTMENT']")
    public WebElement apartmentTab;

    @FindBy(xpath = "//button[text()='VILLA']")
    public WebElement villaTab;

    @FindBy(xpath = "//button[text()='OFFICE']")
    public WebElement OfficeTab;

    @FindBy(xpath = "//button[text()='VILLA']")
    public WebElement VillaTab;

    @FindBy(xpath = "//button[text()='LAND']")
    public WebElement landTab;

    @FindBy(xpath = "//button[text()='SHOP']")
    public WebElement shopTab;

    public void clickLogin() {
        login.click();
    }


}
