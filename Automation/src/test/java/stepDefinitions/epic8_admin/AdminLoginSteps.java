package stepDefinitions.epic8_admin;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AdminPage;

import static hooks.Hooks.driver;
import static config.TestConfig.get;

public class AdminLoginSteps {
   AdminPage adminPage;

    @Given("the admin is on the login page")
    public void the_admin_is_on_the_login_page() {
        adminPage = new AdminPage(driver);
    }

    @When("the admin enters valid username and password")
    public void the_admin_enters_valid_username_and_password() {
        adminPage.enterUsername(get("admin.username"));
        adminPage.enterPassword(get("admin.password"));
    }

    @When("the admin enters invalid username or password")
    public void the_admin_enters_invalid_username_or_password() {
        adminPage.enterUsername("wrongUser");
        adminPage.enterPassword("wrongPass");
    }

    @And("clicks the Login button")
    public void clicks_the_login_button() {
        adminPage.clickLoginButton();
    }

    @Then("the admin should be redirected to the dashboard")
    public void the_admin_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(
                adminPage.isDashboardDisplayed(),
                "Dashboard was NOT displayed after valid login!"
        );
    }

    @Then("an error message should appear saying {string}")
    public void an_error_message_should_appear_saying(String expectedMsg) {
        Assert.assertTrue(
                adminPage.isLoginErrorDisplayed(expectedMsg),
                "Error message NOT displayed or incorrect!"
        );
    }


}

