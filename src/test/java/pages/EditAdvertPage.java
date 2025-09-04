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




    }

