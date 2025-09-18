package stepDefinitions.UI;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.PropertiesSearchPage;
import pages.PropertyDetailPage;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class GuestUserStepdef {
    WebDriver driver = Driver.getDriver();

    HomePage homePage;
    PropertiesSearchPage propertiesSearchPage;
    PropertyDetailPage propertyDetailPage;


    @Given("the guest user goes to the website {string}")
    public void the_guest_user_goes_to_the_website(String url) {
        driver.get(url);
        homePage = new HomePage();
        propertiesSearchPage = new PropertiesSearchPage();
        propertyDetailPage = new PropertyDetailPage();


    }

    @When("the guest enters a keyword in the search bar")
    public void the_guest_enters_a_keyword_in_the_search_bar() {
        homePage.searchbar.sendKeys(ConfigReader.getProperty("search_word"));
        homePage.searchIcon.click();

    }

    @When("selects a price range")
    public void selects_a_price_range() {
        propertiesSearchPage.minPrice.sendKeys(ConfigReader.getProperty("min_price"));
        propertiesSearchPage.maxPrice.sendKeys(ConfigReader.getProperty("max_price"));

    }

    @When("selects an advert type")
    public void selects_an_advert_type() {
        propertiesSearchPage.advertTypeDropdown.sendKeys(ConfigReader.getProperty("advert_type"));
    }

    @When("selects a category")
    public void selects_a_category() {
        propertiesSearchPage.categoryDropdown.sendKeys("category");
    }

    @When("selects a country, city, and district")
    public void selects_a_country_city_and_district() {
        propertiesSearchPage.countryDropdown.sendKeys(ConfigReader.getProperty("country"));
        propertiesSearchPage.cityDropdown.sendKeys(ConfigReader.getProperty("city"));
        propertiesSearchPage.districtDropdown.sendKeys(ConfigReader.getProperty("district"));
    }

    @When("clicks the Search button")
    public void clicks_the_search_button() {
        propertiesSearchPage.SearchButton.click();
    }


    @When("the guest selects a property from the search results")
    public void the_guest_selects_a_property_from_the_search_results() {
        homePage.searchIcon.click();
        propertiesSearchPage.propertyClick.click();


    }


    @Then("the system should display property details including:")
    public void the_system_should_display_property_details_including(io.cucumber.datatable.DataTable dataTable) {
        Map<String, WebElement> detailsMap = new HashMap<>();
        detailsMap.put("image", propertyDetailPage.image);
        detailsMap.put("description", propertyDetailPage.advertDescription);
        detailsMap.put("price", propertyDetailPage.price);
        detailsMap.put("type", propertyDetailPage.type);
        detailsMap.put("size", propertyDetailPage.size);
        detailsMap.put("location", propertyDetailPage.location);

        List<String> expectedDetails = dataTable.asList();
        for (String details : expectedDetails) {
            WebElement element = detailsMap.get(details.toLowerCase());
            assertNotNull( details, element+"unknown Detail " );
            assertTrue(element.isDisplayed(), details + "is not displayed ");
        }


    }

    @When("the guest clicks on {string} on a property advertisement")
    public void the_guest_clicks_on_on_a_property_advertisement(String contact) {
        homePage.searchIcon.click();
        propertiesSearchPage.propertyClick.click();
        propertyDetailPage.contactButtons.get(0).click();


    }

    @Then("the system should display a warning message {string}")
    public void the_system_should_display_a_warning_message(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the warning message is visible
        WebElement warningMessageElement = wait.until(
                ExpectedConditions.visibilityOf(propertyDetailPage.warningMessage)
        );
        String actualMessage = warningMessageElement.getText();
        assertEquals(expectedMessage, actualMessage);

    }

    @When("the guest enters a valid Tour Date {string} and Tour Time {string} on a property advertisement")
    public void the_guest_enters_a_valid_tour_date_and_tour_time_on_a_property_advertisement(String tourDate, String tourTime) {

        homePage.searchIcon.click();
        propertiesSearchPage.propertyClick.click();
        propertyDetailPage.tourDate.sendKeys(tourDate);
        propertyDetailPage.tourTime.sendKeys(tourTime);
    }


    @When("clicks on Submit a Tour Request")
    public void clicks_on_submit_a_tour_request() {

        propertyDetailPage.submitTourRequestButton.click();
    }


    @Then("the system should display a message {string}")
    public void the_system_should_display_a_message(String expectedMessage) {
        String actualMessage = propertyDetailPage.warningMessage.getText();
        assertEquals(expectedMessage, actualMessage);


    }

}





