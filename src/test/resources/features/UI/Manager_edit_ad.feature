@ui_ajeesha

Feature: Manager Adverts
  As a Manager
  i want to view, update, delete adverts
  so that i can manage property listing effectively.

  Background:
    Given Manager navigates to the site "http://64.227.123.49/"
    And Manager is logged in the System

  @TC-01
  Scenario Outline: TC_01 - Verify Manager can view and update an advert
    When Clicks on the BacktoSite
    And the Manager clicks on Profile icon
    And clicks on "MyAdverts"
    And clicks "Edit" for the selected advert
    And updates the Title to "<Title>"
    And updates the Description to "<Description>"
    And updates the Address to "<Address>"
    And clicks "Update"
    And Click on the property
    Then the updated advert with Title "<Title>", Description "<Description>", and Address "<Address>" should be displayed

    Examples:
      | Title            | Description             | Address         |
      | Modern Apartment | Spacious 2BHK apartment | 123 Main Street |

  @TC-02
  Scenario Outline: TC_02 - Verify Manager can delete an advert
    When Clicks on the BacktoSite
    And the Manager clicks on Profile icon
    And clicks on "MyAdverts"
    And clicks "Delete" on the advert with Title "<Title>"
    And confirms the deletion
    Then the advert with Title "<Title>" should no longer appear in the "MyAdverts" list

    Examples:
      | Title            |
      | Modern Apartment |