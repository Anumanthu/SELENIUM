package webdrivertechniques;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HashMapExamples {

	public WebDriver driver;
	public String logincredentials;
	public String getusercredentials[];

	/*
	 * @BeforeMethod public void intializedriver() throws Exception {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
	 * 
	 * driver=new ChromeDriver();
	 * 
	 * //WebDriver driver=new FirefoxDriver();
	 * 
	 * driver.get("https://www.freecrm.com");
	 * 
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * }
	 */

	@Test
	public void loginWithAdmin() throws Exception {

		logincredentials = LoginCredentils.getLogincredentials().get("admin");

		getusercredentials = logincredentials.split("-");
		System.out.println("Username--->" + getusercredentials[0]);

		System.out.println("Paaword--->" + getusercredentials[1]);

		driver.findElement(By.xpath("//input[@name='username' and @type='text']")).sendKeys(getusercredentials[0]);
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys(getusercredentials[1]);

		Thread.sleep(5000);

		driver.switchTo().frame("intercom-borderless-frame");

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build()
				.perform();

		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]/span")).click();

		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();

		// Do Exercise ----After Login select month Dropdown Using Month HashMap

		//
		//
		// How to refresh page
		/// driver.navigate().refresh();

	}

	@Test
	public void loginWithCustomer() throws Exception {

		logincredentials = LoginCredentils.getLogincredentials().get("customer");

		getusercredentials = logincredentials.split("-");

		System.out.println("Username--->" + getusercredentials[0]);

		System.out.println("Paaword--->" + getusercredentials[1]);

		driver.findElement(By.xpath("//input[@name='username' and @type='text']")).sendKeys(getusercredentials[0]);
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys(getusercredentials[1]);

		Thread.sleep(5000);

		driver.switchTo().frame("intercom-borderless-frame");

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build()
				.perform();

		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]/span")).click();

		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

class LoginCredentils {
	public static HashMap<String, String> getLogincredentials() {

		HashMap<String, String> credentials = new HashMap<String, String>();

		credentials.put("admin", "naveenk-test@123");
		credentials.put("customer", "naveenk1-test@123");
		
		return credentials;

	}

}

class GetMonth {

	public static HashMap<Integer, String> getMonth() {

		HashMap<Integer, String> getmonth = new HashMap<Integer, String>();

		getmonth.put(1, "January");
		getmonth.put(2, "Febravery");
		getmonth.put(3, "March");
		getmonth.put(4, "April");
		getmonth.put(5, "May");
		getmonth.put(6, "June");
		getmonth.put(7, "July");
		getmonth.put(8, "August");
		getmonth.put(9, "September");
		getmonth.put(10, "October");
		getmonth.put(11, "November");
		getmonth.put(12, "December");

		return getmonth;

	}
}
