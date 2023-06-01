package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Change_Password {
	
	@FindBy (xpath="//div[@class='avatar']")
	private WebElement Avatar;
	
	@FindBy (xpath="(//a[@role='menuitem'])[2]")
	private WebElement ChangePassTab;
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement OldPassword;
	
	@FindBy (xpath="(//input[@type='password'])[2]")
	private WebElement NewPassword;
	
	@FindBy (xpath="(//input[@type='password'])[3]")
	private WebElement ConfirmPassword;
	
	@FindBy (xpath="//button[@class='btn btn-primary']")
	private WebElement Submit;
	
	
	@FindBy (xpath="//div[@aria-label='Password is changed successfully']")
	private WebElement PasswordChangeSuccesfully;
	
	WebDriver driver1;
	public Change_Password(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;  
	}
	public void ClickonAvatar () {
		Avatar.click();
	}
	public void ClickonChangePassTab () {
		ChangePassTab.click();
	}
	public void ClickonOldPassword () {
		OldPassword.click();
	}
	public void SendOnOldPassword (String OLD_PASSWORD) {
		OldPassword.sendKeys(OLD_PASSWORD);
	}
	public void ClickonNewPassword () {
		NewPassword.click();
	}
	public void SendOnNewPassword (String New_PASSWORD) {
		NewPassword.sendKeys(New_PASSWORD);
	}
	public void ClickonConfirmPassword () {
		ConfirmPassword.click();
	}
	public void SendOnConfirmPassword (String CONFIRM_PASSWORD) {
		ConfirmPassword.sendKeys(CONFIRM_PASSWORD);
	}
	public void ClickonSubmitButton () {
		Submit.click();
	}
	public String ChangePasswordSucessToastMessage () {
		String text=PasswordChangeSuccesfully.getText();
		return text;
	}
	
	
	

}
