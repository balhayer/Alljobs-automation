package il.co.alljob.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailsEnterPage extends BasePageAllJobs {
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
	
	@FindBy(xpath=".//*[@id='UserTopBar']/ul/li[8]/a")
	WebElement btnMyProperties;
	
	@FindBy(css=".MT0.MB8>a")
	List<WebElement> btnCV;



	public UserDetailsEnterPage(WebDriver driver) {
		super(driver);
	}

	//----------------------------------------DATA-------------------------------------------------------//

	public void singinPros(String iMail, String iPass) throws IOException {
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
		
		click(singIn);
		fillText(email, iMail);
		fillText(password, iPass);
		
		click(btnEnter);
		click(btnUserTopBar);
		click(btnMyProperties);
	}
	
	public int prop() {
		return btnCV.size() - 1;
	}
	
	public String getCVURL() {
		click(btnCV.get(2));
		return driver.getCurrentUrl();
	}
	
	public String getCVTitle() {
		return driver.getTitle();
	}
}

