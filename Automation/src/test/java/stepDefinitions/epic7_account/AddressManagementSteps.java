package stepDefinitions.epic7_account;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.AddressBookPage;
import pages.AddressPage;

public class AddressManagementSteps {
    private WebDriver driver = Hooks.driver;
    private AccountPage accountPage;
    private AddressBookPage addressBookPage;
    private AddressPage addressPage;

    @Given("the user is on the Address Book page")
    public void the_user_is_on_the_address_book_page() {
        accountPage = new AccountPage(driver);
        addressBookPage = accountPage.clickAddressBook();
    }

    @Given("the user clicks on New Address")
    public void the_user_clicks_on_new_address() {
        addressPage = addressBookPage.clickNewAddress();
    }

    @When("the user enters a new address with the following details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_a_new_address_with_the_following_details(String firstName, String lastName
            , String address1, String city, String postcode, String country, String region) {

        addressPage.enterFirstName(firstName);
        addressPage.enterLastName(lastName);
        addressPage.enterAddress1(address1);
        addressPage.enterCity(city);
        addressPage.enterPostcode(postcode);
        addressPage.selectCountry(country);
        addressPage.selectRegion(region);
    }


    @When("the user saves the address")
    public void the_user_saves_the_address() {
        addressBookPage = addressPage.clickContinue();
    }
    @Then("a success message for adding address should be displayed")
    public void aSuccessMessageForAddingAddressShouldBeDisplayed() {
        Assert.assertTrue(addressBookPage.isAddSuccessMsgDisplayed(), "Expected Success message is displayed");

    }
    @Then("the new address contains {string}, {string} should appear in the address list")
    public void theNewAddressContainsShouldAppearInTheAddressList(String arg0, String arg1) {
        Assert.assertTrue(addressBookPage.isAddressPresent(arg0, arg1), "Expected Address is added successfully");

    }

    @Given("at least one address exists in the address book")
    public void atLeastOneAddressExistsInTheAddressBook() {
        Assert.assertTrue(addressBookPage.numOfAddressRows()>= 1, "Expected at least one address row but none found");
    }

    @When("the user clicks on Edit for an existing address")
    public void theUserClicksOnEditForAnExistingAddress() {
//        addressPage = addressBookPage.clickEdit();
    }

    @And("the user changes the city to {string}")
    public void theUserChangesTheCityTo(String city) {
    }

    @Then("the updated address details should be displayed in the address list")
    public void theUpdatedAddressDetailsShouldBeDisplayedInTheAddressList() {
    }

    @Given("the user has at least two saved addresses")
    public void theUserHasAtLeastTwoSavedAddresses() {
        
    }

    @When("the user clicks Delete on one of the addresses")
    public void theUserClicksDeleteOnOneOfTheAddresses() {
        
    }

    @And("the user confirms the deletion")
    public void theUserConfirmsTheDeletion() {
        
    }

    @Then("the address should no longer appear in the list")
    public void theAddressShouldNoLongerAppearInTheList() {
    }
}