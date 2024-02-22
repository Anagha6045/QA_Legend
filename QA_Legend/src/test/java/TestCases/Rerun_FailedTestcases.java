package TestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun_FailedTestcases implements IRetryAnalyzer
{
 private int retryCount=0;
 private static final int max_Count=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<max_Count )
		{
			retryCount++;
			return true;
		}
		
		return false;
	}
	

}
