package UITests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    @Parameters("Browser")

    public void openBox(String browsername) {



        System.out.println("Parameter value is:" +browsername);
        WebDriver driver = null;
        if(browsername.contains("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //options.setHeadless(false);
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        else if(browsername.contains("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.get("https://qavbox.github.io/demo");
        Assert.assertTrue(driver.getCurrentUrl().contains("github"), "Does not match");
        driver.close();

    }

}
