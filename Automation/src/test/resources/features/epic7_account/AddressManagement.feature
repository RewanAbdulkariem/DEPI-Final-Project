@requiresLogin
Feature: AddressManagement

  Scenario Outline: Add a new address successfully
    Given the user is on the Address Book page
    And the user clicks on New Address
    When the user enters a new address with the following details "<FirstName>", "<LastName>", "<Address1>", "<City>", "<Postcode>", "<Country>", "<Region>"
    And the user saves the address
    Then the new address should appear in the address list

    Examples:
      | FirstName | LastName | Address1         | City   | Postcode | Country | Region       |
      | Auto      | User     | 123 Test Street  | Cairo  | 11511    | Egypt   | Al Buhayrah  |
