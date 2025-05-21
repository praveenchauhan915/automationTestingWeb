package basicToAdvanceExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class windowHandleExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.get("https://demoqa.com/browser-windows");
        //Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        //Get Window Handle
        String mainWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(childWindow);
                WebElement title = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is: " + title.getText());
//                driver.close();
            }
        }
//        driver.switchTo().window(mainWindow);
    }
}
