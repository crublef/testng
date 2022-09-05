package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerAnnotation implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("The name of the testcase passed is :"+ Result.getName());
    }
}
