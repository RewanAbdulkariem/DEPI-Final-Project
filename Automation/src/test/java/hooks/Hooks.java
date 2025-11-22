package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.UUID;

public class Hooks {

    public static WebDriver driver;
    public static String lastRegisteredEmail;
    public static String lastRegisteredPassword;

    @Before(order = 0)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/OpenCart/");
    }
    @Before(value = "@registerNewUser", order = 1)
    public void registerNewTestUser() {
        String unique = UUID.randomUUID().toString().substring(0, 8);
        String email = "test+" + unique + "@mail.com";
        String password = "Pass" + unique;

        HomePage home = new HomePage(driver);
        home.clickAccountIcon();
        RegisterPage registerPage = home.clickRegister();

        registerPage.enterFirstName("Auto");
        registerPage.enterLastName("User");
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.agreeToPrivacyPolicy();
        registerPage.clickContinue();

        lastRegisteredEmail = email;
        lastRegisteredPassword = password;
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
