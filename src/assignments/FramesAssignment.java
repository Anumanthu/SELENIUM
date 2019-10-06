package assignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesAssignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		// C:\Users\1018546\Desktop\Selenium Learning

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/");

		driver.manage().window().maximize();

		driver.findElement(By.linkText("Nested Frames")).click();

		WebElement ele = driver.findElement(By.xpath("//frame[@name='frame-top']"));

		WebDriverWait wd = new WebDriverWait(driver, 20);

		wd.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
		

		//driver.switchTo().frame("frame-top");

		driver.switchTo().frame("frame-middle");

		String text = driver.findElement(By.cssSelector("div#content")).getText();

		System.out.println("The text in the Middle frame is--->" + text);

		driver.switchTo().defaultContent();

		driver.quit();

	}

}
