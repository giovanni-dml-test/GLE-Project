Feature: User API Validation

  Background:
    Given the base URL

  @api_gio @smoke
  Scenario: Verify user can register successfully
    When I send a POST request to "/users/register" with body:
      """
      {
        "firstName": "testUser",
        "lastName": "lastNameTest",
        "phone": "(231) 321-6326",
        "password": "Test@123",
        "email": "testuser12345@test.com"
      }
      """
    Then the response status code should be 200

  @api_gio
  Scenario: Verify user login works
    When I send a POST request to "/users/login" with body:
      """
      {
        "email": "testuser@mail.com",
        "password": "Test@123"
      }
      """
    Then the response status code should be 200
    And the response should contain "token"

  @api_gio
  Scenario: Verify GET users/auth returns success
    When I send a GET request to "/users/auth"
    Then the response status code should be 200

  @api_gio
  Scenario: Verify GET users/admin returns success
    When I send a GET request to "/users/admin"
    Then the response status code should be 200

  @api_gio
  Scenario: Verify DELETE users/photo is restricted
    When I send a DELETE request to "/users/photo" with body:

    """
      {
        "photo": "Test@123"
      }
      """

    Then the response status code should be 400


  @api_gio
  Scenario: Verify password can be changed with PATCH
    When I send a PATCH request to "/users/change-password" with body:
      """
      {
        "currentPassword": "Test@123",
        "newPassword": "NewPass@123"
      }
      """
    Then the response status code should be 200

  @api_gio
  Scenario: Verify profile photo can be updated with PATCH
    When I send a PATCH request to "/users/photo" with body:
      """
      {
        "photo": "http://example.com/newphoto.png"
      }
      """
    Then the response status code should be 200
