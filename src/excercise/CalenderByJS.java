package excercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderByJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='dropdownDiv']//a"));
		int count = ele.size();

		for (int i = 0; i < count; i++) {
			if (ele.get(i).getText().contains("Goa")) {
				ele.get(i).click();
				break;

			}

		}

		Thread.sleep(5);

		driver.findElement(By.xpath("(//a[@value='AIP'])[1]")).click();

	}

}
