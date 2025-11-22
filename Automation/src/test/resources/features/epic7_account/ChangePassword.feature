@registerNewUser
Feature: Change Password
  Scenario: Change password - Valid
    Given the user navigates to the Change Password page
    When I change password to "123789!" and "123789!"
    And the user submits password
    Then a confirmation message should be displayed


  Scenario Outline: Change Password - Invalid
    Given the user navigates to the Change Password page
    When I change password to "<password>" and "<confirmPassword>"
    And the user submits password
    Then the "<ValidationMessage>" should appear

    Examples:
      | password   | confirmPassword | ValidationMessage                                |
      |            |                 | Password must be between 6 and 40 characters!    |
      | 12         | 12              | Password must be between 6 and 40 characters!    |
      | validPass  |                 | Password confirmation does not match password!   |