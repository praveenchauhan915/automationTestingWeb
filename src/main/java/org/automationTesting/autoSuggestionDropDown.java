package org.automationTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class autoSuggestionDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.findElement(By.id("autosuggest")).sendKeys("in");
        Thread.sleep(3000);
        List<WebElement> options =  driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase("Indonesia")){
                option.click();
                break;
            }
        }
    }
}
