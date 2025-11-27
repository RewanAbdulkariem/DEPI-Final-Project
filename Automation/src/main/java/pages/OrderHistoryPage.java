package pages;

import base.HelpFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends HelpFunctions {

    private final By ordersTableTitle = By.xpath("//h1[text()='Orders']");
    private final By table            = By.xpath("//table[.//th[contains(text(),'Order ID')]]");
    private final By firstBillInHistoryPage =
            By.xpath("//*[@id='content']/div[1]/table/tbody/tr[1]/td[6]/a/i");
    private final By orderStatus      = By.xpath("//*[@id='history']/div[1]/table/tbody/tr/td[3]");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public String getOrdersTableTitle() {
        return getText(ordersTableTitle);
    }

    public WebElement getOrdersTable(){
        return waitForElement(table);
    }

    public void clickFirstOrderInHistoryTable(){
        click(firstBillInHistoryPage);
    }

    public String getOrderStatus(){
        return getText(orderStatus);
    }
}
