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
import Pages.Forgot_PasswordPage;

import Utils.Utility;

public class ForgotPass_TestClass extends Base {
	

	WebDriver driver;
	Forgot_PasswordPage ForgotPass;
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

		System.out.println("Before Test-4");
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
		System.out.println("Before Class-4");

		ForgotPass=new Forgot_PasswordPage(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-4");
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(3000);
		
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyThatUserIsAbleToClickOnForgotPasswordLinkAndNavigateOnResetPasswordPage() throws InterruptedException, IOException {
		TESTID="TEST-TC-19";
		System.out.println("Test 4");
		
		ForgotPass.ClickonForgotPasswordLink();
		Thread.sleep(5000);
		
	
		String actualText=ForgotPass.GetTextOfResetPassword();
		String expectedText="Reset Your Password";
			
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyThatUserIsAbleToPassTheValidUsernameAndThenClickOnResetPasswordButtonThenSeeToastMessageOnUI() throws InterruptedException, IOException {
		TESTID="TEST-TC-20";
		System.out.println("Test 4");
		
		ForgotPass.ClickonForgotPasswordLink();
		Thread.sleep(5000);
		
		ForgotPass.ClickonForgotPassUserName();
		Thread.sleep(4000);
		
		String data=Utility.getExcelData("SheetFirst", 32, 0);
		ForgotPass.SendFWUserName(data);
		Thread.sleep(5000);
		
		ForgotPass.ClickonResetPasswordButton();
		Thread.sleep(6000);
	
	String actualText=ForgotPass.GetResetPasswordToastMessage();
		String expectedText="Please check your Email Inbox to Reset Password";
	
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
	
		
		soft.assertAll(); 
	
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-4");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-4");
		ForgotPass=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-4");
		driver.quit();
		driver=null;
		System.gc();
	}
	


}
