package basicToAdvanceExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class brokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Page: " + links.size());
        for(WebElement link: links){
           String url =  link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(3000);
            conn.connect();
//            int responseCode = conn.getResponseCode();
            if (conn.getResponseCode() >= 400){
                System.out.println("The link with Text " +link.getText()+ " is broken with code " + conn.getResponseCode());
                Assert.assertTrue(false);
            }
        }



    }
}
