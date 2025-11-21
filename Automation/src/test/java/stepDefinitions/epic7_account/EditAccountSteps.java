package stepDefinitions.epic7_account;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.EditAccountPage;

public class EditAccountSteps {
    private WebDriver driver = Hooks.driver;
    private AccountPage accountPage;
    private EditAccountPage editAccountPage;

    // store expected values for later verification
    private String expectedFirst;
    private String expectedLast;

    @Given("the user navigates to the Edit Account page")
    public void the_user_navigates_to_the_edit_account_page(){
        accountPage = new AccountPage(driver);
        editAccountPage = accountPage.clickEditAccount();
    }
    @When("I change first name to {string} and last name to {string}")
    public void i_change_first_name_to_and_last_name_to(String first, String last){
        expectedFirst = first;
        expectedLast = last;

        editAccountPage.enterFirstname(first);
        editAccountPage.enterLastname(last);
    }

    @When("I enter {string}, {string} and {string}")
    public void i_enter_and_and(String firstname, String lastname, String email) {
        // fill fields (if empty strings passed, we intentionally clear)
        editAccountPage.enterFirstname(firstname);
        editAccountPage.enterLastname(lastname);
        editAccountPage.enterEmail(email);
    }

    @When("the user clicks Continue")
    public void the_user_clicks_continue() {
        editAccountPage.clickContinue();
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        boolean isDisplayed = editAccountPage.isSuccessMessageDisplayed();
        Assert.assertTrue(isDisplayed, "Success message was NOT displayed!");
    }

    @Then("the updated account info should be saved correctly")
    public void the_updated_account_info_should_be_saved_correctly(){
        String actualFirst = editAccountPage.getFirstName();
        String actualLast  = editAccountPage.getLastName();

        Assert.assertEquals(actualFirst, expectedFirst, "First name was not saved correctly!");
        Assert.assertEquals(actualLast, expectedLast, "Last name was not saved correctly!");
    }

    @Then("{string} should appear")
    public void validation_message_should_appear(String expectedMessage) {
        String actual = editAccountPage.getErrorMessage();
        Assert.assertEquals(actual, expectedMessage, "Wrong validation message!");
    }

}

