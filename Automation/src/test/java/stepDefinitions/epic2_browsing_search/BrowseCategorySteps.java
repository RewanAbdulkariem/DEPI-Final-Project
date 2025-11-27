package stepDefinitions.epic2_browsing_search;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CategoryPage;
import pages.ForgotPasswordPage;
import pages.HomePage;

public class BrowseCategorySteps 
{

    private WebDriver driver = Hooks.driver;
    private HomePage homePage = new HomePage(driver);
    private CategoryPage categoryPage = new CategoryPage(driver);

    @Given("user is on the Home page")
    public void userIsOnTheHomePage()
    {
        homePage.clickAccountIcon();
    }


    @When("user select a category from the menu")
    public void userSelectACategoryFromTheMenu()
    {

        categoryPage.hoverOnDesktopCat();
        categoryPage.clickOnAlldesctopCat();
    }

    @Then("user should see the products under that category")
    public void userShouldSeeTheProductsUnderThatCategory()
    {

        Assert.assertTrue(categoryPage.isDesctopsAppeared(),
                "Desctops word not displayed");
    }
}

