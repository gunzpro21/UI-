package dataProvider;

import enums.EBrowser;

public class ConfigFileReader {
	PropertyReader prTestData;

	public ConfigFileReader() {
		prTestData = new PropertyReader("src/main/java/properties/testdata.properties");
	}
	public EBrowser getBrowser() {
		String browserName = prTestData.readProperty("browser");
		
		if(browserName == null || browserName.equals("chrome"))
			return EBrowser.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) 
			return EBrowser.FIREFOX;
		else if(browserName.equals("webkit")) 
				return EBrowser.WEBKIT;
			 else 
				throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
}
