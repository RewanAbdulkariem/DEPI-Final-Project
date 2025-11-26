Feature: Admin Login

  Scenario: Successful admin login
    Given the admin is on the login page
    When the admin enters valid username and password
    And clicks the Login button
    Then the admin should be redirected to the dashboard

  Scenario: Invalid admin login
    Given the admin is on the login page
    When the admin enters invalid username or password
    And clicks the Login button
    Then an error message should appear saying "No match for Username and/or Password."