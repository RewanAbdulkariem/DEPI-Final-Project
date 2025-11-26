package pages;

import base.HelpFunctions;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends HelpFunctions {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    By checkoutPageTitle = By.xpath("//h1[text()='Checkout']");
    By firstName = By.id("input-shipping-firstname");
    By lastName = By.id("input-shipping-lastname");
    By address = By.id("input-shipping-address-1");
    By city = By.id("input-shipping-city");
    By country = By.id("input-shipping-country");
    By region = By.id("input-shipping-zone");
    By postalCode = By.id("input-shipping-postcode");
    By savedClientRadioBtn = By.id("input-shipping-existing");
    By newClientRadioBtn = By.id("input-shipping-new");
    By selectClientAddress = By.id("input-shipping-address");

    By shippingAddressContinue = By.id("button-shipping-address");

    By shippingMethodSelect = By.xpath("//button[@id='button-shipping-methods']");
    By flatRateRadBtn = By.xpath("//label[@for=\"input-shipping-method-flat-flat\"]");
    By shippingMethodContinueBtn = By.xpath("//button[@id='button-shipping-method']");

    By paymentMethodSelect = By.xpath("//button[@id='button-payment-methods']");
    By cashOnDeliveryRadioBtn = By.xpath("//label[@for='input-payment-method-cod-cod']");
    By paymentMethodContinueBtn = By.xpath("//button[@id='button-payment-method']");

    By confirmOrder = By.xpath("//*[@id=\"button-confirm\"]");
    By buttonDiv = By.cssSelector("div.text-end");

    public void fillShippingAddressDetails(
            String firstNameValue,
            String lastNameValue,
            String clientAddress,
            String clientCity,
            String clientCountry,
            String clientRegion) {

        click(newClientRadioBtn);

        sendText(firstName, firstNameValue);
        sendText(lastName, lastNameValue);
        sendText(address, clientAddress);
        sendText(city, clientCity);

        selectFromDropDownMenu(country, clientCountry, 0);
        selectFromDropDownMenu(region, clientRegion, 0);
    }

    public void clickShippingAdressContinueBtn() {
        WebElement continueBtn = waitToBeClickable(shippingAddressContinue);
        waitToBeClickable(savedClientRadioBtn).click();
    }
    public void ensureShippingAddressData() {
        WebElement savedAddress = waitForElement(By.id("shipping-existing"));
        String savedShippingAddress = savedAddress.getAttribute("style");

        if (savedShippingAddress != null && savedShippingAddress.contains("display: block")) {
            selectFromDropDownMenu(selectClientAddress, null, 1);
        } else {
            // إذا العنصر مخفي، املأ تفاصيل العنوان
            fillShippingAddressDetails("Muhammed", "Henna", "5 Henna st.", "Manzalah", "Egypt", "Aswan");
        }
    }

    public boolean isRegisteredUserSelected() {
        WebElement savedClientRadiBtn = waitToBeClickable(savedClientRadioBtn);

        try {
            return savedClientRadiBtn.isSelected();
        } catch (StaleElementReferenceException e) {
            // في حالة تغير DOM سريعًا
            savedClientRadiBtn = waitToBeClickable(savedClientRadioBtn);
            return savedClientRadiBtn.isSelected();
        }
    }


    public void chooseShippingMethod() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("alert")));
        waitToBeClickable(shippingMethodSelect).click();
        waitToBeClickable(flatRateRadBtn).click();
        waitToBeClickable(shippingMethodContinueBtn).click();

    }

    public void choosePaymentMethod() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("alert")));
        waitToBeClickable(paymentMethodSelect).click();
        waitToBeClickable(cashOnDeliveryRadioBtn).click();
        waitToBeClickable(paymentMethodContinueBtn).click();

    }




    public boolean isPaymentDisplayed() {
        return driver.getPageSource().contains("Cash On Delivery");
    }

    public void clickConfirmOrder() {
        WebElement button = waitForElement(confirmOrder);

        Actions actions = new Actions(driver);
        actions.moveToElement(waitToBeClickable(confirmOrder)).click().perform();
    }

    public void reviewOrderItems() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("alert")));
        waitForElement(confirmOrder);
    }


    public void clickContinueBtn(){
        waitToBeClickable(By.xpath("//a[text()='Continue']")).click();
    }
    public String getCheckoutPageTitle(){
        return waitForElement(checkoutPageTitle).getText();
    }
}
