package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.awt.SystemColor.desktop;

public class CategoryPage extends HelpFunctions
{
   // private By desctops = By.xpath("//a[text()=\"Desktops\"]");
    private By Alldesctops = By.xpath("//a[text()=\"Show All Desktops\"]");
    private By desctopword = By.xpath("//h1[text()=\"Desktops\"]");
    WebElement desctops = driver.findElement(By.xpath("//a[text()=\"Desktops\"]"));
    // private By MP3 =
  //  private By MP3_playersword =

    public CategoryPage(WebDriver driver)
    {
        super(driver);
    }
    //public void clickOndesctopCat(){waitToBeClickable(desctops).click();}
    public void hoverOnDesktopCat()
    {

        Actions actions = new Actions(driver);
        actions.moveToElement(desctops).perform();
    }
    public void clickOnAlldesctopCat(){waitToBeClickable(Alldesctops).click();}

    public boolean isDesctopsAppeared()
    {

        try
        {
            String msg = getText(desctopword);
            return msg.equalsIgnoreCase("Desktops");
        } catch (Exception e)
        {
            return false;
        }
    }
}
