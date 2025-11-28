package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends HelpFunctions {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    // ===========================
    // ===== LOGIN & DASHBOARD ===
    // ===========================
    private By usernameField   = By.id("input-username");
    private By passwordField   = By.id("input-password");
    private By loginButton     = By.cssSelector("button[type='submit']");
    private By alertMessage    = By.cssSelector(".alert-danger");
    private By dashboardHeader = By.cssSelector("h1");

    public void enterUsername(String username) {
        sendText(usernameField, username);
    }

    public void enterPassword(String password) {
        sendText(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isDashboardDisplayed() {
        try {
            waitForElement(dashboardHeader);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorDisplayed(String expectedMsg) {
        try {
            WebElement alert = waitForElement(alertMessage);
            return alert.getText().trim().contains(expectedMsg);
        } catch (Exception e) {
            return false;
        }
    }

    // ===========================
    // ======== PRODUCTS =========
    // ===========================

    // Menus
    private By catalogMenu      = By.id("menu-catalog");
    private By productsMenu     = By.xpath("//a[text()='Products']");

    // Table
    private By productTableRows = By.cssSelector("form#form-product table.table-bordered.table-hover tbody tr");

    // Buttons
    private By addProductButton  = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
    private By saveProductButton = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");
    private By deleteButton      = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button[3]");

    // Success message
    private By successMessage    = By.cssSelector(".alert-success");

    // Form fields
    private By productNameField  = By.id("input-name-1");
    private By metaTagField      = By.id("input-meta-title-1");
    private By modelField        = By.id("input-model");
    private By seoKeywordField   = By.id("input-keyword-0-1");
    private By statusCheckbox     = By.id("input-status");

    // Tabs
    private By dataTab           = By.cssSelector("a[href='#tab-data']");
    private By seoTab            = By.cssSelector("a[href='#tab-seo']");

    // Row controls
    private By editButtonRow     = By.cssSelector("a[aria-label='Edit'], a[title='Edit'], a[data-bs-original-title='Edit']");
    private By selectCheckbox    = By.cssSelector("input[type='checkbox']");

    // Filters
    private By filterNameField   = By.id("input-name");
    private By filterButton      = By.id("button-filter");

    // ---------- Navigation ----------
    public void goToProductsPage() {
        click(catalogMenu);
        click(productsMenu);

    }

    public boolean isProductsTableDisplayed() {
        return driver.findElements(productTableRows).size() > 0;
    }

    // ---------- Add / Edit Form ----------
    public void clickAddProduct() {
        click(addProductButton);
    }

    public void enterProductName(String name) {
        sendText(productNameField, name);
    }

    public void enterMetaTagTitle(String metaTitle) {
        sendText(metaTagField, metaTitle);
    }

    public void enterModel(String model) {
        click(dataTab);
        sendText(modelField, model);
    }

    public void enterSEOKeyword(String keyword) {
        sendText(seoKeywordField, keyword);
    }

    public void clickSaveProduct() {
        click(saveProductButton);
    }

    public void goToDataTab() {
        click(dataTab);
    }

    public void goToSeoTab() {
        click(seoTab);
    }

    // ---------- Filter / Search ----------
    public void filterProductByName(String name) {
        sendText(filterNameField, name);
        click(filterButton);
        waitForElement(productTableRows);
    }

    public boolean isProductPresent(String productName) {
        try {
            By cellLocator = By.xpath("//form[@id='form-product']//table//tbody//tr//td[contains(normalize-space(.), '"
                    + productName + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(cellLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void clickEditProduct(String productName) {
        waitForElement(productTableRows);
        List<WebElement> rows = driver.findElements(productTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                row.findElement(editButtonRow).click();
                break;
            }
        }
    }

    public void deleteProduct(String productName) {
        waitForElement(productTableRows);
        List<WebElement> rows = driver.findElements(productTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                row.findElement(selectCheckbox).click();
                click(deleteButton);
                driver.switchTo().alert().accept();
                break;
            }
        }
    }

    public void changeProductStatus(String status) {
        goToDataTab();

        WebElement checkbox = waitForElement(statusCheckbox);

        boolean isChecked = checkbox.isSelected();
        boolean shouldBeEnabled = status.equalsIgnoreCase("Enabled");

        if (shouldBeEnabled != isChecked) {
            click(statusCheckbox);
        }
    }

    // ---------- Success message ----------
    public boolean isSuccessMessageDisplayed() {
        try {
            waitForElement(successMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessageText() {
        return waitForElement(successMessage).getText();
    }

    // ===========================
    // ========== ORDERS =========
    // ===========================

    private By salesMenu          = By.id("menu-sale");
    private By ordersMenu         = By.xpath("//a[text()='Orders']");
    private By ordersTableRows    = By.cssSelector("form#form-order table.table-bordered.table-hover tbody tr");
    private By viewButtonInRow    = By.cssSelector("td.text-end a.btn.btn-primary[aria-label='View']");

    private By orderStatusDropdown = By.id("input-order-status");
    private By saveOrderButton     = By.cssSelector("button[data-bs-original-title='Save']");

    private By orderIdField        = By.id("input-order-id");
    private By orderFilterButton   = By.id("button-filter");
    private By customerField       = By.id("input-customer");

    public void goToOrdersPage() {
        click(salesMenu);
        click(ordersMenu);
        // ممكن تنتظر الجدول
        // waitForElement(ordersTableRows);
    }

    public boolean isOrdersTableDisplayed() {
        try {
            return driver.findElements(ordersTableRows).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void searchOrderByID(String orderId) {
        sendText(orderIdField, orderId);
        click(orderFilterButton);
        waitForElement(ordersTableRows);
    }

    public boolean isOrderPresent(String orderId) {
        waitForElement(ordersTableRows);
        List<WebElement> rows = driver.findElements(ordersTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(orderId)) {
                return true;
            }
        }
        return false;
    }

    public void openOrderDetails(String orderId) {
        searchOrderByID(orderId);
        List<WebElement> rows = driver.findElements(ordersTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(orderId)) {
                WebElement viewBtn = row.findElement(viewButtonInRow);
                viewBtn.click();
                break;
            }
        }
    }

    public boolean isOrderDetailsPageDisplayed() {
        return driver.findElements(orderStatusDropdown).size() > 0;
    }

    public void selectOrderStatus(String status) {
        selectFromDropDownMenu(orderStatusDropdown, status);
    }

    public void clickSaveOrder() {
        click(saveOrderButton);
    }

    public void searchOrderByCustomer(String customerName) {
        sendText(customerField, customerName);
        click(orderFilterButton);
        waitForElement(ordersTableRows);
    }

    public boolean isCustomerPresent(String customerName) {
        waitForElement(ordersTableRows);
        List<WebElement> rows = driver.findElements(ordersTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(customerName)) {
                return true;
            }
        }
        return false;
    }

    // ===========================
    // ========== REPORTS =========
    // ===========================
    private By reportsMenu       = By.id("menu-report");
    private By reportTable       = By.cssSelector("form#form-report table.table-bordered.table-hover tbody");
    private By reportTableRows   = By.cssSelector("form#form-report table.table-bordered.table-hover tbody tr");
    private By fromDateField     = By.id("input-date-start");
    private By toDateField       = By.id("input-date-end");
    private By reportsFilterBtn  = By.id("button-filter");
    private By reportCustomerField = By.id("input-customer");
    private By productField      = By.id("input-product");

    public void goToReportsPage() {
        click(reportsMenu);
        waitForElement(reportTable);
    }

    public boolean isReportsTableDisplayed() {
        return driver.findElements(reportTable).size() > 0;
    }

    public void openSalesReport() {
        click(By.xpath("//a[text()='Sales']"));
        waitForElement(reportTable);
    }

    public void openProductsViewedReport() {
        click(By.xpath("//a[text()='Products Viewed']"));
        waitForElement(reportTable);
    }

    public void openProductsPurchasedReport() {
        click(By.xpath("//a[text()='Products Purchased']"));
        waitForElement(reportTable);
    }

    public void openCustomerOrdersReport() {
        click(By.xpath("//a[text()='Customer Orders']"));
        waitForElement(reportTable);
    }

    public void openCustomerRewardPointsReport() {
        click(By.xpath("//a[text()='Customer Reward Points']"));
        waitForElement(reportTable);
    }

    public void filterReportsByDate(String from, String to) {
        sendText(fromDateField, from);
        sendText(toDateField, to);
        click(reportsFilterBtn);
    }

    public void filterReportsByCustomer(String customer) {
        sendText(reportCustomerField, customer);
        click(reportsFilterBtn);
    }

    public void filterReportsByProduct(String product) {
        sendText(productField, product);
        click(reportsFilterBtn);
    }

    public boolean isProductInReport(String product) {
        waitForElement(reportTableRows);
        List<WebElement> rows = driver.findElements(reportTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCustomerInReport(String customer) {
        waitForElement(reportTableRows);
        List<WebElement> rows = driver.findElements(reportTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(customer)) {
                return true;
            }
        }
        return false;
    }
}
