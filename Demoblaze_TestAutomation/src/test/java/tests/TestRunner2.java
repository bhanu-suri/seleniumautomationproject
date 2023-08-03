package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/Signup.feature"},glue = {"step.definition"},
				plugin = {"html:target/cucumber-report-Signup-feature.html",
						"json:target/cucumber-report-Signup-feature.json","pretty"})
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
