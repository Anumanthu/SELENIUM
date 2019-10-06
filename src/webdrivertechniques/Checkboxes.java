package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://spicejet.com/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isDisplayed());

		driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
        // VERY IMPORTANT INFO
		// CSS selector uses '*' instead of contains keyword in xpath as shown below
		//* is for regular exp used in cssselector
		//'contains' for regular exp used in xpath

		// driver.findElement(By.cssSelector("input[id*='Defense')]")).click();

		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isDisplayed());

	}
}
