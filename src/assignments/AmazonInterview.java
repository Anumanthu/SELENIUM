package assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonInterview {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AKINDINT\\Desktop\\Selenium Learning\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);


        //Dimension d =new Dimension(400,400);
        //driver.manage().window().setSize(d);


        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String[] products = {"Divya", "Cucumber", "Beetroot", "Tomato", "Beans", "ABCDEFG"};

        ArrayList<String> al = new ArrayList<String>();


        for (String prod : products) {
            al.add(prod);
        }

        int size = al.size();

        //List<String> al1=Arrays.asList(products);
        List<WebElement> we = driver.findElements(By.xpath("//h4[@class='product-name']"));
        Iterator<WebElement> itrAllProducts = we.iterator();

        int count = 0;

        while (itrAllProducts.hasNext()) {
            String actualProduct = itrAllProducts.next().getText().split("-")[0].trim();
            if (al.contains(actualProduct)) {

                String xpath = "//div[@class='product']/h4[contains(text(),'" + actualProduct + "')]/following-sibling::div[(@class='product-action')]/button";
                driver.findElement(By.xpath(xpath)).click();

                al.remove(al.indexOf(actualProduct));

                count++;

            }

            if (count == size) {
                System.out.println("All products have been added to the cart");
                break;
            }

        }

        if (count < size) {
            for (String strProduct : al) {
                System.out.println("Item " + strProduct + " is NOT added to the cart bcz it is not available on the Shopping site");
            }

        }
    }

}
