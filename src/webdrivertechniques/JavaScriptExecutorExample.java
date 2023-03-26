package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Enter the letters BENG
// Verify if Airport option is displayed in the suggestive box
public class JavaScriptExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("http://www.ksrtc.in/oprs-web/");

        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

        // Javascript DOM can extract hidden elements
        // because selenium cannot identify hidden elements - (Ajax implementation)
        // investigate the properties of object if it have any hidden text

        // JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String text = (String) js.executeScript(script);
        System.out.println(text);
        int i = 0;
        // BENGALURU INTERNATION AIPORT
        while (!text.equalsIgnoreCase("BENGALURU INTATION AIPORT")) {
            i++;
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

            text = (String) js.executeScript(script);
            System.out.println(text);
            if (i > 10) {
                break;
            }

        }

        if (i > 10) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element  found");
        }

    }
}
