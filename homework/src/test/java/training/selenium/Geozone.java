package training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.By.name;

public class Geozone {
    private WebDriver driver;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).click();
    }

    @Test
    public void task9() {
        WebElement dataTable = driver.findElements(By.className("dataTable")).get(0);
        List<WebElement> rows = dataTable.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[@class='row']"));
        for (int i = 0; i < rows.size(); i++) {
            WebElement dataTableRefreshed = driver.findElements(By.className("dataTable")).get(0);
            List<WebElement> rowsRefreshed = dataTableRefreshed.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[@class='row']"));
            List<WebElement> totalColumnCount = rowsRefreshed.get(i).findElements(By.xpath("td"));
            WebElement nameColumn = totalColumnCount.get(2);
            String xpath = "//table//*[contains(text(), '" + nameColumn.getText() + "')]";
            driver.findElement(By.xpath(xpath)).click();
            WebElement zoneTable = driver.findElements(By.id("table-zones")).get(0);
            List<WebElement> zoneElements = zoneTable
                    .findElements(By.xpath("//*[@id='table-zones']/tbody/tr/td[3]/select/option[@selected='selected']"));
            List<String> zones = new ArrayList<>();
            for (WebElement zone : zoneElements) {
                zones.add(zone.getText());
            }
            List<String> copyZones = new ArrayList<>(zones);
            Collections.sort(copyZones);
            Assert.assertEquals(copyZones, zones);
            driver.findElement(By.name("cancel")).click();
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}









    
