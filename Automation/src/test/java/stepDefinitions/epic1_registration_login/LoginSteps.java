package stepDefinitions.epic1_registration_login;


import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps
{
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private LoginPage loginPage;


    @Given("User navigate to login page")
    public void navigatetologinpage ()
    {
        homePage = new HomePage(driver);
       homePage.clickAccountIcon();
        loginPage = homePage.clickLogin();
    }

    @When("User enter valid {string} and {string}")
    public void userEnterValidAnd(String email, String password)
    {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
//    @When("User enter valid {String} and {String}")
//   public void entervaliduserandpassword (String email, String password) {
//
//
//    }

    @And("Click on login button")
    public void clickonloginbtn ()

    {
        loginPage.clickLogin();
    }


    @Then("the user should see the account page")
    public void userseetheaccountpage() {
        String expectedUrl = "route=account/account";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }

}