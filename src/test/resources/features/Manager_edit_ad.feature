Feature: Manager Adverts
  As a Manager
  i want to view, update, delete adverts
  so that i can manage property listing effectively.

  Background:
    Given Manager navigates to the site "http://64.227.123.49/"
    And Manager is logged in the System


  Scenario Outline: TC_01 - Verify Manager can view and update an advert
    When Clicks on the BacktoSite
    And the Manager clicks on Profile icon
    And clicks on "MyAdverts"
    And views the details of an advertisement
    And clicks "Edit" for the selected advert
    And updates the Title to "<Title>"
    And updates the Description to "<Description>"
    And updates the Address to "<Address>"
    And clicks "Update"
    Then the updated advert with Title "<Title>", Description "<Description>", and Address "<Address>" should be displayed in the "MyAdverts" list

    Examples:
      | Title           | Description                | Address            |
      | Modern Apartment| Spacious 2BHK apartment   | 123 Main Street    |
      | Cozy Cottage    | Quiet countryside cottage | 456 Country Road   |

  Scenario Outline: TC_02 - Verify Manager can delete an advert
    When the Manager clicks on "Profile"
    And clicks on "MyAdverts"
    And clicks "Delete" on the advert with Title "<Title>"
    And confirms the deletion
    Then the advert with Title "<Title>" should no longer appear in the "MyAdverts" list

    Examples:
      | Title           |
      | Modern Apartment|
      | Cozy Cottage    |