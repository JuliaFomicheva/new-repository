package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Lesson13 {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
}

    @Test
    public void WorkWithTheBasket () {
        String url = "http://localhost/litecart/en/";
        driver.get(url);
        addToTheBasket();
        driver.findElement(By.className("link")).click();
        deleteProductsFromTheBasket();
    }

    public void addToTheBasket() {
        List<WebElement> listProduct = driver.findElements(By.className("product"));
        int sizeProduct = listProduct.size();
        for(int i = 0; i<3; i++){
            driver.findElement(By.cssSelector("#site-menu > ul > li.general-0 > a > i")).click();
            if(i<sizeProduct) {
                driver.findElements(By.className("product")).get(i).click();
            }else{
                driver.findElements(By.className("product")).get(sizeProduct-1).click();
            }
            clickToAddProduct();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#cart span.quantity")), "innerText", String.valueOf(i+1)));
        }
    }
    public void deleteProductsFromTheBasket() {
        List<WebElement> listShortcut = driver.findElements(By.className("shortcut"));
        int countOfProduct = listShortcut.size();
        for (int i = 0; i < countOfProduct; i++){
            WebElement table = driver.findElement(By.cssSelector("#order_confirmation-wrapper > table > tbody"));
            List<WebElement> shortcutList = driver.findElements(By.className("shortcut"));
            WebElement productCurrent;
            if(shortcutList.size()>0) {
                productCurrent = driver.findElement(By.className("shortcut"));
                productCurrent.click();
            }else {
                productCurrent = driver.findElement(By.cssSelector("#box-checkout-cart > div > ul > li > form"));
            }
            driver.findElement(By.name("remove_cart_item")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.stalenessOf(productCurrent));
            wait.until(ExpectedConditions.stalenessOf(table));
        }
    }

    public void clickToAddProduct() {
        try{
            WebElement sizeOfProduct = driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));
            sizeOfProduct.click();
            sizeOfProduct.sendKeys(Keys.DOWN);
            sizeOfProduct.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select > option:nth-child(2)")).click();
            sizeOfProduct.sendKeys(Keys.ENTER);

        } catch (Exception e){
        }
        driver.findElement(By.name("add_cart_product")).click();
    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
