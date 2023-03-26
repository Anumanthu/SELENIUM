package src.excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseOverExamples {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Actions ac = new Actions(driver);
        ac.moveToElement(driver.findElement(By.xpath("//span[@class='burger-bread']"))).build().perform();

        // ul[@id='menu-list-addons']//a

        Thread.sleep(3000);

        List<WebElement> ele = driver.findElements(By.xpath("//ul[@id='menu-list-addons']//a"));

        int count = ele.size();

        for (int i = 0; i < count; i++) {
            if (ele.get(i).getText().contains("Travel Info")) {
                ac.moveToElement(ele.get(i)).build().perform();

                Thread.sleep(3000);

                for (int j = 0; j < count; j++) {
                    if (ele.get(j).getText().contains("FAQ")) {
                        // ac.moveToElement(ele.get(j)).build().perform();
                        // ac.doubleClick(ele.get(j)).build().perform();
                        // We can do below as well both movement and click as shown below

                        ac.moveToElement(ele.get(j)).doubleClick().build().perform();

                        break;

                    }

                }
                break;

            }

        }

    }

}
