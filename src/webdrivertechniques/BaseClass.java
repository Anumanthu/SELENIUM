package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {


    public WebDriver driver;

    Properties prop;

    FileInputStream fis1;

    @Test

    public void login() throws Exception {
        prop = new Properties();
        fis1 = new FileInputStream("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\Workspace\\SELENIUM\\src\\webdrivertechniques\\databank.properties");

        prop.load(fis1);

        System.out.println(prop.getProperty("username"));

        System.out.println(prop.getProperty("password"));

        System.out.println(prop.getProperty("url"));

        System.out.println(prop.getProperty("browser"));

        if (prop.getProperty("browser").equals("Chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Driver name    " + driver);

        } else if (prop.getProperty("browser").equals("Firefox")) {

            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("Driver name    " + driver);

        } else {
            System.setProperty
                    ("webdriver.ie.driver", "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\IEDriverServer.exe");

            driver = new InternetExplorerDriver();
        }

        driver.get(prop.getProperty("url"));

        driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.id("pass")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }


}
	
	
	


