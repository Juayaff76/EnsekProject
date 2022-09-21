package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;

import com.google.common.io.Files;


import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;

public class Hooks {
TestContext testContext;


	public Hooks(TestContext context) {
	testContext = context;
	}

	@Before
	public void BeforeSteps() {

	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);

				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/Screenshots/"
						+ screenshotName + ".png");

				Files.copy(sourcePath, destinationPath);

				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}
	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();		
	}
}
