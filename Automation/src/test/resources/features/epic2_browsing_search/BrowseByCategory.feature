Feature: Browse Products by Category

  Scenario: Open a category page
  Given user is on the Home page
  When user select a category from the menu
  Then user should see the products under that category