package il.co.alljob.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateCVSecondStagePage extends BasePageAllJobs {
	@FindBy(id="txtCompanyName")
	WebElement companyName;
	@FindBy(id="txtJobPartName")
	WebElement jobPartName;
	@FindBy(id="slcStartJob")
	WebElement btnStartJob;
	@FindBy(css="#slcStartJob > option:nth-child(2)")
	WebElement startJob2014;
	@FindBy(id="slcEndJob")
	WebElement btnEndJob;
	@FindBy(css="#slcEndJob > option:nth-child(2)")
	WebElement endJob;
	@FindBy(id="txtJobsDetailsFake")
	WebElement jobDescriptionArea;
	@FindBy(id="txtJobsDetails")
	WebElement jobDescriptionArea2;
	@FindBy(id="txtMilitaryRoleDefinition")
	WebElement militaryJobArea;
	@FindBy(id="slcFromMilitaryYear")
	WebElement btnArmyStart;
	@FindBy(css="#slcFromMilitaryYear > option:nth-child(20)")
	WebElement armyStart;
	@FindBy(id="slcToMilitaryYear")
	WebElement btnArmyEnd;
	@FindBy(css="#slcToMilitaryYear > option:nth-child(18)")
	WebElement armyEnd;
	@FindBy(id="txtAppNameFake")
	WebElement appNameArea;
	@FindBy(id="txtAppName")
	WebElement appNameArea2;
	@FindBy(id="txtLanguagesName")
	WebElement languagesNameArea1;
	@FindBy(css="#slcLevel > option:nth-child(2)")  
	WebElement btnLanguagesLevel1;
	@FindBy(css="#slcLevel > option:nth-child(5)")  
	WebElement btnLanguagesLevel2;
	@FindBy(css="#divLinkLanguageAndApp > a > span")
	WebElement btnLanguagesAdd;
	@FindBy(id="divBtnCreateCV")
	WebElement btnCreateCV;
	@FindBy(css="#CVWizardBox > div:nth-child(5) > a")
	WebElement btnCreateCV2;
	
	@FindBy(xpath="/html/body/div[9]/div[3]/div/div[3]")
	WebElement btnDownloadCV;
	
	@FindBy(css="#divFooter > footer > div.cols > dl:nth-child(5) > dt")
	WebElement mouseBelongsHere;

	public CreateCVSecondStagePage(WebDriver driver) throws IOException {
		super(driver);
	}

	//----------------------------------------DATA-------------------------------------------------------//
	
	public void workExperience(String iCompany, String iJobPart, String iJobDescription) throws IOException {

		fillText(companyName, iCompany);
		fillText(jobPartName, iJobPart);

		click(btnStartJob);
		click(startJob2014);

		click(btnEndJob);
		click(endJob);

		click(jobDescriptionArea);
		fillText(jobDescriptionArea2, iJobDescription);
	}

	public void IDF(String militaryJob) throws InterruptedException {
	
		fillText2(militaryJobArea, militaryJob);
		click(btnArmyStart);
		click(armyStart);
		click(btnArmyEnd);
		click(armyEnd);
	}

	public void computerApplications(String appName) throws InterruptedException, IOException {

		click(appNameArea);
		fillText(appNameArea2, appName);
	}

	public void languages(String lang1, String lang2) throws IOException {

		fillText(languagesNameArea1, lang1);
		click(btnLanguagesLevel1);
		click(btnLanguagesAdd);
		fillText(languagesNameArea1, lang2);
		click(btnLanguagesLevel2);
	}
	
	public int textArea() {
		 ArrayList<WebElement> area = new ArrayList<WebElement>();
		 area.add(companyName);
		 area.add(jobPartName);
		 
		 area.add(jobDescriptionArea2);
		 area.add(btnStartJob);
		 area.add(btnEndJob);
		 area.add(militaryJobArea);
		 area.add(jobDescriptionArea);
		 area.add(btnArmyStart);
		 area.add(btnArmyEnd);
		 area.add(appNameArea);
		 area.add(languagesNameArea1);
		 area.add(btnLanguagesLevel1);
		 int reval = area.size();
		 return reval;
	}

	public void createCV() throws InterruptedException {
		
//		scroll page to element
		new Actions(driver).moveToElement(mouseBelongsHere).perform();

		click(btnCreateCV);
		Thread.sleep(3000);
		click(btnCreateCV2);
		Thread.sleep(1000);
		click(btnDownloadCV);
	}
	
}

