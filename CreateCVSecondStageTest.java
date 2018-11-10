package il.co.alljob.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import il.co.alljob.pageobjects.CreateCVFirstStagePage;
import il.co.alljob.pageobjects.CreateCVSecondStagePage;
import il.co.alljob.utils.Excel;

public class CreateCVSecondStageTest extends BaseTest {	
	
	@Test(priority=1, dataProvider="getDataFromExcel")
	public void login(String iFName, String iLName, String iMail, String iCell, String iCity, String iPhone, String iCitizenship) throws IOException, InterruptedException {
		CreateCVFirstStagePage singin = new CreateCVFirstStagePage(driver);
		singin.singinPros("msdv.tech@gmail.com", "o621qzLrqw");
		
		CreateCVFirstStagePage stageOne = new CreateCVFirstStagePage(driver);
		stageOne.iPersonalInfo(iFName, iLName, iMail, iCell, iCity, iPhone, iCitizenship);
		stageOne.moreOptions();
		stageOne.educationArea("קורס אוטומציה QA", "תעודת סיום", "אוטומציה QA");
	}
	
	@Test(priority=2, dataProvider="getDataFromExcel2")
	public void fillPersonalData2(String companyName, String jobPartName, String jobDescriptionArea, String militaryJobArea) throws IOException, InterruptedException {
		
		CreateCVSecondStagePage stageTwo = new CreateCVSecondStagePage(driver);
		stageTwo.workExperience(companyName, jobPartName, jobDescriptionArea);
		stageTwo.IDF(militaryJobArea);
		int expected = 12;
		int actual = stageTwo.textArea();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3, dataProvider="getDataFromExcel3")
	public void fillPersonalData3(String appNameArea, String lang1, String lang2) throws InterruptedException, IOException {
		CreateCVSecondStagePage stageTwo = new CreateCVSecondStagePage(driver);
		stageTwo.computerApplications(appNameArea);
		stageTwo.languages(lang1, lang2);
		stageTwo.createCV();
	}
	
	@DataProvider
	public Object[][] getDataFromExcel(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "iPersonalInfo");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel2(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "iPersonalInfo2");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel3(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "iPersonalInfo3");
	}
	


}
