package testNGRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SignIn.feature",
        glue = {"stepDefinition"},
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
