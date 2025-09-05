package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DashboardPage {


    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    // Locators

    @FindBy(xpath ="//span[text()='Dashboard']")
    private WebElement dashboard;

    @FindBy(xpath ="//span[text()='Adverts']")
    private WebElement adverts;

    @FindBy(xpath ="//span[text()='Categories']")
    private WebElement categories ;

    @FindBy(xpath ="//span[text()='Advert Types']")
    private WebElement advertType;

    @FindBy(xpath ="//span[text()='Users']")
    private WebElement users;

    @FindBy(xpath ="//span[text()='Tour Requests']")
    private WebElement tourRequests;

    @FindBy(xpath ="//span[text()='Reports']")
    private WebElement reports;

    @FindBy(xpath = "//span[text()='Back to Site']")
    private WebElement backToSite;

    @FindBy(xpath ="//span[text()='Logout']")
    private WebElement logout;

       //methods

    public void goBackTosite(){
        backToSite.click();
    }

}
