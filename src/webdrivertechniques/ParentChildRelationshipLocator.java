package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildRelationshipLocator {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://spicejet.com/");

        driver.manage().window().maximize();

        //driver.manage().deleteAllCookies();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();

        WebElement source = driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']"));

        source.clear();
        source.click();
        Thread.sleep(2000);
        //Parent xpath + child xpath
        //Parent xpath--->//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTNR'] //a[@value='AMD']--->this is child xpath

        driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTNR'] //a[@value='AMD']")).click();

        Thread.sleep(2000L);

        driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR'] //a[@value='AIP']")).click();

    }

}
