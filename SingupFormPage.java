package il.co.alljob.pageobjects;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SingupFormPage extends BasePageAllJobs {
	@FindBy(css="#UserGuestTopBar > div:nth-child(1) > a")
	WebElement singUp;
	@FindBy(css="#cboxLoadedContent > iframe")
	WebElement popup;
	@FindBy(css="#firstStage > div.Poster > div")
	WebElement popupX;
	@FindBy(xpath = "//*[@id=\"form1\"]/div[3]/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[9]/td/strong")
	WebElement freeText;

	@FindBy(css=".OpenBlocker.UserFree")
	WebElement register;
	@FindBy(css="#cboxLoadedContent > iframe.cboxIframe")
	WebElement registerTwo;
	@FindBy(css="#email_container input")
	WebElement email;
	@FindBy(id="inputCellphone")
	WebElement cell;
	@FindBy(id="inputPassword")
	WebElement pass;
	@FindBy(id="spnPassword")
	WebElement spnPass;

	@FindBy(id="JobText")
	WebElement btnJobText;
	@FindBy(id="tdParentName_431")
	WebElement btnJobTextQA;
	@FindBy(id="tdJobChildrenChk_1533")
	WebElement cbxJobTextQA;
	@FindBy(id="SaveCategories")
	WebElement btnSaveJob;

	@FindBy(css="#RegionsContainer > div:nth-child(1)")
	WebElement btnJobRegions;
	@FindBy(id="tdJobRegionsChk_2")
	WebElement cbxbtnJobRegions;
	@FindBy(id="SaveRegions")
	WebElement btnSaveJobRegions;

	@FindBy(css="#CB_Lessons_Email > .cb-elment")
	WebElement cbx1;
	@FindBy(css="#CB_Advertise_Email > .cb-elment")
	WebElement cbx2;
	@FindBy(id="btn-submit-form")
	WebElement btnSave;

	@FindBy(css="#UserAuthTopBar > div > div.logoff.gatbd1")
	WebElement btnLogoff;
	
	@FindBy(css="#form1 tr:nth-child(18) > td")
	WebElement mouseBelongsHere;

	public SingupFormPage(WebDriver driver) {
		super(driver);
	}

	//-------------------------------------------------Test--------------------------------------------------//
	
	public void newUserPage() throws InterruptedException {
		Thread.sleep(2000);
		popUp();
		click(singUp);
	}

	public String singupFormTitle() {
		return driver.getTitle();
	}

	public String singupFormURL() {
		return driver.getCurrentUrl();
	}

	public boolean textIsDisplayed() throws InterruptedException {
		Thread.sleep(200);
		new Actions(driver).moveToElement(mouseBelongsHere).perform();
		getText(freeText);
		if(freeText.isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getPageTextColor() {
		return freeText.getCssValue("color");
	}
	
	public void getForm() throws InterruptedException {
		click(register);
		Thread.sleep(2000);
		switchTo(registerTwo);
		Thread.sleep(1000);
	}
	public void validMsgMail() throws InterruptedException, IOException {
		for(int i=1; i <= 3; i++) {	
			fillText(email,"");
		}
	}

	public void validMsgPass() throws InterruptedException, IOException {
		for(int i=1; i <= 3; i++) {	
			fillText(pass, "");
		}
	}
	
	public String getValidMsg() throws InterruptedException {
		return getText(spnPass);
	}
	

	public void validMsgTel() throws IOException, InterruptedException {
		for(int i=1; i <= 3; i++) {	
			fillText(cell, "");
		}
	}

	public String newUserRegistration() throws IOException, InterruptedException {
		Thread.sleep(1000);
		Random rad = new Random();
		for (int j=1; j<=1; j++ )
		{
			fillText(email, ("username"+rad.nextInt(10000)+"@gmail.com"));
		}
		fillText(pass, "abc123");
		fillText(cell, "0547123456");

		click(btnJobText);
		click(btnJobTextQA);
		click(cbxJobTextQA);
		click(btnSaveJob);

		click(btnJobRegions);
		click(cbxbtnJobRegions);
		click(btnSaveJobRegions);
		click(cbx1);
		click(cbx2);
		click(btnSave);

		return driver.getTitle();
	}

	public String newUserURL() throws InterruptedException {
		Thread.sleep(4000);
		return driver.getCurrentUrl();
	}

	public String logoffBtnText() {
		driver.get("https://www.alljobs.co.il");
		return getText(btnLogoff);
	}
	
	public void logOut() {
		click(btnLogoff);
	}
	
	public String singupBtnText() {
		return getText(singUp);
	}

	public  void popUp() throws InterruptedException {
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
	}
	
}
