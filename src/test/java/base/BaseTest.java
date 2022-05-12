package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    @BeforeTest
    public void setUp() throws IOException {

        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "configfiles" +
                    File.separator + "config.properties");
            prop.load(fr);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testUrl"));
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testUrl"));
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("Teardown successful");

    }
}
