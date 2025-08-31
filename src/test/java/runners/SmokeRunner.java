package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "steps",
        dryRun = false,
        tags ="@loginOnly",
        plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed"}


)

public class SmokeRunner {
}
