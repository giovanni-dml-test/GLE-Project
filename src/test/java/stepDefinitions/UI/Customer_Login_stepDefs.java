package stepDefinitions.UI;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Customer_Login_stepDefs {

    WebDriver driver = Driver.getDriver();

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("the user goes to the website {string}")
    public void the_user_goes_to_the_website(String url) {
        driver.get(url);


    }

    @When("clicks on the Login button")
    public void clicks_on_the_login_button() {
        homePage.login.click();


    }

    @When("enters {string} in the Email field")
    public void enters_in_the_email_field(String email) {
        loginPage.enterUsername(email);

    }

    @Given("clicks on the password Field")
    public void clicks_on_the_password_field() {
        loginPage.clickOnPasswordField();
    }

    @Then("the system should {string}")
    public void the_system_should(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("Invalid email")) {
            String actualMessage = loginPage.getInvalidEmailMessage();
            assertTrue(
                    actualMessage.toLowerCase().contains("invalid email"),
                    " Expected 'Invalid email' but got: " + actualMessage);

        } else {
            //expect No error message
            List<WebElement> errorElements = Driver.getDriver()
                    .findElements(By.cssSelector("div.form-feedback.invalid-feedback"));

            boolean isErrorAbsent = errorElements.isEmpty() || !errorElements.get(0).isDisplayed();
            assertTrue( isErrorAbsent," Error message was displayed when it should not");
        }


    }

    @When("enters a valid email in the Email field")
    public void enters_a_valid_email_in_the_email_field() {

        loginPage.enterUsername(ConfigReader.getProperty("customer_email"));

    }

    @When("leaves the Password field blank")
    public void leaves_the_password_field_blank() {
        loginPage.enterPassword("");

    }

    @Given("Clicks on the emailfield")
    public void clicks_on_the_emailfield() {
        loginPage.clickOnEmailField();
    }

    @Given("clicks on LoginButton")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("an error message {string} should appear")
    public void an_error_message_should_appear(String expectedMessage) {
        String actualMessage = loginPage.getPasswordRequiredMessage();
        assertEquals(expectedMessage, actualMessage);


    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        loginPage.enterPassword(ConfigReader.getProperty("customer_email"));

    }

    @Then("the error message should disappear")
    public void the_error_message_should_disappear() {

        assertFalse( loginPage.isPasswordErrorDisplayed(),"Password error message should disappear");
    }

    @When("enters a valid password in the Password field")
    public void enters_a_valid_password_in_the_password_field() {
        loginPage.enterPassword(ConfigReader.getProperty("customer_password"));

    }

    @When("clicks the Login button")
    public void clicks_the_login_button() {
        loginPage.clickLoginButton();

    }

    @Then("redirected to the Homepage")
    public void redirected_to_the_homepage() {
        assertTrue(homePage.profileIcon.isDisplayed());


    }

    @When("enters {string} in the Password field")
    public void enters_in_the_password_field(String password) {
        loginPage.enterPassword(password);

    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String expectedPartialMessage) {

        String actualMessage = loginPage.getInvalidLoginMessage();

        assertTrue(actualMessage.contains(expectedPartialMessage), "Expected message to contain: \"" + expectedPartialMessage + "\" but got: \"" + actualMessage + "\"");

    }


}
