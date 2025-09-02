Feature: Guest User Functionality
  As a guest user
  I want to browse property listings
  So that I can see adverts but restricted from certain actions

  Background:
    Given the user is not registered or logged in

  Scenario: TC-01-Verify guest user can perform property search with filters
    When the guest enters a keyword in the search bar
    And selects a price range
    And selects an advert type
    And selects a category
    And selects a country, city, and district
    And clicks the Search button
    Then the system should display properties matching the filter

  Scenario: TC-02-Verify guest user can view property details
    When the guest selects a property from the search results
    And opens the property details page
    Then the system should display property details including:
      | Image(s)   |
      | Description|
      | Price      |
      | Status     |
      | Type       |
      | Size       |
      | Location   |

  Scenario Outline:TC-03-Verify guest user is restricted from contacting advertiser
    When the guest clicks on "<contactOption>" on a property advertisement
    Then the system should display a warning message "<warningMessage>"

    Examples:
      | contactOption | warningMessage                          |
      | Contact Number| Don't have an account? Create one now!  |
      | Email         | Don't have an account? Create one now!  |



  Scenario Outline: TC-04-Verify guest user cannot request an appointment for a property
    When the guest enters a valid Tour Date "<tourDate>" and Tour Time "<tourTime>" on a property advertisement
    And clicks on Submit a Tour Request
    Then the system should display a warning message "<loginMessage>"
    And the system should display a message "<createAccountMessage>"

    Examples:
      | tourDate  | tourTime | loginMessage          | createAccountMessage             |
      | 2025-09-10| 10:00 AM | Log in for tour request| Don't have an account? Create one now! |
