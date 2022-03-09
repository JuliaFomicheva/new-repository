package training.selenium;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;



public class DucksSticers {
    private WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/en/");

    }
    @Test
    public void Lesson7() {
            List<WebElement> listSticker;
            List<WebElement> productList = driver.findElements(By.className("product"));
            for(WebElement itemCurrent:productList){
                listSticker = itemCurrent.findElements(By.className("sticker"));
                Assert.assertEquals(1, listSticker.size());
            }

    }




    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

