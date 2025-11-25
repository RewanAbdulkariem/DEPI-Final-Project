Feature: Add Product to Cart
  Scenario: Verify adding a product to the cart
    Given the product is available in stock
    When the user clicks Add to Cart
    Then a cart success message should be displayed
    And the cart count should increase



  Scenario: Verify empty cart message
    Given the cart is empty
    When the user opens the cart
    Then a message should appear saying "Your shopping cart is empty!"