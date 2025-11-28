package stepDefinitions.epic8_admin;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AdminPage;

import static hooks.Hooks.driver;
import static config.TestConfig.get;

public class AdminOrdersSteps {
AdminPage adminPage;

public AdminOrdersSteps(){
    adminPage = new AdminPage(driver);
}

@Given("the admin is logged in successfully")
public void the_admin_is_logged_in_successfully() {
    adminPage.enterUsername(get("admin.username"));
    adminPage.enterPassword(get("admin.password"));

    adminPage.clickLoginButton();

    Assert.assertTrue(
            adminPage.isDashboardDisplayed(),
            "Admin login failed — Dashboard not displayed!"
    );
}

    @Given("the admin navigates to the Orders page")
    public void the_admin_navigates_to_the_orders_page() {
        adminPage.goToOrdersPage();

        Assert.assertTrue(
                adminPage.isOrdersTableDisplayed(),
                "Orders table is NOT displayed!"
        );
    }

    @When("the admin views the orders list")
    public void the_admin_views_the_orders_list() {
        Assert.assertTrue(
                adminPage.isOrdersTableDisplayed(),
                "Orders list is NOT visible!"
        );
    }

    @Then("the orders table should be displayed")
    public void the_orders_table_should_be_displayed() {
        Assert.assertTrue(
                adminPage.isOrdersTableDisplayed(),
                "Orders table NOT shown!"
        );
    }

    // ========== Search Order by ID ==========
    @When("the admin searches for order with ID {string}")
    public void the_admin_searches_for_order_with_id(String orderId) {
        adminPage.searchOrderByID(orderId);
    }

    @Then("the searched order with ID {string} should appear in the results")
    public void the_searched_order_should_appear_in_the_results(String orderId) {
        Assert.assertTrue(
                adminPage.isOrderPresent(orderId),
                "Order ID " + orderId + " NOT found!"
        );
    }

    // ========== Change Order Status ==========
    @Given("an order with ID {string} exists")
    public void an_order_with_id_exists(String orderId) {
        adminPage.goToOrdersPage();
        adminPage.searchOrderByID(orderId);

        Assert.assertTrue(
                adminPage.isOrderPresent(orderId),
                "Order ID " + orderId + " does NOT exist!"
        );
    }

    @When("the admin opens the order details for {string}")
    public void the_admin_opens_the_order_details_for(String orderId) {
        adminPage.openOrderDetails(orderId);

        Assert.assertTrue(
                adminPage.isOrderDetailsPageDisplayed(),
                "Order details page NOT displayed!"
        );
    }

    @When("the admin changes the order status to {string}")
    public void the_admin_changes_the_order_status_to(String status) {
        adminPage.selectOrderStatus(status);
    }

    @When("clicks the Save button")
    public void clicks_the_save_button() {
        adminPage.clickAddHistiry();
    }

    @Then("a success message should appear saying {string}")
    public void a_success_message_should_appear_saying(String expectedMsg) {
        Assert.assertTrue(
                adminPage.isSuccessMessageDisplayed(),
                "Success message NOT displayed!"
        );
    }

    // ========== Filter by Customer Name ==========
    @When("the admin filters orders using customer name {string}")
    public void the_admin_filters_orders_using_customer_name(String customerName) {
        adminPage.searchOrderByCustomer(customerName);
    }

    @Then("orders belonging to {string} should be displayed")
    public void orders_belonging_to_should_be_displayed(String customerName) {
        Assert.assertTrue(
                adminPage.isCustomerPresent(customerName),
                "No orders for customer: " + customerName
        );
    }

    // ========== View Details ==========
    @Then("the order information page should be displayed")
    public void the_order_information_page_should_be_displayed() {
        Assert.assertTrue(
                adminPage.isOrderDetailsPageDisplayed(),
                "Order Information NOT displayed!"
        );
    }
}

