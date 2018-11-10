package il.co.alljob.test;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import il.co.alljob.pageobjects.SingupFormPage;

public class SingUpFormTest extends BaseTest {

	@Test(priority=1, description="get title")
	public void getTitle() throws InterruptedException, IOException  {

		SingupFormPage formPage = new SingupFormPage(driver);
		formPage.newUserPage();

		String expected = "דרושים חינם | הצטרפות חינם | AllJobs";
		String actual = formPage.singupFormTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=2, description="get URL")
	public void getURL() throws InterruptedException {

		SingupFormPage formPage = new SingupFormPage(driver);

		String expected = "https://www.alljobs.co.il/Landing_page.aspx?CameFrom=NavigationBar_Register";
		String actual = formPage.singupFormURL();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=3, description="is element displayed")
	public void textDisplay() throws InterruptedException {
		
		SingupFormPage formPage = new SingupFormPage(driver);

		boolean expected = true;
		boolean actual = formPage.textIsDisplayed();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=4, description="get text color")
	public void colorText() throws InterruptedException {
		
		SingupFormPage formPage = new SingupFormPage(driver);

		String expected = "rgba(254, 139, 31, 1)";
		String actual = formPage.getPageTextColor();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=5, description="get password validation message")
	public void passValidMsg() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);
		formPage.getForm();
		formPage.validMsgPass();

		String expected = "השתמש ב: לפחות ב- 6 תווים אותיות מספרים";
		String actual = formPage.getValidMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=6, description="get cell Number validation message")
	public void telValidMsg() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);
		formPage.validMsgTel();

		String expected = "ככה מעסיקים יפנו אליך ישירות ואנחנו נעדכן אותך על משרות";
		String actual = formPage.getValidMsg();
		Assert.assertEquals(actual, expected);	
	}

	@Test(priority=7, description="get mail validation message")
	public void mailValidMsg() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);
		formPage.validMsgMail();

		String expected = "באמצעות המייל נזהה אותך ונעדכן אותך בהצעות עבודה";
		String actual = formPage.getValidMsg();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority=8, description="get page title of new user joining")
	public void newUserPageTitle() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);

		String expected = "דרושים חינם | הצטרפות חינם | AllJobs";
		String actual = formPage.newUserRegistration();
		Assert.assertEquals(actual, expected);	
		
	}
	
	@Test(priority=9, description="get URL page of new user joining")
	public void newUserPageURL() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);

		String expected = "https://www.alljobs.co.il/User/Register/LandingTNX.aspx?CameFrom=landing_page";
		String actual = formPage.newUserURL();
		Assert.assertEquals(actual, expected);		
	}
	
	@Test(priority=10, description="get text button")
	public void logoffButton() throws InterruptedException, IOException {

		SingupFormPage formPage = new SingupFormPage(driver);
		String expected = "התנתק";
		String actual = formPage.logoffBtnText();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(priority=11, description="SingupPage get [Sing Up] Button text")
	public void getBtnText() throws InterruptedException {
		SingupFormPage formPage = new SingupFormPage(driver);
		formPage.logOut();
			
		String expected = "הירשם";
		String actual = formPage.singupBtnText();
		Assert.assertEquals(actual, expected);
	}
	
}
