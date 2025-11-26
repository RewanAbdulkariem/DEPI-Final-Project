package stepDefinitions.epic6_orders;

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

import java.util.List;

public class OrderManagementSteps {
    private static final Logger log = LoggerFactory.getLogger(OrderManagementSteps.class);
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private AccountPage accountPage;
    private AddressBookPage addressBookPage;
    private AddressPage addressPage;
    @Before
    public void setPages(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage  = new CartPage(driver);
    }


    @When("the user clicks on Order History in the My Account menu")
    public void clickOrderHistory(){
        loginPage.clickOrderHistory();
    }
    @Then("the system should display a list of previous orders")
    public void ensureOrdersAreDisplayed(){
        Assert.assertEquals(loginPage.getOrdersTableTitle(), "Orders");
    }
    @And("each order should show Order ID, Status, and Date Added")
    public void checkTableContent(){
        // افترض أن جدول الطلبات لديه id="orders"
        WebElement ordersTable = loginPage.getOrdersTable();

        // احصل على كل الصفوف (tr) ما عدا العنوان
        List<WebElement> rows = ordersTable.findElements(By.xpath(".//tbody/tr"));

        for (WebElement row : rows) {
            String orderId = row.findElement(By.xpath(".//td[1]")).getText();
            String status = row.findElement(By.xpath(".//td[3]")).getText();
            String dateAdded = row.findElement(By.xpath(".//td[5]")).getText();


            // تحقق أنها ليست فارغة
            Assert.assertNotEquals(orderId.isEmpty(), "Order ID should not be empty");
            Assert.assertNotEquals(status.isEmpty(), "Status should not be empty");
            Assert.assertNotEquals(dateAdded.isEmpty(), "Date Added should not be empty");
        }
    }

    @Given("the user is on the Order History page")
    public void userIsOnPage() {
        loginPage.clickOrderHistory();
        Assert.assertEquals(loginPage.getOrdersTableTitle(), "Orders");
    }
    @When("the user checks a specific order")
    public void userChecksSpecificOrder() {
        loginPage.clickFirstOrderInHistoryTable();
    }
    @Then("the order details page should show the current order status")
    public void verifyOrderStatus(io.cucumber.datatable.DataTable dataTable) {
        // اجلب كل القيم المتوقعة من الـ DataTable
        List<String> expectedStatuses = dataTable.asList(String.class);

        String actualStatus = loginPage.getOrderStatus();

        // تحقق أن الحالة الحالية ضمن القيم المتوقعة
        Assert.assertTrue(expectedStatuses.contains(actualStatus),
                "Order status should be one of " + expectedStatuses);
    }

}

