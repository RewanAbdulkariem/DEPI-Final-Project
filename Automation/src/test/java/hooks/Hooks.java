package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static config.TestConfig.get;

import java.util.UUID;

public class Hooks {

    public static WebDriver driver;
    public static String baseUrl;
    public static String lastRegisteredEmail;
    public static String lastRegisteredPassword;

    @Before(order = 0)
    public void setUp()
    {
        String env  = get("env");    // demo / admin
        String port = get("port");   // 80 / 8080 ...

        switch (env.toLowerCase()) {
            case "admin":
            case "myadmin":
                baseUrl = "http://localhost:" + port + "/opencart/" + env;
                break;

            case "demo":
            default:
                baseUrl = "http://localhost:" + port + "/opencart/";
                break;
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        // to run mvn test -Denv=demo -Dport=8080 or mvn test -Denv=admin -Dport=8080
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
        login.enterEmail(get("demo.username"));
        login.enterPassword(get("demo.password"));
        login.clickLogin();
        login.waitForSuccessfulLogin();
    }
    @Before(value = "@requiredProductsInCart", order = 3)
    public void addProductsToCart(){
        HomePage home = new HomePage(driver);

        home.addProductToCart("MacBook");
        home.addProductToCart("iPhone");

        home.openCart();
        home.getCheckout().click();
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
