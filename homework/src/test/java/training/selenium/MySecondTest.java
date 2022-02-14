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

public class MySecondTest {
    private WebDriver driver;

    @Before
    public void start1() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void mySecondTest() {

        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).submit();
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}



