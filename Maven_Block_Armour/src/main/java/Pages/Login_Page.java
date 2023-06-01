package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	@FindBy (xpath="//div[@class='login-section__logo ng-star-inserted']//h3[text()='Log in to your account']")
	private WebElement GetTextofHomepage;
	
	@FindBy (xpath="//button[text()='Log In']")
	private WebElement Log_In_Button;
	
	
		
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		
	
	public String TextofLogInHomepage () {
		String text=GetTextofHomepage.getText();
		return text;
	}
	
	public boolean LogInButton () {
		return Log_In_Button.isDisplayed();
	}
	

}




