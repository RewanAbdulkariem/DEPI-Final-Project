package stepDefinitions.epic4_cart;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;

import pages.ProductPage;

import static hooks.Hooks.driver;

public class AddToCartSteps {

    ProductPage productPage;
    int oldCartCount;

    @Given("the product is available in stock")
    public void the_product_is_available_in_stock() {
        driver.get("http://localhost/opencart/index.php?route=product/product&language=en-gb&product_id=43");
        productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isProductInStock(),
                "Product is NOT in stock — cannot proceed with Add to Cart test");
    }
    @When("the user clicks Add to Cart")
    public void the_user_clicks_add_to_cart() {

        oldCartCount = productPage.getCartCount();
        productPage.clickAddToCart();
    }
    @Then("a cart success message should be displayed")
    public void a_success_message_should_be_displayed() {
        Assert.assertTrue(
                productPage.isSuccessMessageDisplayed(),
                "Success message NOT displayed after adding product to cart"
        );
    }

    @And ("the cart count should increase")
    public void the_cart_count_should_increase() {

        int newCount = productPage.getCartCount();

        Assert.assertTrue(newCount > oldCartCount,
                "Cart count did NOT increase! Old: " + oldCartCount + " | New: " + newCount);
    }




    CartPage cartPage = new CartPage(driver);

    @Given("the cart is empty")
    public void the_cart_is_empty() {
          driver.manage().deleteAllCookies();
          driver.navigate().refresh();
    }

    @When("the user opens the cart")
    public void the_user_opens_the_cart() {
        driver.get("http://localhost/opencart/index.php?route=checkout/cart&language=en-gb") ;
    }

    @Then("a message should appear saying {string}")
    public void a_message_should_appear_saying(String expectedMessage) {
        Assert.assertTrue(
                cartPage.isCartEmptyMessageDisplayed(expectedMessage),
                "Empty cart message NOT displayed or incorrect!"
        );
    }


}

