package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	

	@FindBy (xpath="//input[@type='text']")
	private WebElement Login_UserName;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement Login_Password;
	
	@FindBy (xpath="//div[@role='checkbox']")
	private WebElement CheckBox;
	
	
	@FindBy (xpath="//button[@class='btn login-btn']")
	private WebElement LOGIN;
	
	@FindBy (xpath="//div[@aria-label='Your account is pending for approval.']")
	private WebElement ApprovalPendingToastMessage;
	
	@FindBy (xpath="//div[@aria-label='Login Successful.']")
	private WebElement LoginSuccessfully;
	
	
	WebDriver driver1;
	public LogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;  
	}
	
	public void ClickonLoginUserName () {
		Login_UserName.click();
	}
	public void SendLoginUserName (String USERNAME) {
		Login_UserName.sendKeys(USERNAME);
	}
	public void ClickonLoginPassword () {
		Login_Password.click();
	}
	public void SendLoginPassword (String Password) {
		Login_Password.sendKeys(Password);
	}
	public void ClickonCheckBox () {
		CheckBox.click();
	}
	public void ClickonLogIn () {
		LOGIN.click();
	}
	public String GetToastMessageForNewAccountPendingForApproval () {
		String text=ApprovalPendingToastMessage.getText();
		return text;
	}
	public String GetToastMessageForLoginSuccesfully () {
		String text=LoginSuccessfully.getText();
		return text;
	}

}
