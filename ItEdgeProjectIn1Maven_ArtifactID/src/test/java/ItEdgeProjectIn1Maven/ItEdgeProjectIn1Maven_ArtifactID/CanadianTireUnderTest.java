package ItEdgeProjectIn1Maven.ItEdgeProjectIn1Maven_ArtifactID;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class CanadianTireUnderTest {


	CanadianTire obj = new CanadianTire();
	String categoryButtonColor;
	String headerOfThePage;

	// Test to check for category background and capture the text of the category
	// TC13 - Test to click on Category filter drop down

	@BeforeTest
	public void beforeTests() {
		obj.useChromeBrowser();
		obj.launchTestWebsite();

	}

	@Test 
	public void test1() { 
		obj.navigateToTestPage(); // going to hot offers page and click on category filter button
	}

	// This is to test the category filter button has black background when hover 
	@Test
	public void test2() throws InterruptedException {
		/*
		 * obj.causingDelayToAction(); obj.navigateToTestPage();
		 */
		// obj.scrollDown();
		obj.causingDelayToAction();
		obj.categoryFilterButtonPropertyWhenHover();
	}

	// This is to test the category filter button has black background when click
	@Test
	public void test3() throws InterruptedException {
		// obj.scrollDown();
		/*
		 * obj.causingDelayToAction(); obj.navigateToTestPage();
		 */
		// obj.scrollDown();
		obj.causingDelayToAction();
		obj.categoryFilterButtonPropertyWhenClick();
	}




	@AfterTest
	public void afterTests() throws InterruptedException {
		obj.endBrowserSession();
	}

}
