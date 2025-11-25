Feature: User Registration

  Scenario: Successful user registration
    Given User is on the Registration page
    When User enter valid data "makariouss" , "morgann" , "maky@gmail.com" , "1123456"
    And User agree to the privacy policy
    And User click on the Continue button
    Then User should be redirected to the account success page

