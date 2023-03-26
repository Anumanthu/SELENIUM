package webdrivertechniques;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotOfWebElement {

    //***********VVVVIMP************************************************************

    //https://www.seleniumhq.org/download/---Selenium official website( org.openqa.selenium package name)

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.facebook.com");

        // Inspect element
        WebElement username = driver.findElement(By.id("email"));

        //Below is to take screenshot for entire page

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File("destination path"));

        //1.way Below is to take screenshot for perticular webelement

        File src1 = ((TakesScreenshot) username).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src1, new File("destination path"));


        //2.way Below is to take screenshot for perticular webelement

        File src2 = username.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src2, new File("destination path"));


        //Anumanthu Selenium learning


    }

}
