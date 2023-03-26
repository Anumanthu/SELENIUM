package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Practice {

    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver", "\"C:\\\\Users\\\\ANUMANTHU\\\\Desktop\\\\Selenium Learning\\\\chromedriver.exe\"");

        WebDriver driver = new ChromeDriver();


        driver.get("https:amazon.com");

        driver.getCurrentUrl();
        String url = "";
        HttpURLConnection huc;

        WebElement ele = driver.findElement(By.tagName("a"));
        driver.manage().window().fullscreen();

        List<WebElement> alllinks = driver.findElements(By.tagName("a"));

        Iterator<WebElement> itr = alllinks.iterator();

        while (itr.hasNext()) {

            String link = itr.next().getAttribute("href");

            URL urlobject = new URL(link);

            huc = (HttpURLConnection) urlobject.openConnection();

            huc.setRequestMethod("HEAD");
        }


    }

}
