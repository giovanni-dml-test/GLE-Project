package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class EditAdvertPage {
    public EditAdvertPage()
        {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//input[@id='title']")
    public WebElement title;

    @FindBy(xpath = "//*[@id='desc']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='address']")
    public WebElement address;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;

    @FindBy(id="price")
    public WebElement price;

    @FindBy(id="advertTypeId")
    public WebElement advertType;

    @FindBy(id="categoryId")
    public WebElement category;

    @FindBy(id="custom-switch")
    public WebElement activeSwitch;

    @FindBy(id="countryId")
    public WebElement country;

    @FindBy(id="cityId")
    public WebElement city;

    @FindBy(id="districtId")
    public WebElement district;

    @FindBy(id="Size")
    public WebElement size;

    @FindBy(id="Bedrooms")
    public WebElement bedrooms;

    @FindBy(id="Bathrooms")
    public WebElement bathrooms;

    @FindBy(id="Parking Space")
    public WebElement parkingSpace;

    @FindBy(id="Year of Build")
    public WebElement buildYear;

    @FindBy(id="Furniture")
    public WebElement furniture;

    @FindBy(id="Maintenance Fee")
    public WebElement maintenanceFee;

    @FindBy(id="Balcony")
    public WebElement balcony;

    @FindBy(id="Elevator")
    public WebElement elevator;

    @FindBy(id="Flat")
    public WebElement flat;

    @FindBy(id="Flat1")
    public WebElement Flat1;

    @FindBy(id="Flat2")
    public WebElement flat2;

    @FindBy(id="Flat4")
    public WebElement flat4;

    @FindBy(id="Flat7")
    public WebElement flat7;

    @FindBy(xpath="//button[text()='Upload']")
    public WebElement uploadImage;

    @FindBy(xpath="//button[text()='Set Featured']")
    public WebElement setFeatured;

    @FindBy(xpath="//button[text()='Delete']")
    public WebElement delete;

}

