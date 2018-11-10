package il.co.alljob.test;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import il.co.alljob.pageobjects.SingupFormNegativePage;
import il.co.alljob.utils.Excel;

public class SingUpFormNegiativeTest extends BaseTest {

	@Test(priority=1) 
	public void loginPros() throws InterruptedException {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);
		formPage.goToForm();
	}

	@Test(priority=2, dataProvider="getDataFromExcel")
	public void mailFailedMessage(String mail) throws IOException, InterruptedException {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);
		formPage.negativeMail(mail);

		String expected = "כתובת המייל אינה תקינה";
		String actual = formPage.emailInvalidMessage();
		Assert.assertEquals(actual, expected);		
	}

	@Test(priority=3, dataProvider="getDataFromExcel2")
	public void cellFailedMessage(String cell) throws IOException, InterruptedException {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);
		formPage.negativeCell(cell);

		String expected = "מספר הטלפון הנייד לא תקין ☹";
		String actual = formPage.cellInvalidMessage();
		Assert.assertEquals(actual, expected);		
	}

	@Test(priority=4, dataProvider="getDataFromExcel3")
	public void invalidPassword(String pass) throws IOException, InterruptedException {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);
		formPage.negativPassword(pass);

		String expected = "<img class=\"six-letters\" src=\"/SignIn/images/V-Grey.png\" width=\"12\" height=\"11\" border=\"0\">";
		String actual = formPage.getPasswordResponse();
		Assert.assertEquals(actual, expected);	
	}

	@Test(priority=5)
	public void getCategoriesMessage() {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);

		String expected = "לא חבל? לא ציינת שום תפקיד";
		String actual = formPage.getCategoriesMsg();
		Assert.assertEquals(actual, expected);	
	}

	@Test(priority=6)
	public void getRegionMessage() {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);

		String expected = "בטח יש לך איזור עבודה מועדף. מהו?";
		String actual = formPage.getRegionMsg();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority=7)
	public void mailExistsMessage() throws IOException, InterruptedException {
		SingupFormNegativePage formPage = new SingupFormNegativePage(driver);

		String expected = "הי, כבר יש לנו את המייל שלך☺ לחץ כאן להזדהות.";
		String actual = formPage.emailExistsMessage("ascola@mail.ru");
		Assert.assertEquals(actual, expected);		
	}


	//---------------------------------------------DATA PROVIDER----------------------------------------------------------------//	

	@DataProvider
	public Object[][] getDataFromExcel(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "InvalidMail");
	}

	@DataProvider
	public Object[][] getDataFromExcel2(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "InvalidCell");
	}

	@DataProvider
	public Object[][] getDataFromExcel3(){
		Excel excel = new Excel();
		return excel.getTableArray(System.getProperty("user.dir") + "\\src\\il\\co\\alljob\\data\\input.xlsx", "InvalidPass");
	}


}
