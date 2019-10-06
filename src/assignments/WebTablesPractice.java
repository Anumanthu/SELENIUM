package assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTablesPractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

		// C:\Users\1018546\Desktop\Selenium Learning

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://qaclickacademy.com/practice.php");

		driver.manage().window().maximize();

		int rows = driver.findElements(By.xpath("//table[@id='product']/tbody/tr")).size();

		System.out.println("No. of Rows in the Table is --->" + rows);

		int columns = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[1]/th")).size();

		System.out.println("No. of Column in the Table is --->" + columns);

		int specificRow = 2;

		ArrayList<String> al = getColumnsValuesInSpecificRow(driver, specificRow + 1);// 2nd row means third row in the if exclude
																	// headervalues

		System.out.println("Printing the columns in the " +specificRow+ " row are ");

		for (String str : al) {
			System.out.println(str);
		}

	}

	public static ArrayList<String> getColumnsValuesInSpecificRow(WebDriver driver, int row) {
		
		List<WebElement> lst = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[" + row + "]/td"));

		ArrayList<String> al = new ArrayList<String>();

		Iterator<WebElement> itr = lst.iterator();
		// Print the columns values for the specific row
		while (itr.hasNext()) {
			al.add(itr.next().getText());
		}
		return al;
	}

}
