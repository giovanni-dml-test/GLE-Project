@ui
Feature: User Profile Management
  As a logged-in user
  I want to manage my profile information
  So that I can keep my account details up to date

  Background:
    Given the user is logged in

  @TC_01
  Scenario: View Profile Information
    When the user navigates to the dashboard
    Then the profile information is displayed

  @TC_02
  Scenario: Update Profile Information
    Given the profile page is open
    When the user updates profile fields
    And the user clicks the update button
    Then the profile is updated successfully
    And a confirmation message is displayed


  @TC_03
  Scenario: Change Password
    When the user navigates to the dashboard
    And the user clicks Change Password
    And the user enters current password, new password, and confirms new password
    And the user clicks on the Change button
    Then the password is updated successfully and a confirmation message is displayed


  @TC_04
  Scenario: Add Profile Picture
    When the user navigates to the dashboard
    And the user clicks on Profile Photo
    And the user uploads a valid image file
    And the user clicks on the Done button
    Then the profile picture is displayed correctly


  @TC_05
  Scenario: Invalid Profile Picture Upload
    When the user navigates to the dashboard
    And the user clicks on Profile Photo
    And the user tries uploading an invalid file type
    Then an error message appears
    And the save button is disabled

  @TC_06
  Scenario: Delete Account
    When the user navigates to the dashboard
    And the user clicks Delete Account
    And the user enters the password
    And the user confirms deletion
    Then the account is deleted
    And the user is logged out
    And the account cannot be accessed anymore
