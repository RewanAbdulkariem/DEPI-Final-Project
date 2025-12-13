package stepDefinitions.epic1_registration_login;


import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

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
    @When("User enter invalid {string} and {string}")
    public void user_Enter_Invalid_And(String email, String password)
    {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("Click on login button")
    public void clickonloginbtn () {loginPage.clickLogin();}


    @Then("the user should see the account page")
    public void userseetheaccountpage() {
        loginPage.waitForSuccessfulLogin();
        String expectedUrl = "route=account/account";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }

    @Then("error msg should be displayed and user still on login page")
    public void errorMsgShouldBeDisplayedAndUserStillOnLoginPage()
    {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actual = loginPage.getErrorMsg();
        Assert.assertEquals(actual, expectedMessage, "Wrong validation message!");

    }

}