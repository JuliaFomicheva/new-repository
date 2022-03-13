package training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(2) > td > a")).click();
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handlesSet);
        driver.switchTo().window(handlesList.get(1));
        driver.close();
        driver.switchTo().window(handlesList.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(3) > td > a")).click();
        Set<String> handlesSet1 = driver.getWindowHandles();
        List<String> handlesList1 = new ArrayList<>(handlesSet1);
        driver.switchTo().window(handlesList1.get(1));
        driver.close();
        driver.switchTo().window(handlesList1.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(6) > td > a")).click();
        Set<String> handlesSet2 = driver.getWindowHandles();
        List<String> handlesList2 = new ArrayList<>(handlesSet2);
        driver.switchTo().window(handlesList2.get(1));
        driver.close();
        driver.switchTo().window(handlesList2.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(7) > td > a:nth-child(3)")).click();
        Set<String> handlesSet3 = driver.getWindowHandles();
        List<String> handlesList3 = new ArrayList<>(handlesSet3);
        driver.switchTo().window(handlesList3.get(1));
        driver.close();
        driver.switchTo().window(handlesList3.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(8) > td > a")).click();
        Set<String> handlesSet4 = driver.getWindowHandles();
        List<String> handlesList4 = new ArrayList<>(handlesSet4);
        driver.switchTo().window(handlesList4.get(1));
        driver.close();
        driver.switchTo().window(handlesList4.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(9) > td > a")).click();
        Set<String> handlesSet5 = driver.getWindowHandles();
        List<String> handlesList5 = new ArrayList<>(handlesSet5);
        driver.switchTo().window(handlesList5.get(1));
        driver.close();
        driver.switchTo().window(handlesList5.get(0));
        driver.findElement(By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(10) > td > a")).click();
        Set<String> handlesSet6 = driver.getWindowHandles();
        List<String> handlesList6 = new ArrayList<>(handlesSet6);
        driver.switchTo().window(handlesList6.get(1));
        driver.close();
        driver.switchTo().window(handlesList6.get(0));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
