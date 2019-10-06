package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalenderDatePick {
	

	public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com/flights/");

	driver.manage().window().maximize();
	Thread.sleep(6000L);
	
	//driver.findElement(By.xpath("//label[contains(text(),'round trip')]")).click();
	//Thread.sleep(3000L);
	
	driver.findElement(By.xpath(".//*[@id='hp-widget__depart']")).click();


	 //Selecting ur desierd month

	 while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("AUGUST"))
	 {
	  driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	 }
	 
	 int count1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
	 System.out.println(count1);
	  
	for (int i=0;i<count1;i++)
	 {
	  String s1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
	  System.out.println(s1);
	  
	  if (s1.equalsIgnoreCase("11"))
	  {
	  driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
	  break;
	  }
	  
	 }
	 
	//RETURN DATE DATE
	 
	driver.findElement(By.xpath("//input[@id='hp-widget__return']")).click();
	 
	Thread.sleep(3000);
	System.out.println(driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText());
	 
	while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText().contains("NOVEMBER"))
	{
	driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
	}
	 
	 
	int count2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
	System.out.println(count2);
	 
	 
	for (int i=0;i<count2;i++)
	{
	 String s2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
	 System.out.println(s2);
	 
	 if (s2.equalsIgnoreCase("15"))
	 {
	 driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
	 break;
	 }
	 
	}

	}

}
