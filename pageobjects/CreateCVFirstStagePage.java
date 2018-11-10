package il.co.alljob.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateCVFirstStagePage extends BasePageAllJobs {
	@FindBy(css=".FloatR #txtFirstName")
	WebElement fName;
	@FindBy(id="txtFamilyName")
	WebElement lName;
	@FindBy(id="txtEmail")
	WebElement email;
	@FindBy(id="txtCellPhone")
	WebElement cellNum;
	@FindBy(id="txtCityLocation")
	WebElement city;
	@FindBy(id="PrefixCellPhone")
	WebElement btnPrefixCellPhone;
	@FindBy(css="#PrefixCellPhone > option:nth-child(4)") 
	WebElement prefixCellPhone;
	@FindBy(id="slcBirthYear")
	WebElement btnYearOfBirth;
	@FindBy(css="#slcBirthYear > option:nth-child(26)")
	WebElement yearOfBirth;
	@FindBy(css="#divContainerDDLs > div >div:nth-child(1)>div:nth-child(2) >div:nth-child(1)")
	WebElement btnMoreOptions;
	@FindBy(id="txtPhone")
	WebElement phoneNum;
	@FindBy(id="PrefixPhone")
	WebElement btnPrefixPhone; 
	@FindBy(css="#PrefixPhone > option:nth-child(2)")
	WebElement PrefixPhone;
	@FindBy(id="ddlFamiliyStatus")
	WebElement btnFamiliyStatus;
	@FindBy(css="#ddlFamiliyStatus > option:nth-child(4)")
	WebElement familiyStatus;
	
	@FindBy(id="chkParentLicense")
	WebElement chbDrivingLicense;
	@FindBy(id="aLicense")
	WebElement btnDrivingLicenseType;
	@FindBy(id="chkChildLicens_1")
	WebElement drivingLicenseType;
	@FindBy(id="txtEducationalInstitutionName")
	WebElement myAcademia;
	@FindBy(id="txtDegreeName")
	WebElement certificateDetails;
	@FindBy(id="txtSpecialty")
	WebElement specialty;
	@FindBy(id="slcFromSchoolYear")
	WebElement btnStartYear2017;
	@FindBy(css="#slcFromSchoolYear > option:nth-child(3)")
	WebElement startYear2017;
	@FindBy(id="slcToSchoolYear")
	WebElement btnEndYear2018;
	@FindBy(css="#slcToSchoolYear > option:nth-child(2)")
	WebElement endYear2018;
	@FindBy(id="divBtnContinu")
	WebElement nextPage;
	@FindBy(css="div.T14.Red.PT10")
	WebElement errMes;
	@FindBy(css="#divFooter > footer > div.cols > dl:nth-child(5) > dt")
	WebElement mouseBelongsHere;
	
	@FindBy(css="#UserGuestTopBar > div.login.gatbd1 > a")
	WebElement singIn;
	@FindBy(css="#cboxLoadedContent > iframe")
	WebElement popup;
	@FindBy(css="#firstStage > div.Poster > div")
	WebElement popupX;
	@FindBy(css="#in-email-c > input")
	WebElement eMail;
	@FindBy(css="#in-pass-c > input")
	WebElement password;
	@FindBy(css=".front>div>button")
	WebElement btnEnter;
	@FindBy(xpath=".//*[@id='UserTopBar']/ul/li[8]/a")
	WebElement btnMyProperties;
	@FindBy(css=".MT0.MB8>a")
	List<WebElement> btnCV;
	@FindBy(id="UserTopBar")
	WebElement btnUserTopBar;
	@FindBy(id="txtCitizenship")
	WebElement citizenShip;
	
	@FindBy(css="#Stage2 > div.Green.T14.B.PB30.PR10")
	WebElement msgFirstStageSuccessful;

	public CreateCVFirstStagePage(WebDriver driver) {
		super(driver);
	}

	
	//-------------------------------------------------Tests-------------------------------------------//
	
	
	
	//----------------------------------------DATA-------------------------------------------------------//
	
	public void singinPros(String iMail, String iPass) throws IOException  {
		driver.switchTo().frame(popup);
		click(popupX);
		driver.switchTo().defaultContent();
		click(singIn);
		fillText(eMail, iMail);
		fillText(password, iPass);
		click(btnEnter);
		click(btnUserTopBar);
		click(btnMyProperties);
		click(btnCV.get(2));
	}
	
	public void iPersonalInfo (String iFName, String iLName, String iMail, String iCell, String iCity, String iPhone, String iCitizenship) throws InterruptedException, IOException {
		fillText(fName, iFName); 
		fillText(lName, iLName); 
		fillText(email, iMail);

		click(btnPrefixCellPhone); 
		click(prefixCellPhone); 
		fillText(cellNum, iCell);

		fillText(city, iCity); 
		click(btnYearOfBirth);
		click(yearOfBirth);
		
		click(btnPrefixCellPhone);
		click(PrefixPhone);
		fillText(phoneNum, iPhone);
		
		fillText(citizenShip, iCitizenship);
		click(btnFamiliyStatus);
		click(familiyStatus);


	}
	
	public void moreOptions() {
		click(btnMoreOptions);
		click(chbDrivingLicense);
		click(btnDrivingLicenseType);

		click(drivingLicenseType);
		click(btnMoreOptions);
	}

	public void educationArea(String iCourse, String iCertificate, String iQA) throws InterruptedException, IOException {

		new Actions(driver).moveToElement(myAcademia).perform();

		fillText(myAcademia, iCourse);
		fillText(certificateDetails, iCertificate);
		fillText(specialty, iQA);

		click(btnStartYear2017);
		click(startYear2017);
		click(btnEndYear2018);
		click(endYear2018);

		btnNextPage();
	}

	public void btnNextPage ( ) throws InterruptedException {
		//scroll page to element
		new Actions(driver).moveToElement(mouseBelongsHere).perform();
		click(nextPage);
	}
	
	public String successfulMessage() {
		String m = getText(msgFirstStageSuccessful);
		return m;
	}



}

