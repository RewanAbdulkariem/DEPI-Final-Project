package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCart/");
    }

    @Before("@requiresLogin")
    public void doLogin() {
        HomePage home = new HomePage(driver);
        home.clickAccountIcon();
        LoginPage login = home.clickLogin();
        login.enterEmail("admin@gmail.com");
        login.enterPassword("123456");
        login.clickLogin();
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
