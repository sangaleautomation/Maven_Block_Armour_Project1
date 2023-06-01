package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	
	@FindBy (xpath="//div[@class='avatar']")
	private WebElement Avatar;
	
	@FindBy (xpath="(//a[@role='menuitem'])[1]")
	private WebElement ProfileTab;
	
	@FindBy (xpath="//h2[text()='User Profile']")
	private WebElement UserProfileText;
	
	
	@FindBy (xpath="//span[@class='Dashboard ng-star-inserted']")
	private WebElement Dashboard;
	
	
	@FindBy (xpath="//span[@class='Logs ng-star-inserted']")
	private WebElement Logs;
	
	@FindBy (xpath="//span[@class='Policy ng-star-inserted']")
	private WebElement Policy;
	
	WebDriver driver1;
	public Profile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;  
	}
	public void ClickonAvtarp () {
		Avatar.click();
	}
	public void ClickonProfileTab () {
		ProfileTab.click();
	}
	public String GetTextonProfilePage () {
		String text=UserProfileText.getText();
		return text;
	}
	public void ClickonDashboard () {
		Dashboard.click();
	}
	public void ClickonLogs () {
		Logs.click();
	}
	public void ClickonPolicy () {
		Policy.click();
	}


}
