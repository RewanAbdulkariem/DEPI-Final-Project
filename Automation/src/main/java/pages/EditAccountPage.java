package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends HelpFunctions {

    private By firstnameField = By.id("input-firstname");
    private By lastnameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");

    private By continueBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    private By backBtn = By.linkText("Back");

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

    public void enterTelephone(String telephone){
        sendText(telephoneField, telephone);
    }

    // -------------------- Buttons --------------------
    public AccountPage clickContinue(){
        click(continueBtn);
        return new AccountPage(driver);

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

}
