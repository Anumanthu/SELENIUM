package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasicMethods {

	public static void main(String[] args) {

		// System.out.println("This is my first class");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		
		//driver.get("www.google.com"); WebDriverException if you don't pass https
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		System.out.println("The Title of Google page is       " + driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource());

		driver.get("https:\\yahoo.com");

		driver.navigate().back();
		
		//driver.navigate().refresh();
		
		
		

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());


		driver.navigate().forward();
		driver.navigate().to("https:\\yahoo.com");

		// driver.close();//it closes the current open browser

		// driver.quit(); //It closes all browsers opened by selenium script

		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("anumanthunitt@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Sandhya.143");

		// driver.findElement(By.linkText("Forgotten account?")).click();
		// driver.findElement(By.partialLinkText("Forgotton"));

		driver.findElement(By.id("loginbutton")).click(); //driver.findElement(By.id("loginbutton")).submit(); both are same only
		driver.findElement(By.id("loginbutton")).sendKeys(Keys.F5);// To Refresh the page
		
		driver.findElement(By.id("loginbutton")).clear();
		driver.findElement(By.id("loginbutton")).getTagName();
		
		driver.findElement(By.id("loginbutton")).getText();
		

	}

}
