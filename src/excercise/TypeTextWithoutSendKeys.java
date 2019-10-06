package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypeTextWithoutSendKeys {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.gmail.com");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		// how to handle authentication popup in selenium
		// http://username:password@URL(starting with www.)
		// http://rajkumar:myPassword@www.softwaretestingmaterial.com

		// To initialize js object
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		// To enter username
		JS.executeScript("document.getElementById('identifierId').value='SoftwareTestingMaterial.com'");
		
		// VVIMP We can also use same as shown below
		// JS.executeScript("document.getElementById(\"identifierId\").value='SoftwareTestingMaterial.com'");

		// To enter password
		JS.executeScript("document.getElementById('Pass').value='tester'");

		// JS.executeScript("document.getElementById('pass').value='tester'");

	}

}
