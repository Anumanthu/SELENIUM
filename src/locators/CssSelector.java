package src.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // VERY VERY IMP SEE BELOW
        // XPATH ----> //TagName[@attribut='value']
        // CSS selector --> TagName[attribute='value']

        // For CSS id: tagName#id for id
        // For CSS class: tagName.className for class

        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("anumanthunitt@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Sandhya.143");
        //driver.findElement(By.cssSelector("[type='password']")).sendKeys("Sandhya.143"); //give blank tagname for any tagname as same as xpath *


        driver.findElement(By.partialLinkText("Forgotten")).click();

        // driver.findElement(By.linkText("Forgotten account?")).click();


        driver.get("http://rediff.com");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();//regular expression for CSSSelector
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("goodbye");//tagName#id
        driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();////regular expression for Xpath


    }

}
