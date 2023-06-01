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
import Pages.Change_Password;
import Pages.LogIn;
import Pages.Profile;
import Utils.Utility;

public class ChangePassword_TestClass extends Base {
	
	WebDriver driver;
	LogIn login;
	Profile prof;
	Change_Password changpass;
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

		System.out.println("Before Test-6");
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
		System.out.println("Before Class-6");

		login=new LogIn(driver);
		prof=new Profile(driver);
		changpass=new Change_Password(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException, IOException {
		System.out.println("Before Method-7");
		Thread.sleep(2000);
		
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(5000);
		
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyThatAfterLoginUserIsAbleToChangePassword() throws InterruptedException, IOException {
		TESTID="TEST-TC-24";
		System.out.println("Test 6");
		
		login.ClickonLoginUserName();
		Thread.sleep(2000);
		String data=Utility.getExcelData("SheetFirst", 32, 0);
		login.SendLoginUserName(data);
		Thread.sleep(4000);
		
		login.ClickonLoginPassword();
		
		data=Utility.getExcelData("SheetFirst", 33, 0);
		login.SendLoginPassword(data);
		Thread.sleep(4000);
		
		login.ClickonCheckBox();
		Thread.sleep(3000);
		
		login.ClickonLogIn();
		Thread.sleep(7000);
		
		changpass.ClickonAvatar();
		Thread.sleep(4000);
		
    	changpass.ClickonChangePassTab();
		Thread.sleep(4000);
		
		changpass.ClickonOldPassword();
		Thread.sleep(3000);
		
		 data=Utility.getExcelData("SheetFirst", 36, 0);
		changpass.SendOnOldPassword(data);
		Thread.sleep(2000);
		
		changpass.ClickonNewPassword();
		Thread.sleep(2000);
		data=Utility.getExcelData("SheetFirst", 37, 0);
		changpass.SendOnNewPassword(data);
		Thread.sleep(2000);
		
		changpass.ClickonConfirmPassword();
		data=Utility.getExcelData("SheetFirst", 38, 0);
		changpass.SendOnConfirmPassword(data);
		Thread.sleep(2000);
		
		changpass.ClickonSubmitButton();
		Thread.sleep(4000);
		
		
		String actualText=changpass.ChangePasswordSucessToastMessage();
		String expectedText="Password is changed successfully";
		
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
				
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyThatAfterChangingPasswordUserCanLoginWithNewPassword() throws InterruptedException, IOException {
		TESTID="TEST-TC-25";
		System.out.println("Test 6");
		
		login.ClickonLoginUserName();
		Thread.sleep(2000);
		String data=Utility.getExcelData("SheetFirst", 41, 0);
		login.SendLoginUserName(data);
		Thread.sleep(4000);
		
		login.ClickonLoginPassword();
		
		data=Utility.getExcelData("SheetFirst", 42, 0);
		login.SendLoginPassword(data);
		Thread.sleep(4000);
		
		login.ClickonCheckBox();
		Thread.sleep(3000);
		
		login.ClickonLogIn();
		Thread.sleep(7000);
		
		String actualText=login.GetToastMessageForLoginSuccesfully();
		String expectedText="Login Successful.";
		
	soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
	
		soft.assertAll(); 
	

	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-6");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-6");
		changpass=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-6");
		driver.quit();
		driver=null;
		System.gc();
	}

}
