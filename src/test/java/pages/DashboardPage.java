package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    // Locators
   
    private By backToSite =By.xpath("//span[text()='Back to Site']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }


    public void goBackTosite(){
        driver.findElement(backToSite).click();

   
}
