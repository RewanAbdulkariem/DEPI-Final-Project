package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends HelpFunctions {
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By address1 = By.id("input-address-1");
    private By city = By.id("input-city");
    private By postcode = By.id("input-postcode");
    private By country = By.id("input-country");
    private By region = By.id("input-zone");

    private By defaultYes = By.cssSelector("input[name='default'][value='1']");
    private By defaultNo = By.cssSelector("input[name='default'][value='0']");

    private By continueBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    private By backBtn = By.linkText("Back");

    public void enterFirstName(String text){
        sendText(firstName, text);
    }

    public void enterLastName(String text){
        sendText(lastName, text);
    }

    public void enterAddress1(String text){
        sendText(address1, text);
    }

    public void enterCity(String text){
        sendText(city, text);
    }

    public void enterPostcode(String text){
        sendText(postcode, text);
    }
    public void selectCountry(String countryVisibleName) {
        WebElement countryElement = waitToBeClickable(country);
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByVisibleText(countryVisibleName);
        waitToBeClickable(region);
    }

    public void selectRegion(String regionVisibleName) {
        WebElement regionElement = waitToBeClickable(region);
        Select selectZone = new Select(regionElement);
        selectZone.selectByVisibleText(regionVisibleName);
    }

    public void setDefaultAddress(boolean makeDefault) {
        if (makeDefault) {
            click(defaultYes);
        } else {
            click(defaultNo);
        }
    }
    public AddressBookPage clickContinue() {
        click(continueBtn);
        return new AddressBookPage(driver);
    }
    }
