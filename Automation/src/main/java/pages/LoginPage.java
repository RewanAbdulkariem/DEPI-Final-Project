package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HelpFunctions {

    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginBtn = By.xpath("//button[contains(@class,'btn-primary')]");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String email){
        sendText(emailField, email);
    }

    public void enterPassword(String password){
        sendText(passwordField, password);
    }

    public AccountPage clickLogin(){
        click(loginBtn);
        return new AccountPage(driver);
    }
}
