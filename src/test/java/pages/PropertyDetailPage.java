package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PropertyDetailPage {
    public PropertyDetailPage()
        {

            PageFactory.initElements(Driver.getDriver(), this);
        }

  @FindBy(className ="advert-title")
  public WebElement advertTitle;

    @FindBy(className ="advert-description")
    public WebElement advertDescription;


    @FindBy(className ="address-value")
    public WebElement advertAddress;


}
