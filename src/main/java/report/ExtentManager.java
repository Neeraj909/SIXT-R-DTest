package report;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    public static ExtentReports extent = null;

    private ExtentManager() {
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
            @SuppressWarnings("unused")
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports("./Reports/ExtentReportResults.html", true);
        }


        return extent;
    }
}
