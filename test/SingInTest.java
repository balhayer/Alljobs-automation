package il.co.alljob.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import il.co.alljob.pageobjects.SingInAllJobsPage;

public class SingInTest extends BaseTest {

	@Test(priority=1, description="SingIn Page get [SingIn] Button text")
	public void getBtnText() throws InterruptedException {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);
		singInPage.popUp();

		String expected = "התחבר";
		String actual = singInPage.singInBtnText();
		Assert.assertEquals(actual, expected);	
	}

	@Test(priority=2, description="SingIn Page get [SingIn] button color")
	public void getButtonColor() {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);

		String expected = "rgba(21, 178, 178, 1)";
		String actual = singInPage.mouseOver();
		Assert.assertEquals(actual, expected);
	}

	@Test(priority=3, description="SingIn with registered user and get button text")
	public void singinText() throws IOException, InterruptedException {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);
		singInPage.singinPros("msdv.tech@gmail.com", "o621qzLrqw");

		String expected = "ברוך שובך";
		String actual = singInPage.userTopBarText();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=4, description="get registered user name")
	public void singinText2() throws IOException, InterruptedException {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);

		String expected = "אלכס";
		String actual = singInPage.userTopBarText2();
		Assert.assertEquals(actual, expected);
	} 
	
	@Test(priority=5, description="get Details page URL")
	public void detailsPageURL() throws IOException, InterruptedException {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);

		String expected = "https://www.alljobs.co.il/UserChangeDetails.aspx";
		String actual = singInPage.UserDetailsURL();
		Assert.assertEquals(actual, expected);
	} 
	
	@Test(priority=6, description="get Details page Title")
	public void detailsPageTitle() throws IOException, InterruptedException {
		SingInAllJobsPage singInPage = new SingInAllJobsPage(driver);

		String expected = "הגדרות שלי";
		String actual = singInPage.UserDetailsTitle();
		Assert.assertEquals(actual, expected);
	} 

}
