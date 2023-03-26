package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        // C:\Users\1018546\Desktop\Selenium Learning

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        Set<String> ids = driver.getWindowHandles();

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();


        Set<String> windowids = driver.getWindowHandles();

        Iterator<String> itr = windowids.iterator();
        String parent = itr.next();
        String child = itr.next();
        driver.switchTo().window(child);

        String childstring = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        System.out.println(childstring);


        driver.switchTo().window(parent);

        String parentstring = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();

        System.out.println(parentstring);

        driver.quit();


    }

}
