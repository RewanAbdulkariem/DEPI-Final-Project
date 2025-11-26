package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends HelpFunctions
{

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private By productName = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1");
    private By productPrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");
    private By productDescription = By.xpath("//*[@id=\"content\"]/ul/li[1]/a");
    private By productStockStatus = By.xpath("//li[contains(text(),'Availability')]");
    private By addToCartButton = By.xpath("//button[@id=\"button-cart\"]");
    private By successAlert = By.cssSelector(".alert-success");
    private By cartTotal = By.xpath("//*[@id='cart']");
    private By stockStatus = By.xpath("//li[contains(text(), 'Availability')]");

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public boolean isProductNameDisplayed() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isProductDescriptionDisplayed() {
        return driver.findElement(productDescription).isDisplayed();
    }
    public boolean isStockStatusDisplayed() {
        return driver.findElement(productStockStatus).isDisplayed();
    }
    public boolean isProductInStock() {
        String stockText = driver.findElement(stockStatus).getText();
        return stockText.toLowerCase().contains("in stock");
    }
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
            return alert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public int getCartCount() {
        String text = driver.findElement(cartTotal).getText();
        String count = text.split(" ")[0];
        return Integer.parseInt(count);
    }


}
