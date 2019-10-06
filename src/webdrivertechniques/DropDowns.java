package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://spicejet.com/");

		driver.manage().window().maximize();

		// driver.manage().deleteAllCookies();

		Thread.sleep(2000);

		// ******************* Static Dropdowns(Which has "Select" tag in HTML
		// Code)***************************

		Select s = new Select(driver.findElement(By.xpath("//*[contains(@id,'DropDownListCurrency')]")));

		/*
		 * *********************VERY VERY IMP ********************************* Below
		 * code is for practice knowledge knowing about Static Dropdowns
		 * 
		 * 
		 * // Actions ac=new Actions(driver);
		 * 
		 * WebElement e1=s.getFirstSelectedOption(); String str=e1.getText();
		 * 
		 * 
		 * List<WebElement> lst=s.getOptions(); //Count of values from Static dropdown
		 * //int count=s.getOptions().size(); int count =lst.size();
		 * 
		 * Iterator<WebElement> itr=lst.iterator();
		 * 
		 * while(itr.hasNext()) { WebElement e2=itr.next();
		 * System.out.println("Values from Static Dropdown are "+e2.getText());
		 * 
		 * }
		 * 
		 */

		s.selectByVisibleText("AED");
		s.selectByValue("INR");
		s.selectByIndex(3);
		// System.out.println("Printing selected option on the dropdown
		// box--->"+s.getFirstSelectedOption());
		// List<WebElement> lst=s.getOptions();

		// Iterator it=lst.iterator();

		// System.out.println("Print all the options on the dropdown list");

		// while(it.hasNext())
		// {
		// System.out.println(it.next().toString());

		// }

		// ********************Dynamic DropDowns**********************

		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_originStation1_CTXT\']")).click();

		driver.findElement(By.xpath("//a[@value='AMD']")).click();

		Thread.sleep(3);

		// Click on second dropdown because developers calling the same code city list
		// in second dropdown also...

		driver.findElement(By.xpath("(//a[@value='AIP'])[2]")).click();// sometimes it takes as (//a[@value='AIP'])[1]

		/*
		 * We can use here below Parent- child xpath concept..if they are matching
		 * multiple webelements, first identify its parent xpath and give one space and
		 * give child xpath
		 ****************** 
		 * parent xpath+one space+child xpath********************
		 * //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']
		 * 
		 */

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='AIP']"))
				.click();// no need to use like (//a[@value='AIP'])[2]

		// div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']

		WebElement element = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));

		// input[@id='ctl00_mainContent_view_date1']

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].setAttribute('value','15/09');", element);

	}

}
