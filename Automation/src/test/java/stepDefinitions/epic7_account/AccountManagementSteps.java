package stepDefinitions.epic7_account;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountManagementSteps {
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private EditAccountPage editAccountPage;

    // store expected values for later verification
    private String expectedFirst;
    private String expectedLast;

    @Given("the user is logged in with {string} and {string}")
    public void the_user_is_logged_in(String email, String password){
        homePage = new HomePage(driver);
        homePage.clickAccountIcon();
        loginPage = homePage.clickLogin();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        accountPage = loginPage.clickLogin();
    }

    @Given("the user navigates to the Edit Account page")
    public void the_user_navigates_to_the_edit_account_page(){
        editAccountPage = accountPage.clickEditAccount();
    }
    @When("I change first name to {string} and last name to {string}")
    public void i_change_first_name_to_and_last_name_to(String first, String last){
        expectedFirst = first;
        expectedLast = last;

        editAccountPage.enterFirstname(first);
        editAccountPage.enterLastname(last);
    }

    @When("the user clicks Continue")
    public void the_user_clicks_continue() {
        accountPage = editAccountPage.clickContinue();
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        boolean isDisplayed = editAccountPage.isSuccessMessageDisplayed();
        Assert.assertTrue(isDisplayed, "Success message was NOT displayed!");
    }

    @Then("the updated account info should be saved correctly")
    public void the_updated_account_info_should_be_saved_correctly(){
        editAccountPage = accountPage.clickEditAccount();
        String actualFirst = editAccountPage.getFirstName();
        String actualLast  = editAccountPage.getLastName();

        Assert.assertEquals(actualFirst, expectedFirst, "First name was not saved correctly!");
        Assert.assertEquals(actualLast, expectedLast, "Last name was not saved correctly!");
    }
}

