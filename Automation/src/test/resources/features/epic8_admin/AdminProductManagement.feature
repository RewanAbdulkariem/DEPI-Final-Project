Feature: Admin Product Management

  Background:
    Given the admin is logged in successfully
    And the admin navigates to the Products page

  # View Products
  Scenario: View all products
    When the admin views the list of products
    Then the products table should be displayed

  # Search Product
  Scenario: Search for a product by name
    When the admin searches for a product named "iPhone"
    Then the searched product "iPhone" should appear in the results

  # Add Product
  Scenario: Add a new product
    When the admin clicks the Add Product button
    And the admin enters product name "Test Product"
    And enters meta tag title "Test Meta"
    And navigates to the Data tab
    And enters model "TP-1001"
    And navigates to the SEO tab
    And enters SEO keyword "test-product"
    And clicks Save
    Then a success message should appear saying "Success: You have modified products!"

  # Edit Product
  Scenario: Edit an existing product
    Given a product named "Test Product" exists
    When the admin clicks the Edit button for "Test Product"
    And changes the model to "TP-2002"
    And clicks Save
    Then a success message should appear saying "Success: You have modified products!"

  # Delete Product
  Scenario: Delete an existing product
    Given a product named "Test Product" exists
    When the admin selects the checkbox of "Test Product"
    And clicks the Delete button
    And confirms the deletion
    Then a success message should appear saying "Success: You have modified products!"

  # Enable / Disable Product
  Scenario: Disable a product
    Given a product named "iPhone" exists
    When the admin clicks the Edit button for "iPhone"
    And changes the product status to "Disabled"
    And clicks Save
    Then a success message should appear saying "Success: You have modified products!"

  Scenario: Enable a product
    Given a product named "iPhone" exists
    When the admin clicks the Edit button for "iPhone"
    And changes the product status to "Enabled"
    And clicks Save
    Then a success message should appear saying "Success: You have modified products!"
