package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/Login.feature"},glue = {"step.definition"},
				plugin = {"html:target/cucumber-report-login-feature.html",
					"json:target/cucumber-report-login-feature.json","pretty"})
public class TestRunner3 extends AbstractTestNGCucumberTests {

}
