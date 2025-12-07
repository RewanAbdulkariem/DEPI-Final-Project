package pages;

import base.HelpFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends HelpFunctions {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ===== Locators =====
    By accountIcon = By.xpath("//a[i[contains(@class,'fa-user')]]");
    By registerLink = By.cssSelector("a[href*='register']");
    By loginLink = By.cssSelector("a[href*='login']");
    By openCartImg = By.xpath("//img[@title=\"Your Store\"]");

    By addToCartBtn = By.cssSelector(".fa-shopping-cart");
    By cartBtn = By.xpath("//a[@title=\"Shopping Cart\"]");
    By checkoutBtn = By.xpath("//span[contains(text(),'Checkout')]");

    By searchBarTxt = By.xpath("//input[@name=\"search\"]");
    By searchBtn = By.xpath("//button[@class=\"btn btn-light btn-lg\"]");

    By IPOD = By.xpath("//a[text()=\"iPod Classic\"]");

    By searchResultProducts = By.cssSelector("#product-list .product-thumb");
    By searchResultFirstProduct = By.cssSelector("#product-list > div:nth-child(1) > div");

    By popupCloseBtn            = By.cssSelector(".modal .btn-close");
    By overlay = By.cssSelector(".overlay, .loading, .modal-backdrop");

    // ===== Account / Auth =====
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

    // ===== Search & Cart =====
    public void addProductToCart(String productName) {
        closePopupIfPresent();
        waitForOverlayToDisappear();

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
        WebElement addToCart = firstProduct.findElement(addToCartBtn);

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCart).click().perform();
    }

    public void openCart() {
        click(cartBtn);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }


    //Search Section
    public void clickOnOpencartImg(){
        click(openCartImg);
    }
    public void enterProductName(String productname){
        sendText(searchBarTxt, productname);
    }
    public void clickSearchBtn(){
        click(searchBtn);
    }
    public boolean isProductAppeared()
    {

        try
        {
            String msg = getText(IPOD);
            return msg.equalsIgnoreCase("iPod Classic");
        } catch (Exception e)
        {
            return false;
        }
    }

    private void closePopupIfPresent() {
        try {
            WebElement popupClose = driver.findElement(popupCloseBtn);
            if (popupClose.isDisplayed()) {
                popupClose.click();
            }
        } catch (NoSuchElementException ignored) {
        }
    }

    private void waitForOverlayToDisappear() {
        try {
            wait.until(d -> d.findElements(overlay).isEmpty());
        } catch (Exception ignored) {
        }
    }
}
