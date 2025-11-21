Feature: Edit Account Information
  Scenario: Edit account with valid first and last name
    Given the user is logged in with "admin@gmail.com" and "123456"
    And the user navigates to the Edit Account page

    When I change first name to "John" and last name to "Doe"
    And the user clicks Continue

    Then a success message should be displayed
    And the updated account info should be saved correctly


