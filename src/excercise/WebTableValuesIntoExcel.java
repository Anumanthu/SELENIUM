package excercise;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableValuesIntoExcel {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
		
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/html/html_tables.asp");
		 
		 driver.manage().deleteAllCookies();

	driver.manage().window().maximize();
	
	//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	
	//table[@id='customers']/tbody/tr[3]/td[1]
	
	
	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
	List<WebElement> columns=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[2]//td"));
	
	
	
	String BeforeXpath="//table[@id='customers']//tbody//tr[";
	String AfterXpath="]//td[";
	
	
	
	
	int row_Count=rows.size();
	int column_Count=columns.size();
	
	
	System.out.println("No of rows  --->"+row_Count);
	System.out.println("No of columns  --->"+column_Count);
	
	
	//create new Class Xls_Reader and define some methods like adding sheet,column and import that
//Xls_Reader reader=new Xls_Reader("C://Users//ANUMANTHU//Desktop//Selenium Learning//Book2.xlsx");

	
	
	//FileInputStream fis= new FileInputStream("C://Users//ANUMANTHU//Desktop//Selenium Learning//Book2.xlsx");
	
	//XSSFWorkbook wb=new XSSFWorkbook(fis);
	
	
	
	for(int i=2;i<=row_Count;i++)
	{
		System.out.println("***********************************************");
		
		for(int j=1;j<=column_Count;j++)
		{
			String cell_data=driver.findElement(By.xpath(BeforeXpath+i+AfterXpath+j+"]")).getText();
			
			System.out.println(cell_data);
		}
		
		
		
	}
	
	
	
		

	}

}
