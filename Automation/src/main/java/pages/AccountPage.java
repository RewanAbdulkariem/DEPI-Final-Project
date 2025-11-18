package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends HelpFunctions {

    By editAccountLink = By.cssSelector("a[href*='route=account/edit']");
    By changePasswordLink = By.cssSelector("a[href*='route=account/password']");
    By addressBookLink = By.cssSelector("a[href*='route=account/address']");
    By modifyWishlistLink = By.cssSelector("a[href*='route=account/wishlist']") ;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditAccount() {
        click(editAccountLink);
    }

    public void clickChangePassword() {
        click(changePasswordLink);
    }

    public void clickAddressBook() {
        click(addressBookLink);
    }

    public void clickModifyWishlist() {
        click(modifyWishlistLink);
    }
}
