Feature: Authentication
  Scenario: check login with valid data
    Given User navigate to login page
    When User enter valid "admin@gmail.com" and "123456"
    And Click on login button
    Then the user should see the account page
