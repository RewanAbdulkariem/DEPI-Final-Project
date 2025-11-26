Feature: Product Search

  Scenario: Search for an existing product
    Given user on the Home page
    When user enter a valid product name in the search bar "iPod Classic"
    And user click the search button
    Then user should see products related to the search term