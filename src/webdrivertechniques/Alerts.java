package webdrivertechniques;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 
		 * There 2types of alerts 1)HTML alerts and 2)JAVA Script alerts which we will have
		 * to handle using "Alert" class The Selenium WebDriver provides an Alert class
		 * for handling alerts. To get the alert box displayed on the screen as an
		 * instance of the Alert class, the driver.switchTo(). alert() method is used as
		 * follows: Alert alert = driver.switchTo().alert(); A test might need to verify
		 * what message is displayed in an alert box. We can get the text from an alert
		 * box by calling the getText() method of the Alert class as follows: String
		 * textOnAlert = alert.getText(); An alert box is closed by clicking on the OK
		 * button; this can be done by calling the accept() method as follows:
		 * alert.accept(); alert.dismiss();
		 * 
		 */

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		// WebDriver driver=new FirefoxDriver();

		// Alert alert =driver.switchTo().alert();
		

		// alert.accept();
		// alert.dismiss();

		driver.findElement(By.xpath("html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input"))
				.click();
	
		// driver.switchTo().alert().getText();
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();
		// driver.switchTo().alert().sendKeys("Enter something into popup box");

		System.out.println(driver.switchTo().alert().getText());

		// driver.switchTo().alert().sendKeys("fesfe");

		driver.switchTo().alert().accept(); // Accept = ok/done/yes

		// driver.switchTo().alert().accept();

		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		// driver.switchTo().alert().dismiss();//Dismiss=cancel/no

	}

}
