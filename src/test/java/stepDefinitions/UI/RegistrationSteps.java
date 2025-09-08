package stepDefinitions.UI;

import io.cucumber.java.en.*;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.Driver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RegistrationSteps {


    public final RegistrationPage registrationPage = new RegistrationPage();

    @Given("the registration page is open")
    public void openRegistrationPage() {
        Driver.getDriver().get(("http://64.227.123.49/register"));
    }

    @When("the user leaves the First Name field empty")
    public void leaveFirstNameEmpty() {
        registrationPage.firstNameInput.clear();
        registrationPage.firstNameInput.sendKeys("");
    }

    @When("the user leaves the Last Name field empty")
    public void leaveLastNameEmpty() {
        registrationPage.lastNameInput.clear();
        registrationPage.lastNameInput.sendKeys("");
    }

    @When("the user leaves the Phone Number field empty")
    public void leavePhoneEmpty() {
        registrationPage.phoneInput.clear();
        registrationPage.phoneInput.sendKeys("");
    }

    @When("the user leaves the Email field empty")
    public void leaveEmailEmpty() {
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys("");
    }

    @When("the user enters an invalid email format {string}")
    public void enterInvalidEmail(String email) {
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys(ConfigReader.getProperty("invalidEmail"));

    }

    @When("the user leaves the Password field empty")
    public void leavePasswordEmpty() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys("");
    }

    @When("the user enters an invalid password")
    public void enterInvalidPassword() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password"));// weak password
    }

    @When("the user leaves the Confirm Password field empty")
    public void leaveConfirmPasswordEmpty() {
        registrationPage.confirmPasswordInput.clear();
        registrationPage.confirmPasswordInput.sendKeys("");
    }

    @When("the user enters a valid Password {string}")
    public void enterValidPassword() {
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @When("enters a different Confirm Password {string}")
    public void enterDifferentConfirmPassword() {
        registrationPage.confirmPasswordInput.sendKeys(ConfigReader.getProperty("different_password"));
    }

    @When("the user leaves the Terms and Conditions checkbox unchecked")
    public void leaveTnCUnchecked() {
        // do nothing (leave unchecked)
    }

    @When("the registration page is loaded")
    public void pageIsLoaded() {
        Driver.getDriver().get("http://64.227.123.49/register");
    }

    @When("the user fills all other fields correctly")
    public void fillAllOtherFields() {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        registrationPage.phoneInput.sendKeys("1234567890");
        registrationPage.emailInput.sendKeys("john.doe@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @When("the user fills all fields with valid details")
    public void fillAllFieldsValid() {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        registrationPage.phoneInput.sendKeys("1234567890");
        registrationPage.emailInput.sendKeys("john.doe@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
    }

    @When("the user clicks Register")
    public void clickRegister() {
        registrationPage.registerButton.click();
    }

    @When("the user checks the Terms and Conditions checkbox")
    public void checkTnC() {
        registrationPage.termsCheckbox.click();
    }

    // ==============================
    // THEN steps (assertions)
    // ==============================

    @Then("an error message {string} should be displayed")
    public void errorMessageDisplayed(String expectedMessage) {
        assertTrue(registrationPage.errorMessage.getText().contains(expectedMessage));
    }

    @Then("the Terms and Conditions checkbox should be unchecked by default")
    public void verifyTnCUnchecked() {
        assertFalse(registrationPage.termsCheckbox.isSelected());
    }

    @Then("a success message {string} should be displayed")
    public void successMessageDisplayed(String expectedMessage) {
        assertTrue(registrationPage.successMessage.getText().contains(expectedMessage));
    }

    @Then("a confirmation text {string} should be shown")
    public void confirmationTextDisplayed(String expectedText) {
        assertTrue(registrationPage.successMessage.getText().contains(expectedText));
    }

    @Then("the user should receive a confirmation email")
    public void confirmationEmailReceived() {
        // Here you’d normally stub/mock an email service or query test mailbox
        //assertTrue(registrationPage.isConfirmationEmailReceived());
    }


}
