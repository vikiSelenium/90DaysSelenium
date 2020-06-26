package runner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/java/feature/CarWale.feature", glue ="steps", monochrome = true)



public class TestCarWale extends AbstractTestNGCucumberTests {


		

}
