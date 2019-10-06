package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class DropdownsEditBoxesErrors {

	@BeforeTest
	public void bforetest() {
		System.out.println("Before test");
	}

	@Test
	public void assignment() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		// C:\Users\1018546\Desktop\Selenium Learning

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");

		driver.manage().window().maximize();
		WebElement adults = driver.findElement(By.xpath("//select[@id='Adults']"));

		Select s1 = new Select(adults);

		s1.selectByValue("2");

		WebElement childs = driver.findElement(By.cssSelector("#Childrens"));

		s1 = new Select(childs);

		s1.selectByIndex(1);

		WebElement infants = driver.findElement(By.id("Infants"));

		s1 = new Select(infants);

		s1.selectByVisibleText("1");

		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();

		WebElement cls = driver.findElement(By.xpath("//select[@name='class']"));

		s1 = new Select(cls);

		s1.selectByVisibleText("Business");

		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("ind");
		
	

		int count = driver.findElements(By.xpath("//a[contains(@id,'ui-id')]")).size();
		int loopcount = 1;

		WebElement Airline = driver.findElement(By.xpath("//a[contains(@id,'ui-id')]"));
		
		Thread.sleep(5000);

		for (int i = 0; i < count; i++) {
			if (Airline.getText().equalsIgnoreCase("IndiGo (6E)")) {
				Airline.click();
				break;
			}

			loopcount++;

			Airline.sendKeys(Keys.ARROW_DOWN);

			if (loopcount > 15)
				break;

		}

		driver.findElement(By.cssSelector("#SearchBtn")).sendKeys(Keys.ENTER); // instead of using click

		// div[@id='homeErrorMessage']

		String str = driver.findElement(By.id("homeErrorMessage")).getText();

		System.out.println("This is the error message " + str);

	}

}
