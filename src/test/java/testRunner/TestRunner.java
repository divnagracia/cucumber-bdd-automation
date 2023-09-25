package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features", glue = {
		"stepDefinitions" }, plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt" }, monochrome = true, dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}
	
	

}


