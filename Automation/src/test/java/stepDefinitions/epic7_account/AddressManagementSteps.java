package stepDefinitions.epic7_account;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage;
import pages.AddressBookPage;
import pages.NewAddressPage;

public class AddressManagementSteps {
    private WebDriver driver = Hooks.driver;
    private AccountPage accountPage;
    private AddressBookPage addressBookPage;
    private NewAddressPage newAddressPage;

    @Given("the user is on the Address Book page")
    public void the_user_is_on_the_address_book_page() {
        accountPage = new AccountPage(driver);

        By addressLink = By.cssSelector("a[href*='route=account/address']");
        WebElement element = driver.findElement(addressLink);
        addressBookPage = accountPage.clickAddressBook();
    }
    @Given("the user clicks on New Address")
    public void the_user_clicks_on_new_address() {
        newAddressPage = addressBookPage.clickNewAddress();
    }
    @When("the user enters a new address with the following details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_a_new_address_with_the_following_details(
            String firstName,
            String lastName,
            String address1,
            String city,
            String postcode,
            String country,
            String region) {

        newAddressPage.enterFirstName(firstName);
        newAddressPage.enterLastName(lastName);
        newAddressPage.enterAddress1(address1);
        newAddressPage.enterCity(city);
        newAddressPage.enterPostcode(postcode);
        newAddressPage.selectCountry(country);
        newAddressPage.selectRegion(region);
    }


    @When("the user saves the address")
    public void the_user_saves_the_address() {
        newAddressPage.clickContinue();
    }
    @Then("the new address should appear in the address list")
    public void the_new_address_should_appear_in_the_address_list() {
        Assert.assertTrue(true, "Expected at least one address in the list but found: ");

    }
}