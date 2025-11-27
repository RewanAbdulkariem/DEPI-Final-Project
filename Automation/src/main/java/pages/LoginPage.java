package pages;

import base.HelpFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends HelpFunctions {
    private By forgottenlink =By.linkText("Forgotten Password");
    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    By myAccountTitle = By.xpath("//*[@id=\"content\"]/h1");
    By orderHistory = By.xpath("//a[text()='View your order history']");
    By cartBtn = By.xpath("//a[@title=\"Shopping Cart\"]");
    By checkoutBtn = By.xpath("//span[contains(text(),'Checkout')]");
    By ordersTableTitle = By.xpath("//h1[text()='Orders']");
    By overlay = By.cssSelector(".overlay, .loading, .modal-backdrop");
    By searchBarTxt = By.xpath("//input[@name=\"search\"]");
    By searchResultProducts = By.cssSelector("#product-list .product-thumb");
    By searchResultFirstProduct = By.cssSelector("#product-list > div:nth-child(1) > div");
    By table = By.xpath("//table[.//th[contains(text(),'Order ID')]]");
    By firstBillInHistoryPage = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/a/i");
    By orderStatus = By.xpath("//*[@id=\"history\"]/div[1]/table/tbody/tr/td[3]");
    By Errormsg = By.xpath("//div[contains(@class,\"alert alert-danger alert-dismissible\")]");
    public LoginPage(WebDriver driver){

        super(driver);
        this.driver = driver;
    }

    public void enterEmail(String email){
        sendText(emailField, email);
    }

    public void enterPassword(String password){
        sendText(passwordField, password);
    }

    public AccountPage clickLogin(){
        click(loginBtn);
        waitForUrlContains("route=account/account");
        return new AccountPage(driver);
    }
    public void addProductToCart(String productName) {
        // البحث
        WebElement search = waitToBeClickable(searchBarTxt);
        sendText(searchBarTxt, productName);
        search.sendKeys(Keys.ENTER);

        // انتظر ظهور المنتجات
        waitForElement(searchResultProducts);

        // اضغط على أول منتج
        clickFirstProduct();
    }
    public void clickFirstProduct() {
        // انتظر ظهور أول منتج
        WebElement firstProduct = waitForElement(searchResultFirstProduct);

        // ابحث عن زر "Add to Cart"
        By addToCartBtn = By.cssSelector(".fa-shopping-cart");

        // تمرير الزر إلى منتصف الشاشة باستخدام Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(waitToBeClickable(addToCartBtn)).click().perform();
    }
    public void openCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitToBeClickable(cartBtn)).click().perform();
    }
    public WebElement getCheckout() {
        WebElement btn = waitToBeClickable(checkoutBtn);
        return btn;
    }
    public String getLoginPageTitle(){
        return waitForElement(myAccountTitle).getText();

    }
    public void clickOrderHistory(){waitToBeClickable(orderHistory).click();}
    public String getOrdersTableTitle()
    {
        return waitForElement(ordersTableTitle).getText();
    }
    public WebElement getOrdersTable(){
        return waitForElement(table);
    }
    public void clickFirstOrderInHistoryTable(){
        waitToBeClickable(firstBillInHistoryPage).click();
    }
    public String getOrderStatus(){
        return waitForElement(orderStatus).getText();
    }
    public String getErrorMsg(){
        return getText(Errormsg);
    }

    public ForgotPasswordPage ClicknforgottenpassLink ()
    {
        driver.findElement(forgottenlink).click();
        return new ForgotPasswordPage(driver);
    }
}
