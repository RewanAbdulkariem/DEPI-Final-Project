package pages;

import base.HelpFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends HelpFunctions {
    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    By accountIcon = By.xpath("//a[i[contains(@class,'fa-user')]]");
    By registerLink = By.cssSelector("a[href*='register']");
    By loginLink = By.cssSelector("a[href*='login']");

    By cartBtn = By.xpath("//a[@title=\"Shopping Cart\"]");
    By checkoutBtn = By.xpath("//span[contains(text(),'Checkout')]");
    By searchBarTxt = By.xpath("//input[@name=\"search\"]");
    By searchResultProducts = By.cssSelector("#product-list .product-thumb");
    By searchResultFirstProduct = By.cssSelector("#product-list > div:nth-child(1) > div");
    By overlay = By.cssSelector(".overlay, .loading, .modal-backdrop");

    public void clickAccountIcon(){
        click(accountIcon);
    }

    public LoginPage clickLogin(){
        click(loginLink);
        return new LoginPage(driver);


    }

    public RegisterPage clickRegister(){
        click(registerLink);
        return new RegisterPage(driver);
    }

    public void addProductToCart(String productName) {
        // أغلق أي popup
        try {
            WebElement popupClose = driver.findElement(By.cssSelector(".modal .btn-close"));
            if (popupClose.isDisplayed()) popupClose.click();
        } catch (Exception ignored) {}

        // انتظر اختفاء أي overlay
        try {
            waitForElement(overlay);
        } catch (Exception ignored) {}

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
        //WebElement cartBtnEl = waitForElement(cartBtn);

        Actions actions = new Actions(driver);
        actions.moveToElement(waitToBeClickable(cartBtn)).click().perform();
    }
    public WebElement getCheckout() {
        WebElement btn = waitToBeClickable(checkoutBtn);


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);


        return btn;
    }



    // ---- OPEN ORDER HISTORY ----
    public void openOrderHistory() {
        waitToBeClickable(accountIcon).click();
        driver.findElement(By.linkText("Order History")).click();
    }
}
