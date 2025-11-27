package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends HelpFunctions
{
    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    private By emailaddress = By.xpath("//input[@id=\"input-email\"]");
    private By continuebtn = By.xpath("//button[@class=\"btn btn-primary\"]");
    private By successmessage = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
    public void enteremail (String email)
    {
        driver.findElement(emailaddress).sendKeys(email);
    }

    public void clickonContinuebtn ()
    {
        driver.findElement(continuebtn).click();
       // waitToBeClickable(continuebtn).click();
    }


    public boolean isResetEmailSent()
    {

        try
        {
            String msg = getText(successmessage);
            return msg.equalsIgnoreCase("text_success");
        } catch (Exception e)
        {
            return false;
        }
    }
}
