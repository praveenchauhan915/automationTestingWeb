package basicToAdvanceExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserLaunch {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        if (title.contentEquals("Google")){
            System.out.println("Test case passed");
        }
        else{
            System.out.println("Test case failed");
        }
        driver.close();
    }
}
