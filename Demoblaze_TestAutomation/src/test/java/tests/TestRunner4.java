package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features/Products_Cart.feature"},glue = {"step.definition"},
			plugin = {"html:target/cucumber-report-Products-Cart-feature.html",
					"json:target/cucumber-report-Products-Cart-feature.json","pretty"})
public class TestRunner4 extends AbstractTestNGCucumberTests {

}
