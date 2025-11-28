package stepDefinitions.epic8_admin;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AdminPage;

import static hooks.Hooks.driver;

public class AdminProductManagementSteps {

    private AdminPage adminPage;

    public AdminProductManagementSteps() {
        this.adminPage = new AdminPage(driver);
    }

    // ===========================
    // NAVIGATE TO PRODUCTS PAGE
    // ===========================
    @Given("the admin navigates to the Products page")
    public void the_admin_navigates_to_the_products_page() {
        adminPage.goToProductsPage();

        Assert.assertTrue(
                adminPage.isProductsTableDisplayed(),
                "Products table is NOT displayed!"
        );
    }

    // ===========================
    // VIEW PRODUCTS
    // ===========================
    @When("the admin views the list of products")
    public void the_admin_views_the_list_of_products() {
        Assert.assertTrue(
                adminPage.isProductsTableDisplayed(),
                "Products table NOT visible!"
        );
    }

    @Then("the products table should be displayed")
    public void the_products_table_should_be_displayed() {
        Assert.assertTrue(
                adminPage.isProductsTableDisplayed(),
                "Products table NOT displayed!"
        );
    }

    // ===========================
    // SEARCH PRODUCT
    // ===========================
    @When("the admin searches for a product named {string}")
    public void the_admin_searches_for_a_product_named(String productName) {
        adminPage.filterProductByName(productName);
    }

    @Then("the searched product {string} should appear in the results")
    public void the_searched_product_should_appear_in_the_results(String productName) {
        Assert.assertTrue(
                adminPage.isProductPresent(productName),
                "Product '" + productName + "' NOT appearing in search results!"
        );
    }

    // ===========================
    // ADD PRODUCT
    // ===========================
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

    @And("navigates to the Data tab")
    public void navigates_to_the_data_tab() {
        adminPage.goToDataTab();
    }

    @And("enters model {string}")
    public void enters_model(String model) {
        adminPage.enterModel(model);
    }

    @And("navigates to the SEO tab")
    public void navigates_to_the_seo_tab() {
        adminPage.goToSeoTab();
    }

    @And("enters SEO keyword {string}")
    public void enters_seo_keyword(String keyword) {
        adminPage.enterSEOKeyword(keyword);
    }

    @And("clicks Save")
    public void clicks_save() {
        adminPage.clickSaveProduct();
    }
    // ===========================
    // EDIT PRODUCT
    // ===========================
    @Given("a product named {string} exists")
    public void a_product_named_exists(String productName) {
        adminPage.goToProductsPage();
        adminPage.filterProductByName(productName);

        Assert.assertTrue(
                adminPage.isProductPresent(productName),
                "Product '" + productName + "' does NOT exist!"
        );
    }

    @When("the admin clicks the Edit button for {string}")
    public void the_admin_clicks_the_edit_button_for(String productName) {
        adminPage.clickEditProduct(productName);
    }

    @And("changes the model to {string}")
    public void changes_the_model_to(String model) {
        adminPage.enterModel(model);
    }

    // ===========================
    // DELETE PRODUCT
    // ===========================
    @When("the admin selects the checkbox of {string}")
    public void the_admin_selects_the_checkbox_of(String productName) {
        adminPage.deleteProduct(productName); // الدالة جوه الـ Page بتعمل select + delete + confirm
    }

    @And("clicks the Delete button")
    public void clicks_the_delete_button() {
        // ضمني في deleteProduct
    }

    @And("confirms the deletion")
    public void confirms_the_deletion() {
        // ضمني في deleteProduct
    }

    // ===========================
    // ENABLE / DISABLE PRODUCT
    // ===========================
    @When("the admin changes the product status to {string} for {string}")
    public void the_admin_changes_the_product_status_to_for(String status, String productName) {
        adminPage.goToProductsPage();
        adminPage.filterProductByName(productName);
        adminPage.clickEditProduct(productName);
        adminPage.changeProductStatus(status);
        adminPage.clickSaveProduct();
    }

    @And("changes the product status to {string}")
    public void changesTheProductStatusTo(String status) {
        adminPage.changeProductStatus(status);
    }
}
