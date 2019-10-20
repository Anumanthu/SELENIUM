package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class AutoSuggestiveDropDwons {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("http://www.ksrtc.in/oprs-web/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		// WebElement e=driver.findElement(By.xpath("//*[@id='fromPlaceName']"));

		driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys("Ben");

		driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

		// driver.findElement(By.xpath("//*[@id='fromPlaceName']")).getText();

		// driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

		// Carefully observe the below line,you can't get text because it is hidden
		// element...this is the draw back in selenium

		// driver.findElement(By.xpath("//*[@id='fromPlaceName']")).getText();

		// Using JavaScriptExecutor, we can identify and get text of hidden WebElements
		// Refer more details 'JavaScript DOM' in w3schools.com for more info

		int i = 0;

		JavascriptExecutor js = (JavascriptExecutor) (driver);

		String script = "return document.getElementById(\"fromPlaceName\").value;";
		//We can write as below also
		//String script1 = "return document.getElementById('fromPlaceName').value;";
		
		// String text=(String) js.executeScript(script);
		String text = (String) js.executeScript(script);

		System.out.println(text);

		while (!(text.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")))

		{

			i++;
			// System.out.println(text);

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

			text = (String) js.executeScript(script);

			System.out.println(text);
			if (i > 10) {
				break;
			}

		}

		if (i > 10) {

			System.out.println("Element Not Found");
		} else {

			System.out.println("Element Found");
		}

	}

}
