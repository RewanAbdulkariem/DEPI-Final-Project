Feature: Authentication
  Scenario: check login with valid data
    Given User navigate to login page
    When User enter valid "admin@gmail.com" and "123456"
    And Click on login button
    Then the user should see the account page


    Scenario Outline: check login with in valid data
      Given User navigate to login page
      When User enter invalid "<email>" and "<password>"
      And Click on login button
      Then error msg should be displayed and user still on login page
      Examples:
        | email              | password |
        | admin@gmail.com    |  111111  |
        | add@gmail.com      |  123456  |
        | add@gmail.com      |  111111  |
