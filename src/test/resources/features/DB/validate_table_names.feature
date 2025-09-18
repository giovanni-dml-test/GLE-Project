Feature: Database Table Validation

  @db
  Scenario: Validate all required tables exist in the database
    Given the database connection is established
    When I retrieve the list of tables
    Then the following tables should exist:
      | advert_types             |
      | adverts                  |
      | categories               |
      | category_property_keys   |
      | category_property_values |
      | cities                   |
      | cmd_exec                 |
      | confirmation_token       |
      | countries                |
      | daily_reports            |
      | districts                |
      | favorites                |
      | images                   |
      | logs                     |
      | personel                 |
      | profile_photos           |
      | tour_requests            |
      | users                    |
