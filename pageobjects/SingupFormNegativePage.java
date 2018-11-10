package il.co.alljob.pageobjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingupFormNegativePage extends BasePageAllJobs {
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
	WebElement cell;
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

	@FindBy(css="#UserAuthTopBar > div > div.logoff.gatbd1")
	WebElement btnLogoff;
	@FindBy(id="email-valid-msg")
	WebElement emailInvalidMsg;
	@FindBy(id="cellphone-valid-msg")
	WebElement cellInvalidMsg;
	@FindBy(css="#spnPassword > img.six-letters")
	WebElement passwordCondition;
	@FindBy(id="MsgCategories")
	WebElement msgCat;
	@FindBy(id="MsgRegions")
	WebElement msgReg;

	public SingupFormNegativePage(WebDriver driver) {
		super(driver);
	}

	//-------------------------------------------------Tests-------------------------------------------//
	
	public void goToForm() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
		
		click(singUp);
		click(register);
		switchTo(registerTwo);
		Thread.sleep(2000);
	}
	
	public void negativeMail(String iMail) throws InterruptedException, IOException {
		fillText(email, iMail);
		click(btnSave);
	}

	public String emailInvalidMessage() throws IOException, InterruptedException {
		Thread.sleep(100);
		return getText(emailInvalidMsg);
	}
	
	public void negativeCell(String iCell) throws IOException {
		fillText(cell, iCell);
		click(btnSave);
	}
	
	public String cellInvalidMessage() throws IOException, InterruptedException {
		Thread.sleep(100);
		return getText(cellInvalidMsg);
	}
	
	public String emailExistsMessage(String iMail) throws IOException, InterruptedException {
		fillText(email, iMail);
		click(btnSave);
		Thread.sleep(1000);
		return getText(emailInvalidMsg);
	}
	
	public void negativPassword(String iPass) throws IOException {
		fillText(pass, iPass);
	}

	public String getPasswordResponse() {
		return passwordCondition.getAttribute("outerHTML");
	}
	
	public String getCategoriesMsg() {
		return msgCat.getText();
	}
	
	public String getRegionMsg() {
		return msgReg.getText();
	}

	//-------------------------------------------------End of Tests-------------------------------------------//

	public  void popUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
	}

}
