package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Driver;

public class Manager_edit_ad_stepdef {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    DashboardPage dashboardPage=new DashboardPage(driver);



    @Given("Manager navigates to the site {string}")
    public void manager_navigates_to_the_site(String url) {
        driver.get(url);

    }


    @Given("Manager is logged in the System")
    public void manager_is_logged_in_the_system() {
        loginPage.login("ajeeshamanager@gmail.com","Ajeeshaman@123");
    }

    @When("Clicks on the BacktoSite")
    public void clicks_on_the_backto_site() {
        dashboardPage.goBackTosite();
    }
    @When("the Manager clicks on Profile icon")
    public void the_manager_clicks_on_profile_icon() {

    }

    @When("clicks on {string}")
    public void clicks_on(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("views the details of an advertisement")
    public void views_the_details_of_an_advertisement() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks {string} for the selected advert")
    public void clicks_for_the_selected_advert(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("updates the Title to {string}")
    public void updates_the_title_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("updates the Description to {string}")
    public void updates_the_description_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("updates the Address to {string}")
    public void updates_the_address_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks {string}")
    public void clicks(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the updated advert with Title {string}, Description {string}, and Address {string} should be displayed in the {string} list")
    public void the_updated_advert_with_title_description_and_address_should_be_displayed_in_the_list(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks {string} on the advert with Title {string}")
    public void clicks_on_the_advert_with_title(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the advert with Title {string} should no longer appear in the {string} list")
    public void the_advert_with_title_should_no_longer_appear_in_the_list(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}