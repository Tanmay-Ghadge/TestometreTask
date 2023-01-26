package com.DemoQA.ReusableComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestIRetryAnalyser implements IRetryAnalyzer
{
	int count=1;
	int retryMaxLimit=2;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<retryMaxLimit)
		{
			count++;
			return true;
		}

		return false;
	}

}
