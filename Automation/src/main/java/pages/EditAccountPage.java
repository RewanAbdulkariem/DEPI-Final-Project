package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends HelpFunctions {

    private By firstnameField = By.id("input-firstname");
    private By lastnameField = By.id("input-lastname");
    private By emailField = By.id("input-email");

    private By continueBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    private By backBtn = By.linkText("Back");

    private By errorMsg = By.xpath("//div[contains(@class,'invalid-feedback') and contains(@class,'d-block')]");
    private By successMsg = By.cssSelector("div[class*=\"alert-success\"]");

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    // -------------------- Setters --------------------
    public void enterFirstname(String firstname){
        sendText(firstnameField, firstname);
    }

    public void enterLastname(String lastname){
        sendText(lastnameField, lastname);
    }

    public void enterEmail(String email){
        sendText(emailField, email);
    }

    // -------------------- Buttons --------------------
    public void clickContinue(){
        click(continueBtn);
    }

    public AccountPage clickBack(){
        click(backBtn);
        return new AccountPage(driver);
    }

    // -------------------- Verification --------------------
    public String getFirstName(){
        return waitForElement(firstnameField).getAttribute("value");
    }

    public String getLastName(){
        return waitForElement(lastnameField).getAttribute("value");
    }

    public String getErrorMessage(){
        return getText(errorMsg);
    }
    public boolean isSuccessMessageDisplayed() {
        return waitForElement(successMsg).isDisplayed();
    }
}
