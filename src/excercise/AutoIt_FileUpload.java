package excercise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoIt_FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 driver.get("file:///C:/Users/ANUMANTHU/Desktop/fileupload.html");

	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@type='file']")).click();
	
	Thread.sleep(3000);
	
	Runtime.getRuntime().exec("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\Autoit\\Fileupload.exe");
	
	
	//driver.findElement(By.xpath("//a[@id='closeLB']")).click();
	
	}

}
