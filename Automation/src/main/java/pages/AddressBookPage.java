package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class represents the Address Book page in OpenCart.
 * It provides actions for creating, editing, and removing customer address records.
 */
public class AddressBookPage extends HelpFunctions {

    private By newAddressBtn = By.xpath("//a[text()='New Address']");
    private By backBtn = By.linkText("Back");

    private By editBtns = By.xpath("//*[contains(@class,'btn') and contains(@aria-label,'Edit')]");
    private By deleteBtns = By.xpath("//*[contains(@class,'btn') and contains(@aria-label,'Delete')]");

    private By addressRows = By.xpath("(//tr)/td[1]");
    private By Alert = By.cssSelector("div[class*='alert']");


    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    // Opens the Add Address page
    public AddressPage clickNewAddress(){
        click(newAddressBtn);
        return new AddressPage(driver);
    }

    // Goes back to the previous page
    public void clickBack(){
        click(backBtn);
    }

    // Clicks the first Edit button (index 0)
    public AddressPage clickEdit() {
        clickEdit(1); // default index = 0
        return new AddressPage(driver);
    }

    // Clicks Edit button by index  (0 represents first button)
    public AddressPage clickEdit(int index) {
        clickByIndex(editBtns, index);
        return new AddressPage(driver);

    }

    // Clicks the first Delete button (index 0)
    public void clickDelete() {
        clickDelete(1); // default index = 0
    }

    // Clicks Delete button by index (0 represents first button)
    public void clickDelete(int index) {
        clickByIndex(deleteBtns, index);
    }

    public boolean isAddSuccessMsgDisplayed(){
        return getText(Alert).contains("Your address has been successfully added");
    }

    public boolean isUpdateSuccessMsgDisplayed(){
        return getText(Alert).contains("Your address has been successfully updated");
    }


    public int numOfAddressRows(){
        List <WebElement> rows = driver.findElements(addressRows);
        return rows.size();
    }
    public boolean isAddressPresent(String firstName, String address1) {
        List <WebElement> rows = driver.findElements(addressRows);
        for (WebElement row: rows){
            String text = row.getText().trim();
            if (text.contains(firstName) && text.contains(address1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isCityPresent(String city) {
        List<WebElement> rows = driver.findElements(addressRows);
        for (WebElement row : rows) {
            if (row.getText().contains(city)) {
                return true;
            }
        }
        return false;
    }
}
