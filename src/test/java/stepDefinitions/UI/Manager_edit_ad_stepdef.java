package stepDefinitions.UI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class Manager_edit_ad_stepdef {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homepage = new HomePage();
    MyAdvertsPage myAdvertsPage = new MyAdvertsPage();
    EditAdvertPage editAdvertPage = new EditAdvertPage();
    PropertyDetailPage propertyDetailPage = new PropertyDetailPage();


    @Given("Manager navigates to the site {string}")
    public void manager_navigates_to_the_site(String url) {
        driver.get(url);

    }


    @Given("Manager is logged in the System")
    public void manager_is_logged_in_the_system() {
        homepage.clickLogin();
        loginPage.enterUsername(ConfigReader.getProperty("manager_email"));
        loginPage.enterPassword(ConfigReader.getProperty("manager_password"));
        loginPage.clickLoginButton();


    }

    @When("Clicks on the BacktoSite")
    public void clicks_on_the_backto_site() {

        dashboardPage.goBackTosite();
    }

    @When("the Manager clicks on Profile icon")
    public void the_manager_clicks_on_profile_icon() {

        homepage.profileIcon.click();


    }

    @When("clicks on {string}")
    public void clicks_on(String myAdverts) {
        homepage.myAdverts.click();

    }

    @When("clicks {string} for the selected advert")
    public void clicks_for_the_selected_advert(String edit) {
        myAdvertsPage.editIcon.click();


    }

    @When("updates the Title to {string}")
    public void updates_the_title_to(String title) {
        editAdvertPage.title.sendKeys(Keys.CONTROL + "a");
        editAdvertPage.title.sendKeys(title);

    }

    @When("updates the Description to {string}")
    public void updates_the_description_to(String description) {
        editAdvertPage.description.sendKeys(Keys.CONTROL + "a");
        editAdvertPage.description.sendKeys(description);

    }

    @When("updates the Address to {string}")
    public void updates_the_address_to(String address) {
        editAdvertPage.address.sendKeys(Keys.CONTROL + "a");
        editAdvertPage.address.sendKeys(Keys.DELETE);
        editAdvertPage.address.sendKeys(address);
    }


    @When("clicks {string}")
    public void clicks(String update) {
        // editAdvertPage.updateButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(editAdvertPage.updateButton)).click();

    }

    @When("Click on the property")
    public void click_on_the_property() {
        myAdvertsPage.propertyDetails.click();


    }

    @Then("the updated advert with Title {string}, Description {string}, and Address {string} should be displayed")
    public void the_updated_advert_with_title_description_and_address_should_be_displayed_in_the_list(String title, String description, String address) {

        String actualTitle = propertyDetailPage.advertTitle.getText().trim();
        String actualDescription = propertyDetailPage.advertDescription.getText().trim();
        String actualAddress = propertyDetailPage.advertAddress.getText().trim();

        Assert.assertEquals(title, actualTitle);
        Assert.assertEquals(description, actualDescription);
        Assert.assertEquals(address, actualAddress);


    }

    @When("clicks {string} on the advert with Title {string}")
    public void clicks_on_the_advert_with_title(String delete, String title) {
        myAdvertsPage.deleteIcon.click();


    }

    @When("confirms the deletion")
    public void confirms_the_deletion() {
        myAdvertsPage.deleteYes.click();

    }

    @Then("the advert with Title {string} should no longer appear in the {string} list")
    public void the_advert_with_title_should_no_longer_appear_in_the_list(String title, String myAdverts) {

        List<WebElement> adverts = myAdvertsPage.allPropertyTitles;
        for (WebElement advert : adverts) {

            Assert.assertNotEquals(title, advert.getText().trim());

        }

    }


}