package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManger() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resource\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");

        if (driver == null) {
            String browser = prop.getProperty("browser");

            if (browser != null && browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resource\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser != null && browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "\\src\\test\\resource\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalStateException("Unsupported or missing browser in properties");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
        }
        return driver;
    }
}
