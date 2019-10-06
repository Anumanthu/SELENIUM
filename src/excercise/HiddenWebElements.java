package excercise;

import java.util.List;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenWebElements {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

		driver.manage().window().maximize();

		Thread.sleep(3000);

		// To initialize js object
		// JavascriptExecutor js = (JavascriptExecutor)driver;

		List<WebElement> ele = driver.findElements(By.xpath("//input[@id='male']"));

		int count = ele.size();

		// js.executeScript("document.getElementById(\"male\").click();");

		// driver.findElement(By.xpath("//input[@id='male']")).click();

		// driver.findElement(By.xpath("//input[@id='female']")).click();

		for (int i = 0; i < count; i++) {
			int x = ele.get(i).getLocation().getX();

			if (x != 0) {
				driver.findElements(By.xpath("//input[@id='male']")).get(i).click();

			}
		}

	}

}
