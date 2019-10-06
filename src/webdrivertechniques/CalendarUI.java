package webdrivertechniques;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("https://www.path2usa.com/travel-companions");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(("input#travel_date"))).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("August")) {

			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		int count = driver.findElements(By.className("day")).size();

		System.out.println(count);

		// Grab common attribute//Put into list and iterate

		List<WebElement> dates = driver.findElements(By.className("day"));
		// dates.get(0).getText();

		Iterator<WebElement> abc = dates.iterator();

		while (abc.hasNext())

		{
			// abc.next();
			String str1 = abc.next().getText();

			if (str1.equalsIgnoreCase("30")) {
				abc.next().click();

				break;
			}

		}
	

		/*
		 * 
		 * for(int i=0;i<count;i++)
		 * 
		 * {
		 * 
		 * //dates.get(i).getText();
		 * 
		 * String str=driver.findElements(By.className("day")).get(i).getText();
		 * 
		 * 
		 * 
		 * if(str.equalsIgnoreCase("23")) {
		 * driver.findElements(By.className("day")).get(i).click(); break; } }
		 * 
		 * 
		 */

		// ASSIGNMENT-1
		// How TO select month from a list of 12 months and How to navigate back to
		// Years in DOB

		// ASSIGNMENT-2 Try makemytrip select date

	}

}
