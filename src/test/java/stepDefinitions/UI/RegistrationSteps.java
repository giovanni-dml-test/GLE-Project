package stepDefinitions.UI;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    @When("the user enters an invalid email format")
    public void enterInvalidEmail() {
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys(ConfigReader.getProperty("invalid_email"));

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

    @When("the user enters a valid Password")
    public void enterValidPassword() {
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @When("enters a different Confirm Password")
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
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @When("the user fills all fields with valid details")
    public void fillAllFieldsValid() throws InterruptedException {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(5000);
        registrationPage.emailInput.sendKeys("john.doe@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
    }

    @When("the user fills all other fields correctly, except First Name")
    public void fillAllOtherFieldsExceptFirstName() throws InterruptedException {
        registrationPage.lastNameInput.sendKeys("Doe");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.emailInput.sendKeys("john.doe@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @When("the user fills all other fields correctly, except Last Name")
    public void fillAllOtherFieldsExceptLastName() throws InterruptedException {
        registrationPage.firstNameInput.sendKeys("John");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.emailInput.sendKeys("john.doe@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @And("the user fills all other fields correctly, except Phone Number")
    public void theUserFillsAllOtherFieldsCorrectlyExceptPhoneNumber() throws InterruptedException {
            registrationPage.firstNameInput.sendKeys("John");
            registrationPage.lastNameInput.sendKeys("Doe");
            registrationPage.emailInput.sendKeys("john.doe@test.com");
            registrationPage.passwordInput.sendKeys("ValidPass123!");
            registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
            registrationPage.termsCheckbox.click();
    }

    @And("the user fills all other fields correctly, except Email")
    public void theUserFillsAllOtherFieldsCorrectlyExceptEmail() throws InterruptedException {

        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();

    }

    @And("the user fills all other fields correctly, except Password")
    public void theUserFillsAllOtherFieldsCorrectlyExceptPassword() throws InterruptedException {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        registrationPage.emailInput.sendKeys("test@test.com");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @And("the user fills all other fields correctly, except Confirm Password")
    public void theUserFillsAllOtherFieldsCorrectlyExceptConfirmPassword() throws InterruptedException {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        registrationPage.emailInput.sendKeys("test@test.com");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.termsCheckbox.click();
    }

    @When("the user enters an invalid password - less than eight characters")
    public void theUserEntersAnInvalidPasswordLessThanEightCharacters() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password_length"));
    }

    @When("the user enters an invalid password - without an uppercase letter")
    public void theUserEntersAnInvalidPasswordWithoutAnUppercaseLetter() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password_no_upper"));
    }

    @When("the user enters an invalid password - without a special character")
    public void theUserEntersAnInvalidPasswordWithoutASpecialCharacter() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password_no_special"));
    }

    @When("the user enters an invalid password - without a lowercase letter")
    public void theUserEntersAnInvalidPasswordWithoutALowercaseLetter() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password_no_lower"));
    }

    @When("the user enters an invalid password - without a number")
    public void theUserEntersAnInvalidPasswordWithoutANumber() {
        registrationPage.passwordInput.clear();
        registrationPage.passwordInput.sendKeys(ConfigReader.getProperty("invalid_password_no_number"));
    }


    @And("the user fills all other fields correctly - except Password and Confirm Password")
    public void theUserFillsAllOtherFieldsCorrectlyExceptPasswordAndConfirmPassword() throws InterruptedException {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        registrationPage.emailInput.sendKeys("test@test.com");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        registrationPage.termsCheckbox.click();
    }

    @When("the customer enters all valid details in the registration form")
    public void theCustomerEntersAllValidDetailsInTheRegistrationForm() {
        registrationPage.firstNameInput.sendKeys("John");
        registrationPage.lastNameInput.sendKeys("Doe");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='1234567890';", registrationPage.phoneInput);
        registrationPage.phoneInput.sendKeys(Keys.TAB);
        registrationPage.emailInput.sendKeys("test@test.com");
        registrationPage.passwordInput.sendKeys("ValidPass123!");
        registrationPage.confirmPasswordInput.sendKeys("ValidPass123!");
    }


    @When("the user clicks Register")
    public void clickRegister() {
        registrationPage.registerButton.click();
    }

    @When("the user checks the Terms and Conditions checkbox")
    public void checkTnC() throws InterruptedException {
        Thread.sleep(5000);
        registrationPage.termsCheckbox.click();
        Thread.sleep(5000);
    }

    // ==============================
    // THEN steps (assertions)
    // ==============================

    @Then("an error message {string} should be displayed")
    public void errorMessageDisplayed(String expectedMessage) {
        assertTrue(registrationPage.errorMessage.getText().contains(expectedMessage));
    }

    @Then("an error message on the first name field should be displayed")
    public void firstNameErrorMessageDisplayed() {
        assertTrue(registrationPage.firstNameError.isDisplayed());
    }

    @Then("the Terms and Conditions checkbox should be unchecked by default")
    public void verifyTnCUnchecked() {
        assertFalse(registrationPage.termsCheckbox.isSelected());
    }

    @Then("a success message should be displayed")
    public void successMessageDisplayed() {
        assertTrue(registrationPage.successMessage.isDisplayed());
    }

    @Then("the user should receive a confirmation email")
    public void confirmationEmailReceived() {
        // Here you’d normally stub/mock an email service or query test mailbox
        //assertTrue(registrationPage.isConfirmationEmailReceived());
    }


    @Then("the register button is disabled")
    public void theRegisterButtonIsDisabled() {
        assertFalse(registrationPage.registerButton.isEnabled());
    }

    @Then("an error message on the last name should be displayed")
    public void anErrorMessageOnTheLastNameShouldBeDisplayed() {
        assertTrue(registrationPage.lastNameError.isDisplayed());
    }



    @Then("an error message on the phone number field should be displayed")
    public void anErrorMessageOnThePhoneNumberFieldShouldBeDisplayed() {
        assertTrue(registrationPage.phoneError.isDisplayed());
    }



    @Then("an error message on the email field should be displayed")
    public void anErrorMessageOnTheEmailFieldShouldBeDisplayed() {
        assertTrue(registrationPage.emailError.isDisplayed());
    }

    @Then("an error message on the email field should be displayed showing invalid email format")
    public void anErrorMessageOnTheEmailFieldShouldBeDisplayedShowingInvalidEmailFormat() {
        assertTrue(registrationPage.invalidEmailError.isDisplayed());
    }



    @Then("an error message on the password field should be displayed")
    public void anErrorMessageOnThePasswordFieldShouldBeDisplayed() {
        assertTrue(registrationPage.passwordError.isDisplayed());
    }


    @Then("an error message on the password should be displayed showing password strength requirements - at least eight characters")
    public void anErrorMessageOnThePasswordShouldBeDisplayedShowingPasswordStrengthRequirementsAtLeastCharacters() {
        assertTrue(registrationPage.passwordLengthError.isDisplayed());
    }

    @Then("an error message on the password should be displayed showing password strength requirements - at least one uppercase letter")
    public void anErrorMessageOnThePasswordShouldBeDisplayedShowingPasswordStrengthRequirementsAtLeastOneUppercaseLetter() {
        assertTrue(registrationPage.passwordUppercaseError.isDisplayed());
    }

    @Then("an error message on the password should be displayed showing password strength requirements - at least one special character")
    public void anErrorMessageOnThePasswordShouldBeDisplayedShowingPasswordStrengthRequirementsAtLeastOneSpecialCharacter() {
        assertTrue(registrationPage.passwordSpecialCharError.isDisplayed());
    }

    @Then("an error message on the password should be displayed showing password strength requirements - at least one lowercase letter")
    public void anErrorMessageOnThePasswordShouldBeDisplayedShowingPasswordStrengthRequirementsAtLeastOneLowercaseLetter() {
        assertTrue(registrationPage.passwordLowercaseError.isDisplayed());
    }

    @Then("an error message on the password should be displayed showing password strength requirements - at least one number")
    public void anErrorMessageOnThePasswordShouldBeDisplayedShowingPasswordStrengthRequirementsAtLeastOneNumber() {
        assertTrue(registrationPage.passwordNumberError.isDisplayed());
    }


    @Then("an error message on the confirm password field should be displayed")
    public void anErrorMessageOnTheConfirmPasswordFieldShouldBeDisplayed() {
        assertTrue(registrationPage.confirmPasswordError.isDisplayed());
    }


    @Then("an error message should be displayed on the confirm password field - Passwords do not match")
    public void anErrorMessageShouldBeDisplayedOnTheConfirmPasswordField() {
        assertTrue(registrationPage.passwordsMustMatchError.isDisplayed());
    }


}
