package assignments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		// C:\Users\1018546\Desktop\Selenium Learning

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://qaclickacademy.com/practice.php");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
		
		Thread.sleep(2000L);
		
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li"));
		
		//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li
		
		Iterator<WebElement> itr=lst.iterator();
		Actions ac=new Actions(driver);
		
		while(itr.hasNext())
		{
			WebElement ele=itr.next();
			String str=ele.getText();
			if(str.trim().equalsIgnoreCase("India"))
			{
				ac.moveToElement(ele).click().build().perform();
			}
		}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	String selectedValue=(String) js.executeScript("return document.getElementById(\"autocomplete\").value;");
	
	System.out.println(selectedValue);
	}

}
