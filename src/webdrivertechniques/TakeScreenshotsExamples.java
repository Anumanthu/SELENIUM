package webdrivertechniques;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class TakeScreenshotsExamples {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("https://www.google.com/");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        // driver.manage().deleteAllCookies();
        // driver.manage().deleteCookieNamed("Cookie name or session id");

        // Taking Screenshot code

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\screen1.png"));

        // FileUtils.copyFile(src, new File("C:\\screen.png")); //Access denied

// Below code is Taking screenshot of WebElement but did not work out	

        /*
         * WebElement e=driver.findElement(By.xpath("//img[@id='hplogo']"));
         *
         *
         * WebDriver s=(WebDriver)((TakesScreenshot)e);
         *
         *
         * File src1=((TakesScreenshot) s).getScreenshotAs(OutputType.FILE);
         *
         *
         *
         * FileUtils.copyFile(src1,new
         * File("C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\screen2.png"));
         *
         */
        // Killing process
        //WindowsUtils.killByName("notepad++.exe");


        // WindowsUtils.killByName("notepad++.exe");

        //WindowsUtils.killByName("excel.exe");

    }

}
