Feature: Password Reset

  Scenario: Successful password reset request
    Given User is on the Login page
    When User click on the Forgot Password link
    Then User should be navigated to forgotten password page
    When User enter a registered email address "admin@gmail.com"
    And User click the Continue button
    Then User should be redirected to the login page