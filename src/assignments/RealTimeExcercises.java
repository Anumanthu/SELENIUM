package assignments;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealTimeExcercises {

	@Test
	public void realtimeExamples() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		// C:\Users\1018546\Desktop\Selenium Learning

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://qaclickacademy.com/practice.php");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).isSelected());

		String selectedOption = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText()
				.trim();

		WebElement select = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));

		select.click();

		Select selectDropDown = new Select(select);

		Thread.sleep(3000);

		selectDropDown.selectByVisibleText(selectedOption);

		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(selectedOption);

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("input#alertbtn")).click();

		Alert alert = driver.switchTo().alert();

		String alertMessage = alert.getText();

		Assert.assertTrue(alertMessage.contains(selectedOption));

		alert.accept();
		driver.quit();

	}

}
