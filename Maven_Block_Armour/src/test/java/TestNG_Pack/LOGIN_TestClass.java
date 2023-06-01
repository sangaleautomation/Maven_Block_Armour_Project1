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
import Pages.CreateAccount;
import Pages.LogIn;
import Utils.Utility;

public class LOGIN_TestClass extends Base {
	
	WebDriver driver;
	LogIn login;
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

		System.out.println("Before Test-3");
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
		System.out.println("Before Class-3");

		login=new LogIn(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-3");
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(3000);
		
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyThatUserCanBeLogInByEnteringTheNewAccountCreatedValidCredentialAndClickOnLogInButton() throws InterruptedException, IOException {
		TESTID="TEST-TC-17";
		System.out.println("Test 3");
		
		login.ClickonLoginUserName();
		Thread.sleep(2000);
		
		String data=Utility.getExcelData("SheetFirst", 30, 0);
		login.SendLoginUserName(data);
		Thread.sleep(5000);
		
		login.ClickonLoginPassword();
		
		data=Utility.getExcelData("SheetFirst", 31, 0);
		login.SendLoginPassword(data);
		Thread.sleep(5000);
		
		login.ClickonCheckBox();
		Thread.sleep(3000);
		
		login.ClickonLogIn();
		Thread.sleep(8000);
	
		String actualText=login.GetToastMessageForNewAccountPendingForApproval();
		String expectedText="Your account is pending for approval.";
			
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyThatUserCanBeLogInByEnteringOldAccountValidCredentialAndClickOnLogInButton() throws InterruptedException, IOException {
		TESTID="TEST-TC-18";
		System.out.println("Test 3");
		
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
	
		String actualText=login.GetToastMessageForLoginSuccesfully();
		String expectedText="Login Successful.";
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/access-map"	;
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		
		soft.assertAll(); 
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-3");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-3");
		login=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-3");
		driver.quit();
		driver=null;
		System.gc();
	}
	



}
