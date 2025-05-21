package org.automationTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // waits globally
        //Explicit Wait
        WebElement firstResult = new WebDriverWait(driver,Duration.ofSeconds(10)).
                                 until(ExpectedConditions.elementToBeClickable(By.xpath("//a//h3")));
        //Fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                              withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).
                              ignoring(NoSuchElementException.class);
    }
}
