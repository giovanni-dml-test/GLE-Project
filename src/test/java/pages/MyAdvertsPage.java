package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MyAdvertsPage {
    public MyAdvertsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//button[@class='btn-link btn btn-primary'])[1]")
    public WebElement deleteIcon;

    @FindBy(xpath="(//button[@class='btn-link btn btn-primary'])[2]")
    public WebElement editIcon;

    @FindBy(xpath="(//div[@class='text'])[1]")
    public WebElement propertyDetails;


    @FindBy(xpath="//button[span[text()='Yes']]")
    public WebElement deleteYes;

    @FindBy(xpath="//button[span[text()='No']]")
    public WebElement deleteNo;





}
