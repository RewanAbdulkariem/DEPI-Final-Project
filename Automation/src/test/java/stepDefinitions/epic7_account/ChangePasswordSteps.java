package stepDefinitions.epic7_account;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.ChangePasswordPage;

public class ChangePasswordSteps {
    private WebDriver driver = Hooks.driver;
    private AccountPage accountPage;
    private ChangePasswordPage changePasswordPage;


    @Given("the user navigates to the Change Password page")
    public void the_user_navigates_to_the_Change_Password_page(){
        accountPage = new AccountPage(driver);
        changePasswordPage = accountPage.clickChangePassword();
    }

    @When("I change password to {string} and {string}")
    public void I_change_password_to_and(String password, String confirm){
        changePasswordPage.enterPassword(password);
        changePasswordPage.enterConfirmPassword(confirm);
    }

    @When("the user submits password")
    public void the_user_submits_password() {
        changePasswordPage.clickContinue();
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        boolean isDisplayed = changePasswordPage.isSuccessMessageDisplayed();
        Assert.assertTrue(isDisplayed, "Success message was NOT displayed!");
    }

    @Then("the {string} should appear")
    public void the_validation_message_should_appear(String expectedMessage) {
        String actual = changePasswordPage.getErrorMessage();
        Assert.assertEquals(actual, expectedMessage, "Wrong validation message!");
    }


}
