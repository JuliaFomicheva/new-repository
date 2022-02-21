package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;

public class AdminPanel {
private WebDriver driver;
    private int numberOfListElements;
    private By menuApp;


    @Before
    public void start(){
       System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
       driver = new ChromeDriver();

   }

    @Test
    public void EnterToSite() {
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).click();
        List<WebElement> coll = driver.findElements(By.cssSelector("#app- > a"));
        int size = coll.size();
        for (int i = 0; i < size; i++){
            WebElement elApp = driver.findElements(By.cssSelector("#app- > a")).get(i);
            elApp.click();
            elApp = driver.findElements(By.cssSelector("#app- > a")).get(i);
            List<WebElement> listDocs = driver.findElements(new By.ByClassName("docs"));
            if(listDocs.size()>0) {
                List<WebElement> collInternal = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span"));
                int sizeInternal = collInternal.size();
                for (int i2 = 0; i2 < sizeInternal; i2++) {
                    if (collInternal.size() > 0) {
                        WebElement subMenuCurrent = driver.findElement(new By.ByClassName("docs")).findElements(new By.ByCssSelector("span")).get(i2);
                        subMenuCurrent.click();
                    }
                }
            }
        }

    }




    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}


