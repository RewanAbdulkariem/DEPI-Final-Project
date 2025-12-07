package stepDefinitions.epic1_registration_login;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.util.UUID;

public class RegisterSteps
{
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private RegisterPage registerPage ;



    @Given("User is on the Registration page")
    public void user_is_on_the_registration_page()
    {
        homePage = new HomePage(driver);
        homePage.clickAccountIcon();
        registerPage = homePage.clickRegister();
    }


    @When("User enter valid data")
    public void user_enter_valid_data()
    {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        String firstname ="auto";
        String lastname= "auto";
        String email = "test+" + unique + "@mail.com";
        String password ="123456";
        registerPage.enterFirstName(firstname);
        registerPage.enterLastName(lastname);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
    }

    @And("User agree to the privacy policy")
    public void user_agree_to_the_privacy_policy()
    {
        // click only if not already selected
        By agreeCheckbox = By.name("agree");
        if (!driver.findElement(agreeCheckbox).isSelected())
       {
            registerPage.click(agreeCheckbox);
       }
    }

    @And("User click on the Continue button")
    public void user_click_on_the_continue_button() throws InterruptedException {
        registerPage.clickContinue();
        Thread.sleep(5000);
    }

    @Then("User should be redirected to the account success page")
    public void user_should_be_redirected_to_the_account_success_page()
    {
        String expectedUrl = "account/success";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }


}

