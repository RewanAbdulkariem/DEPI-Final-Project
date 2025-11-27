package stepDefinitions.epic1_registration_login;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class ResetPasswordSteps 
{
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    ;

    @Given("User is on the Login page")
    public void user_is_on_the_login_page()
    {
        homePage = new HomePage(driver);
        homePage.clickAccountIcon();
        loginPage = homePage.clickLogin();
    }

    @When("User click on the Forgot Password link")
    public void user_click_on_the_forgot_password_link()
    {
        loginPage.clickForgottenPasswordLink();
    }
    
    @Then("User should be navigated to forgotten password page")
    public void user_should_be_navigated_to_forgotten_password_page()
    {
        String expectedUrl = "route=account/forgotten";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Navigation failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }

    @When("User enter a registered email address {string}")
    public void user_enter_a_registered_email_address(String email)
    {
        forgotPasswordPage.enteremail(email);
    }

    @And("User click the Continue button")
    public void user_click_the_continue_button()
    {
        forgotPasswordPage.clickonContinuebtn();
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page()
    {

        Assert.assertTrue(forgotPasswordPage.isResetEmailSent(),
                "Success message not displayed after submitting reset request.");
    }
}

