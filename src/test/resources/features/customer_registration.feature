Feature: Registration form validation
  As a user
  I want to register with valid details
  So that I can create an account successfully

  Background:
    Given the registration page is open

  Scenario: TC_01 - First Name is mandatory
    When the user leaves the First Name field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "First name is required" should be displayed

  Scenario: TC_02 - Last Name is mandatory
    When the user leaves the Last Name field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Last name is required" should be displayed

  Scenario: TC_03 - Phone Number is mandatory
    When the user leaves the Phone Number field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Invalid phone number" should be displayed

  Scenario: TC_04 - Email is mandatory
    When the user leaves the Email field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Email is required" should be displayed

  Scenario: TC_05 - Email format validation
    When the user enters an invalid email format "invalidemail"
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Invalid email format" should be displayed

  Scenario: TC_06 - Password is mandatory
    When the user leaves the Password field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Password is required" should be displayed

  Scenario: TC_07 - Password strength validation
    When the user enters an invalid password
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Invalid format" should be displayed

  Scenario: TC_08 - Confirm Password is mandatory
    When the user leaves the Confirm Password field empty
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Confirm password is required" should be displayed

  Scenario: TC_09 - Password and Confirm Password mismatch
    When the user enters a valid Password "ValidPass123!"
    And enters a different Confirm Password "DifferentPass123!"
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "Passwords do not match" should be displayed

  Scenario: TC_10 - Terms and Conditions unchecked
    When the user leaves the Terms and Conditions checkbox unchecked
    And the user fills all other fields correctly
    And the user clicks Register
    Then an error message "You must agree to the terms and conditions" should be displayed

  Scenario: TC_11 - Terms and Conditions unchecked on page load
    When the registration page is loaded
    Then the Terms and Conditions checkbox should be unchecked by default

  Scenario: TC_12 - Successful registration with valid details
    When the user fills all fields with valid details
    And the user checks the Terms and Conditions checkbox
    And the user clicks Register
    Then a success message "Registration successful" should be displayed
    And a confirmation text "Your registration has been completed successfully. Please activate your account by clicking the activation link sent to your e-mail." should be shown
    And the user should receive a confirmation email

