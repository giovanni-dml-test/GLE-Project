package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RegistrationSteps {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given("the registration page is open")
    public void openRegistrationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
        registrationPage.open();
    }

    @When("the user leaves the First Name field empty")
    public void leaveFirstNameEmpty() {
        registrationPage.enterFirstName("");
    }

    @When("the user leaves the Last Name field empty")
    public void leaveLastNameEmpty() {
        registrationPage.enterLastName("");
    }

    @When("the user leaves the Phone Number field empty")
    public void leavePhoneEmpty() {
        registrationPage.enterPhoneNumber("");
    }

    @When("the user leaves the Email field empty")
    public void leaveEmailEmpty() {
        registrationPage.enterEmail("");
    }

    @When("the user enters an invalid email format {string}")
    public void enterInvalidEmail(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user leaves the Password field empty")
    public void leavePasswordEmpty() {
        registrationPage.enterPassword("");
    }

    @When("the user enters an invalid password")
    public void enterInvalidPassword() {
        registrationPage.enterPassword("123"); // weak password
    }

    @When("the user leaves the Confirm Password field empty")
    public void leaveConfirmPasswordEmpty() {
        registrationPage.enterConfirmPassword("");
    }

    @When("the user enters a valid Password {string}")
    public void enterValidPassword(String password) {
        registrationPage.enterPassword(password);
    }

    @When("enters a different Confirm Password {string}")
    public void enterDifferentConfirmPassword(String confirmPassword) {
        registrationPage.enterConfirmPassword(confirmPassword);
    }

    @When("the user leaves the Terms and Conditions checkbox unchecked")
    public void leaveTnCUnchecked() {
        // do nothing (leave unchecked)
    }

    @When("the registration page is loaded")
    public void pageIsLoaded() {
        registrationPage.open();
    }

    @When("the user fills all other fields correctly")
    public void fillAllOtherFields() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterPhoneNumber("1234567890");
        registrationPage.enterEmail("john.doe@test.com");
        registrationPage.enterPassword("ValidPass123!");
        registrationPage.enterConfirmPassword("ValidPass123!");
    }

    @When("the user fills all fields with valid details")
    public void fillAllFieldsValid() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterPhoneNumber("1234567890");
        registrationPage.enterEmail("john.doe@test.com");
        registrationPage.enterPassword("ValidPass123!");
        registrationPage.enterConfirmPassword("ValidPass123!");
    }

    @When("the user clicks Register")
    public void clickRegister() {
        registrationPage.clickRegister();
    }

    @When("the user checks the Terms and Conditions checkbox")
    public void checkTnC() {
        registrationPage.acceptTerms();
    }

    // ==============================
    // THEN steps (assertions)
    // ==============================

    @Then("an error message {string} should be displayed")
    public void errorMessageDisplayed(String expectedMessage) {
        assertTrue(registrationPage.getErrorMessage().contains(expectedMessage));
    }

    @Then("the Terms and Conditions checkbox should be unchecked by default")
    public void verifyTnCUnchecked() {
        assertFalse(registrationPage.isTermsChecked());
    }

    @Then("a success message {string} should be displayed")
    public void successMessageDisplayed(String expectedMessage) {
        assertTrue(registrationPage.getSuccessMessage().contains(expectedMessage));
    }

    @Then("a confirmation text {string} should be shown")
    public void confirmationTextDisplayed(String expectedText) {
        assertTrue(registrationPage.getConfirmationText().contains(expectedText));
    }

    @Then("the user should receive a confirmation email")
    public void confirmationEmailReceived() {
        // Here you’d normally stub/mock an email service or query test mailbox
        assertTrue(registrationPage.isConfirmationEmailReceived());
    }
}
