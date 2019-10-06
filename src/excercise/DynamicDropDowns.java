package excercise;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicDropDowns {
	
	

	public static void main(String []args){



		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

	WebDriver driver=new ChromeDriver();


	driver.manage().window().maximize();

	driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
	
	
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//button[@id='menu1']")).click();
	
	int ddmenu_count=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a")).size();
	
	List<WebElement> ele=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
	//Print all the dropdown item names using getText() method 
	for(int i=0;i<ddmenu_count;i++)
	{
		String str=ele.get(i).getText();
		
		System.out.println("Values from dropdown(getText() method) are  "+str);
		
	}
	
	
	//Print all the dropdown item names using InnerHTML
	
	for(int i=0;i<ddmenu_count;i++)
	{
		String str=ele.get(i).getAttribute("innerHTML");
		
	System.out.println("Values from dropdown(innerHTML) are  "+str);
		
		if(str.contains("JavaScript"))
		{
			ele.get(i).click();
			break;
		}
		
	}
 }

}


