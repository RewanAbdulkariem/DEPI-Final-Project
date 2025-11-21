package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * This class represents the Address Book page in OpenCart.
 * It provides actions for creating, editing, and removing customer address records.
 */
public class AddressBookPage extends HelpFunctions {

    private By newAddressBtn = By.cssSelector("a[href*='route=account/address/add']");
    private By backBtn = By.linkText("Back");

    private By editBtns = By.cssSelector("a[href*='route=account/address/edit']");
    private By deleteBtns = By.cssSelector("a[href*='route=account/address/delete']");

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    // Opens the Add Address page
    public void clickNewAddress(){
        click(newAddressBtn);
    }
    // Goes back to the previous page
    public void clickBack(){
        click(backBtn);
    }

    // Clicks the first Edit button (index 0)
    public void clickEdit() {
        clickEdit(0); // default index = 0
    }
    // Clicks Edit button by index  (0 represents first button)
    public void clickEdit(int index) {
        clickByIndex(editBtns, index);
    }

    // Clicks the first Delete button (index 0)
    public void clickDelete() {
        clickDelete(0); // default index = 0
    }
    // Clicks Delete button by index (0 represents first button)
    public void clickDelete(int index) {
        clickByIndex(deleteBtns, index);
    }
}
