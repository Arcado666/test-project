package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage2 extends LoadableComponent<LoginPage2> {

	@FindBy(xpath = "")
	public WebElement username;
	@FindBy(xpath = "")
	public WebElement password;
	@FindBy(xpath = "")
	public WebElement loginbutton;
	
	
	public LoginPage2(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

}
