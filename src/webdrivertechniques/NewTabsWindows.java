package src.webdrivertechniques;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTabsWindows {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ankindint\\Desktop\\Selenium Learning\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.co.in");

        String parent = driver.getWindowHandle();

        //Below things will work in Selenium 4.0.0 alpha-3 version

        //WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);

        //WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);

        //newTab.close();
        //driver.switchTo().window(parent);

        //Selenium 4.0 new feature 1. relative locators or friendly locators
        //2. Take screenshot of perticular webelement
        //3. Switch to new Tab() or new Window()
        driver.get("");
        driver.navigate().to("");
    }

}
