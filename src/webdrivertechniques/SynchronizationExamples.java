package src.webdrivertechniques;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SynchronizationExamples {

    public static void main(String[] args) throws InterruptedException {

        //This is outdated setting property not required
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ANUMANTHU\\Desktop\\Selenium Learning\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().browserVersion("browser version").setup();

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        // Thread.sleep(2000);

        // ****************Implicit wait*****************************************

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //SetSpeed () :  For specific amount of time it will stop the execution for every selenium command.
        //It takes a single argument in integer format
        //selenium.setSpeed(2000); //It will wait for 2 seconds this was using in RC ..now a days not using

        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");

        driver.manage().window().maximize();

        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);

        driver.findElement(By.id("H-fromDate")).sendKeys(Keys.ENTER);

        // driver.findElement(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")).click();

        // *******************************Explicit wait
        // *********************************************

        WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(10));

        //d.until(ExpectedConditions.

        // Syntax----> d.until(ExpectedConditions.visibilityOfElementLocated(locator))

        // d.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        // d.until(ExpectedConditions.visibilityOf(element))
        // d.until(ExpectedConditions.textToBePresentInElement(Weblement, "text on
        // Weblement"));

        // d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")));
        d.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")));

        driver.findElement(By.xpath("//a[contains(@href,'New-York-Hotels-Paramount-Times-Square')]")).click();


        /*
         * WebDriverWait d=new WebDriverWait(driver,20);
         * d.until(ExpectedConditions.elementToBeClickable(By.xpath(
         * "//div[@id='resultsContainer']/section/article[1]"))); //Thread.sleep(5000L);
         *
         * driver.findElement(By.xpath(
         * "//div[@id='resultsContainer']/section/article[1]")).click();
         *
         */

        // FluentWait

        /*
         * Wait wait = new FluentWait(driver)
         *
         * .withTimeout(30, SECONDS)
         *
         * .pollingEvery(5, SECONDS)
         *
         * .ignoring(NoSuchElementException.class);
         *
         * WebElement foo = wait.until(new Function() {
         *
         * public WebElement apply(WebDriver driver) {
         *
         * return driver.findElement(By.id("foo"));
         *
         * }
         *
         * });
         *
         */

    }

}
