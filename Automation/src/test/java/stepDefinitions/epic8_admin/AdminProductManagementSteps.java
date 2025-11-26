package stepDefinitions.epic8_admin;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AdminPage;

import static hooks.Hooks.driver;
public class AdminProductManagementSteps {

 AdminPage adminPage;
// @Given("the admin is logged in successfully")
// public void the_admin_is_logged_in_successfully() {
//     // Write code here that turns the phrase above into concrete actions
//     throw new io.cucumber.java.PendingException();
// }
// @When("navigates to the Data tab")
// public void navigates_to_the_data_tab() {
//     // Write code here that turns the phrase above into concrete actions
//     throw new io.cucumber.java.PendingException();
// }
// @When("navigates to the SEO tab")
// public void navigates_to_the_seo_tab() {
//     // Write code here that turns the phrase above into concrete actions
//     throw new io.cucumber.java.PendingException();
// }
    @Given("the admin navigates to the Products page")
    public void the_admin_navigates_to_the_products_page() {
        adminPage = new AdminPage(driver);
        adminPage.goToProductsPage();

        Assert.assertTrue(
                adminPage.isProductPresent(""), // تحقق إن الجدول ظاهر
                "Products table is NOT displayed!"
        );
    }

    @When("the admin views the list of products")
    public void the_admin_views_the_list_of_products() {
        Assert.assertTrue(
                adminPage.isProductPresent(""),
                "Products table NOT visible!"
        );
    }

    @Then("the products table should be displayed")
    public void the_products_table_should_be_displayed() {
        Assert.assertTrue(
                adminPage.isProductPresent(""),
                "Products table NOT displayed!"
        );
    }

    // ---------- Search Product ----------
    @When("the admin searches for a product named {string}")
    public void the_admin_searches_for_a_product_named(String productName) {
       
        Assert.assertTrue(adminPage.isProductPresent(productName),
                "Product '" + productName + "' NOT found!");
    }

    @Then("the searched product {string} should appear in the results")
    public void the_searched_product_should_appear_in_the_results(String productName) {
        Assert.assertTrue(adminPage.isProductPresent(productName),
                "Product '" + productName + "' NOT appearing in search results!");
    }

    // ---------- Add Product ----------
    @When("the admin clicks the Add Product button")
    public void the_admin_clicks_the_add_product_button() {
        adminPage.clickAddProduct();
    }

    @And("the admin enters product name {string}")
    public void the_admin_enters_product_name(String productName) {
        adminPage.enterProductName(productName);
    }

    @And("enters meta tag title {string}")
    public void enters_meta_tag_title(String metaTitle) {
        adminPage.enterMetaTagTitle(metaTitle);
    }

    @And("enters model {string}")
    public void enters_model(String model) {
        adminPage.enterModel(model);
    }

    @And("enters SEO keyword {string}")
    public void enters_seo_keyword(String keyword) {
        adminPage.enterSEOKeyword(keyword);
    }

    @And("clicks Save")
    public void clicks_save() {
        adminPage.clickSaveProduct();
    }

    // @Then("a success message should appear saying {string}")
    // public void a_success_message_should_appear_saying(String expectedMsg) {
    //     Assert.assertTrue(adminPage.isSuccessMessageDisplayed(),
    //             "Success message NOT displayed after product operation!");
    // }

    // ---------- Edit Product ----------
    @Given("a product named {string} exists")
    public void a_product_named_exists(String productName) {
        Assert.assertTrue(adminPage.isProductPresent(productName),
                "Product '" + productName + "' does NOT exist!");
    }

    @When("the admin clicks the Edit button for {string}")
    public void the_admin_clicks_the_edit_button_for(String productName) {
        adminPage.clickEditProduct(productName);
    }

    @And("changes the model to {string}")
    public void changes_the_model_to(String model) {
        adminPage.enterModel(model);
    }

    // ---------- Delete Product ----------
    @When("the admin selects the checkbox of {string}")
    public void the_admin_selects_the_checkbox_of(String productName) {
        adminPage.deleteProduct(productName); // الدالة داخل AdminPage بتحدد وتضغط Delete
    }

    @And("clicks the Delete button")
    public void clicks_the_delete_button() {
        // ضمني داخل deleteProduct في AdminPage
    }

    @And("confirms the deletion")
    public void confirms_the_deletion() {
        // ضمني داخل deleteProduct في AdminPage
    }

    // ---------- Enable / Disable Product ----------
    @When("the admin changes the product status to {string} for {string}")
    public void the_admin_changes_the_product_status_to_for(String status, String productName) {
        adminPage.clickEditProduct(productName);
        adminPage.changeProductStatus(status);
        adminPage.clickSaveProduct();
    }

}

