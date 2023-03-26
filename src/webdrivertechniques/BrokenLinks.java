package src.webdrivertechniques;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https:amazon.com");

        String homepage = driver.getCurrentUrl();

        String url = "";
        List<WebElement> lst = driver.findElements(By.tagName("a"));

        HttpURLConnection huc;

        Iterator<WebElement> itr = lst.iterator();

        while (itr.hasNext()) {
            url = itr.next().toString();
            if (url == null || url.isEmpty()) {
                System.out.println("This is not Configured or undefined");
                continue;

            }
            if (!url.startsWith(homepage)) {
                System.out.println("This url belongs to another domain");
            }

            URL http = new URL(url);

            huc = (HttpURLConnection) http.openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            //	if(huc.getResponseCode());


        }


    }

}
