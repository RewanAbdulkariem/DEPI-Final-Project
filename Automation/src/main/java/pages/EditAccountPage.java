package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountPage extends HelpFunctions {

    By firstnameField = By.id("input-firstname");
    By lastnameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By telephoneField = By.id("input-telephone");

    By continueBtn = By.xpath("//input[@value='Continue']");
    By backBtn = By.linkText("Back");


    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

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

    public void clickContinue(){
        click(continueBtn);
    }

    public void clickBack(){
        click(backBtn);
    }
}
