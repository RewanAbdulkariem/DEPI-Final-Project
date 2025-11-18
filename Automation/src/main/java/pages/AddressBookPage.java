package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage extends HelpFunctions {

    private By newAddressBtn = By.cssSelector("a[href*='route=account/address/add']");
    private By backBtn = By.linkText("Back");

    private By editBtn = By.cssSelector("a[href*='route=account/address/edit']");
    private By deletesBtn = By.cssSelector("a[href*='route=account/address/delete']");

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewAddress(){
        click(newAddressBtn);
    }

    public void clickBack(){
        click(backBtn);
    }
}
