package il.co.alljob.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import il.co.alljob.pageobjects.SingupAllJobsPage;

public class SingUpTest extends BaseTest {
		
	@Test(priority=1, description="SingupPage get title test")
	public void getTitle() throws InterruptedException {
		SingupAllJobsPage singUpPage = new SingupAllJobsPage(driver);
	
		String expected = "דרושים | AllJobs לוח דרושים חינם הגדול בישראל | חיפוש עבודה";
		String actual = singUpPage.singupTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2, description="SingupPage get URL test")
	public void getURL() throws InterruptedException {
		SingupAllJobsPage singUpPage = new SingupAllJobsPage(driver);
	
		String expected = "https://www.alljobs.co.il/";
		String actual = singUpPage.singupURL();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3, description="SingupPage get [Sing Up] Button text")
	public void getBtnText() throws InterruptedException {
		SingupAllJobsPage singUpPage = new SingupAllJobsPage(driver);
		singUpPage.popUp();
		
		String expected = "הירשם";
		String actual = singUpPage.singupBtnText();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=4, description="SingupPage get button color")
	public void getButtonColor() {
	SingupAllJobsPage singUpPage = new SingupAllJobsPage(driver);
	
	String expected = "rgba(21, 178, 178, 1)";
	String actual = singUpPage.mouseOver();
	Assert.assertEquals(actual, expected);
	}
	
}
