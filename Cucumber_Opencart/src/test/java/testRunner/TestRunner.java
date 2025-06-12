package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			//features = {".//features/"},
			features = {".//features/Login.feature"},
			//features = {".//features/Registration.feature"},
			//features= {".//Features/LoginDDTExcel.feature"},
			//features = {"@target/rerun.txt"},
			//features = {".//features/Login.feature",".//features/Registration.feature"},
			glue={"stepsDefinitions","hooks"},
			plugin= {"pretty","html:reports/myrepot.html",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // use to generate a extend reports
					"rerun:target/rerun.txt" // use to rerun failed scenarios
					},
			dryRun=false, //check mapping between scenario steps and step definition method
			monochrome=true, //to avoid junk characters in output
			publish=true 	//use to publish report in cucumber server	
			//tags="@sanity"
			
		)

public class TestRunner{
	
}

