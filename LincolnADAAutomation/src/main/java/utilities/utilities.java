package utilities;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utilities {
	
	private final Properties configProp = new Properties();
	public String browser;
	public String url;
	public WebDriver driver;
	
	public utilities() {
		try {
			//Log4j Configuration setting
			DOMConfigurator.configure("log4j.xml");
			
			//Properties file reader
			FileReader reader = new FileReader("src/test/resources/config/configProperties.properties");
			configProp.load(reader);
			browser = configProp.getProperty("Browser");
			Log.info("Browser read from file: "+browser);
			url = configProp.getProperty("Application_url");
			Log.info("Application url read from file: "+url);
		}
		catch(Exception e) {
			Log.error(e);
		}
	}
	
	public WebDriver launchBrowser() {
		
		switch(browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			driver=null;
			Log.error("Please specify the correct Browser");
		}		
		
		return driver;
	}
	
	public void launchApplication() {
		driver.manage().window().maximize();
		driver.get(url);
	}

}
