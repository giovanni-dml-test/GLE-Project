@ui_ajeesha @login_functionality

Feature: Login functionality
  As a registered customer, I want to login securely
  so that I can access my account with valid credentials

  Background:
    Given the user goes to the website "http://64.227.123.49"

  @TC-01
  Scenario Outline: TC_01-Verify email accepts only valid format
    When clicks on the Login button
    And enters "<email>" in the Email field
    And clicks on the password Field
    Then the system should "<result>"

    Examples:
      | email       | result        |
      | abc         | Invalid email |
      | abc@abc     | Invalid email |
      | abc@abc.com |               |

  @TC-02
  Scenario: TC_02-Verify password field is mandatory
    When clicks on the Login button
    And leaves the Password field blank
    And Clicks on the emailfield
    Then an error message "Password is required" should appear
    When the user enters a valid password
    Then the error message should disappear

  @TC-03
  Scenario: TC_03-Customer-Verify Login button is disabled until valid inputs are entered
    When clicks on the Login button
    And enters a valid email in the Email field
    And enters a valid password in the Password field
    And clicks the Login button
    Then redirected to the Homepage

  @TC-04
  Scenario Outline: TC-04-Verify login attempts fails with invalid credentials
    When clicks on the Login button
    And enters "<email>" in the Email field
    And enters "<password>" in the Password field
    And clicks the Login button
    Then the system should display an error message "Invalid email or password"

    Examples:
      | email         | password  |
      | test@abc.com  | wrongPass |
      | wrong@abc.com | Test@123  |

  @TC-05
  Scenario: TC_05-Verify successful login with valid email and password
    When clicks on the Login button
    And enters a valid email in the Email field
    And enters a valid password in the Password field
    And clicks the Login button
    Then redirected to the Homepage