package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/Product_Store.feature"},glue = {"step.definition"},
				plugin = {"html:target/cucumber-report-ProductStore-feature.html",
						"json:target/cucumber-report-ProductStore-feature.json","pretty"} )
public class TestRunner1 extends AbstractTestNGCucumberTests {

}
