package webdrivertechniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions2ClassExample {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();

	//WebDriver driver=new FirefoxDriver();

	driver.get("http://www.amazon.com");
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	

	
	driver.manage().window().maximize();
	
	Thread.sleep(2000);
	
	
	
	
	
	WebElement e1=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
	

	//WebElement e2=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	
	
	Actions ac= new Actions(driver);
	
	
	ac.moveToElement(e1).build().perform();
	
	
	WebDriverWait d=new WebDriverWait(driver,10);
	
	
	WebElement e3=driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"));
	
	//d.until(ExpectedConditions.visibilityOf(e3));
	
	d.until(ExpectedConditions.elementToBeClickable(e3));
	
	
	e3.click();
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("#ap_email")).sendKeys("anumanthunitt@gmail.com");
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@id='continue']")).click();

	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("#ap_password")).sendKeys("sandhya.143");

	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	
	WebElement e4=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[@class='nav-line-2']"));
	
	d.until(ExpectedConditions.elementToBeClickable(e4));
	
	ac.moveToElement(e4).build().perform();
	  
	driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click(); //text() function example
		

	}

}
