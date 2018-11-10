package il.co.alljob.pageobjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SingInAllJobsPage extends BasePageAllJobs {
	@FindBy(css="#UserGuestTopBar > div.login.gatbd1 > a")
	WebElement singIn;
	@FindBy(css="#cboxLoadedContent > iframe")
	WebElement popup;
	@FindBy(css="#firstStage > div.Poster > div")
	WebElement popupX;
	@FindBy(css="#in-email-c > input")
	WebElement email;
	@FindBy(css="#in-pass-c > input")
	WebElement password;
	@FindBy(css=".front>div>button")
	WebElement btnEnter;
	
	@FindBy(id="UserTopBar")
	WebElement btnUserTopBar;
	
	@FindBy(css="#UserTopBar > div:nth-child(2)")
	WebElement btnText;
	
	@FindBy(css="#NameText")
	WebElement nameText;

	@FindBy(xpath=".//*[@id='UserTopBar']/ul/li[8]/a")
	WebElement btnMyProperties;
	
	public SingInAllJobsPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String singInBtnText() {
		return getText(singIn);
	}
	
	public String mouseOver() {
		Actions builder = new Actions(driver);
		builder.moveToElement(singIn).build().perform();
		return singIn.getCssValue("background-color");
	}
	
	//----------------------------------------DATA-------------------------------------------------------//
	
	public void singinPros(String iMail, String iPass) throws IOException  {

		click(singIn);
		fillText(email, iMail);
		fillText(password, iPass);
		click(btnEnter);
	}
	
	public String userTopBarText () throws InterruptedException {
		click(btnUserTopBar);
		return getText(btnText);

	}
	
	public String userTopBarText2() {
		return getText(nameText);
	}


	public  void popUp () {
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
	}
	
	public String UserDetailsURL() {
		click(btnMyProperties);
		String u = driver.getCurrentUrl();
		return u;
	}
	
	public String UserDetailsTitle() {
		String t = driver.getTitle();
		return t;
	}
}

