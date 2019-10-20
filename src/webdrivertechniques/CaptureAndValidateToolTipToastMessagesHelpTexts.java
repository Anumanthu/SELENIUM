package webdrivertechniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CaptureAndValidateToolTipToastMessagesHelpTexts {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Jasmine Morgan");

		driver.findElement(By.id("systemUser_userName")).sendKeys("Anumanthunitt");
		driver.findElement(By.id("systemUser_userName")).sendKeys(Keys.TAB);

		Thread.sleep(5);

		// driver.findElement(By.id("btnSave")).click();
		Actions ac = new Actions(driver);

		ac.doubleClick(driver.findElement(By.cssSelector("input.addbutton"))).build().perform();
		;

		driver.findElement(By.cssSelector("input.addbutton")).click();

		// VVV IMP ****The xpath of ToastMessage goes away with in a second...so it is
		// difficult to inspect the element
		// To capture this kind of messages press 'F8' or 'Function F8' key it will
		// pause the debugger on the internet then capture the xpath/webElement
		// div[@class='message success fadable']********/

		String ToastMessage = driver.findElement(By.xpath("//div[@class='message success fadable']")).getText();

		System.out.println("The captured message is " + ToastMessage);

		Assert.assertEquals("Successfully Saved\r\n" + "Close", ToastMessage,
				"Actual & Expected Messages are not equal");

	}

}
