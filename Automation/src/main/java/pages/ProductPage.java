package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends HelpFunctions {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private By productName = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1");
    private By productPrice = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[1]/h2/span");
    private By productDescription = By.xpath("//*[@id=\"content\"]/ul/li[1]/a");
    private By productStockStatus = By.xpath("//li[contains(text(),'Availability')]");

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
}
