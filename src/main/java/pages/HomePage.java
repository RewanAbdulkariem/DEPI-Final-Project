package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HelpFunctions {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By accountIcon = By.xpath("//a[i[contains(@class,'fa-user')]]");
    By registerLink = By.cssSelector("a[href*='register']");
    By loginLink = By.cssSelector("a[href*='login']");

    public void clickAccountIcon(){
        click(accountIcon);
    }

    public LoginPage clickLogin(){
        click(loginLink);
        return new LoginPage(driver);

    }

    public RegisterPage clickRegister(){
        click(registerLink);
        return new RegisterPage(driver);
    }


}
