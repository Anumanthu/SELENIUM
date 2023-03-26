package src.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Brokenlinks {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("http://www.facebook.com");

        String homepage = "https://www.facebook.com";

        driver.manage().window().maximize();

        // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String url = "";

        HttpURLConnection huc;

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {
            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url.isEmpty() || url == null) {
                System.out.println(url);
                System.out.println("The url is unconfigured or not set");
                continue;
            }

            if (!url.startsWith(homepage)) {

                System.out.println("The url belongs to another domain ------------->" + url);
                continue;
            }

            try {

                URL httppageURL = new URL(url);
                huc = (HttpURLConnection) httppageURL.openConnection();

                huc.setRequestMethod("HEAD");

                huc.connect();

                huc.getResponseCode();
                if (huc.getResponseCode() >= 400)
                    System.out.println("The url " + url + " is  Broken Link");
                else
                    System.out.println("The url " + url + " is valid");

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }
}
