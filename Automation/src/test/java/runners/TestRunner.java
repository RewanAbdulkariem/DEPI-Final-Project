package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/epic8_admin",
        glue = {"stepDefinitions", "hooks"}  ,
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        //tags = "not @admin"
)
public class TestRunner extends AbstractTestNGCucumberTests
{

}