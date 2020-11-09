import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utills.CommonUtils;

import java.util.concurrent.TimeUnit;

class UiBase {
    private  WebDriver driver;
    private static long IMPLICIT_WAIT = 20;
    public WebDriverWait webDriverWait;
    public  WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
    @BeforeSuite
    @Parameters({ "browserName", "env" })
    public void setup(@Optional("chrome") String browserName,String env) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        } else if (browserName.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver());
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
            webDriverWait = new WebDriverWait(getDriver(), 30);
        }

        return webDriverWait;
    }
}
