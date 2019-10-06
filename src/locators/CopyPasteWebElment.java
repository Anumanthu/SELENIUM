package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CopyPasteWebElment {

	@Test
	public void copyPaste() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("https://www.google.co.in/");

		// String homepage="https://www.facebook.com";

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("English");

		driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);

		// driver.findElement(By.xpath("//div[@class='kno-ecr-pt kno-fb-ctx
		// sKbx2c']//span[contains(text(),'English language')]")).sendKeys(Keys.COMMAND+
		// "c");

		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'English Language')]"))).clickAndHold()
				.sendKeys(Keys.chord(Keys.CONTROL, Keys.getKeyFromUnicode('c')));
		// div[@class='kno-ecr-pt kno-fb-ctx sKbx2c']//span[contains(text(),'English
		// language')]
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.cssSelector("input[name='q']")))
				.sendKeys(Keys.chord(Keys.CONTROL, Keys.getKeyFromUnicode('a')));
		Thread.sleep(2000);

		ac.moveToElement(driver.findElement(By.cssSelector("input[name='q']")))
				.sendKeys(Keys.chord(Keys.CONTROL, Keys.getKeyFromUnicode('v')));

	}
}
