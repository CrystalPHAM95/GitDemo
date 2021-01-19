import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public String driverPath = "C:\\\\Selenium-install\\\\chromedriver_win32\\\\chromedriver.exe";
	public WebDriver driver;
	public String expectedTitle = null;
	public String actualTitle = null;

	/*
	 * @BeforeTest public void f() { System.out.println("launching chrome browser");
	 * System.setProperty("webdriver.chrome.driver", driverPath); driver = new
	 * ChromeDriver(); driver.get(baseUrl); String expectedTitle =
	 * "Welcome: Mercury Tours"; String actualTitle = driver.getTitle();
	 * Assert.assertEquals(actualTitle, expectedTitle); }
	 * 
	 * @Test public void test() { System.out.println("Hello"); }
	 * 
	 * @AfterTest public void terminateBrowser() throws InterruptedException {
	 * Thread.sleep(2000); driver.close(); }
	 */
	@BeforeTest
	public void navegateToWeb() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		expectedTitle = "Welcome: Mercury Tours";
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void register() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("SUPPORT")).click();
		expectedTitle = "Under Construction: Mercury Tours";
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1)
	public void goBackHome() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
