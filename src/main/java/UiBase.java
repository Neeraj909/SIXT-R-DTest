import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class UiBase {
    public static WebDriver driver;
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void browserInitialization(String browserName) {

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        } else if (browserName.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        //getDriver().get(CommonUtills.getEnv().getConfig().getEnvironment().getURL());

    }
}
