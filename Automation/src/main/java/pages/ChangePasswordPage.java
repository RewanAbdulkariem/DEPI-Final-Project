package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends HelpFunctions {

    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");

    By continueBtn = By.xpath("//input[@value='Continue']");
    By backBtn = By.linkText("Back");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterPassword(String password){
        sendText(passwordField,password);
    }

    public void enterConfirmPassword(String confirmPassword){
        sendText(confirmPasswordField, confirmPassword);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public void clickBack() {
        click(backBtn);
    }
}
