Feature: Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user logs in with "ReWan.QA@Test.com" and "1234"
    Then the user should see the home page
