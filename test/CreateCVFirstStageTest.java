package il.co.alljob.test;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import il.co.alljob.pageobjects.CreateCVFirstStagePage;
import il.co.alljob.utils.Excel;

public class CreateCVFirstStageTest extends BaseTest {

	@Test(priority=1)
	public void login () throws IOException {
		CreateCVFirstStagePage singin = new CreateCVFirstStagePage(driver);
		singin.singinPros("msdv.tech@gmail.com", "o621qzLrqw");
	}

	@Test(priority=2, dataProvider="getDataFromExcel")
	public void fillPersonalData(String iFName, String iLName, String iMail, String iCell, String iCity, String iPhone, String iCitizenship) throws IOException, InterruptedException {

		CreateCVFirstStagePage stageOne = new CreateCVFirstStagePage(driver);
		stageOne.iPersonalInfo(iFName, iLName, iMail, iCell, iCity, iPhone, iCitizenship);
		stageOne.moreOptions();
	}

	@Test(priority=3) 
	public void fillPersonalData2() throws InterruptedException, IOException {
		CreateCVFirstStagePage stageOne = new CreateCVFirstStagePage(driver);
		stageOne.educationArea("קורס אוטומציה QA", "תעודת סיום", "אוטומציה QA");
		
		String expected = "הנתונים בשלב 1 נשמרו בהצלחה.";
		String actual = stageOne.successfulMessage();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getDataFromExcel(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "iPersonalInfo");
	}

}
