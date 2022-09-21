package runners;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, strict = false, features = {

		"src/test/resources/Ensek.feature",

}, glue = { "stepDefinitions" },

		plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:" }, monochrome = true)

public class Runner {

	@BeforeClass
	public static void setup() {
		DateFormat format = new java.text.SimpleDateFormat("dd-MM-yyyy_hh-mm");
		Date date = new Date();
		String Execution_Time = format.format(date);
		System.out.println("Execution Time: " + Execution_Time);
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("target/cucumber-reports/report" + Execution_Time + ".html");

	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

	}

}
