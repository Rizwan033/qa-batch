package ItEdgeProjectIn1Maven.ItEdgeProjectIn1Maven_ArtifactID;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class TDMortgageUnderTest {

	TdClientMortgagePreApproval Tdcmp = new TdClientMortgagePreApproval();

	@BeforeTest
	public void beforeTest() {
		Tdcmp.useMozillaBrowser();
		Tdcmp.launchTestWebsite();
	}

	@Test
	public void test1_goingToTestPage() {
		Tdcmp.scrollingDownIntoView();
		Tdcmp.navigateToTestPage();
	}

	@Test
	public void test2_clickingOnCategory1AndClosing() throws InterruptedException {
		Tdcmp.clickAndCloseCategory1();
	}

	@Test
	public void test3_clickingOnCategory2AndClosing() throws InterruptedException {
		Tdcmp.clickAndCloseCategory2();
	}

	@Test
	public void test4_clickingOnCategory3AndClosing() throws InterruptedException {
		Tdcmp.clickAndCloseCategory3();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Tdcmp.endBrowserSession();
	}
}
