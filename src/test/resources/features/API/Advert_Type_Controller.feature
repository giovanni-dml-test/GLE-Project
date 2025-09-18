@api_ajeesha
Feature: AdvertType_controller

  Scenario: Get all advert types
    Given I send a GET request
    Then Response status code should be 200
    And Response body should contain title

  Scenario: Create a new advert type
    When I send a POST request to create advert type
    Then Response status code should be 200
    And Response should contain created title

  Scenario: Update an existing advert type
    When I send a PUT request to update advert type
    Then Response status code should be 200
    And Response should contain updated title

  Scenario: Delete an advert type
    When I send a DELETE request
    Then Response status code should be 204







