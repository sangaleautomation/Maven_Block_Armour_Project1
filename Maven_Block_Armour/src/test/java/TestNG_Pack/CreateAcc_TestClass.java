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
import Utils.Utility;

public class CreateAcc_TestClass extends Base {
	
	
	WebDriver driver;
	CreateAccount createacc;
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

		

		System.out.println("Before Test-2");
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
		System.out.println("Before Class-2");

		createacc=new CreateAccount(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-2");
		driver.get("https://dev340.blockarmour.com/");
		Thread.sleep(3000);
		
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void VerifyThatUserIsAbleToClickOnCreateAccountLinkThenItWillNavigateOnUserRegistarionpage() throws InterruptedException {
		TESTID="TEST-TC-04";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(7000);
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://dev340.blockarmour.com/user-auth/user-registration";
		
		String actualText=createacc.TextonUserRegistrationPage();
		String expectedText="User Registration";
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		
		soft.assertAll(); 
	
	}
	@Test(priority=2)
	public void VerifyThatAfterNavigateOnUserRegistrationPageByDefaultUserTypeIsSelectedAsLocal() throws InterruptedException {
		TESTID="TEST-TC-05";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(5000);
		String actualText=createacc.TextonUserType();
		String expectedText="Local";
soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		
		soft.assertAll(); 
	
	}
	@Test(priority=3)
	public void VerifyThatUserIsAbleToSelectUserTypeasDomain() throws InterruptedException {
		TESTID="TEST-TC-06";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(5000);
		createacc.ClickonUserTypeList();
		createacc.SelectDomainAndClickOnDomain();
		
		
		String actualText=createacc.getTextofDomain();
		String expectedText="Domain";
    soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		
	soft.assertAll(); 
	
	}
	@Test(priority=4)
	public void VerifyThatUserNameTextBoxAcceptTheStringTypeData() throws InterruptedException, IOException {
		TESTID="TEST-TC-07";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		String data=Utility.getExcelData("SheetFirst", 1, 0);
		createacc.SendUserName(data);
		Thread.sleep(5000);
		
		String actualText=createacc.ValidUserNamemessage();
		String expectedText="";
       soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=5)
	public void VerifyThatUserNameFieldAcceptStringTypeDataWithOneSpecialCharacterOrNot() throws InterruptedException, IOException {
		TESTID="TEST-TC-08";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		String data=Utility.getExcelData("SheetFirst", 2, 0);
		createacc.SendUserName(data);
		Thread.sleep(5000);
		
		String actualText=createacc.UserNameSpecialCharacterErrorMessage();
		String expectedText="Please enter valid user name";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=6)
	public void VerifyThatAfterPassingMoreThan50CharacterInUserNameTextBoxItWillAcceptOrNot() throws InterruptedException, IOException {
		TESTID="TEST-TC-09";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		String data=Utility.getExcelData("SheetFirst", 3, 0);
		createacc.SendUserName(data);
		Thread.sleep(5000);
		
		
		String actualText=createacc.UserNameMoreThan50CharacterErrorMessage();
		String expectedText="User Name must between 1 to 50 characters";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
		@Test(priority=7)
	public void VerifyThatAfterClickOnUserNameTextBoxAndThenPassTheValueDirectlyInFirstNameTextBoxItWillGiveErrorUnderTheUserNameField() throws InterruptedException, IOException {
		TESTID="TEST-TC-10";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnUserName();
		Thread.sleep(5000);
		
		String data=Utility.getExcelData("SheetFirst", 4, 0);
		createacc.SendFirstName(data);
		Thread.sleep(5000);
		
		
		String actualText=createacc.IfUserNameisEmptyThenErrorMessage();
		String expectedText="User Name is required";
       soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=8)
	public void VerifyThatUserIsAbleToPassTheStringIntegerTypeDataInFirstNameTextBox () throws InterruptedException, IOException {
		TESTID="TEST-TC-11";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnFirstName();
		Thread.sleep(4000);
		
		String data=Utility.getExcelData("SheetFirst", 6, 0);
		createacc.SendFirstName(data);
		Thread.sleep(5000);
		
		
		String actualText=createacc.IfInvalidFirstNamePassThenErrorMessage();
		String expectedText="Please enter valid first name";
       soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=9)
	public void VerifyThatUserIsAbleToPassTheStringIntegerTypeDataInPasswordTextBox  () throws InterruptedException, IOException {
		TESTID="TEST-TC-12";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnPassword();
		Thread.sleep(4000);
		
		String data=Utility.getExcelData("SheetFirst", 8, 0);
		createacc.SendOnPassword(data);
		Thread.sleep(5000);
		
		
		String actualText=createacc.IfInvalidPasswordPassThenErrorMessage();
		String expectedText="Password should contain atleast 1 special character";
       soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=10)
	public void VerifyThatIfUserCanPassDifferentPasswordInBothPasswordAndConfirmPasswordField() throws InterruptedException, IOException {
		TESTID="TEST-TC-13";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnPassword();
		Thread.sleep(3000);
		
		String data=Utility.getExcelData("SheetFirst", 9, 0);
		createacc.SendOnPassword(data);
		Thread.sleep(5000);
		
	
		createacc.ClickOnConfirmPassword();
		Thread.sleep(4000);
		
		 data=Utility.getExcelData("SheetFirst", 10, 0);
		createacc.SendOnConfirmPassword(data);
		
		
		String actualText=createacc.IfPasswordAndConfirmPasswordMismatchThenErrorMessage();
		String expectedText="Confirm Password doesn't match";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=11)
	public void VerifyThatIfUserCanPassTheInvalidEmailIdInEmailIdTextBox() throws InterruptedException, IOException {
		TESTID="TEST-TC-14";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnEmailId();
		Thread.sleep(3000);
		
		String data=Utility.getExcelData("SheetFirst", 13, 0);
		createacc.SendOnEmailId(data);
		Thread.sleep(5000);
	
		
		String actualText=createacc.IfInvalidEmailIdIsPassThenError();
		String expectedText="Please enter valid email";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
		
	}
	@Test(priority=12)
	public void VerifyThatUserIsAbleToSelectAndorraCountryCodePlus376AndPassSixDigitPhoneNumber () throws InterruptedException, IOException {
		TESTID="TEST-TC-15";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnCountryCodeArrow();
		Thread.sleep(6000);
		
		createacc.SelectAndorraCountryCode();
		Thread.sleep(3000);
		
		String data=Utility.getExcelData("SheetFirst", 16, 0);
		createacc.SendOnMobileno(data);
		Thread.sleep(5000);
	
		
		String actualText=createacc.GetSelectedCountryCodeText();
		String expectedText="+376";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
	}	

	@Test(priority=13)
	public void VerifyThatByPassingTheAllValidDataInTextBoxesClickOnCreateButtonToastMessageWillSeeOnLogInPage () throws InterruptedException, IOException {
		TESTID="TEST-TC-16";
		System.out.println("Test 2");
		
		createacc.ClickonCreateAccountButton();
		Thread.sleep(8000);
		
		createacc.ClickOnUserName();
		String data=Utility.getExcelData("SheetFirst", 19, 0);
		createacc.SendUserName(data);
	
		Thread.sleep(2000);
		
		createacc.ClickOnFirstName();
		 data=Utility.getExcelData("SheetFirst", 20, 0);
		createacc.SendFirstName(data);
	
		Thread.sleep(2000);
		
		createacc.ClickOnLastName();
		 data=Utility.getExcelData("SheetFirst", 21, 0);
			createacc.SendLastName(data);
			Thread.sleep(2000);
			
			createacc.ClickOnPassword();
			data=Utility.getExcelData("SheetFirst", 22, 0);
			createacc.SendOnPassword(data);
			Thread.sleep(2000);
			
			createacc.ClickOnConfirmPassword();
			data=Utility.getExcelData("SheetFirst", 23, 0);
			createacc.SendOnConfirmPassword(data);
			Thread.sleep(2000);
			
			createacc.ClickOnEmailId();
			data=Utility.getExcelData("SheetFirst", 24, 0);
			createacc.SendOnEmailId(data);
			Thread.sleep(2000);
			
			createacc.ClickOnCountryCodeArrow();
			Thread.sleep(5000);
			
			createacc.SelectAndorraCountryCode();
			Thread.sleep(3000);
			
			data=Utility.getExcelData("SheetFirst", 25, 0);
			createacc.SendOnMobileno(data);
			Thread.sleep(2000);
			
			createacc.ClickOnDepartment();
			data=Utility.getExcelData("SheetFirst", 26, 0);
			createacc.SendOnDepartment(data);
			Thread.sleep(2000);
			
			createacc.ClickOnUserDescription();
			data=Utility.getExcelData("SheetFirst", 27, 0);
			createacc.SendOnUserDescription(data);
			Thread.sleep(2000);
			
			createacc.ClickOnTimeZoneArrow();
			Thread.sleep(6000);
			
			createacc.ClickOnTimeZoneSearch();
			Thread.sleep(3000);
			
			data=Utility.getExcelData("SheetFirst", 28, 0);
			createacc.SendOnTimeZone(data);
			Thread.sleep(5000);
		
			createacc.ClickOnIndianChagos();
			Thread.sleep(3000);
			
			createacc.ClickOnCreateButton();
			Thread.sleep(3000);
		
	

		String actualText=createacc.GetTextOfUserRegistrationSubmissionSuccesfully();
		String expectedText="User registration request is submitted successfully and is pending for approval.";
        soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll(); 
	
	}
		
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-2");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-2");
		createacc=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-2");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
	
	
	
	


