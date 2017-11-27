import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverConfigurations {

    public static WebDriver getDriver(String browserName) {
        if (browserName.contentEquals("firefox")) {
            System.setProperty(
                    "webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
            return new FirefoxDriver();
        } else if (browserName.contentEquals("ie") || browserName.equals("internet_explorer")) {
            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if (browserName.contentEquals("chrome")) {
            System.setProperty(
                    "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }
}