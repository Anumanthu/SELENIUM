package webdrivertechniques;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AKINDINT\\Desktop\\Selenium Learning\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver=new FirefoxDriver();

		driver.get("http://www.echoecho.com/htmlforms10.htm");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		// driver.findElement(By.xpath("//input[@value='Milk']")).click();

		// int count =
		// driver.findElements(By.xpath("//input[@name='group1'][@type='radio']")).size();
		int count = driver.findElements(By.xpath("//input[@name='group1' and @type='radio']")).size();

		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			

			if (text.equals("Cheese")) {
				// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isDisplayed());
				// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isEnabled());
				System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isSelected());

				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

				// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isDisplayed());
				// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isEnabled());
				System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).isSelected());

			}

		}

	}
}
