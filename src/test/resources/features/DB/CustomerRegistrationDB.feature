Feature: Customer Registration - Database Validation
  As a QA Engineer
  I want to validate that customer registration data is stored correctly in the database
  So that the application ensures data consistency and integrity

  Background:
    Given a database connection is established

 @positive
  Scenario: Verify customer is stored in DB after successful registration
    Given a new customer registers via API with the following details:
      | firstName | lastName | phone      | email              | password     |
      | John      | Doe      | 1234567890 | john.doe@test.com  | ValidPass123! |
    Then the customer with email "john.doe@test.com" should exist in the database
    And the customer first name should be "John"
    And the customer last name should be "Doe"
    And the customer phone should be "1234567890"

 @negative
  Scenario: Verify customer is NOT stored in DB with duplicate email
    Given a new customer registers via API with the following details:
      | firstName | lastName | phone      | email              | password     |
      | Alice     | Smith    | 9876543210 | john.doe@test.com  | ValidPass123! |
    Then the registration API should return status 400
    And the customer with email "john.doe@test.com" should still have first name "John"

 @negative
  Scenario: Verify customer is NOT stored in DB with invalid email format
    Given a new customer registers via API with the following details:
      | firstName | lastName | phone      | email     | password     |
      | Bob       | Miller   | 5551112222 | bobtest   | ValidPass123! |
    Then the registration API should return status 400
    And the customer with email "bobtest" should not exist in the database

 @cleanup
  Scenario: Clean up test data from DB
    Given I delete the customer with email "john.doe@test.com" from the database
    Then the customer with email "john.doe@test.com" should not exist in the database
