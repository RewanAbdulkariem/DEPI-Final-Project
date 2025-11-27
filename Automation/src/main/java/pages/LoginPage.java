package pages;

import base.HelpFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends HelpFunctions {

    private By forgottenLink =By.linkText("Forgotten Password");
    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginBtn = By.xpath("//button[contains(@class,'btn-primary')]");
    private final By myAccountTitle = By.xpath("//*[@id='content']/h1");
    private By ErrorMsg = By.xpath("//div[contains(@class,\"alert alert-danger alert-dismissible\")]");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String email){
        sendText(emailField, email);
    }

    public void enterPassword(String password){
        sendText(passwordField, password);
    }

    public void clickLogin(){
        click(loginBtn);
        // بلاش waitForUrlContains هنا
    }

    public AccountPage waitForSuccessfulLogin() {
        waitForUrlContains("route=account/account");
        return new AccountPage(driver);
    }

    public String getLoginPageTitle(){
        return waitForElement(myAccountTitle).getText();
    }
    public String getErrorMsg(){
        return getText(ErrorMsg);
    }

    public ForgotPasswordPage clickForgottenPasswordLink ()
    {
        click(forgottenLink);
        return new ForgotPasswordPage(driver);
    }
}
