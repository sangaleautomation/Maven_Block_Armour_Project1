package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgot_PasswordPage {
	
	@FindBy (xpath="//p[text()='Forgot password?']")
	private WebElement ForgotPassword;
	
	@FindBy (xpath="//h3[text()='Reset Your Password']")
	private WebElement ResetPasswordText;
	
	@FindBy (xpath="//input[@class='form-input ui-inputtext ui-corner-all ui-state-default ui-widget ng-untouched ng-pristine ng-invalid']")
	private WebElement ForgotPassUserName;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement ResetPassword;
	
	
	@FindBy (xpath="//div[@aria-label='Please check your Email Inbox to Reset Password']")
	private WebElement ResetPasswordToastMessage;
	
	
	WebDriver driver1;
	public Forgot_PasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;  
	}
	public void ClickonForgotPasswordLink () {
		ForgotPassword.click();
	}
	public String GetTextOfResetPassword () {
		String text=ResetPasswordText.getText();
		return text;
	}
	
	public void ClickonForgotPassUserName () {
		ForgotPassUserName.click();
	}
	public void SendFWUserName (String USERNAME) {
		ForgotPassUserName.sendKeys(USERNAME);
	}
	public void ClickonResetPasswordButton () {
		ResetPassword.click();
	}
	public String GetResetPasswordToastMessage () {
		String text=ResetPasswordToastMessage.getText();
		return text;
	}
	
	

}
