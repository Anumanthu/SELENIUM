package src.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("hello");
        driver.findElement(By.name("pw")).sendKeys("123456");
//driver.findElement(By.className("button r4 wide primary")).click();//Error because compound class can't use it
        driver.findElement(By.xpath("//*[@id='Login']")).click();

        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());

        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getAttribute("class"));

        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getTagName());
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getClass());
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getLocation().x);
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getLocation().y);


    }
}