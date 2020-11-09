package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utills.CommonUtils;

import java.util.concurrent.TimeUnit;

public class UiBase {
    private static WebDriver driver;
    private static final long IMPLICIT_WAIT = 60;
    public WebDriverWait webDriverWait;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @BeforeSuite
    @Parameters({"browserName", "env"})
    public static void setup(@Optional("chrome") String browserName, String env) {

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver(options));
        } else if (browserName.equals("FF")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver(options));
        }
        CommonUtils.setEnv(env);
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        System.out.println(CommonUtils.getEnv().getConfig().getEnvironment().getURL());
        getDriver().get(CommonUtils.getEnv().getConfig().getEnvironment().getURL());

    }

    public WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(getDriver(), 120);
        }

        return webDriverWait;
    }

    public Select selectClass(WebElement ele) {
        return new Select(ele);
    }
    public static void meditate(int time) throws InterruptedException {
        Thread.sleep(1000 * time);
    }
}
