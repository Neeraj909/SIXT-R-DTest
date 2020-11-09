import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utills.CommonUtils;

public class ClearTripTest extends UiBase {
    public ClearTripUiAction clearTripUiAction;

    @Parameters({"env", "browserName"})
    @BeforeSuite
    public void beforeTest() throws Exception {
        clearTripUiAction = new ClearTripUiAction();
        CommonUtils.cleanFolder();
    }

    @Test(priority = 1)
    public void bookFlight() {
        clearTripUiAction.clickOnRoundTrip();

    }

    @AfterSuite
    public void afterSuite() {
        getDriver().close();

    }
}
