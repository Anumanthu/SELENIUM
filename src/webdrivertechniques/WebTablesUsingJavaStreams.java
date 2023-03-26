package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablesUsingJavaStreams {

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ankindinti\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.manage().window().maximize();

        // driver.manage().deleteAllCookies();

        Thread.sleep(2000);

        WebElement pageMenuElement = driver.findElement(By.xpath("//select[@id='page-menu']"));

        Select pagemenu = new Select(pageMenuElement);

        String defaultItemSelected = pagemenu.getFirstSelectedOption().getText();

        System.out.println("*********************************************************************");
        System.out.println("Default item selected is ---->" + defaultItemSelected);

        pageMenuElement.click();
        pagemenu.selectByVisibleText("20");

        driver.findElement(By.xpath("//thead/tr/th[1]")).click();

        List<WebElement> allvegies = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        List<String> actualList = allvegies.stream().map(s -> s.getText()).collect(Collectors.toList());

        actualList.stream().forEach(s -> System.out.println(s));
        System.out.println("*********************************************************************");

        List<String> expectedList = actualList.stream().sorted().collect(Collectors.toList());

        expectedList.stream().forEach(s -> System.out.println(s));
        System.out.println("*********************************************************************");

        Assert.assertTrue(actualList.equals(expectedList));

        List<String> riceList = expectedList.stream().filter(s -> s.contains("Rice")).collect(Collectors.toList());

        riceList.stream().forEach(s -> System.out.println(s));

        List<String> riceEles = allvegies.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s))
                .collect(Collectors.toList());
        // List< WebElement>
        // ricePrices=riceEles.stream().map(s->s.findElement(By.xpath("//following-sibling::td[1]"))).collect(Collectors.toList());
        riceEles.stream().forEach(s -> System.out.println("Prices   ---> " + s));

        do {
            riceList = expectedList.stream().filter(s -> s.contains("Rice1")).collect(Collectors.toList());
            ArrayList<String> riceListArray = new ArrayList<String>(riceList);
            if (riceList.size() < 1) {
                WebElement next = driver.findElement(By.xpath("//li/a[@aria-label='Next']"));

                if (next.isEnabled()) {
                    Thread.sleep(10000);
                    next.click();
                } else {
                    Assert.fail("The vegie you are searching not found in the page");
                }
            }
        } while (riceList.size() < 1);

        driver.close();

    }

    public static String getPrice(WebElement priceElement) {

        WebElement price = priceElement.findElement(By.xpath("following-sibling::td[1]"));
        return price.getText();

    }

}
