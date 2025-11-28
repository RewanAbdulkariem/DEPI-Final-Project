@admin
Feature: Admin Orders Management

  Background:
    Given the admin is logged in successfully
    And the admin navigates to the Orders page

  Scenario: View all orders
    When the admin views the orders list
    Then the orders table should be displayed

  Scenario: Search for an order by order ID
    When the admin searches for order with ID "2"
    Then the searched order with ID "2" should appear in the results

  Scenario: Change order status
    Given an order with ID "2" exists
    When the admin opens the order details for "2"
    And the admin changes the order status to "Complete"
    And clicks the Save button
    Then a success message should appear saying "Success: You have modified orders!"

  Scenario: Filter orders by customer name
    When the admin filters orders using customer name "John"
    Then orders belonging to "John" should be displayed

  Scenario: View order details
    Given an order with ID "2" exists
    When the admin opens the order details for "2"
    Then the order information page should be displayed
