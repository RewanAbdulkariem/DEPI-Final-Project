Feature: Product Details Visibility

  Scenario: Verify product details visibility
    Given the user is on the product details page
    When the product page loads completely
    Then the product name should be displayed
    And the product price should be displayed
    And the product description should be displayed
    And the product stock status should be displayed


  Scenario: Verify product price format and currency
    Given the user opens a product with a defined price
    When the product price is shown
    Then it should display the correct currency symbol
