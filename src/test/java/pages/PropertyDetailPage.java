package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class PropertyDetailPage {
    public PropertyDetailPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "advert-title")
    public WebElement advertTitle;

    @FindBy(className = "advert-description")
    public WebElement advertDescription;


    @FindBy(className = "address-value")
    public WebElement advertAddress;

    @FindBy(css = ".show-toggle.btn.btn-danger")
    public List<WebElement> contactButtons;


    @FindBy(id = "tourDate")
    public WebElement tourDate;

    @FindBy(id = "tourTime")
    public WebElement tourTime;

    @FindBy(xpath = "//*[text()='Submit a tour request']")
    public WebElement submitTourRequestButton;

    @FindBy(className = "advert-properties-title")
    public WebElement details;

    @FindBy(xpath = "//strong[@class='property-key' and text()='Size']")
    public WebElement size;

    @FindBy(className = "price")
    public WebElement price;

    @FindBy(className = "advert-type")
    public WebElement type;

    @FindBy(css = ".p-galleria-item-container")
    public WebElement image;

    @FindBy(className = "details")
    public WebElement location;

    @FindBy(xpath = "//*[contains(text(),\"Don't have an account?\")]")
    public WebElement warningMessage;

    @FindBy(className = "register-link")
    public WebElement createNew;


}
