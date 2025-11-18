package stepDefinitions.epic1_registration_login;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private void setupDriver() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://localhost/OpenCart/");
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        setupDriver();
        homePage = new HomePage(driver);
        homePage.clickAccountIcon();
        loginPage = homePage.clickLogin();
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the user should see the home page")
    public void the_user_should_see_the_home_page() {
        String expectedUrl = "http://localhost/OpenCart/index.php?route=account/account";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login failed. Expected URL to contain: " + expectedUrl + " but got: " + actualUrl);
    }
}