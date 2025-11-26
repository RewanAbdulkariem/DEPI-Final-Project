package stepDefinitions.epic2_browsing_search;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class SearchSteps
{
    private WebDriver driver = Hooks.driver;
    private HomePage homePage= new HomePage(driver);

    @Given("user on the Home page")
    public void userOnTheHomePage()
    {
        homePage.clickOnOpencartimg();
    }

    @When("user enter a valid product name in the search bar {string}")
    public void userEnterAValidProductNameInTheSearchBar(String product)
    {
        homePage.enterproductname(product);
    }

    @And("user click the search button")
    public void userClickTheSearchButton()
    {
        homePage.clicknsearchBtn();
    }

    @Then("user should see products related to the search term")
    public void userShouldSeeProductsRelatedToTheSearchTerm()
    {
        Assert.assertTrue(homePage.isProductAppeared(), "Product is not appear");
    }


}

