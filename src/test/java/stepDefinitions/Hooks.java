package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import utils.TestContextSetup;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentService;


public class Hooks {

//	TestContextSetup testContextSetup;
//	public  Hooks(TestContextSetup testContextSetup) {
//		this.testContextSetup = testContextSetup;
//		
//	}
//	@After
//	public void AfterScenario() throws IOException {
//		testContextSetup.testBase.WebDriverManger().quit();
//		
//	}
	
	TestContextSetup testContextSetup;
    ExtentReports extent;
    ExtentTest test;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        // You can log scenario start if needed
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        // Quit WebDriver (your existing logic)
        testContextSetup.testBase.WebDriverManger().quit();

        // Optional: log scenario result to console
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
        } else {
            System.out.println("Scenario passed: " + scenario.getName());
        }
    }
    
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
    	WebDriver driver = testContextSetup.testBase.WebDriverManger();
    	if (scenario.isFailed()) {
    		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		byte []fileContent = FileUtils.readFileToByteArray(sourcePath);
    		scenario.attach(fileContent, "image/png", scenario.getName());
    		System.out.println("After Step Hook executed");
		}
    }
   
}
