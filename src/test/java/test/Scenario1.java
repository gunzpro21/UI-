package test;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Scenario1 extends TestCase {
	// create cucumber + extent report latest
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public Scenario1(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(Scenario1.class);
	}

	/**
	 * rhrehehr :-)
	 */
	public void testApp() {
		try (Playwright playwright = Playwright.create()) {
			//Browser browser = playwright.chromium().launch();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			Page page = browser.newPage();
			page.setViewportSize(1920, 1080);
			page.navigate("http://www.automationpractice.pl/");
			page.locator("css=[title='Contact us']").click();
			System.out.println(page.title());
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/evidences/example123.png")));
			browser.close();
		}
	}
}
