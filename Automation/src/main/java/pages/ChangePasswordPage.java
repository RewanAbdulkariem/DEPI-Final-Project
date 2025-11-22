package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends HelpFunctions {

    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");

    By continueBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    By backBtn = By.linkText("Back");

    private By errorMsg = By.xpath("//div[contains(@class,'invalid-feedback') and contains(@class,'d-block')]");
    private By successMsg = By.cssSelector("div[class*=\"alert-success\"]");

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

    public boolean isSuccessMessageDisplayed(){
        return waitForElement(successMsg).isDisplayed();
    }

    public String getErrorMessage(){
        return getText(errorMsg);
    }
}
