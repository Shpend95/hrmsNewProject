package runners;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class )
@CucumberOptions(
        //we write the path to feature directory
        features = "src/test/resources/features",

        // we provide the name of steps package
        glue="steps",

        // we provide true value to get the missing step definitions, and we provide false value to run the actual execution
        dryRun =false,

        // we provide the tag name of the scenario we want to execute
        tags ="@smoke",

        // here we write pretty keyword to print all the steps in console which we execute , and to generate report and location of report
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}
)
public class RunnerClass {
}
