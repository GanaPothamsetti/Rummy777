package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			
			features = "src/test/resources/Features/loginTest.feature", 
			glue={"com.game.stepDefinitions","com.game.hooks"},
			plugin= {"pretty","html:target/cucumber-reports.html","com.game.core.StartExecution"}, 
			monochrome = true, 
			dryRun = false
			)
	 
	public class TestRunner {
	 
	}
	
	
