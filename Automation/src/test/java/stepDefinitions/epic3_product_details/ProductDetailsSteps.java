package stepDefinitions.epic3_product_details;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProductPage;
import hooks.Hooks;

import static hooks.Hooks.driver;

public class ProductDetailsSteps {
    ProductPage productPage = new ProductPage(driver);

    @Given("the user is on the product details page")

    public void the_user_is_on_the_product_details_page() {
        driver.get("http://localhost/opencart/index.php?route=product/product&language=en-gb&product_id=43");

    }

    @When("the product page loads completely")
    public void the_product_page_loads_completely() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {
        Assert.assertTrue(productPage.isProductNameDisplayed(),
                "Product name is NOT displayed!");
    }
    @And("the product price should be displayed")
    public void the_product_price_should_be_displayed() {
        Assert.assertTrue(productPage.isProductPriceDisplayed(),
                "Product price is NOT displayed!");
    }
    @And("the product description should be displayed")
    public void the_product_description_should_be_displayed() {
        Assert.assertTrue(productPage.isProductDescriptionDisplayed(),
                "Product description is NOT displayed!");
    }
    @And ("the product stock status should be displayed")
    public void the_product_stock_status_should_be_displayed() {
        Assert.assertTrue(productPage.isStockStatusDisplayed(),
                "Stock status is NOT displayed!");
    }
    @Given("the user opens a product with a defined price")
    public void the_user_opens_a_product_with_a_defined_price() {
        driver.get("http://localhost/opencart/index.php?route=product/product&language=en-gb&product_id=43");
    }

    @When("the product price is shown")
    public void the_product_price_is_shown() {
        Assert.assertTrue(productPage.isProductPriceDisplayed(),
                "Product price is NOT displayed on the page!");
    }
    @Then("it should display the correct currency symbol")
    public void it_should_display_the_correct_currency_symbol() {

        String priceText = productPage.getProductPrice();
        boolean containsCurrency =
                priceText.contains("$") ||
                        priceText.contains("£") ||
                        priceText.contains("€");

        Assert.assertTrue(containsCurrency,
                "Price does NOT contain a valid currency symbol! Actual price: " + priceText);
    }
}

