package stepDefinitions.epic5_checkout;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.*;

public class CheckoutSteps {
    private static final Logger log = LoggerFactory.getLogger(CheckoutSteps.class);
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private AccountPage accountPage;
    private AddressBookPage addressBookPage;
    private NewAddressPage newAddressPage;

    // ---------------------------------------------------------
    // TC016 – Proceed to Checkout
    // ---------------------------------------------------------
    @Before
    public void setPages(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage  = new CartPage(driver);
    }

    @Given("the user is logged in")
    public void user_is_logged_in() {
        Assert.assertEquals(loginPage.getLoginPageTitle(), "My Account");

    }

    @Given("the user has items in the shopping cart")
    public void user_has_items_in_cart() {
        loginPage.addProductToCart("MacBook");
        loginPage.addProductToCart("iPhone");
    }

    @When("the user goes to the cart page")
    public void go_to_cart_page() {
        loginPage.openCart();
    }
    @When("the user clicks on the Checkout button")
    public void click_checkout_button() {
        loginPage.getCheckout();
    }


    @Then("the user should be redirected to the checkout page")
    public void redirected_to_checkout() {
        checkoutPage.waitForUrlContains("checkout");
    }

    @Then("the URL should contain checkout")
    public void url_should_contain() {
        assert driver.getCurrentUrl().contains("checkout");
    }

    // ---------------------------------------------------------
    // TC017 – Enter Shipping Details
    // ---------------------------------------------------------

    @Given("the user is on the checkout page")
    public void on_checkout_page() {
        loginPage.getCheckout().click();
    }

    @When("the user fills in valid shipping and billing information")
    public void fill_shipping_info(io.cucumber.datatable.DataTable data) {
        checkoutPage = new CheckoutPage(driver);

        var map = data.asMap(String.class, String.class);

        // split name into first/last name
        String fullName = map.get("Name");
        String firstName = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];

        checkoutPage.fillShippingAddressDetails(
                firstName,
                lastName,
                map.get("Address"),
                map.get("City"),
                map.get("Country"),
                map.get("Region")
        );
    }


    @When("the user clicks on the Continue button of Shipping Address section")
    public void click_continue_shipping() {

        checkoutPage.clickShippingAdressContinueBtn();
    }

    @Then("the shipping address section is collapsed")
    public void moved_to_payment_page() {

        Assert.assertTrue(checkoutPage.isRegisteredUserSelected());
    }

    // ---------------------------------------------------------
    // TC018 – Select Payment Method
    // ---------------------------------------------------------

    @Given("the user has completed the shipping details section")
    public void shipping_details_completed() {
        checkoutPage.ensureShippingAddressData();
    }

    @When("the user selects Shipping Method")
    public void selectShippingMethod(){
        checkoutPage.chooseShippingMethod();
    }
    @And("the user selects Cash On Delivery as the payment method")
    public void select_payment_method() {
        checkoutPage.choosePaymentMethod();


    }
    @And("the user clicks on the Confirm Order button")
    public void clickConfirmOrderBtn(){
        checkoutPage.clickConfirmOrder();
    }
    @Then("the user should be redirected to the order confirmation page")
    public void redirected_to_confirm_order() {
        checkoutPage.waitForElement(By.id("button-confirm"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
    }

    @And("the selected payment method should appear in the summary")
    public void verify_payment_in_summary() {
        assert checkoutPage.isPaymentDisplayed();
    }

    // ---------------------------------------------------------
    // TC019 – Review Order Before Confirmation
    // ---------------------------------------------------------

    @Given("the user is on the confirm order page")
    public void user_on_confirm_order_page() {
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");
    }
    @And("the user reviews the order items, quantities, and total")
    public void review_order() {
        checkoutPage.reviewOrderItems();
    }

    @And("the user clicks on the Continue button")
    public void clickContinueBtn(){
        checkoutPage.clickContinueBtn();
    }
    @Then("the homepage will open")
    public void homepageOpened() {
        // الانتظار حتى ظهور رسالة التأكيد
        checkoutPage.waitForUrlContains("http://localhost/opencart/index.php?route=common/home&language=en-gb");
        // الانتظار حتى تظهر الصفحة الرئيسية (اختياري، حسب احتياجك)
        //wait.until(ExpectedConditions.urlToBe("http://localhost/opencart/index.php?route=common/home&language=en-gb")); // أو أي نص من title للصفحة الرئيسية
    }

    // ---------------------------------------------------------
    // TC020 – Verify Confirmation Message
    // ---------------------------------------------------------
    @Given("the order is placed successfully")
    public void order_placed_successfully() {
        // يمكن إعادة استخدام Steps سابقة لتأكيد الطلب
        checkoutPage.reviewOrderItems();
        checkoutPage.clickConfirmOrder();
    }

    @When("the confirmation page loads")
    public void confirmation_page_loads() {
        checkoutPage.waitForElement(By.xpath("//h1[contains(text(),'Your order has been placed')]"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Your order has been placed')]")));
    }

    @Then("the message {string} should be displayed")
    public void verify_confirmation_message(String message) {
        WebElement msg = checkoutPage.waitForElement(By.xpath("//h1"));
        assert msg.getText().equals(message);
    }
}

