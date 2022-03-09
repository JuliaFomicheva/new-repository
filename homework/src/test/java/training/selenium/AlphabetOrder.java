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

import static org.openqa.selenium.By.className;
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
            List<WebElement> totalColumnCount = rowElement.findElements(By.xpath("td"));
            WebElement column = totalColumnCount.get(4);
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
            List<WebElement> totalColumnCount = rowElement.findElements(By.xpath("td"));
            WebElement column = totalColumnCount.get(4);
            countries.add(column.getText());
        }
        countries.add(0,"qwre");
        List<String> copyCountries = new ArrayList<>(countries);
        Collections.sort(copyCountries);
        Assert.assertNotEquals(copyCountries, countries);

    }

    @Test
    public void checkGeoZones() {
        List<WebElement> rowList = driver.findElements(By.className("row"));
        List<String> listToCheck = new ArrayList<>();
        String nameCountry;
        List<String> listString = new ArrayList<>();
        for(WebElement rowCurrent:rowList){
            nameCountry = rowCurrent.findElements(By.cssSelector("td")).get(4).getText();
            listString.add(nameCountry);
            if (rowCurrent.findElements(By.cssSelector("td")).get(5).getText().contains("0") != true){
                listToCheck.add(nameCountry);
            }
        }


        WebElement countryToCheck = null;
        List<WebElement> listRowsZones;
        List<String> listZonesNames;
        List<String> listZonesNameSort;
        for(String currentToCheck:listToCheck){
            countryToCheck = driver.findElement(By.linkText(currentToCheck));
            countryToCheck.click();
            WebElement tableZones = driver.findElement(By.className("dataTable"));
            listRowsZones = tableZones.findElements(By.cssSelector("tr"));
            listRowsZones.remove(0);
            listRowsZones.remove(listRowsZones.size()-1);
            listZonesNames = new ArrayList<>();
            for (WebElement rowZonesCurrent:listRowsZones){
                listZonesNames.add(rowZonesCurrent.findElements(By.cssSelector("td")).get(2).getText());
            }
            listZonesNameSort = new ArrayList<>(listZonesNames);
            Collections.sort(listZonesNameSort);
            Assert.assertEquals(listZonesNameSort, listZonesNames);
            //sa.assertEquals(listZonesNames, listZonesNameSort);

            //press Cancel;
            //driver.findElement(className("cancel"));
             pressButton("Cancel");

        }
    }
    public void pressButton(String ButtonName) {
        List<WebElement> listButtons = driver.findElement(By.className("button-set")).findElements(By.cssSelector("button"));
        for(WebElement button:listButtons){
            if(button.getText().contains(ButtonName)) {
                button.click();
                return;
            }
        }
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}



