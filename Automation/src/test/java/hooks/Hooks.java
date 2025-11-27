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
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/opencart");
    }
    @Before(value = "@registerNewUser", order = 1)
    public void registerNewTestUser()
    {
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
    @Before(value = "@requiresLogin", order = 2)
    public void doLogin() {
        HomePage home = new HomePage(driver);
        home.clickAccountIcon();
        LoginPage login = home.clickLogin();
        login.enterEmail("admin@gmail.com");
        login.enterPassword("123456");
        login.clickLogin();
    }
    @Before(value = "@requiredProductsInCart", order = 3)
    public void addProductsToCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.addProductToCart("MacBook");
        loginPage.addProductToCart("iPhone");
        loginPage.openCart();
        loginPage.getCheckout().click();
    }
    @Before(value = "@completeCheckoutPageData", order = 4)
    public void fillChekoutPage(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.ensureShippingAddressData();
        checkoutPage.chooseShippingMethod();
        checkoutPage.choosePaymentMethod();
    }
    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
