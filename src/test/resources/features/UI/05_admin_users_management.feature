@ui_gio
Feature: Admin User Management
  As an Admin user,
  I want to manage user accounts (login, view, update, assign roles, delete)
  So that I can maintain system access and permissions effectively.


  @TC_01
  Scenario: Admin Login
    Given User has valid Admin credentials
    When the user enters his credentials and login
    Then Admin is successfully logged in and redirected to the Admin dashboard


  @TC_02
  Scenario: View created user information
    Given At least one user account exists in the system
    When I navigate to User Management
    And I select the created user
    Then Created user's information is displayed correctly


  @TC_03
  Scenario: Update user information
    Given At least one user account exists in the system
    When I navigate to User Management
    And I navigate to the created user's profile
    And I click on the edit button
    And I modify one or more fields
    And I save the changes
    Then User information is successfully updated and visible in the system


  @TC_04
  Scenario: Assign roles (Manager, Customer, Admin)
    Given At least one user account exists in the system
    When I navigate to User Management
    And I navigate to the created user's profile
    And I click on the edit button
    And I select and assign roles
    And I save the changes
    Then User information is successfully updated and visible in the system

  @TC_05
  Scenario: Delete user
    Given At least one user account exists in the system
    When I navigate to User Management
    And I select a user to delete
    And I click on DELETE
    And I confirm the deletion
    Then User account is permanently deleted and no longer visible in the system