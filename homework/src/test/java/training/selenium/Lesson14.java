package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class Lesson14 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(name("username")).sendKeys("admin");
        driver.findElement(name("password")).sendKeys("admin");
        driver.findElement(name("login")).click();

    }

    @Test
    public void testFirst() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")).click();
        List<WebElement> listLinks = driver.findElements(By.cssSelector("td > a > i"));
        int sizeList = listLinks.size();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i < sizeList; i++) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            driver.findElements(By.cssSelector("td > a > i")).get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
