package stepDefinitions.epic1_registration_login;


import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        homePage = new HomePage(driver);
        homePage.clickAccountIcon();
        loginPage = homePage.clickLogin();
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the user should see the account page")
    public void the_user_should_see_the_account_page() {
        String expectedUrl = "route=account/account";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }
}