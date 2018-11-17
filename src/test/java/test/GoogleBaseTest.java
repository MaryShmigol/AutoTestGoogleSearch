package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleHomePage;

public class GoogleBaseTest {
    public WebDriver webDriver;
    GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);


    @Parameters({"browserType"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome")String browserType){
        switch (browserType.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.google.com/");
        googleHomePage = new GoogleHomePage(webDriver);
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
