package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class HomePage {
	private Page page;
	private Locator registerBtn;

	public HomePage(Page page) {
		this.page = page;
		registerBtn = page.locator("#enterimg");
		
	}

	public void clickRegisterBtn() {
		registerBtn.click();
	}

	public String getPageTitle() {
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		return page.title();
	}

	public void navigateToUrl(String string) {
		page.navigate(string);
	}
}
