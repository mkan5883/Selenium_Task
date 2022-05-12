package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageUtils {
    WebDriver driver;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitTillClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        return el;
    }

    public WebElement waitTillVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        return el;
    }

}
