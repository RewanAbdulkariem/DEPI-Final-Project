package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the My Account page in OpenCart.
 * Provides navigation methods to Edit Account, Change Password,
 * Address Book, and Wishlist pages.
 */
public class AccountPage extends HelpFunctions {

    private By editAccountLink = By.cssSelector("a[href*='route=account/edit']");
    private By changePasswordLink = By.cssSelector("a[href*='route=account/password']");
    private By addressBookLink = By.cssSelector("a[href*='route=account/address']");
    private By modifyWishlistLink = By.cssSelector("a[href*='route=account/wishlist']") ;

    private By successMsg = By.cssSelector("div[class*=\"alert-success\"]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    // Navigates to the Edit Account page
    public EditAccountPage clickEditAccount() {
        click(editAccountLink);
        return new EditAccountPage(driver);

    }

    // Navigates to the Change Password page
    public ChangePasswordPage clickChangePassword() {
        click(changePasswordLink);
        return new ChangePasswordPage(driver);
    }

    // Navigates to the Address Book page
    public AddressBookPage clickAddressBook() {
        click(addressBookLink);
        return new AddressBookPage(driver);
    }

    // Navigates to the Wishlist page
    public WishListPage clickModifyWishlist() {
        click(modifyWishlistLink);
        return new WishListPage(driver);
    }
    public boolean isSuccessMessageDisplayed() {
        return waitForElement(successMsg).isDisplayed();
    }
}
