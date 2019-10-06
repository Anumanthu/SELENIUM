package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IrritatingModelPopup {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("https://www.freecrm.com");

		driver.manage().window().maximize();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='username' and @type='text']")).sendKeys("anumanthunitt");
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys("divyasree");

		Thread.sleep(5000);

		driver.switchTo().frame("intercom-borderless-frame");

		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build()
				.perform();

		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]/span")).click();

		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).click();

	}

}
