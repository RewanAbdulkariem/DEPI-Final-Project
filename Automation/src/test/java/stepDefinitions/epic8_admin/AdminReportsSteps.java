package stepDefinitions.epic8_admin;
import io.cucumber.java.en.*;
import org.testng.Assert; 
import pages.AdminPage;

import static hooks.Hooks.driver;
public class AdminReportsSteps {
 AdminPage adminPage;

    @Given("the admin navigates to the Reports page")
    public void the_admin_navigates_to_the_reports_page() {
        adminPage = new AdminPage(driver);
        adminPage.goToReportsPage();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Reports page is NOT displayed!");
    }

    // ---------- Sales Report ----------
    @When("the admin opens the Sales Report")
    public void the_admin_opens_the_sales_report() {
        adminPage.openSalesReport();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Sales report table NOT displayed!");
    }

    @When("filters by date from {string} to {string}")
    public void filters_by_date_from_to(String fromDate, String toDate) {
        adminPage.filterReportsByDate(fromDate, toDate);
    }

    @Then("the results should be updated based on the selected date range")
    public void the_results_should_be_updated_based_on_the_selected_date_range() {
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Filtered report results NOT displayed!");
    }

    // ---------- Products Viewed ----------
    @When("the admin opens the Products Viewed Report")
    public void the_admin_opens_the_products_viewed_report() {
        adminPage.openProductsViewedReport();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Products Viewed report table NOT displayed!");
    }

    // ---------- Products Purchased ----------
    @When("the admin opens the Products Purchased Report")
    public void the_admin_opens_the_products_purchased_report() {
        adminPage.openProductsPurchasedReport();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Products Purchased report table NOT displayed!");
    }

    @When("filters by product name {string}")
    public void filters_by_product_name(String productName) {
        adminPage.filterReportsByProduct(productName);
    }

    @Then("only results related to {string} should be displayed")
    public void only_results_related_to_should_be_displayed(String productName) {
        Assert.assertTrue(adminPage.isProductInReport(productName),
                "Filtered product not found in report: " + productName);
    }

    // ---------- Customer Orders ----------
    @When("the admin opens the Customer Orders Report")
    public void the_admin_opens_the_customer_orders_report() {
        adminPage.openCustomerOrdersReport();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Customer Orders report table NOT displayed!");
    }

    @When("filters by customer name {string}")
    public void filters_by_customer_name(String customerName) {
        adminPage.filterReportsByCustomer(customerName);
    }

    @Then("only orders belonging to {string} should be displayed")
    public void only_orders_belonging_to_should_be_displayed(String customerName) {
        Assert.assertTrue(adminPage.isCustomerInReport(customerName),
                "Filtered customer not found in report: " + customerName);
    }

    // ---------- Customer Reward Points ----------
    @When("the admin opens the Customer Reward Points Report")
    public void the_admin_opens_the_customer_reward_points_report() {
        adminPage.openCustomerRewardPointsReport();
        Assert.assertTrue(adminPage.isReportsTableDisplayed(),
                "Customer Reward Points report table NOT displayed!");
    }

    @Then("only reward points related to {string} should appear")
    public void only_reward_points_related_to_should_appear(String customerName) {
        Assert.assertTrue(adminPage.isCustomerInReport(customerName),
                "Filtered customer reward points not found: " + customerName);
    }
}

