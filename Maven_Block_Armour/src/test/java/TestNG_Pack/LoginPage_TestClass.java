package TestNG_Pack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.Base;
import Pages.Login_Page;
import Utils.Utility;

public class LoginPage_TestClass extends Base {
	
	WebDriver driver;
	Login_Page log;
	SoftAssert soft;
	String TESTID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);

		System.out.println("Before Test-1");
		if(BrowserName.equals("Chrome"))
		{
			driver=OpenChromeBrowser();
		}
		if(BrowserName.equals("Firefox"))
	    {
			driver=OpenFirefoxBrowser();
		}
	
			
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class-1");

		log=new Login_Page(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-1");
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(3000);
		
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyUserIsAbleToNavigateOnLoginPageAfterHitTheURL() throws InterruptedException {
		TESTID="TEST-TC-01";
		System.out.println("Test 1");
		
		
		Thread.sleep(5000);
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/login";
		
		
		boolean actualLoginButton = log.LogInButton();
		System.out.println(actualLoginButton);
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualLoginButton, true,"Login button is not disply");
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyUserIsAbleToSeeTheTextLogIntoYourAccountAfterComingOnLoginPage() throws InterruptedException {
		TESTID="TEST-TC-02";
		System.out.println("Test 1");
		
		String actualText=log.TextofLogInHomepage();
		String expectedText="Log in to your account";
		
		
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
	
	}
	@Test(priority=3)
	public void VerifyThatLogInButtonIsDisplayOnLoginPageOrNot() throws InterruptedException {
		TESTID="TEST-TC-03";
		System.out.println("Test 1");
		Thread.sleep(5000);
		
		boolean actualLoginButton = log.LogInButton();
		System.out.println(actualLoginButton);
		
		soft.assertEquals(actualLoginButton, true,"Login button is not disply");
		soft.assertAll(); 
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-1");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-1");
		log=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-1");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}



