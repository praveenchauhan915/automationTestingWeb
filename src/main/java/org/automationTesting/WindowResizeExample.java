package org.automationTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowResizeExample {
    public static void main(String[] args) {
        int width = 600;
        int height = 400;
        Dimension dem = new Dimension(width,height);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().setSize(dem);

        //Using javascript executor
        ((JavascriptExecutor)driver).executeScript("window.resizeTo(600,400);");
    }
}
