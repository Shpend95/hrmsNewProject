package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CommonMethods;


import java.io.IOException;
import java.net.MalformedURLException;


public class Hooks extends CommonMethods {


    @Before
    public void setUp() throws IOException {
       launchBrowser();

    }

    @After
    public void close(Scenario scenario) throws IOException {

        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        closeBrowser();
    }
}




