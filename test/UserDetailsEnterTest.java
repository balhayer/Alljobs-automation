package il.co.alljob.test;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import il.co.alljob.pageobjects.UserDetailsEnterPage;

public class UserDetailsEnterTest extends BaseTest {

	
	
	@Test(priority=1, description="get number of links in properties menu")
	public void UserDetails() throws IOException {
		
		UserDetailsEnterPage singin = new UserDetailsEnterPage(driver);
		singin.singinPros("msdv.tech@gmail.com", "o621qzLrqw");
		
		int expected = 13;
		int actual = singin.prop();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2, description="get new page URL")
	public void getCVURL() throws IOException {
		UserDetailsEnterPage singin = new UserDetailsEnterPage(driver);
		
		String expected = "https://www.alljobs.co.il/%D7%9B%D7%AA%D7%99%D7%91%D7%AA_%D7%A7%D7%95%D7%A8%D7%95%D7%AA_%D7%97%D7%99%D7%99%D7%9D/";
		String actual = singin.getCVURL();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3, description="get new page Title")
	public void getCVtitle() throws IOException {
		UserDetailsEnterPage singin = new UserDetailsEnterPage(driver);
		
		String expected = "כתיבת קורות חיים | AllJobs";
		String actual = singin.getCVTitle();
		Assert.assertEquals(actual, expected);
	}
}
