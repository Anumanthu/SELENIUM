package src.webdrivertechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableGridsExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\akindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // WebDriver driver=new FirefoxDriver();

        driver.get(
                "http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        int sum = 0;

        // Below cssSelector matching with 4 WebElements
        // however it will take first WebElement since Selenium scans webelements from
        // the topleft
        // WebElement table = driver.findElement(By.cssSelector("div[class='cb-col
        // cb-col-100 cb-ltst-wgt-hdr']"));

        // To Identify only first WebElement use the pattern (xpath)[1]...(xpath)[2] for
        // 2nd WebElement

        WebElement table = driver.findElement(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));

        int rowcount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
                .size();

        for (int i = 0; i < count - 2; i++) {
            String str = table
                    .findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
                    .getText();

            sum = sum + Integer.parseInt(str);

            //System.out.println(str);

        }

        String Extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();

        int extras = Integer.parseInt(Extras);

        int TotalScore = sum + extras;

        System.out.println("Total score =   -----" + TotalScore);

        String Total = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();

        int ActualTotal = Integer.parseInt(Total);

        if (TotalScore == ActualTotal)
            System.out.println(" Given Test case PASSED");
        else
            System.out.println(" Given Test case FAILED");

    }

}
