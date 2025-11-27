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

    private final By addressRows  = By.cssSelector("#address table tbody tr");

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

    public int numOfAddressRows(){
        List <WebElement> rows = driver.findElements(addressRows);
        return rows.size();
    }

    public AddressPage clickEdit() {
        return clickEditByIndex(0);
    }

    public AddressPage clickEditByIndex(int index) {
        waitForElement(addressRows);

        List<WebElement> rows = driver.findElements(addressRows);

        if (rows.isEmpty()) {
            throw new IllegalStateException("No address rows found in address book!");
        }
        if (index < 0 || index >= rows.size()) {
            throw new IndexOutOfBoundsException(
                    "Invalid row index: " + index + " (available rows: " + rows.size() + ")"
            );
        }

        By editBtnLocator = By.xpath("//*[@id='address']/div/table/tbody/tr[" + (index + 1) + "]/td[3]/a[1]");
        waitToBeClickable(editBtnLocator).click();

        return new AddressPage(driver);
    }
    public void clickDelete() {
        clickDeleteByIndex(0);
    }
    public void clickDeleteByIndex(int index) {
        waitForElement(addressRows);

        List<WebElement> rows = driver.findElements(addressRows);

        if (rows.isEmpty()) {
            throw new IllegalStateException("No address rows found in address book!");
        }
        if (index < 0 || index >= rows.size()) {
            throw new IndexOutOfBoundsException(
                    "Invalid row index: " + index + " (available rows: " + rows.size() + ")"
            );
        }

        By deleteBtnLocator = By.xpath("//*[@id='address']/div/table/tbody/tr[" + (index + 1) + "]/td[3]/a[2]");
        waitToBeClickable(deleteBtnLocator).click();
    }

    public boolean isAddSuccessMsgDisplayed(){
        return getText(Alert).contains("successfully added");
    }

    public boolean isUpdateSuccessMsgDisplayed(){
        return getText(Alert).contains("successfully updated");
    }
    public boolean isDeleteSuccessMsgDisplayed() {
        return getText(Alert).contains("successfully deleted");
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

    public boolean isCityUpdated(String city) {
        waitForElement(addressRows);

        List<WebElement> rows = driver.findElements(addressRows);
        WebElement row = rows.get(0);
        if (row.getText().contains(city)) {
                return true;
        }
        return false;
    }
}
