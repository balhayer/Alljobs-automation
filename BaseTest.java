package il.co.alljob.test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import il.co.alljob.utils.Utils;

public abstract class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.alljobs.co.il/");
		driver.get(Utils.readProp("url"));
	}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}



	
}
