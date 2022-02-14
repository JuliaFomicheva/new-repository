package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.openqa.selenium.By.name;

public class MyFirstTest {
    private WebDriver driver;

    @Before
    public void start1() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(name("q")).sendKeys("webdriver");
        driver.findElement(name("btnK")).submit();
        //wait(10000);
        //wait.until(titleIs("webdriver - Поиск в Google"));
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
   }


}
