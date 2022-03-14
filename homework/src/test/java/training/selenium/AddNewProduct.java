package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;

import static org.openqa.selenium.By.*;


public class AddNewProduct {
    private WebDriver driver;
    private WebElement searchField;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).click();
    }

    @Test
    public void AddNewProduct() {
        driver.navigate().to("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(1) > td > label:nth-child(3) > input[type=radio]")).click();
        String nameProduct = "Doggy_" + UUID.randomUUID().toString().substring(0,7);
        driver.findElement(By.name("name[en]")).sendKeys(nameProduct);
        driver.findElement(By.name("code")).sendKeys("12345");
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=checkbox]")).click();
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > input[type=checkbox]")).click();
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(7) > td > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > input[type=checkbox]")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).click();
        driver.findElement(By.name("quantity")).sendKeys("5");
        driver.findElement(By.name("sold_out_status_id")).click();
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(8) > td > table > tbody > tr > td:nth-child(4) > select > option:nth-child(3)")).click();
        String pathPicture = getClass().getClassLoader().getResource("unnamed.jpg").getPath().replace("/", "\\").substring(1);
        driver.findElement(By.cssSelector("input[type=file]")).sendKeys(pathPicture);
        driver.findElement(By.name("date_valid_from")).sendKeys("27022022");
        driver.findElement(By.name("date_valid_to")).sendKeys("27022023");
        getTab("Information").click();
        //driver.findElement(By.cssSelector("#content > form > div > ul > li.active > a")).click();
        //driver.findElement(cssSelector("information"));
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //driver.findElement(By.name("manufacturer_id")).click();
       // driver.findElement(By.name("save")).click();
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.cssSelector("#tab-information > table > tbody > tr:nth-child(1) > td > select > option:nth-child(2)")).click();
        driver.findElement(By.name("keywords")).sendKeys("123456789");
        driver.findElement(By.name("short_description[en]")).sendKeys("helohelohelo");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("heloheloheloHowAreYou");
        driver.findElement(By.name("head_title[en]")).sendKeys("GoodProduct");
        driver.findElement(By.name("meta_description[en]")).sendKeys("GoodProductForHomeHelpful");
        getTab("Prices").click();
        driver.findElement(By.name("purchase_price")).sendKeys("100");
        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.cssSelector("#tab-prices > table:nth-child(2) > tbody > tr > td > select > option:nth-child(2)")).click();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("1");
        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("0.5");
        driver.findElement(By.name("save")).click();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.xpath("//table//*[contains(text(), '" + nameProduct + "')]")).click();




    }
    public WebElement getTab (String tabName){
        WebElement tabEl;
        List<WebElement> listTabs;
        listTabs = driver.findElement(By.className("index")).findElements(By.cssSelector("li"));
        for (WebElement currentTab:listTabs){
            if(currentTab.getText().contains(tabName)){
                return currentTab;
            }
        }
        //driver.findElement(By.className("index")).findElements(By.cssSelector("li")).get(0).getText()

        return null;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}



















