package managers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import enums.EBrowser;

public class DriverFactory {
	public Browser browser;
	public static BrowserContext context;
	public static Page page;

	public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>(); // For Parallel execution
	public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

	// Launches Browser as set by user in config file
	public Page initDriver(EBrowser browserName) {
		BrowserType browserType = null;
		boolean headless = false;
		switch (browserName) {
		case FIREFOX:
			browserType = Playwright.create().firefox();
			browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
			break;
		case CHROME:
			browserType = Playwright.create().chromium();
			browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
			break;
		case WEBKIT:
			browserType = Playwright.create().webkit();
			browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
			break;
		}
		if (browserType == null)
			throw new IllegalArgumentException("Could not Launch Browser for type" + browserType);
		context = browser.newContext();

		page = context.newPage();
		threadLocalDriver.set(page);
		threadLocalContext.set(context);
		return page;
	}

	public static synchronized Page getPage() {
		return threadLocalDriver.get(); // Will return Initialized Thread Local Driver
	}

	public static synchronized BrowserContext getContext() {
		return threadLocalContext.get(); // Will return Initialized Thread Local Context
	}
}
