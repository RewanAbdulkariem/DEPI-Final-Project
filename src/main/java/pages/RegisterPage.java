package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends HelpFunctions {
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");

    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");

    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.xpath("//input[contains(@class,\"btn-primary\")]");
    private By successMessage = By.cssSelector("#content h1");

    public void enterFirstName(String text){
        sendText(firstName, text);
    }

    public void enterLastName(String text){
        sendText(lastName, text);
    }

    public void enterEmail(String text){
        sendText(email, text);
    }

    public void enterTelephone(String text){
        sendText(telephone, text);
    }

    public void enterPassword(String text){
        sendText(password, text);
    }

    public void enterConfirmPassword(String text){
        sendText(confirmPassword, text);
    }

    public void agreeToPrivacyPolicy() {
        // click only if not already selected
        if (!driver.findElement(agreeCheckbox).isSelected()) {
            click(agreeCheckbox);
        }
    }

    public void clickContinue(){
        click(continueButton);
    }


    public boolean isRegistrationSuccessful() {
        try {
            String msg = getText(successMessage);
            return msg.equalsIgnoreCase("Your Account Has Been Created!");
        } catch (Exception e){
            return false;
        }
    }
}
