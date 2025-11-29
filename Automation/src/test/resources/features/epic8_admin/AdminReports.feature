@admin
Feature: Admin Reports Management

  Background:
    Given the admin is logged in successfully
    And the admin navigates to the Reports page

  # Sales Report
  Scenario: View Sales Report
    When the admin opens the Sales Report
    Then the sales report table should be displayed

  Scenario: Filter Sales Report by date range
    When the admin opens the Sales Report
    And filters by date from "2024-01-01" to "2024-01-31"
    Then the results should be updated based on the selected date range

  # Products Viewed Report
  Scenario: View Products Viewed Report
    When the admin opens the Products Viewed Report
    Then the products viewed table should be displayed

  # Products Purchased Report
  Scenario: View Products Purchased Report
    When the admin opens the Products Purchased Report
    Then the products purchased table should be displayed

  # Customer Orders Report
  Scenario: View Customer Orders Report
    When the admin opens the Customer Orders Report
    Then the customer orders table should be displayed

  Scenario: Filter Customer Orders by customer name
    When the admin opens the Customer Orders Report
    And filters by customer name "john john"
    Then only orders belonging to "john john" should be displayed

  # Customer Reward Points Report
  Scenario: View Customer Reward Points Report
    When the admin opens the Customer Reward Points Report
    Then the customer reward points table should be displayed
