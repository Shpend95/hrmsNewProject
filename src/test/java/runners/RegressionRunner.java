package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue="steps",
        dryRun = true,
        tags = "@regression",
        plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}


)

public class RegressionRunner  {
}
