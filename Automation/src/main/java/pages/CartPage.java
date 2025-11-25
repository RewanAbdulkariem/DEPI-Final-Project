package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emptyCartMessage = By.cssSelector("#content p");
    private By cartButton = By.xpath("//*[@id='cart']/div/button");

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isCartEmptyMessageDisplayed(String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
            return msg.getText().trim().equalsIgnoreCase(expectedText);
        } catch (Exception e) {
            return false;
        }
    }
}
