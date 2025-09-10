
@Category_table
Feature: Validate Categories Table

  As a QA Engineer
  i want to validate the categories table column names and information
  So that the database schema and data are correct and consistent

  Background:
    Given i have the access to the database

  Scenario:Verify categories table column and data
    When i fetch the structure of the "categories" table
    Then the table should have the following columns:

      | id         |
      | created_at |
      | updated_at |
      | is_active  |
      | built_in   |
      | icon       |
      | seq        |
      | slug       |
      | title      |
    Then i fetch all records from the categories table
    Then each category record should have valid data

