package excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicWebTable {


    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.freecrm.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();


        Thread.sleep(5000);

        driver.switchTo().frame("mainpanel");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

        //Method-1:

        //*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a


        String BeforeXpath = "//*[@id='vContactsForm']/table/tbody/tr[";
        String AfterXpath = "]/td[2]/a";

        for (int i = 4; i <= 7; i++) {
            if (driver.findElement(By.xpath(BeforeXpath + i + AfterXpath)).getText().equalsIgnoreCase("test2 test2")) {
                driver.findElement(By.xpath(BeforeXpath + i + "]/td[1]/input")).click();
            }
        }


        //Method-2:

        driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'ui uiii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();


    }


}
