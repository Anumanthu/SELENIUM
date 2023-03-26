package src.webdrivertechniques;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPageLoadComplete2 {

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("http://www.google.com");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        waitForPageLoad(driver, 10);

    }

    public static void waitForPageLoad(WebDriver driver, int timeOutInSeconds) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String jsCommand = "return document.readyState";
            // Validate readyState before doing any waits
            if (js.executeScript(jsCommand).toString().equals("complete")) {
                return;
            }

            for (int i = 0; i < timeOutInSeconds; i++) {
                Thread.sleep(1000);
                if (js.executeScript(jsCommand).toString().equals("complete")) {
                    Thread.sleep(3000);
                    break;
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
