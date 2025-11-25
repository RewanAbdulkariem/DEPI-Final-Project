package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/epic1_registration_login/Register.feature",
        glue = {"stepDefinitions", "hooks"}

)
public class TestRunner extends AbstractTestNGCucumberTests
{
}
