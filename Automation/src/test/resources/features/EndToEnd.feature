@requiresLogin
Feature: End To End Scenario
  Scenario: End To End
    Given user is on the Home page
    And the user Add items to the shopping cart
    When the user goes to the cart page
    And the user clicks on the Checkout button
    And the user fills in valid shipping and billing information
      | Name    | Muhammed Henna       |
      | Address | 123 Main St    |
      | City    | Manzalah         |
      | Country | Egypt             |
      | Region  | Aswan             |
    And the user clicks on the Continue button of Shipping Address section
    And the user selects Shipping Method
    And the user selects Cash On Delivery as the payment method
    And the user clicks on the Confirm Order button
    And the confirmation page loads
    Then the message "Your order has been placed!" should be displayed

