@api
Feature: Customer Registration API
  As a new customer
  I want to register via the API
  So that I can create an account successfully

  Background:
    Given the base API URL is set

  @API @Positive
  Scenario: Successful registration with valid data
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 200
    And the response body should contain "id"
    And the response body should contain "email"

  @API @Negative
  Scenario: First Name is required
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "First Name is required"

  @API @Negative
  Scenario: Last Name is required
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Last Name is required"

  @API @Negative
  Scenario: Phone is required
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Phone is required"

  @API @Negative
  Scenario Outline: Invalid phone format
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "<phone>",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Invalid phone number"

    Examples:
      | phone         |
      | abcdefg       |
      | 123           |
      | +49-123-XYZ   |

  @API @Negative
  Scenario: Email is required
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Email is required"

  @API @Negative
  Scenario Outline: Invalid email format
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "<email>",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Invalid email format"

    Examples:
      | email         |
      | johndoe.com   |
      | john@doe      |
      | john@@test.com|

  @API @Negative
  Scenario: Password is required
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": ""
      }
      """
    Then the response status code should be 400
    And the response body should contain "Password is required"

  @API @Negative
  Scenario: Weak password
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": "123"
      }
      """
    Then the response status code should be 400
    And the response body should contain "Password does not meet security requirements"

  @API @Negative
  Scenario: Duplicate email registration
    Given a user already exists with email "john.doe@test.com"
    When I send a POST request to "/users/register" with the following body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "phone": "1234567890",
        "email": "john.doe@test.com",
        "password": "ValidPass123!"
      }
      """
    Then the response status code should be 409
    And the response body should contain "Email already exists"
