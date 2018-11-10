package il.co.alljob.pageobjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SingupAllJobsPage extends BasePageAllJobs {
	@FindBy(css="#UserGuestTopBar > div:nth-child(1) > a")
	WebElement singUp;
	@FindBy(css="#cboxLoadedContent > iframe")
	WebElement popup;
	@FindBy(css="#firstStage > div.Poster > div")
	WebElement popupX;
	@FindBy(css=".OpenBlocker.UserFree")
	WebElement register;

	@FindBy(css="#cboxLoadedContent > iframe.cboxIframe")
	WebElement registerTwo;
	@FindBy(css="#email_container input")
	WebElement email;
	@FindBy(id="inputCellphone")
	WebElement iCell;
	@FindBy(id="inputPassword")
	WebElement pass;

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
	
	@FindBy(css="#confirm-maling-list .title")
	WebElement errorMesage;

	public SingupAllJobsPage(WebDriver driver) {
		super(driver);
	}
	
	//-------------------------------------------------Tests-------------------------------------------//
	
	public String singupTitle() {
		String t = driver.getTitle();
		return t;
	}
	
	public String singupURL() {
		String u = driver.getCurrentUrl();
		return u;
	}
	
	public String singupBtnText() {
		return getText(singUp);
	}
	
	public String mouseOver() {
		Actions builder = new Actions(driver);
		builder.moveToElement(singUp).build().perform();
		return singUp.getCssValue("background-color");
	}
	
	//-------------------------------------------------End of Tests-------------------------------------------//
	
	public void singUpStart() throws InterruptedException {
		popUp();
		click(singUp);
		click(register);
		driver.switchTo().defaultContent();
	}

	public void singUpEnd(String newMail, String cell, String iPass) throws InterruptedException, IOException {
		driver.switchTo().frame(registerTwo);
		Thread.sleep(2000);

		fillText(email, newMail);
		fillText(pass, iPass);
		fillText(iCell, cell);
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
	}

	public  void popUp() throws InterruptedException {
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
	}
}
