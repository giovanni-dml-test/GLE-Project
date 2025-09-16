Feature: Registration form validation
  As a user
  I want to register with valid details
  So that I can create an account successfully

  Background:
    Given the registration page is open

  Scenario: TC_01 - First Name is mandatory
    When the user leaves the First Name field empty
    And the user fills all other fields correctly, except First Name
    Then the register button is disabled
    Then an error message on the first name field should be displayed

  Scenario: TC_02 - Last Name is mandatory
    When the user leaves the Last Name field empty
    And the user fills all other fields correctly, except Last Name
    Then the register button is disabled
    Then an error message on the last name should be displayed

  Scenario: TC_03 - Phone Number is mandatory
    When the user leaves the Phone Number field empty
    And the user fills all other fields correctly, except Phone Number
    Then the register button is disabled
    Then an error message on the phone number field should be displayed


  Scenario: TC_04 - Email is mandatory
    When the user leaves the Email field empty
    And the user fills all other fields correctly, except Email
    Then the register button is disabled
    Then an error message on the email field should be displayed

  Scenario: TC_05 - Email format validation
    When the user enters an invalid email format
    And the user fills all other fields correctly
    Then the register button is disabled
    Then an error message on the email field should be displayed showing invalid email format

  Scenario: TC_06 - Password is mandatory
    When the user leaves the Password field empty
    And the user fills all other fields correctly, except Password
    Then the register button is disabled
    Then an error message on the password field should be displayed

  Scenario: TC_07a - Password strength validation - Minimum 8 characters
    When the user enters an invalid password - less than eight characters
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message on the password should be displayed showing password strength requirements - at least eight characters

  Scenario: TC_07b - Password strength validation - At least one uppercase letter
    When the user enters an invalid password - without an uppercase letter
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message on the password should be displayed showing password strength requirements - at least one uppercase letter

  Scenario: TC_07c - Password strength validation - At least one special character
    When the user enters an invalid password - without a special character
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message on the password should be displayed showing password strength requirements - at least one special character

  Scenario: TC_07d - Password strength validation - At least one lowercase letter
    When the user enters an invalid password - without a lowercase letter
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message on the password should be displayed showing password strength requirements - at least one lowercase letter

  Scenario: TC_07e - Password strength validation - At least one number
    When the user enters an invalid password - without a number
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message on the password should be displayed showing password strength requirements - at least one number


  Scenario: TC_08 - Confirm Password is mandatory
    When the user leaves the Confirm Password field empty
    And the user fills all other fields correctly, except Confirm Password
    Then the register button is disabled
    Then an error message on the confirm password field should be displayed

  Scenario: TC_09 - Password and Confirm Password mismatch
    When the user enters a valid Password
    And enters a different Confirm Password
    And the user fills all other fields correctly - except Password and Confirm Password
    Then the register button is disabled
    Then an error message should be displayed on the confirm password field - Passwords do not match

  Scenario: TC_10 - Terms and Conditions unchecked
    When the user leaves the Terms and Conditions checkbox unchecked
    And the user fills all fields with valid details
    Then the register button is disabled

  Scenario: TC_11 - Terms and Conditions unchecked on page load
    When the registration page is loaded
    Then the Terms and Conditions checkbox should be unchecked by default

  Scenario: TC_12 - Successful registration with valid details
    When the customer enters all valid details in the registration form
    And the user checks the Terms and Conditions checkbox
    And the user clicks Register
    Then a success message should be displayed
    And the user should receive a confirmation email

