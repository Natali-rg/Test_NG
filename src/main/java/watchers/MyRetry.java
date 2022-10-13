package watchers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//перезапускает тест если он не стабильный и запускается не с первого раза
public class MyRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
