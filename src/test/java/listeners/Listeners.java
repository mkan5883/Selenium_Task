package listeners;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

    public void onTestStart(ITestResult tr) {
        Reporter.log(tr.getTestName());

    }

    public void onTestSuccess(ITestResult tr) {
        Reporter.log(String.valueOf(tr.getStatus()));

    }

    public void onTestFailure(ITestResult tr) {
        Reporter.log(String.valueOf(tr.getStatus()));

    }

    public void onTestSkipped(ITestResult tr) {
        System.out.println("Test Skipped");

    }

}
