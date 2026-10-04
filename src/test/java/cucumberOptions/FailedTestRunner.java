package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//html, xml, json, junit, extent 
// Point features to the resources folder (ensures feature files are on the test classpath)
@CucumberOptions(features = "@target/failed_Scenario.txt", glue = "stepDefinitions", monochrome=true,  
plugin = {"html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}) // Specify the output formats for the test results
public class FailedTestRunner extends AbstractTestNGCucumberTests {
//super.scenarios() is a method from the AbstractTestNGCucumberTests class that returns an array of scenarios to be executed.
	@Override
	@DataProvider(parallel = true) // Enable parallel execution of scenarios
	public Object[][] scenarios() {
		return super.scenarios();
	}
} 