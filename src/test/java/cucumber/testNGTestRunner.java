package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="snehal.stepdefination",monochrome=true,tags="regg",plugin= {"html.target/cucumbr.html"})
public class testNGTestRunner extends AbstractTestNGCucumberTests {

}
