package steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;
import util.Util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startTest(){
        WebDriver driver = Util.createDriver();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(properties.getProperty("app.url"));
    }

    @After
    public void quitTest(){
        Util.quitDriver();
    }
}
