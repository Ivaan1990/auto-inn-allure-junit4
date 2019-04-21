package steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private static WebDriver driver;
    private Properties properties = TestProperties.getInstance().getProperties();
    private String baseURL;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp(){
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
        }

        baseURL = properties.getProperty("app.url");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        //driver = new ChromeDriver(); junit4
        //baseURL = "https://service.nalog.ru/inn.do"; junit4
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @After
    public void quit(){
        driver.quit();
    }
}
