package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectClassExamples2 {

    //

    @Test
    public void selectDropDownValues() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\1018546\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get("http://www.facebook.com");

        driver.manage().window().maximize();

        WebElement month_dropdown = driver.findElement(By.xpath("//select[@id='month']"));

        Select month = new Select(month_dropdown);

        // selectByValue("oct");
        // selectByVisibleText("oct");
        // selectByIndex(3);

        WebElement first_value = month.getFirstSelectedOption(); // It selects the default value on textbox

        String value = first_value.getText();

        System.out.println("First selected value     " + value);

        // Select By Index
        month.selectByIndex(3);

        System.out.println("Selected value     " + month.getFirstSelectedOption().getText());

        Thread.sleep(4000);

        // Select By Visible Text
        month.selectByVisibleText("Oct");
        ;
        System.out.println("Selected value     " + month.getFirstSelectedOption().getText());
        Thread.sleep(4000);
        /*
         * //Select By Value month.deselectByValue("Dec");
         * System.out.println("Selected value     "+month.getFirstSelectedOption().
         * getText()); Thread.sleep(4000);
         */

        List<WebElement> dropdown = month.getOptions();

        int cont = dropdown.size();

        Assert.assertEquals(cont, 13, "Total months does not match");

        String[] month_list = {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov",
                "Dec"};

        for (int i = 0; i < dropdown.size(); i++) {

            String drop_down_values = dropdown.get(i).getText();
            System.out.println("dropdown values are " + drop_down_values);

            Assert.assertEquals(drop_down_values, month_list[i], "Month is not match");

        }

        // Using ArrayList and Iterator

        ArrayList<String> al = new ArrayList<String>();

        al.add("Month");
        al.add("Jan");
        al.add("Feb");
        al.add("Mar");
        al.add("Apr");
        al.add("May");
        al.add("Jun");
        al.add("Jul");
        al.add("Aug");
        al.add("Sept");
        al.add("Oct");
        al.add("Nov");
        al.add("Dec");

        Iterator<String> it = al.iterator();

        Iterator<WebElement> it1 = dropdown.iterator();

        while (it.hasNext()) {

            // System.out.println("dropdown values are
            // "+it.next().toString()+"========"+it1.next().getText());

            Assert.assertEquals(it.next().toString(), it1.next().getText(), "Month does not match");
        }

    }

}
