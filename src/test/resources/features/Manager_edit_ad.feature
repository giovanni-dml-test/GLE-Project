Feature: Manager Adverts
  As a Manager
  i want to viw, update, delete adverts
  so that i can manage property listing effectively.

  Background:
    Given Manager is registered in the system
    And at least one advert exists.

    Scenario: TC_01-Verify Manager can view and update an advert
      When the Manager navigates to the site
      And clicks on Profile
      And clicks on MyAdverts
      And checks details for an advertisement
      And clicks Edit for the selected advert
      And updates one or more fields such as Title, Description, or Address
      And clicks Update
      Then the updated advert should be shown in the MyAdverts list

  Scenario: TC_02-Verify Manager can delete an advert
    When the Manager navigates to the site
    And clicks on Profile
    And clicks on MyAdverts
    And clicks Delete on an advert
    And confirms the deletion
    Then the deleted advert should not be shown in the MyAdverts list
