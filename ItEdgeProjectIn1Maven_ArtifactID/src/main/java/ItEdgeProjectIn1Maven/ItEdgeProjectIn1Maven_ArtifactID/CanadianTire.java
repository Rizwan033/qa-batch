package ItEdgeProjectIn1Maven.ItEdgeProjectIn1Maven_ArtifactID;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CanadianTire {

	String baseURL;			
	WebDriver driver;    			// initialize web driver
	String categoryButtonColor;
	
	// on Home page, the user has to go to the Hot offers page, this is the link for that
	
	@FindBy(linkText="Shop Now")
	public static WebElement navigateTo;

	@FindBy(xpath = "//span[contains(text(), 'Category')]")
	public static WebElement categoryButton;

	/*using Page factory of the POM for the WebElements, initializing it 
	using this keyword */ 

	// These are the Methods to do the different tests or invoke from Test classes
	public void useChromeBrowser() {
		driver = new ChromeDriver();
		System.setProperty("ChromeDriver.driver", "C:\\Users\\rizwa\\OneDrive\\Documents\\Selenium\\Application.chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		PageFactory.initElements(driver, this);
	}

	public void useMozillaBrowser() {
		driver = new FirefoxDriver();
		System.setProperty("MozillaDriver.driver", "C:\\Users\\rizwa\\OneDrive\\Documents\\Selenium\\Application.geckodriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		PageFactory.initElements(driver, this);
	}

	public void launchTestWebsite() {
		baseURL = "https://www.canadiantire.ca/en.html";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();

	} 

	public void endBrowserSession() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

	public void navigateToTestPage(){
		navigateTo.click();
		String headerOfThePage = driver.getTitle();
		Assert.assertEquals("Hot Sale | Canadian Tire", headerOfThePage);
	}

	public void categoryFilterButtonPropertyWhenClick() {
		categoryButton.click();
		categoryButtonColor = categoryButton.getCssValue("border-color");
		System.out.println("category filter button when mouse click " + categoryButtonColor);
		//System.out.println("category filter button att " + categoryButton.getCssValue("border-box"));
		// Assert.assertEquals("rgb(38, 38, 38)", categoryButtonColor);
	}

	public void categoryFilterButtonPropertyWhenHover() {
		Actions action = new Actions(driver);
		action.moveToElement(categoryButton).perform();
		System.out.println("category filter button when mouse hover " + categoryButton.getCssValue("border-color"));
		Assert.assertEquals("rgb(38, 38, 38)", categoryButtonColor);
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", categoryButton);
	}

	public void causingDelayToAction() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public void clickOutsideOfBox() {
		
	}



}
