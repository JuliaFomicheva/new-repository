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

import static org.openqa.selenium.By.name;

public class AlphabetOrder {
    private WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).click();
    }

    @Test
    public void Alphabet() {
        WebElement dataTable = driver.findElements(By.className("dataTable")).get(0);
        List<WebElement> rows = dataTable.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[@class='row']"));

        List<String> countries = new ArrayList<>();
        for (WebElement rowElement : rows) {
            List<WebElement> TotalColumnCount = rowElement.findElements(By.xpath("td"));
            WebElement column = TotalColumnCount.get(4);
            countries.add(column.getText());
        }
        List<String> copyCountries = new ArrayList<>(countries);
        Collections.sort(copyCountries);
        Assert.assertEquals(copyCountries, countries);
    }

    @Test
    public void rainyAlphabet() {
        WebElement dataTable = driver.findElements(By.className("dataTable")).get(0);
        List<WebElement> rows = dataTable.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[@class='row']"));

        List<String> countries = new ArrayList<>();
        for (WebElement rowElement : rows) {
            List<WebElement> TotalColumnCount = rowElement.findElements(By.xpath("td"));
            WebElement column = TotalColumnCount.get(4);
            countries.add(column.getText());
        }
        countries.add(0,"qwre");
        List<String> copyCountries = new ArrayList<>(countries);
        Collections.sort(copyCountries);
        Assert.assertNotEquals(copyCountries, countries);

    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}



