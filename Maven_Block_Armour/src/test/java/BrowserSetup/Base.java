package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver OpenChromeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanja\\eclipse-workspace\\Block_Armour\\src\\test\\resources\\Browser_File\\chromedriver.exe");
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
	
		
		WebDriver driver=new ChromeDriver(ops);
		return driver;
	}
	
	public static WebDriver OpenFirefoxBrowser() {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\sanja\\eclipse-workspace\\Block_Armour\\src\\test\\resources\\Browser_File\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver OpenEgdeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sanja\\eclipse-workspace\\Block_Armour\\src\\test\\resources\\Browser_File\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}


}
