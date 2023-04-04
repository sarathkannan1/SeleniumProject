package UITests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOne {

        @Parameters("Browser")
        @Test
        public void openQAVBox(String browsername)
        {
            System.out.println("Parameter value is:" +browsername);
            WebDriver driver = null;
            if(browsername.contains("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
            else if(browsername.contains("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }
            //WebDriverManager.chromedriver().setup();
            //ChromeOptions options = new ChromeOptions();
            //options.setHeadless(false);
            //options.addArguments("--remote-allow-origins=*");
            //WebDriver driver = new ChromeDriver(options);

            //WebDriverManager.chromedriver().setup();
            //WebDriver driver = new ChromeDriver();
            driver.get("https://qavbox.github.io/demo");
            Assert.assertTrue(driver.getCurrentUrl().contains("github"), "Does not match");
            driver.close();
        }
    }

