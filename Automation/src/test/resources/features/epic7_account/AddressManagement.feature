@requiresLogin
Feature: AddressManagement

  Scenario Outline: Add a new address successfully
    Given the user is on the Address Book page
    And the user clicks on New Address
    When the user enters a new address with the following details "<FirstName>", "<LastName>", "<Address1>", "<City>", "<Postcode>", "<Country>", "<Region>"
    And the user saves the address
    Then a success message for adding address should be displayed
    And the new address contains "<FirstName>", "<Address1>" should appear in the address list

    Examples:
      | FirstName | LastName | Address1         | City   | Postcode | Country | Region       |
      | Auto      | User     | 123 Test Street  | Cairo  | 11511    | Egypt   | Al Buhayrah  |


  Scenario: Edit an existing address
    Given the user is on the Address Book page
    And at least one address exists in the address book
    When the user clicks on Edit for an existing address
    And the user changes the city to "Alexandria"
    And the user saves the address
    Then Success message confirms the edition
    And the updated address details should be displayed in the address list


  Scenario: Delete an address successfully
    Given the user is on the Address Book page
    And the user has at least two saved addresses
    When the user clicks Delete on one of the addresses
    And Success message confirms the deletion
    Then the address should no longer appear in the list
