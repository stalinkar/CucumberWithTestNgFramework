package com.OrangeHRM.BDDTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/OrangeHRM/Features/OrangHRM.feature", 
		glue = "com/OrangeHRM/StepDefinition", 
		dryRun = false, 
		monochrome = true, 
		publish = true, 
		plugin = {"pretty:target/cucumber-pretty.txt",
				"html:target/cucumber-html-report.html", 
				"json:target/cucumber.json",
				"rerun:target/rerun.txt" }, 
		tags = "@SmokeTest or @RegressionalTest")

public class OrangeHRMTestRunner extends AbstractTestNGCucumberTests {

}
