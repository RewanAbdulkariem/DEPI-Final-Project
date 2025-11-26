package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {
  private WebDriver driver;
    private WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===========================
    // Locators - Login & Dashboard
    // ===========================
    private By usernameField = By.id("input-username");
    private By passwordField = By.id("input-password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By alertMessage = By.cssSelector(".alert-danger");
    private By dashboardHeader = By.cssSelector("h1");

    // ===========================
    // Locators - Products
    // ===========================
    private By catalogMenu = By.id("menu-catalog");
    private By productsMenu = By.xpath("//a[text()='Products']");
    private By addProductButton = By.cssSelector("a[data-original-title='Add New']");
    private By saveProductButton = By.cssSelector("button[data-original-title='Save']");
    private By successMessage = By.cssSelector(".alert-success");

    private By productNameField = By.id("input-name");
    private By metaTagField = By.id("input-meta-title");
    private By modelField = By.id("input-model");
    private By seoKeywordField = By.id("input-keyword");
    private By productTableRows = By.cssSelector("table tbody tr");
    private By editButtonRow = By.cssSelector("a[data-original-title='Edit']");
    private By deleteButton = By.cssSelector("button[data-original-title='Delete']");
    private By selectCheckbox = By.cssSelector("input[type='checkbox']");
    private By statusDropdown = By.id("input-status");

    // ===========================
    // Locators - Orders
    // ===========================
    private By salesMenu = By.id("menu-sale");
    private By ordersMenu = By.xpath("//a[text()='Orders']");
    private By ordersTableRows = By.cssSelector("table tbody tr");
    private By orderViewButton = By.cssSelector("a[data-original-title='View']");
    private By orderStatusDropdown = By.id("input-order-status");
    private By saveOrderButton = By.cssSelector("button[data-original-title='Save']");

    // ===========================
    // Locators - Reports
    // ===========================
    private By reportsMenu = By.id("menu-report");
    private By reportTable = By.cssSelector("table tbody");
    private By fromDateField = By.id("input-date-start");
    private By toDateField = By.id("input-date-end");
    private By filterButton = By.id("button-filter");
    private By customerField = By.id("input-customer");
    private By productField = By.id("input-product");

    // ===========================
    // ========== LOGIN ==========
    // ===========================
    public void enterUsername(String username) { driver.findElement(usernameField).sendKeys(username); }
    public void enterPassword(String password) { driver.findElement(passwordField).sendKeys(password); }
    public void clickLoginButton() { driver.findElement(loginButton).click(); }
    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isLoginErrorDisplayed(String expectedMsg) {
        try {
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
            return alert.getText().trim().contains(expectedMsg);
        } catch (Exception e) {
            return false;
        }
    }

    // ===========================
    // ========== PRODUCTS ==========
    // ===========================
    public void goToProductsPage() {
        driver.findElement(catalogMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addProductButton));
    }
    public void clickAddProduct() { driver.findElement(addProductButton).click(); }
    public void enterProductName(String name) { driver.findElement(productNameField).sendKeys(name); }
    public void enterMetaTagTitle(String metaTitle) { driver.findElement(metaTagField).sendKeys(metaTitle); }
    public void enterModel(String model) { driver.findElement(modelField).sendKeys(model); }
    public void enterSEOKeyword(String keyword) { driver.findElement(seoKeywordField).sendKeys(keyword); }
    public void clickSaveProduct() { driver.findElement(saveProductButton).click(); }
    public boolean isProductPresent(String productName) {
        List<WebElement> rows = driver.findElements(productTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) return true;
        }
        return false;
    }
    public void clickEditProduct(String productName) {
        List<WebElement> rows = driver.findElements(productTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                row.findElement(editButtonRow).click();
                break;
            }
        }
    }
    public void deleteProduct(String productName) {
        List<WebElement> rows = driver.findElements(productTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                row.findElement(selectCheckbox).click();
                driver.findElement(deleteButton).click();
                driver.switchTo().alert().accept();
                break;
            }
        }
    }
    public void changeProductStatus(String status) {
        WebElement dropdown = driver.findElement(statusDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + status + "']")).click();
    }

    // ===========================
    // ========== ORDERS ==========
    // ===========================
    public void goToOrdersPage() {
        driver.findElement(salesMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ordersMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderViewButton));
    }
    public boolean isOrdersTableDisplayed() {
        try { return driver.findElements(ordersTableRows).size() > 0; }
        catch (Exception e) { return false; }
    }
    public void searchOrderByID(String orderId) {
        driver.findElement(By.id("input-order-id")).clear();
        driver.findElement(By.id("input-order-id")).sendKeys(orderId);
        driver.findElement(By.id("button-filter")).click();
    }
    public boolean isOrderPresent(String orderId) {
        List<WebElement> rows = driver.findElements(ordersTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(orderId)) return true;
        }
        return false;
    }
    public void openOrderDetails(String orderId) {
        searchOrderByID(orderId);
        driver.findElement(orderViewButton).click();
    }
    public boolean isOrderDetailsPageDisplayed() {
        return driver.findElements(orderStatusDropdown).size() > 0;
    }
    public void selectOrderStatus(String status) {
        WebElement dropdown = driver.findElement(orderStatusDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + status + "']")).click();
    }
    public void clickSaveOrder() { driver.findElement(saveOrderButton).click(); }

    public void searchOrderByCustomer(String customerName) {
        driver.findElement(customerField).clear();
        driver.findElement(customerField).sendKeys(customerName);
        driver.findElement(filterButton).click();
    }
    public boolean isCustomerPresent(String customerName) {
        List<WebElement> rows = driver.findElements(ordersTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(customerName)) return true;
        }
        return false;
    }

    // ===========================
    // ========== REPORTS ==========
    // ===========================
    public void goToReportsPage() {
        driver.findElement(reportsMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public boolean isReportsTableDisplayed() {
        return driver.findElements(reportTable).size() > 0;
    }
    public void openSalesReport() {
        driver.findElement(By.xpath("//a[text()='Sales']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public void openProductsViewedReport() {
        driver.findElement(By.xpath("//a[text()='Products Viewed']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public void openProductsPurchasedReport() {
        driver.findElement(By.xpath("//a[text()='Products Purchased']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public void openCustomerOrdersReport() {
        driver.findElement(By.xpath("//a[text()='Customer Orders']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public void openCustomerRewardPointsReport() {
        driver.findElement(By.xpath("//a[text()='Customer Reward Points']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportTable));
    }
    public void filterReportsByDate(String from, String to) {
        driver.findElement(fromDateField).clear();
        driver.findElement(fromDateField).sendKeys(from);
        driver.findElement(toDateField).clear();
        driver.findElement(toDateField).sendKeys(to);
        driver.findElement(filterButton).click();
    }
    public void filterReportsByCustomer(String customer) {
        driver.findElement(customerField).clear();
        driver.findElement(customerField).sendKeys(customer);
        driver.findElement(filterButton).click();
    }
    public void filterReportsByProduct(String product) {
        driver.findElement(productField).clear();
        driver.findElement(productField).sendKeys(product);
        driver.findElement(filterButton).click();
    }
    public boolean isProductInReport(String product) {
        List<WebElement> rows = driver.findElements(reportTable);
        for (WebElement row : rows) {
            if (row.getText().contains(product)) return true;
        }
        return false;
    }
    public boolean isCustomerInReport(String customer) {
        List<WebElement> rows = driver.findElements(reportTable);
        for (WebElement row : rows) {
            if (row.getText().contains(customer)) return true;
        }
        return false;
    }

    // ===========================
    // ========== SUCCESS MESSAGE ==========
    // ===========================
    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
