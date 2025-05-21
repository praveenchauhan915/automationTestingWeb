package TestNGTutorial;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {
    ExtentReports extent;
    @Test
    public void initialDemo(){
         ExtentTest test = extent.createTest("Initial Demo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/");
        System.out.print("Title is:- " +driver.getTitle());
        driver.close();
//        test.addScreenCaptureFromBase64String();
        test.fail("Result do not match");
        extent.flush();
    }

    @BeforeMethod
    public void config(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Praveen Chauhan");

    }
}
