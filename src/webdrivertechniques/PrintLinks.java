package webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintLinks {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");

        driver.manage().window().maximize();

        // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        // WebDriverWait d=new WebDriverWait(driver,20);
        // Syntax----> d.until(ExpectedConditions.visibilityOfElementLocated(locator))

//d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")));
//d.until(ExpectedConditions.elementToBeClickable
//(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")));

        Thread.sleep(2000);

        System.out.println(driver.findElements(By.tagName("a")).size());

        // How to count all links in the footer section of the Web page
        // First sub webdriver using WebElement and count it

        WebElement footerdriver = driver.findElement(By.xpath("//*[@id='gf-BIG']"));

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[2]/ul"));

        System.out.println(columndriver.findElements(By.tagName("a")).size());

//Click on each link

        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

//The below code will open page in the same window and next link selenium will not find

//columndriver.findElements(By.tagName("a")).get(i).click()

            String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);// REMEMBER ENTER is equal to CLICK


            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);// In send keys we can pass key
            // events Keys.Enter like that
            Thread.sleep(3000);

        }

        Set<String> abc = driver.getWindowHandles();

        Iterator<String> itr = abc.iterator();

        while (itr.hasNext()) {
            driver.switchTo().window(itr.next());

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            // System.out.println(driver.getPageSource());

            System.out.println("-----------------------------------NEXT PAGE LINK---------------------------------------------");

        }

    }
}
