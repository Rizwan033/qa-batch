package ItEdgeProjectIn1Maven.ItEdgeProjectIn1Maven_ArtifactID;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TdClientMortgagePreApproval {

	WebDriver driver; 
	String baseURL;
	
	@FindBy(linkText="Get pre-approved")
	public static WebElement preApprovedButton;
	
	@FindBy(xpath="//span[contains(text(), ' permanent resident')]")
	public static WebElement categoryPermanentResident;
	
	@FindBy(xpath="//span[contains(text(), ' age of majority  ')]")
	public static WebElement categoryAgeOfMajority;
	
	@FindBy(xpath="//span[contains(text(), '  primary residence')]")
	public static WebElement categoryPrimaryResidence;
	
	@FindBy(xpath="//button[@id='close-tooltip']")
	public static WebElement closeCategoryToolTip;

	public void useChromeBrowser() {
		driver = new ChromeDriver();
		System.setProperty("ChromeDriver.driver","C:\\Users\\rizwa\\OneDrive\\Documents\\Selenium\\Application.chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		PageFactory.initElements(driver, this);
		
	}
		
	public void useMozillaBrowser() {
		driver = new FirefoxDriver();
		System.setProperty("MozillaDriver.driver", "C:\\Users\\rizwa\\OneDrive\\Documents\\Selenium\\Application.geckodriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}
	
	public void launchTestWebsite() {
		baseURL = "https://www.td.com/ca/en/personal-banking/products/mortgages/calculators-tools";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();

	} 
	
	public void scrollingDownIntoView() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", preApprovedButton);
	}
	
	public void navigateToTestPage() {
		preApprovedButton.click();
	}
	
	public void endBrowserSession() throws InterruptedException{
		Thread.sleep(10000);
		driver.quit();
	}
	
	public void clickAndCloseCategory1() throws InterruptedException {
		categoryPermanentResident.click();
		Thread.sleep(2000);
		closeCategoryToolTip.click();
	}
	
	public void clickAndCloseCategory2() throws InterruptedException {
		categoryAgeOfMajority.click();
		Thread.sleep(2000);
		closeCategoryToolTip.click();
	}
	
	public void clickAndCloseCategory3() throws InterruptedException {
		categoryPrimaryResidence.click();
		Thread.sleep(2000);
		closeCategoryToolTip.click();
	}
}
