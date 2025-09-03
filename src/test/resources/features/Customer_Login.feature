Feature: Login functionality
  As a registered customer, I want to login securely
  so that I can access my account with valid credentials

  Background:
    Given the customer is registered in the system

  Scenario Outline: TC_01-Verify email accepts only valid format
    When the user goes to the website http://64.227.123.49/
    And clicks on the Login button
    And enters "<email>" in the Email field
    Then the system should "<result>"

    Examples:
      | email       | result                      |
      | abc         | reject the email as invalid |
      | abc@abc     | reject the email as invalid |
      | abc@abc.com | accept the email as valid   |

  Scenario: TC_02-Customer-Verify Login button is disabled until valid inputs are entered
    When the user goes to the website http://64.227.123.49/
    And clicks on the Login button
    And enters a valid email in the Email field
    And leaves the Password field blank
    Then an error message "Password required" should appear
    When the user enters a valid password
    Then the error message should disappear

  Scenario: TC_03-Customer-Verify Login button is disabled until valid inputs are entered
    When the user goes to the website
    And clicks on the Login button
    And enters a valid email in the Email field
    And enters a valid password in the Password field
    And clicks the Login button
    Then the user should be successfully logged in
    And redirected to the Homepage

  Scenario Outline: TC_04-Verify login attempts fails with invalid credentials
    When the user goes to the website
    And clicks on the Login button
    And enters "<email>" in the Email field
    And enters "<password>" in the Password field
    And clicks the Login button
    Then the system should display an error message "Invalid username or password"

    Examples:
      | email         | password  |
      | test@abc.com  | wrongPass |
      | wrong@abc.com | Test@123  |

  Scenario: TC_05-Verify successful login with valid email and password
    When the user goes to the website
    And clicks on the Login button
    And enters a valid email in the Email field
    And enters a valid password in the Password field
    And clicks the Login button
    Then the user should be successfully logged in
    And redirected to the Homepage