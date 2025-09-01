Feature: Admin User Management
  As an Admin user,
  I want to manage user accounts (login, view, update, assign roles, delete)
  So that I can maintain system access and permissions effectively.

  @TC_01
  Scenario: Admin Login
    Given User has valid Admin credentials
    When I navigate to the login page
    And I enter valid Admin username and password
    And I click on the "Login" button
    Then Admin is successfully logged in and redirected to the Admin dashboard

  @TC_02
  Scenario: View created user information
    Given At least one user account exists in the system
    And I am logged in as Admin
    When I navigate to "User Management"
    And I select the created user
    Then Created user's information is displayed correctly

  @TC_03
  Scenario: Update user information
    Given Admin is logged in, and user information exists
    When I navigate to the created user's profile
    And I click on "Edit" or "Update" button
    And I modify one or more fields (e.g., email, phone number)
    And I save the changes
    Then User information is successfully updated and visible in the system

  @TC_04
  Scenario: Assign roles (Manager, Customer, Admin)
    Given Admin is logged in, and a user is created
    When I open the created user's profile
    And I navigate to the "Roles" section
    And I select and assign roles (Manager, Customer, or Admin)
    And I save changes
    Then The user is successfully assigned the selected roles

  @TC_05
  Scenario: Delete user
    Given Admin is logged in, and at least one user exists
    When I navigate to "User Management"
    And I select the created user
    And I click on "Delete User"
    And I confirm the deletion
    Then User account is permanently deleted and no longer visible in the system