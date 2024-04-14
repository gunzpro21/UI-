package stepdefinitions;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public DriverFactory driverFactory;
	public Page page;

	@Before
	public void launchBrowser() {
		String browserName = "chrome"; // Fetching browser value from config file
		driverFactory = new DriverFactory();
		page = driverFactory.initDriver(browserName); // Passing browser name to launch the browser
	}
	//why dont we have config with java file and properties at the same time?

	@After(order = 0)
	public void quitBrowser() {
		page.close();
	}
	// After runs in reverse order so order=1 will run first
	@After(order = 1)
	//image save name as screenshot confiure file but report still print embedded1 and use it
	public void AddScreenshot(Scenario scenario) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotName = scenario.getName().replaceAll(" ", "_");

		String attachmentName = screenshotName + dateName;
		
		
		Path abc = Paths.get("test-output/SparkReport/screenshots",attachmentName+ ".png");
		ScreenshotOptions option = new Page.ScreenshotOptions().setPath(abc);
		final byte[] screenshot = page
				.screenshot(option.setFullPage(true));// still have embedded1
		
		scenario.attach(screenshot, "image/png", attachmentName); // error of miss / of screenshot.dir - Trailing char < > at index 23: test-output/SparkReport \embedded1.png
	}

}
