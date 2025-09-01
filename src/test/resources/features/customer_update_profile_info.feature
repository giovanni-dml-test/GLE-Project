Feature: User Profile Management
  As a logged-in user
  I want to manage my profile information
  So that I can keep my account details up to date

  Background:
    Given the user is logged in

  @TC_01
  Scenario: View Profile Information
    When the user navigates to the dashboard
    And the user clicks on "My Profile"
    Then the profile information (name, email, phone, etc.) is displayed

  @TC_02
  Scenario: Update Profile Information
    Given the profile page is open
    When the user updates profile fields (e.g., first name, last name, phone number)
    And the user clicks "Save"
    Then the profile is updated successfully
    And a confirmation message is displayed

  @TC_03
  Scenario: Change Password
    When the user opens "My Profile"
    And the user clicks "Change Password"
    And the user enters current password, new password, and confirms new password
    And the user clicks "Save"
    Then the password is updated successfully
    And a confirmation message is displayed

  @TC_04
  Scenario: Add Profile Picture
    When the user opens "My Profile"
    And the user clicks "Profile Photo"
    And the user uploads a valid image file (e.g., .jpg, .png)
    And the user clicks "Save"
    Then the profile picture is uploaded
    And the profile picture is displayed correctly

  @TC_05
  Scenario: Invalid Profile Picture Upload
    When the user opens "My Profile"
    And the user clicks "Profile Photo"
    And the user tries uploading an invalid file type (e.g., .exe, .pdf)
    Then an error message appears "Invalid file type. Please upload a valid image."

  @TC_06
  Scenario: Delete Account
    When the user opens "My Profile"
    And the user clicks "Delete Account"
    And the user confirms deletion
    Then the account is deleted
    And the user is logged out
    And the account cannot be accessed anymore
