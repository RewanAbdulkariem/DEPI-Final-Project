package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends HelpFunctions
{
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");

    private By password = By.id("input-password");

    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.xpath("//button[contains(@class,\"btn-primary\")]");
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


    public void enterPassword(String text){
        sendText(password, text);
    }

    public void agreeToPrivacyPolicy()
    {

        // استدعاء العنصر
        WebElement element1 = driver.findElement(agreeCheckbox);
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight + -200);"
        );
            // Optional: انتظار العنصر يكون clickable قبل الضغط
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element1));

            if (!driver.findElement(agreeCheckbox).isSelected()) {
                click(agreeCheckbox);
            }
    }

//    public void agreeToPrivacyPolicy() {
//        // click only if not already selected
//        if (!driver.findElement(agreeCheckbox).isSelected()) {
//            click(agreeCheckbox);
//        }
//    }

    public void clickContinue()
    {

        // استدعاء العنصر
        WebElement element = driver.findElement(continueButton);
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight + -200);"
        );
            // انتظار العنصر يكون clickable بعد scroll
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            // ضغط على العنصر بعد scroll
            element.click();
        // انتظار ظهور رسالة النجاح
        waitForElement(successMessage);
    }


//    public void clickContinue(){
//        click(continueButton);
//        waitForElement(successMessage);
//
//    }



public boolean isRegistrationSuccessful()
    {
        try
        {
            String msg = getText(successMessage);
            return msg.equalsIgnoreCase("Your Account Has Been Created!");
        } catch (Exception e)
        {
            return false;
        }
    }
}
