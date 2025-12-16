package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");
	private static final int maxTry = 2;
	private int count = 0;

	@Override
	public boolean retry(final ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {
			if (this.count < maxTry) {
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true;
			}
		}
		return false;
	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}
}

//flaky test cases
//these are not stable. i.e it gets pass sometimes and may get fail at someother situation.
//flaky test cases occur due to n/w issues, s/m loading issues.
//for such flaky test cases retry mechanism can be implemented. When retry is applied on a test case, it runs multiple times.

//Retry is a mechanism which gives multiple chances for a test script if it is failing due to flaky reasons.