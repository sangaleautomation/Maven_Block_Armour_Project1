package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	
	@FindBy (xpath="//div[@class='userRegistration ng-star-inserted']//p[text()='Create Account']")
	private WebElement CreateAccount;
	
	@FindBy (xpath="//h3[text()='User Registration']")
	private WebElement UserRegistrationText;
	
	@FindBy (xpath="//span[contains(text(),'Local')]")
	private WebElement UserType;
	
	@FindBy (xpath="//div[@aria-haspopup='listbox']")
	private WebElement UserTypelist;
	
	@FindBy (xpath="//li[@aria-label='Domain']")
	private WebElement SelectDomain;
	
	@FindBy (xpath="//li[@aria-label='Domain']")
	private WebElement DomaingetText;
	
	@FindBy (xpath="//input[@autocomplete='nope']")
	private WebElement UserName;
	
	
	@FindBy (xpath="(//div[contains(@class,'ng-star-inserted')])[2]")
    private WebElement ValidUserName;
    
	@FindBy (xpath="//small[@class='errorMsgStyle ng-star-inserted']//span[text()='Please enter valid user name']")
	private WebElement UserNameSpecialCharacterError;
	
	@FindBy (xpath="//small[@class='errorMsgStyle ng-star-inserted']//span[text()='User Name must between 1 to 50 characters']")
	private WebElement UserNameMorethanCharacterError; 
	
	@FindBy (xpath="(//input[@type='text'])[3]")
    private WebElement FirstName;
	
	@FindBy (xpath="//small[@class='errorMsgStyle ng-star-inserted']//span[text()='User Name is required']")
	private WebElement UserNameErrorIfEmpty;
	
	@FindBy (xpath="//small[@class='errorMsgStyle ng-star-inserted']//span[text()='Please enter valid first name']")
	private WebElement FirstNameError;
	
	@FindBy (xpath="(//input[@type='text'])[4]")
    private WebElement LastName;
	
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement Password;
	
	@FindBy (xpath="//span[text()='Password should contain atleast 1 special character']")
	private WebElement PasswordError;
	
	
	@FindBy (xpath="(//input[@type='password'])[2]")
	private WebElement ConfirmPassword;
	
	@FindBy (xpath="((//div[@class='ng-star-inserted'])[6]//small//span[1])")
	private WebElement MismatchPasswordError;
	
	
	@FindBy (xpath="(//input[@type='text'])[5]")
	private WebElement EmailId;
	
	@FindBy (xpath="//span[text()='Please enter valid email']")
	private WebElement EmailId_Invalid;
	
	@FindBy (xpath="//div[@class='iti__arrow']")
	private WebElement CountryCodeArrow;
	
	@FindBy (xpath="//span[text()='Andorra']")
	private WebElement AndorraCountryCode;
	
	@FindBy (xpath="//div[@class='selected-dial-code ng-star-inserted']")
	private WebElement SelectCountryCodeText;
	
	@FindBy (xpath="//input[@type='tel']")
	private WebElement MobileNo;
	
	@FindBy (xpath="(//input[@type='text'])[6]")
	private WebElement Department;
	
	@FindBy (xpath="(//input[@type='text'])[7]")
	private WebElement UserDescription;
	
	@FindBy (xpath="(//div[@aria-haspopup='listbox'])[2]")
	private WebElement TimeZoneArrow;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	private WebElement TimeZoneSearch;
	
	@FindBy (xpath="//ul[@role='listbox']//li[@aria-label='Indian/Chagos']")
	private WebElement IndianChagos ;
	
	@FindBy (xpath="//button[text()='Create ']")
	private WebElement CreateButton ;
	
	@FindBy (xpath="//div[@aria-label='User registration request is submitted successfully and is pending for approval.']")
	private WebElement UserRegistartionSuccesfully ;
	
	
	
	WebDriver driver1;
	public CreateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;  
	}
	
	
	public void ClickonCreateAccountButton () {
		CreateAccount.click();
	}
	
	public String TextonUserRegistrationPage () {
		String text=UserRegistrationText.getText();
		return text;
	}
	
	public String TextonUserType () {
		String text=UserType.getText();
		return text;
	}
	public void ClickonUserTypeList () {
		UserTypelist.click();
	}
	public void SelectDomainAndClickOnDomain () {
		SelectDomain.click();
	}
	public String getTextofDomain () {
		String text=DomaingetText.getText();
		return text;
	}
	public void SendUserName (String USERNAME) {
		UserName.sendKeys(USERNAME);
	}
	
	public String ValidUserNamemessage () {
		String text=ValidUserName.getText();
		return text;
	}
	
	public String UserNameSpecialCharacterErrorMessage () {
		String text=UserNameSpecialCharacterError.getText();
		return text;
	}
	public String UserNameMoreThan50CharacterErrorMessage () {
		String text=UserNameMorethanCharacterError.getText();
		return text;
	}
	public void ClickOnUserName () {
		UserName.click();
	}
	public void ClickOnFirstName () {
		FirstName.click();
	}
	public void SendFirstName (String FIRSTNAME) {
		FirstName.sendKeys(FIRSTNAME);
	}
	public String IfUserNameisEmptyThenErrorMessage () {
		String text=UserNameErrorIfEmpty.getText();
		return text;
	}
	
	public String IfInvalidFirstNamePassThenErrorMessage () {
		String text=FirstNameError.getText();
		return text;
	}
	public void ClickOnLastName () {
		LastName.click();
	}
	public void SendLastName (String LASTNAME) {
		LastName.sendKeys(LASTNAME);
	}
	public void ClickOnPassword () {
		Password.click();
	}
	public void SendOnPassword (String PASSWORD) {
		Password.sendKeys(PASSWORD);
	}
	public String IfInvalidPasswordPassThenErrorMessage () {
		String text=PasswordError.getText();
		return text;
	}
	public void ClickOnConfirmPassword () {
		ConfirmPassword.click();
	}
	public void SendOnConfirmPassword (String CONFIRMPASSWORD) {
		ConfirmPassword.sendKeys(CONFIRMPASSWORD);
	}
	public String IfPasswordAndConfirmPasswordMismatchThenErrorMessage () {
		String text=MismatchPasswordError.getText();
		return text;
	}
	public void ClickOnEmailId () {
		EmailId.click();
	}
	public void SendOnEmailId (String EMAIL_ID) {
		EmailId.sendKeys(EMAIL_ID);
	}
	public String IfInvalidEmailIdIsPassThenError () {
		String text=EmailId_Invalid.getText();
		return text;
	}
	public void ClickOnCountryCodeArrow () {
		CountryCodeArrow.click();
	}
	public void SelectAndorraCountryCode () {
		AndorraCountryCode.click();
	}
	public String GetSelectedCountryCodeText () {
		String text=SelectCountryCodeText.getText();
		return text;
	}
	public void ClickOnMobileNo () {
		MobileNo.click();
	}
	public void SendOnMobileno (String MOBILENO) {
		MobileNo.sendKeys(MOBILENO);
	}
	public void ClickOnDepartment () {
		Department.click();
	}
	public void SendOnDepartment (String DEPARTMENT) {
		Department.sendKeys(DEPARTMENT);
	}
	public void ClickOnUserDescription () {
		UserDescription.click();
	}
	public void SendOnUserDescription (String USERDESCRIPTION) {
		UserDescription.sendKeys(USERDESCRIPTION);
	}
	public void ClickOnTimeZoneArrow () {
		TimeZoneArrow.click();
	}
	public void ClickOnTimeZoneSearch () {
		TimeZoneSearch.click();
	}
	public void SendOnTimeZone (String SelectTimeZone) {
		TimeZoneSearch.sendKeys(SelectTimeZone);
	}
	public void ClickOnIndianChagos () {
		IndianChagos.click();
	}
	public String GetSelectedIndianChagosText () {
		String text=IndianChagos.getText();
		return text;
	}
	public void ClickOnCreateButton () {
		CreateButton.click();
	}
	public String GetTextOfUserRegistrationSubmissionSuccesfully () {
		String text=UserRegistartionSuccesfully.getText();
		return text;
	}
	
	
	
	

}


