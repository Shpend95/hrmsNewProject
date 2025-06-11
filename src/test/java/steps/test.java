package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import utils.Log;

import java.io.File;

public class test {
    public static void main(String[] args) {
        System.out.println("=== Starting logging test ===");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Test direct logging
        Log.info("This is a direct log test message");

        // Test the startTestCase method
        Log.startTestCase("Logging Test Case");

        System.out.println("=== Logging test completed ===");

        // Check if file was created
        File logFile = new File("logfile.log");
        System.out.println("Log file exists: " + logFile.exists());
        System.out.println("Log file path: " + logFile.getAbsolutePath());
    }

}
