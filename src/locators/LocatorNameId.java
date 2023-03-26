package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorNameId {

    public static void main(String[] args) {

        // System.out.println("This is my first class");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("www.google.com");/// We will get org.openqa.selenium.WebDriverException if we miss http

        System.out.println("The Title of Google page is  " + driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.facebook.com/");

        driver.findElement(By.className("inputtext")).sendKeys("anumanthunitt@gmail.com");
        driver.findElement(By.className("inputtext")).sendKeys("Sandhya.143");

        driver.findElement(By.linkText("Forgotten account?")).click();

        // driver.findElement(By.id("loginbutton")).click();

        // How to traverse to sibling when parent tag is changing dynamically

        // followingsibling concept

        // $x("//*[@id='day']/following-sibling::select[1]")
        //// *[@id='day']/following-sibling::select[2]

    }

}
