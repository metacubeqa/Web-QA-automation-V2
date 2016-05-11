package testUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

/**
 * Utility for assertions and verification.
 * @author Ashish Sharma
 * @version 1.0
 * 
 */
public class TestUtil {

	/**
	 * isElementPresent to verify element is present or not.
	 * @param locatorKey - locator of element.
	 * @param driver .
	 * @return true/false
	 * 
	 */
	public static boolean isElementPresent(By locatorKey, WebDriver driver) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * isElementVisible to verify element is visible or not.
	 * @param locatorKey - locator of element.
	 * @param driver .
	 * @return true/false
	 * 
	 */
	public static boolean isElementVisible(By locatorKey, WebDriver driver){
		try {

			return driver.findElement(locatorKey).isDisplayed();

		} catch (org.openqa.selenium.ElementNotVisibleException e) {
			return false;
		}
	}

	/**
	 * isTextPresent to verify text is present or not.
	 * @param element - web-element which contains text.
	 * @param driver .
	 * @param str - Text which we want to verify.
	 * @return true/false
	 * 
	 */
	public static boolean isTextPresent(WebElement element, String str, WebDriver driver)
	{
		try {

			return element.getText().equals(str);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * verifyDropdownSelection to verify drop-down selection.
	 * @param driver .
	 * @param str - drop-down option which we want to verify.
	 * @return true/false
	 * 
	 */
	public static boolean verifyDropdownSelection(Select dropdown, String str, WebDriver driver)
	{
		try {
			return(dropdown.getFirstSelectedOption()).getText().equals(str);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * verifyTextboxValue to verify text present in textbox.
	 * @param element - web-element.
	 * @param driver .
	 * @param str - Text which we want to verify.
	 * @return true/false
	 * 
	 */
	public static boolean verifyTextboxValue(WebElement element, String str, WebDriver driver)
	{
		try {
			return element.getAttribute("value").equals(str);

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * verifyTableTextEntries to verify text values of any cell of the table.
	 * @param locator - locator of the table.
	 * @param driver .
	 * @param values[] - array of text values which we want to verify.
	 * 
	 */
	public static void verifyTableTextEntries(String locator, String values[], WebDriver driver)
	{
		int sizeTable,k=0;
		List<WebElement> all_cell;
		sizeTable =(driver.findElements(By.xpath(locator+"/tr")).size());

		for(int i=1;i<=sizeTable;i++)
		{
			all_cell=driver.findElements(By.xpath(locator+"/tr[" +i+ "]/td"));

			for(int j=0;j<all_cell.size();j++)
			{
				if(!(all_cell.get(j).getText()).isEmpty() && !(all_cell.get(j).getText()).equals(" "))
				{

					assertTrue(all_cell.get(j).getText().equals(values[k]));
					k++;
				}

			}
		}
	}

	/**
	 * selectDateFromCalendar to select the date.
	 * @param element - web-element of calendar.
	 * @param driver .
	 * @param str - date which we want to select.
	 * @return true/false
	 * 
	 */
	public static boolean selectDateFromCalendar(WebElement element, String date, WebDriver driver)
	{
		try {
			/*DatePicker is a table.So navigate to each cell   
			 * If a particular cell matches value then select it  
			 */  
			List<WebElement> rows, columns;

			rows=element.findElements(By.tagName("tr"));  
			System.out.println(rows);
			columns=element.findElements(By.tagName("td"));  

			for (WebElement cell: columns){  
				//Select Date   
				if (cell.getText().equals(date)){  
					cell.findElement(By.linkText(date)).click();  
					break;  
				}  
			}  
			return true;

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * addRemoveKeywordsFromSeoCallTrackingTable to select the date.
	 * @param locator - locator of the table.
	 * @param driver .
	 * @param num - number of keywords user want to select.
	 *  @param status - add/remove
	 * @return true/false
	 * 
	 */
	public static boolean addRemoveKeywordsFromSeoCallTrackingTable(String locator, int num, WebDriver driver , String status)
	{
		try {

			int rows, k=0;
			WebElement column_element;
			rows =(driver.findElements(By.xpath(locator+"/tr")).size());

			for(int i=1; i<=rows && k<num; i++)
			{

				column_element = driver.findElement(By.xpath(locator +"/tr[" +i+ "]/td[@class='sm-add']/a/div"));


				if(status.equals("add") && column_element.getAttribute("class").equals("green-plus"))
				{
					column_element.click();	
					k++;
				}else {

					if(status.equals("remove") && column_element.getAttribute("class").equals("red-minus"))
					{
						column_element.click();	
						k++;
						Thread.sleep(2000);
					}

				}

			}
			return true;

		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} 
	}


	/**
	 * selectUsersFromManageUsersAddTable to select the date.
	 * @param locator - locator of the table.
	 * @param driver .
	 * @param num - number of users we want to select.
	 * @return true/false
	 * 
	 */
	public static boolean selectUsersFromManageUsersAddTable(String locator, int num, WebDriver driver) throws InterruptedException
	{
		int rows, k=0;
		WebElement column_element;
		rows =(driver.findElements(By.xpath(locator+"/tr")).size());

		for(int i=1; i<=rows && k<num; i++)
		{

			column_element = driver.findElement(By.xpath(locator +"/tr[" +i+ "]/td[@class=' sorting_1']/input"));


			if(column_element.isEnabled())
			{
				column_element.click();	
				k++;
			}


		}

		if(k == (num-1))
			return true;
		else
			return false; 
	}

	/**
	 * deleteUsersFromManageUsersTable to select the date.
	 * @param locator - Array of locators 
	 * (1st locator -table , 2nd locator - edit button , 3rd locator - delete link, 4th locator - delete button)
	 * @param driver .
	 * @param num - number of users we want to delete.
	 * @return true/false
	 * 
	 */
	public static boolean deleteUsersFromManageUsersTable(String locator[], int num, WebDriver driver ,Wait<WebDriver> wait) throws InterruptedException
	{
		int rows, k=0;
		WebElement column_element;
		rows =(driver.findElements(By.xpath(locator[0]+"/tr")).size());

		for(int i=rows; i>2 && k<num; i--)
		{
			column_element = driver.findElement(By.xpath(locator[0] +"/tr[" +i+ "]/td[@class='name']"));



			if( !column_element.getText().equals("Demo QA02") && !column_element.getText().equals("Demo QA01") )
			{
				column_element = driver.findElement(By.xpath(locator[0] +"/tr[" +i+ "]/td[@class='details-edit']/a/i"));
				column_element.click();	
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator[1])));
				driver.findElement(By.xpath(locator[1])).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator[2])));
				driver.findElement(By.xpath(locator[2])).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator[3])));
				driver.findElement(By.xpath(locator[3])).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator[0])));
				k++;
			}

		}

		if(k == (num-1))
			return true;
		else
			return false; 
	}

	/**
	 * checkUserStatus to check the user status is green or yellow.
	 * @param locator - table locator 
	 * @param driver .
	 * @param no_of_user - number of users whom we want to check status .
	 * 
	 */
	public static void checkUserStatus(String locator, int no_of_user ,String status, WebDriver driver) throws Exception {
		int rows, k=0;
		WebElement column_element;
		String failedMsg = "Status indicator is not correct" , status_class ;
		String PassedMsg = "Status indicator is correct";
		boolean passed = true, failed = false;

		// verify assign extension number status is yellow
		rows =(driver.findElements(By.xpath(locator+"/tr")).size());

		if(status.equals("yellow"))
			status_class = "icon icon-nonumber";
		else
			status_class = "icon icon-active";

		for(int i=rows; i>(rows-no_of_user) && k<no_of_user; i--)
		{
			column_element = driver.findElement(By.xpath(locator +"/tr[" +i+ "]/td[1]/a/i"));		

			if(column_element.getAttribute("class").equals(status_class))
			{
				assertTrue(passed, PassedMsg);
				k++;
			}
			else
			{
				assertTrue(failed, failedMsg);
			}
		}


	}

	/**
	 * This function is used to delete the smart numbers from "Manage Smart Numbers" utility.
	 * @param smartnumber
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void deleteSmartNumbers(String smartnumber, WebDriver driver) throws InterruptedException
	{
		System.out.println("Hello");
		driver.findElement(By.xpath("//*[@id='manage']")).click();
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[6]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(smartnumber);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(Keys.RETURN);
		// Thread.sleep function is used to give some time gap in order to get the data on the screen.
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[2]/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[1]/div/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[2]/div[11]/a")).click();
		driver.findElement(By.xpath("//*[@id='delete-smart-number']/a[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='track']")).click();
		Thread.sleep(5000);
	}

	/**
	 * This function is used to review the smart number details.
	 * @param smartnumber
	 * @param channelname
	 * @param channeltype
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void reviewsmartnumbers(String smartnumber,String channelname, String channeltype, WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='manage']")).click();
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[6]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(smartnumber);
		Thread.sleep(10000);
		String Name = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[2]")).getAttribute("title");
		String Source = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[3]")).getText();
		System.out.println(Source);
		String Type = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[4]")).getText();
		String smrtnumber = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[5]")).getText();
		assertEquals(smartnumber, smrtnumber);
		//assertEquals(Source, "Social Media");
		assertEquals(channeltype,Type);
		assertEquals(channelname,Name);
		driver.findElement(By.xpath("//*[@id='track']")).click();

	}
	/**
	 *  This function is used to open the details of the smart numbers.
	 * @param smartnumber
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void openDetails(String smartnumber, WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='manage']")).click();
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[6]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(smartnumber);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[2]/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[1]/div/button[1]")).click();
		String details_smartnumber_header = driver.findElement(By.linkText("Smart Numbers")).getText();
		assertEquals(details_smartnumber_header, "Smart Numbers");
		driver.findElement(By.xpath("//*[@id='track']")).click();
	}
	/**
	 * This function is used to review the smart numbers on the details page.
	 * @param smartnumber
	 * @param channelname
	 * @param channeltype
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void reviewsmartnumbersfrom_DetailsPaage(String smartnumber,String channelname, String channeltype, WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='manage']")).click();
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[6]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(smartnumber);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[2]/a")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[1]/div/button[1]")).click();
		String Name = driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[2]/div[1]/div[1]/div[2]/div/span")).getText();
		String Source = driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[2]/div[1]/div[3]/div[1]/div/span")).getText();
		System.out.println(Source);
		String Type = driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[2]/div[1]/div[3]/div[2]/div/span")).getText();
		String smrtnumber = driver.findElement(By.xpath("//*[@id='smartNumber-edit']/div[2]/div[1]/div[1]/div[1]/div/span")).getText();
		assertEquals(smartnumber, smrtnumber);
		//assertEquals(Source, "Social Media");
		assertEquals(channeltype,Type);
		assertEquals(channelname,Name);
		driver.findElement(By.xpath("//*[@id='track']")).click();

	}
	/**
	 * This function is used to review the smart numbers for URL Call Tracking feature.
	 * @param smartnumber
	 * @param channel_URL_name
	 * @param channeltype
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void reviewsmartnumbers_forURL(String smartnumber,String channel_URL_name, String channeltype, WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='manage']")).click();
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[6]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='smartNumber-list']/div[1]/div/input[1]")).sendKeys(smartnumber);
		Thread.sleep(10000);
		String URL_Name = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[2]")).getText();
		String Source = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[3]")).getText();
		String Type = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[4]")).getText();
		String smrtnumber = driver.findElement(By.xpath("//*[@id='smartNumbersTable']/tbody/tr/td[5]")).getText();
		assertEquals(smartnumber, smrtnumber);
		assertEquals(Source, "URL");
		assertEquals(channeltype,Type);
		assertEquals(channel_URL_name,URL_Name);
		driver.findElement(By.xpath("//*[@id='track']")).click();
		Thread.sleep(5000);
	}

	/**
	 * This function is used to check whether user is present in the list of a group or not.
	 * @param startlocator
	 * @param endlocator
	 * @param tablelocator
	 * @param groupname
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */

	public static boolean isuserPresent(String startlocator, String endlocator,String tablelocator,String groupname, WebDriver driver) throws InterruptedException
	{
		int rows, k=0;
		WebElement column_element;
		rows =(driver.findElements(By.xpath(tablelocator+"/tr")).size());

		for(int i=1; i<=rows && k<2; i++)
		{

			column_element = driver.findElement(By.xpath(startlocator +i+ endlocator));


			if((column_element.getText()).equals(groupname))
			{	
				k++;
			}


		}

		if(k == 1)
			return true;
		else
			return false; 
	}


}
