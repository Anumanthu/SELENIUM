package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassExamples {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("http://www.amazon.com");
		//driver.get("www.amazon.com"); WebDriverException if you don't pass https

		driver.manage().window().maximize();

		Thread.sleep(2000);

		WebElement e1 = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

		WebElement e2 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		Actions ac = new Actions(driver);
	

		ac.moveToElement(e2).click().keyDown(Keys.SHIFT).sendKeys("heLLo").doubleClick().build().perform();
		// ac.moveToElement(e2).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		e2.sendKeys(Keys.DELETE);

		ac.keyDown(Keys.SHIFT).sendKeys("Wonderful").build().perform();
		
		//To Drag AND Drop
		//ac.dragAndDrop(e1, e2).build().perform();

		// VERY IMP --->To right click on webelement--Context click

		 ac.moveToElement(e2).contextClick().build().perform();
		//ac.contextClick(e1).build().perform();//right click on specific on Webelement


		ac.moveToElement(e1).build().perform();
		
	}

}
