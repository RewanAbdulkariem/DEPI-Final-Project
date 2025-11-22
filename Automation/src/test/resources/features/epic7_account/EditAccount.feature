@registerNewUser
Feature: Edit Account Information
  Scenario: Edit account with valid first and last name
    Given the user navigates to the Edit Account page

    When I change first name to "John" and last name to "Doe"
    And the user clicks Continue

    Then a success message should be displayed
    And the updated account info should be saved correctly

  Scenario Outline: Edit account with invalid info
    Given the user navigates to the Edit Account page

    When I enter "<firstname>", "<lastname>" and "<email>"
    And the user clicks Continue

    Then "<ValidationMessage>" should appear

    Examples:
      | firstname | lastname | email          | ValidationMessage                 |
      | John      | Doe      | user@test     | E-Mail Address does not appear to be valid!    |
      |           | Doe      | john@test.com  | First Name must be between 1 and 32 characters!|
      | John      |          | john@test.com  | Last Name must be between 1 and 32 characters! |
      | John      | Doe      |                | E-Mail Address does not appear to be valid!    |