package webdrivertechniques;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("https://accounts.google.com/signup");

		driver.manage().window().maximize();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[3]/a")).click();

		System.out.println("--------------------Before switching----------------");

		System.out.println(driver.getTitle());
		
		//System.out.println(driver.getCurrentUrl());
		
		String parent1=driver.getWindowHandle();
		
		System.out.println("This will give handle or id of parent page  "+parent1);
		
		Set<String> ids = driver.getWindowHandles();

		Iterator<String> itr = ids.iterator();

		String parent = itr.next();

		String child = itr.next();

		driver.switchTo().window(child);

		System.out.println("--------------------After switching----------------");

		System.out.println(driver.getTitle());

		driver.switchTo().window(parent);

		// driver.switchTo().window(child);
		

		System.out.println("--------------------After switching back to PARENT----------------");

		System.out.println(driver.getTitle());

	}

}
