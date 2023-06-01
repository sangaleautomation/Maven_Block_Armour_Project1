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

import Pages.LogIn;
import Pages.Profile;
import Utils.Utility;

public class Profile_TestClass extends Base {
	
	WebDriver driver;
	LogIn login;
	Profile prof;
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

		System.out.println("Before Test-5");
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
		System.out.println("Before Class-5");

		login=new LogIn(driver);
		prof=new Profile(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException, IOException {
		System.out.println("Before Method-5");
		Thread.sleep(2000);
		
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(5000);
		
		login.ClickonLoginUserName();
		Thread.sleep(2000);
		String data=Utility.getExcelData("SheetFirst", 32, 0);
		login.SendLoginUserName(data);
		Thread.sleep(5000);
		
		login.ClickonLoginPassword();
		
		data=Utility.getExcelData("SheetFirst", 33, 0);
		login.SendLoginPassword(data);
		Thread.sleep(5000);
		
		login.ClickonCheckBox();
		Thread.sleep(3000);
		
		login.ClickonLogIn();
		Thread.sleep(8000);
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyThatAfterLoginUserIsAbleToNavigateOnProfilePage() throws InterruptedException, IOException {
		TESTID="TEST-TC-21";
		System.out.println("Test 5");
		
		
		
		prof.ClickonAvtarp();
		Thread.sleep(4000);
		
		prof.ClickonProfileTab();
		Thread.sleep(4000);
		
		String actualText=prof.GetTextonProfilePage();
		String expectedText="User Profile";
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/user/profile";
			
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyThatAfterLoginUserIsAbleToClickOnPolicyTab() throws InterruptedException, IOException {
		TESTID="TEST-TC-22";
		System.out.println("Test 5");
		
		prof.ClickonPolicy();
		Thread.sleep(6000);
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/policy-rule/list";
			
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		
		soft.assertAll(); 
	
	}
	@Test(priority=3)
	public void VerifyThatUserIsAbleToNavigateFromPolicyTabToLogsTab() throws InterruptedException, IOException {
		TESTID="TEST-TC-23";
		System.out.println("Test 5");	
		
	
		prof.ClickonLogs();
		Thread.sleep(6000);
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/log/list";
			
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		
		soft.assertAll(); 
	
	}
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-5");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-5");
		prof=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-5");
		driver.quit();
		driver=null;
		System.gc();
	}
	


}
