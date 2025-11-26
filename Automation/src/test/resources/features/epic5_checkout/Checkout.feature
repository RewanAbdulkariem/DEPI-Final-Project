Feature: Checkout and Order Flow on OpenCart Demo
  As a registered user
  I want to complete the checkout process
  So that I can place an order successfully
  @requiresLogin
  Scenario: Proceed to checkout with valid cart items
    Given the user is logged in
    And the user has items in the shopping cart
    When the user goes to the cart page
    And the user clicks on the Checkout button
    Then the user should be redirected to the checkout page
    And the URL should contain checkout
  @requiresLogin
  Scenario: Enter valid shipping and billing details

    Given the user is on the checkout page
    When the user fills in valid shipping and billing information
      | Name    | Muhammed Henna       |
      | Address | 123 Main St    |
      | City    | Manzalah         |
      | Country | Egypt             |
      | Region  | Aswan             |
    And the user clicks on the Continue button of Shipping Address section
    Then the shipping address section is collapsed
  @requiresLogin
  @requiredProductsInCart
  Scenario: Select payment method successfully
    Given the user has completed the shipping details section
    When the user selects Shipping Method
    And the user selects Cash On Delivery as the payment method
    And the user clicks on the Confirm Order button
    Then the user should be redirected to the order confirmation page
    And the selected payment method should appear in the summary
  @requiresLogin
  @requiredProductsInCart
  @completeCheckoutPageData
  Scenario: Verify success message after order placement
    Given the user clicks on the Confirm Order button
    When the confirmation page loads
    Then the message "Your order has been placed!" should be displayed
  @requiresLogin
  @requiredProductsInCart
  @completeCheckoutPageData
  Scenario: Review order before confirming
    Given the user is on the confirm order page
    And the user reviews the order items, quantities, and total
    When the user clicks on the Confirm Order button
    And the user clicks on the Continue button
    Then the homepage will open
