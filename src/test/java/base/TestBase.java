package base;

import java.io.FileInputStream;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//import com.saucelabs.common.SauceOnDemandAuthentication;
//import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.saucerest.SauceREST;


//import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
/**
 * Test Base Class is used for Initialization of Properties file, driver etc.
 * @author Yamini Tolambia
 * @version 1.0
 */
public class TestBase {

	//Initializing the properties file reading
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver driver = null;
	public static boolean isLoggedIn = false;
	public static Wait<WebDriver> wait;
	public Select select;

	// Setup function for initialize webdriver and define browser properties

	@Parameters({"username", "key", "os", "browser", "browserVersion"})
	
	@BeforeMethod
	public void setUp(@Optional("cb_ringdna") String username,
			@Optional("97fa0cf8-f39d-44f8-90ad-92cb455194e3") String key,
			@Optional("WIN8") String os,
			@Optional("chrome") String browser,
			@Optional("44.0") String browserVersion,
			Method method) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();	
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		capabilities.setBrowserName(browser);
		capabilities.setCapability("version", browserVersion);
		capabilities.setCapability("platform", Platform.valueOf(os));
		capabilities.setCapability("name", method.getName());
		System.out.println("Hello i am in capa");
		
		driver = new RemoteWebDriver(
				new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
				capabilities);
		wait = new WebDriverWait(driver, 50);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		initialize();
	}

	// Teardown function for closing webdriver

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		String jobID = ((RemoteWebDriver)driver).getSessionId().toString();
		SauceREST client = new SauceREST("cb_ringdna", "97fa0cf8-f39d-44f8-90ad-92cb455194e3");
		Map<String, Object>sauceJob = new HashMap<String, Object>();
		sauceJob.put("name", "Test method: "+result.getMethod().getMethodName());
		if(result.isSuccess()) {
			client.jobPassed(jobID);
			
		} else {
			client.jobFailed(jobID);
		}
		client.updateJobInfo(jobID, sauceJob); 
		System.out.println("I am in Tear down");
		driver.quit();
	}


	//initialize method is responsible for initialize these properties file.
	public void initialize() throws IOException

	{
		// initialize CONFIG Properties file first.

		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//config//config.properties");
		CONFIG.load(fn);

		// initialize OR Properties file first.

		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//config//OR.properties");
		OR.load(fn);

	}

	// doLogin Function to Log-in in the application

	public static void doLogin(String username, String password) throws InterruptedException
	{
		System.out.println("Login to web app");
		driver.get(CONFIG.getProperty("testSiteName"));
		getObject("signin_link").click();
		Thread.sleep(2000);
		getObject("username_signin_input").clear();
		getObject("username_signin_input").sendKeys(username);
		getObject("password_signin_input").sendKeys(password);
		getObject("signin_button").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("manage_menu_link"))));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.getProperty("users_menu_link"))));
	}

	// doLogin Function to Log-in in the application for free account

	public static void doLogin_free(String username, String password)
	{
		driver.get(CONFIG.getProperty("testSiteName"));
		getObject("signin_link").click();
		getObject("username_signin_input").clear();
		getObject("username_signin_input").sendKeys(username);
		getObject("password_signin_input").sendKeys(password);
		getObject("signin_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("support_menu"))));

	}

	// logOut function to exit from the application

	public static void logOut() throws InterruptedException
	{
		getObject("logout_link").click();
		Thread.sleep(5000);
		driver.close();
	}
	
	// This function is used to get the WebElement directly using their respective xpaths.
	public static WebElement getObject(String xpathkey){

		try{
			return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		}catch(Exception e){
			//error message
			return null;
		}

	}

}
