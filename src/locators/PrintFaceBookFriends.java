package locators;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.interactions.Actions;

public class PrintFaceBookFriends {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");
		
		
		
		//VVV IMP How handle notification popups using selenium
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"  
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		// WebDriver driver=new FirefoxDriver();

		driver.get("http://www.facebook.com");

		// String homepage="https://www.facebook.com";

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys("anumanthunitt@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sandhya.143");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).submit();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//a[@href='https://www.facebook.com/kindinti.anumanthu.9']")).click();

		driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();

		while (true) {
			int bs = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

			int y = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).get(bs - 1).getLocation().y;
			
			WebElement lastFriend=driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).get(bs - 1);

			// We have method scroll(horizontal(x-coordinate), vertical(y-coordinate)) i.e.
			// scroll(0,400)

			// ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+y+")");

			// ((JavascriptExecutor)driver).executeScript("window.scroll(0,"+y+")");

			// we can scroll bar without using window.

			//((JavascriptExecutor) driver).executeScript("scroll(0," + y + ")");
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",lastFriend);
			

			Thread.sleep(5000);

			int as = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

			if (bs == as) {
				break;
			}

		}

		int count = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']")).size();

		System.out.println("Total number of friends  ---->" + count);

		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']"));

		Iterator<WebElement> it = lst.iterator();

		// Actions ac=new Actions(driver);

		while (it.hasNext()) {
			System.out.println(it.next().getText());
			// ((JavascriptExecutor)driver).executeScript("scroll(0,100000)");

		}

//JavascriptExecutor js=	(JavascriptExecutor)driver;
//js.executeScript()

	}

}
