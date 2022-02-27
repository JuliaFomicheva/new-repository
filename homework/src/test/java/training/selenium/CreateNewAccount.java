package training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class CreateNewAccount {
    private WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/en/create_account");
    }

    @Test
    public void newAccount(){
        driver.findElement(By.name("firstname")).sendKeys("Gordon");
        driver.findElement(By.name("lastname")).sendKeys("Harrison");
        driver.findElement(By.name("address1")).sendKeys("Fulton Street");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.className("select2-selection__arrow")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("United States");
        driver.findElement(By.className("select2-results__option")).click();
        driver.findElement(By.name("email")).sendKeys("wewqqrty@mil.ru");
        driver.findElement(By.name("phone")).sendKeys("89991818165");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("confirmed_password")).sendKeys("12345");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.name("email")).sendKeys("wewqqrty@mil.ru");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("login")).click();
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}