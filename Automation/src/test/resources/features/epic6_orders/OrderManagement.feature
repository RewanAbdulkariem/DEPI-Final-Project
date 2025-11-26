Feature: Order Management
  As a registered user
  I want to view and manage my orders
  So that I can track my past purchases and their statuses.



  # 21. View order history
  @requiresLogin
  Scenario: View order history
    When the user clicks on Order History in the My Account menu
    Then the system should display a list of previous orders
    And each order should show Order ID, Status, and Date Added

  # 22. View order status
  @requiresLogin
  Scenario: View order status
    Given the user is on the Order History page
    When the user checks a specific order
    Then the order details page should show the current order status
      | Example Status |
      | Pending        |
      | Shipped        |
      | Complete       |


