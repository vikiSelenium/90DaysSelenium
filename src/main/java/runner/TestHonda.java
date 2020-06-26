package runner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/java/feature/Honda.feature", glue ="steps", monochrome = true)



public class TestHonda extends AbstractTestNGCucumberTests {


		

}
