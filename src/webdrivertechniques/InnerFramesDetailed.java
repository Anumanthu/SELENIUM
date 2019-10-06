
package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerFramesDetailed {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		// driver.findElement(By.id("captchaImg"));

		InnerFramesDetailed obj = new InnerFramesDetailed();

		int framenumber = obj.findFrameNumber(driver, By.cssSelector("id"));
		driver.switchTo().frame(framenumber);

		driver.findElement(By.cssSelector("id")).click();
		driver.switchTo().defaultContent();

		int framenumber1 = obj.findFrameNumber(driver,By.cssSelector("xpath of webelement which present in another frame"));
		driver.switchTo().frame(framenumber);
		driver.findElement(By.cssSelector("xpath of webelement which present in another frame")).click();
		driver.switchTo().defaultContent();

	}

	public int findFrameNumber(WebDriver driver, By by) {

		int i;

		int framecount = driver.findElements(By.tagName("iframe")).size();

		for (i = 0; i < framecount; i++)

		{
			driver.switchTo().frame(i);

			int count = driver.findElements(by).size();

			if (count > 0)

			{
				driver.findElement(by).click();
				break;

			} else {
				System.out.println("Continue looping");

			}

		}

		driver.switchTo().defaultContent(); // this is mandatory step

		return i;

	}

}
