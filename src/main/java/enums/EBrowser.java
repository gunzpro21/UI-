package enums;

public enum EBrowser {
	FIREFOX, CHROME, WEBKIT;

	public static EBrowser getBrowserType(String browser) throws IllegalArgumentException {
		for (EBrowser b : values()) {
			if (b.toString().equalsIgnoreCase(browser)) {
				return b;
			}
		}
		throw browserNotFound(browser);
	}

	private static IllegalArgumentException browserNotFound(String browserName) {
		return new IllegalArgumentException(("Invalid browser [" + browserName + "]"));
	}
}
