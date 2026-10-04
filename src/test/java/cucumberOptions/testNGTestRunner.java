package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//html, xml, json, junit, extent 
// Point features to the resources folder (ensures feature files are on the test classpath)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", monochrome=true, tags="@PlaceOrder or @OfferPage", 
plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedrerun.txt"}) // Specify the output formats for the test results
public class testNGTestRunner extends AbstractTestNGCucumberTests {
//super.scenarios() is a method from the AbstractTestNGCucumberTests class that returns an array of scenarios to be executed.
	@Override
	@DataProvider(parallel = true) // Enable parallel execution of scenarios
	public Object[][] scenarios() {
		return super.scenarios();
	}
} 