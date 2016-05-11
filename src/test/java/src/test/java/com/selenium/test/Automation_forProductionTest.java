

package src.test.java.com.selenium.test;
import java.io.IOException;



import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import testUtil.TestUtil;
import base.TestBase;

/**
 * Smoke Test cases for QA environment.
 * @author Sumit Kumar Jangid
 * @version 1.0
 * 
 */
public class Automation_forProductionTest extends TestBase {


	String smart_number1, smart_number2 ,smart_number3, smart_number4, source1, source2, source3, source4, type ="Keyword",type1 ="default", name1, name2, name3, name4, tag1, tag2, tag3,tag4;
	String fields_values[] = new String[9];
	String testing_values[] = {"testfirstname", "testlastname" ,"testtitle", "abc@ringdna.com", "01234567890", "SP-6, Phase IV, (Software Technology Park), EPIP Sitapura", "Jaipur", "Rj", "302022"};
	
	@Test(priority= 0)

	// Test Case ID - 1
	// @throws InterruptedException
	// Objective- Generate a smart number for Basic call tracking-local

	public void smartnumber_for_Basic_calltracking_local() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("basiccalltracking_menu_link").click();
		getObject("Basic_Google_plus_button").click();
		getObject("Basic_Google_website_textbox").sendKeys("www.ashish.com");
		getObject("Basic_added_Google_local_radiobutton").click();
		getObject("Basic_added_Google_local_areacode_textbox").clear();
		getObject("Basic_added_Google_local_areacode_textbox").sendKeys("859");
		getObject("Basic_added_Google_local_tag_textbox").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("Basic_added_Google_local_tag_textbox").sendKeys(Keys.TAB);
		boolean next_isenabled = getObject("basiccalltracking_next_button").isEnabled();
		assertEquals(next_isenabled, true);
		getObject("basiccalltracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Basic_finalizepage_review_table"))));
		Thread.sleep(15000);
		String source_text = getObject("Basic_finalizepage_source_name").getText();
		String type_text = getObject("Basic_finalizepage_type_name").getText();
		String name_text = getObject("Basic_finalizepage_name").getText();
		String wesite_text = getObject("Basic_finalizepage_website_name").getText();
		String tags_text = getObject("Basic_finalizepage_tags_name").getText();
		String smartnumber_text = getObject("Basic_finalizepage_smartnumber_text").getText();
		assertEquals(source_text, "Basic");
		assertEquals(type_text, "Default");
		assertEquals(name_text, "Google");
		assertEquals(wesite_text, "www.ashish.com");
		assertEquals(tags_text, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber_text, driver);
		logOut();
	}	

	@Test(priority= 1)

	// Test Case ID - 2
	// @throws InterruptedException
	// Objective- Generate a smart number for Basic call tracking-TollFree

	public void smartnumber_for_Basic_calltracking_tollfree() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("basiccalltracking_menu_link").click();
		getObject("Basic_Google_plus_button").click();
		getObject("Basic_Google_website_textbox").sendKeys("www.ashish.com");
		getObject("Basic_added_Google_tollfree_radiobutton").click();
		boolean isenabled =getObject("Basic_added_Google_local_areacode_textbox").isEnabled();
		assertEquals(isenabled, false);
		boolean isenabled1 = getObject("Basic_added_Google_local_radiobutton").isEnabled();
		assertEquals(isenabled1, true);
		getObject("Basic_added_Google_local_tag_textbox").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("Basic_added_Google_local_tag_textbox").sendKeys(Keys.TAB);
		boolean next_isenabled = getObject("basiccalltracking_next_button").isEnabled();
		assertEquals(next_isenabled, true);
		getObject("basiccalltracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Basic_finalizepage_review_table"))));
		Thread.sleep(10000);
		String source_text = getObject("Basic_finalizepage_source_name").getText();
		String type_text = getObject("Basic_finalizepage_type_name").getText();
		String name_text = getObject("Basic_finalizepage_name").getText();
		String wesite_text = getObject("Basic_finalizepage_website_name").getText();
		String tags_text = getObject("Basic_finalizepage_tags_name").getText();
		String smartnumber_text = getObject("Basic_finalizepage_smartnumber_text").getText();
		assertEquals(source_text, "Basic");
		assertEquals(type_text, "Default");
		assertEquals(name_text, "Google");
		assertEquals(wesite_text, "www.ashish.com");
		assertEquals(tags_text, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber_text, driver);
		logOut();
	}

	@Test(priority= 2)

	// Test Case ID - 3
	// @throws InterruptedException
	// Objective- Generate a smart number for SEO call tracking-local

	public void smartnumber_for_SEO_calltracking_local() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_menu_link"))));	
		getObject("seocalltracking_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_connect_button"))));
		getObject("seocalltracking_linktonewaccount_link").click();
		getObject("seocalltracking_email_textbox").sendKeys("marketing@ringdna.com");
		
		if(getObject("seocalltracking_login_next_step_button")!=null)
		{
			getObject("seocalltracking_login_next_step_button").click();
		}
		Thread.sleep(3000);
		getObject("seocalltracking_password_textbox").click();
		getObject("seocalltracking_password_textbox").clear();
		getObject("seocalltracking_password_textbox").sendKeys("ringdnaebmdna0198");
		getObject("seocalltracking_signin_button").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_allowaccess_button"))));
		getObject("seocalltracking_allowaccess_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_connect_button"))));
		Thread.sleep(2000);
		assertTrue(getObject("seocalltracking_googleaccount_dropdown").isDisplayed());
		select = new Select(getObject("seocalltracking_googleaccount_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("marketing@ringdna.com");
		getObject("seocalltracking_connect_button").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticsaccount_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticsaccount_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticswebproperty_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticswebproperty_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("UA-25419068-1 - http://www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticsprofile_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticsprofile_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("49914487 - www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_next_button"))));
		getObject("seocalltracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_keyword1_addcell_table"))));
		getObject("seocalltracking_search_textbox").clear();
		getObject("seocalltracking_search_textbox").sendKeys("(not provided)");
		String classname = getObject("seocalltracking_select_keyword").getAttribute("class");
		assertEquals(classname, "green-plus");
		getObject("seocalltracking_select_keyword").click();
		getObject("seocalltracking_keywordtracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_entry1_channelcell_table"))));
		getObject("seocalltracking_select_local_radiobutton").click();
		getObject("seocalltracking_select_areacode_textbox").sendKeys("859");
		getObject("seocalltracking_enter_tag").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("seocalltracking_enter_tag").sendKeys(Keys.TAB);
		getObject("seocalltracking_assignsmartnumber_next_button").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_entry1_channelcell_review_table"))));
		String channel_name = getObject("seocalltracking_finalizepage_channel_name").getText();
		String channel_keywords = getObject("seocalltracking_finalizepage_channel_keywordsname").getText();
		String channel_Tags = getObject("seocalltracking_finalizepage_channel_tagsname").getText();
		String channel_smartnumber = getObject("seocalltracking_finalizepage_channel_smartnumber").getText();
		assertEquals(channel_name, "Organic / bing");
		assertEquals(channel_keywords, "(not provided)");
		assertEquals(channel_Tags, "Ashish");
		TestUtil.deleteSmartNumbers(channel_smartnumber, driver);
		logOut();
	}	

	@Test(priority= 3)

	// Test Case ID - 4
	// @throws InterruptedException
	// Objective- Generate a smart number for SEO call tracking- tollfree

	public void smartnumber_for_SEO_calltracking_tollfree() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_menu_link"))));	
		getObject("seocalltracking_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_connect_button"))));
		getObject("seocalltracking_linktonewaccount_link").click();
		getObject("seocalltracking_email_textbox").sendKeys("marketing@ringdna.com");
		
		if(getObject("seocalltracking_login_next_step_button")!=null)
		{
			getObject("seocalltracking_login_next_step_button").click();
		}
		Thread.sleep(3000);
		getObject("seocalltracking_password_textbox").click();
		getObject("seocalltracking_password_textbox").clear();
		getObject("seocalltracking_password_textbox").sendKeys("ringdnaebmdna0198");
		getObject("seocalltracking_signin_button").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_allowaccess_button"))));
		getObject("seocalltracking_allowaccess_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_connect_button"))));
		Thread.sleep(2000);
		assertTrue(getObject("seocalltracking_googleaccount_dropdown").isDisplayed());
		select = new Select(getObject("seocalltracking_googleaccount_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("marketing@ringdna.com");
		getObject("seocalltracking_connect_button").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticsaccount_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticsaccount_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticswebproperty_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticswebproperty_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("UA-25419068-1 - http://www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_googleanalyticsprofile_dropdown"))));

		select = new Select(getObject("seocalltracking_googleanalyticsprofile_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("49914487 - www.ringdna.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("seocalltracking_next_button"))));
		getObject("seocalltracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_keyword1_addcell_table"))));
		getObject("seocalltracking_search_textbox").clear();
		getObject("seocalltracking_search_textbox").sendKeys("(not provided)");
		String classname = getObject("seocalltracking_select_keyword").getAttribute("class");
		assertEquals(classname, "green-plus");
		getObject("seocalltracking_select_keyword").click();
		getObject("seocalltracking_keywordtracking_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_entry1_channelcell_table"))));
		getObject("seocalltracking_select_tollfree_radiobutton").click();
		boolean isenabled = getObject("seocalltracking_select_areacode_textbox").isEnabled();
		assertEquals(isenabled, false);
		getObject("seocalltracking_enter_tag").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("seocalltracking_enter_tag").sendKeys(Keys.TAB);
		getObject("seocalltracking_assignsmartnumber_next_button").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("seocalltracking_entry1_channelcell_review_table"))));
		String channel_name = getObject("seocalltracking_finalizepage_channel_name").getText();
		String channel_keywords = getObject("seocalltracking_finalizepage_channel_keywordsname").getText();
		String channel_Tags = getObject("seocalltracking_finalizepage_channel_tagsname").getText();
		String channel_smartnumber = getObject("seocalltracking_finalizepage_channel_smartnumber").getText();
		assertEquals(channel_name, "Organic / bing");
		assertEquals(channel_keywords, "(not provided)");
		assertEquals(channel_Tags, "Ashish");
		TestUtil.deleteSmartNumbers(channel_smartnumber, driver);
		logOut();
	}	


	@Test(priority= 4)

	// Test Case ID - 5
	// @throws InterruptedException
	// Objective- Generate a smart number for Google Adwords call tracking-local

	public void smartnumber_for_GoogleAdwords_calltracking_local1() throws InterruptedException
	{
		// doLogin function is used to login into application
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		// getObject is a function which returns WebElement.
		getObject("track_menu_link").click();
		getObject("googleadwords_calltracking_link").click(); 
		getObject("googleadwords_select_account").sendKeys("marketing@ringdna.com");
		boolean isenabled = getObject("googleadwords_connect_button").isEnabled();
		assertEquals(isenabled, true);
		getObject("googleadwords_connect_button").click();
		boolean isenabled_connect = getObject("googleadwords_next_button").isEnabled();
		assertEquals(isenabled_connect, true);
		getObject("googleadwords_next_button").click();	
		Thread.sleep(10000);
		select = new Select(getObject("googleadwords_select_viewall"));
		Thread.sleep(2000);
		select.selectByVisibleText("Keywords");
		Thread.sleep(15000);
		getObject("googleadwords_search_textbox").sendKeys("inside sales software");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_grid_keyword_name"))));
		String keyword_grid_name = getObject("googleadwords_grid_keyword_name").getText();
		assertEquals(keyword_grid_name, "inside sales software");
		getObject("googleadwords_grid_keywords_track_button").click();
		String status = getObject("googleadwords_grid_keywords_track_button").getAttribute("class");
		String number_afterclick = getObject("googleadwords_numberof_keywords_added").getText();
		assertEquals(status, "red-minus");
		assertEquals(number_afterclick, "1");
		getObject("googleadwords_grid_next_button").click();
		String heading = getObject("googleadwords_grid_AssignPage_heading").getText();
		assertEquals(heading, "Assign Phone Numbers");
		getObject("googleadwords_local_radiobutton").click();
		getObject("googleadwords_areacode_textbox").sendKeys("859");
		getObject("googleadwords_tag_textbox").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("googleadwords_tag_textbox").sendKeys(Keys.TAB);
		boolean isnextbutton_enabled = getObject("googleadwords_assignpage_next_button").isEnabled();
		assertEquals(isnextbutton_enabled, true);
		getObject("googleadwords_assignpage_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_finalizepage_review_table"))));
		Thread.sleep(10000);
		String keyword_name = getObject("googleadwords_keyword_name").getText();
		assertEquals(keyword_name,"inside sales software");
		String keyword_smartnumber = getObject("googleadwords_keyword_smartnumber").getText();
		TestUtil.deleteSmartNumbers(keyword_smartnumber, driver);
		logOut(); 
	}

	@Test(priority= 5)

	// Test Case ID - 6
	// @throws InterruptedException
	// Objective- Generate a smart number for Google Adwords-toll free, generate it for campaign

	public void smartnumber_for_GoogleAdwords_calltracking_local2() throws InterruptedException
	{
		// doLogin function is used to login into application
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		// getObject is a function which returns WebElement.
		getObject("track_menu_link").click();
		getObject("googleadwords_calltracking_link").click(); 
		getObject("googleadwords_select_account").sendKeys("marketing@ringdna.com");
		boolean isenabled = getObject("googleadwords_connect_button").isEnabled();
		assertEquals(isenabled, true);
		getObject("googleadwords_connect_button").click();
		boolean isenabled_connect = getObject("googleadwords_next_button").isEnabled();
		assertEquals(isenabled_connect, true);
		getObject("googleadwords_next_button").click();	
		Thread.sleep(10000);
		getObject("googleadwords_search_textbox").sendKeys("Inside Sales Comparison");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_grid_campaign_name"))));
		String keyword_grid_name = getObject("googleadwords_grid_campaign_name").getText();
		assertEquals(keyword_grid_name, "Inside Sales Comparison");
		Thread.sleep(3000);
		getObject("googleadwords_grid_track_button").click();
		String status = getObject("googleadwords_grid_track_button").getAttribute("class");
		String number_afterclick = getObject("googleadwords_numberof_campaign_added").getText();
		assertEquals(status, "red-minus");
		assertEquals(number_afterclick, "1");
		getObject("googleadwords_grid_next_button").click();
		String heading = getObject("googleadwords_grid_AssignPage_heading").getText();
		assertEquals(heading, "Assign Phone Numbers");
		getObject("googleadwords_tollfree_radiobutton").click();
		boolean is_enabled_areacode_textbox = getObject("googleadwords_areacode_textbox").isEnabled();
		assertEquals(is_enabled_areacode_textbox, false);
		getObject("googleadwords_tag_textbox").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("googleadwords_tag_textbox").sendKeys(Keys.TAB);
		boolean isnextbutton_enabled = getObject("googleadwords_assignpage_next_button").isEnabled();
		assertEquals(isnextbutton_enabled, true);
		getObject("googleadwords_assignpage_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_finalizepage_review_table"))));
		Thread.sleep(10000);
		String campaign_name = getObject("googleadwords_finalizepage_campaign_name").getText();
		assertEquals(campaign_name,"Inside Sales Comparison");
		String keyword_smartnumber = getObject("googleadwords_keyword_smartnumber").getText();
		TestUtil.deleteSmartNumbers(keyword_smartnumber, driver);
		logOut(); 
	}	

	@Test(priority= 6)

	// Test Case ID - 7
	// @throws InterruptedException
	// Objective- Generate a smart number for Google Adwords-toll free, generate it for Adgroup

	public void smartnumber_for_GoogleAdwords_calltracking_tollfree() throws InterruptedException
	{
		// doLogin function is used to login into application
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		// getObject is a function which returns WebElement.
		getObject("track_menu_link").click();
		getObject("googleadwords_calltracking_link").click(); 
		getObject("googleadwords_select_account").sendKeys("marketing@ringdna.com");
		boolean isenabled = getObject("googleadwords_connect_button").isEnabled();
		assertEquals(isenabled, true);
		getObject("googleadwords_connect_button").click();
		boolean isenabled_connect = getObject("googleadwords_next_button").isEnabled();
		assertEquals(isenabled_connect, true);
		getObject("googleadwords_next_button").click();	
		Thread.sleep(10000);
		select = new Select(getObject("googleadwords_select_viewall"));
		Thread.sleep(2000);
		select.selectByVisibleText("Ad Groups");
		Thread.sleep(10000);
		getObject("googleadwords_search_textbox").sendKeys("Considering Inside Sales");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_grid_adwords_name"))));
		String Adgroup_grid_name = getObject("googleadwords_grid_adwords_name").getText();
		assertEquals(Adgroup_grid_name, "Considering Inside Sales");
		Thread.sleep(3000);
		getObject("googleadwords_grid_Adgroup_track_button").click();
		String status = getObject("googleadwords_grid_Adgroup_track_button").getAttribute("class");
		String number_afterclick = getObject("googleadwords_numberof_AdGroup_added").getText();
		assertEquals(status, "red-minus");
		assertEquals(number_afterclick, "1");
		getObject("googleadwords_grid_next_button").click();
		String heading = getObject("googleadwords_grid_AssignPage_heading").getText();
		assertEquals(heading, "Assign Phone Numbers");
		getObject("googleadwords_tollfree_radiobutton").click();
		boolean is_enabled_areacode_textbox = getObject("googleadwords_areacode_textbox").isEnabled();
		assertEquals(is_enabled_areacode_textbox, false);
		getObject("googleadwords_tag_textbox").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("googleadwords_tag_textbox").sendKeys(Keys.TAB);
		boolean isnextbutton_enabled = getObject("googleadwords_assignpage_next_button").isEnabled();
		assertEquals(isnextbutton_enabled, true);
		getObject("googleadwords_assignpage_next_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("googleadwords_finalizepage_review_table"))));
		Thread.sleep(10000);
		String adword_name = getObject("googleadwords_finalizepage_Adgroup_name").getText();
		assertEquals(adword_name,"Considering Inside Sales");
		String Adword_smartnumber = getObject("googleadwords_keyword_smartnumber").getText();
		TestUtil.deleteSmartNumbers(Adword_smartnumber, driver);
		logOut(); 
	}	

	@Test(priority= 7)

	// Test Case ID - 8
	// Objective - Generate a smart number for URL Call Tracking-local
	// @throws InterruptedException
	// @throws IOException

	public void Generate_a_smartnumber_for_URL_Call_Tracking_local() throws InterruptedException, IOException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("track_menu_urlcalltracking_link").click();
		getObject("urlcalltracking_selecttype_link").sendKeys("Blog");
		getObject("urlcalltracking_enterurl_link").sendKeys("www.automationbyAshish.com");
		getObject("urlcalltracking_trackthis_button").click();
		Thread.sleep(10000);
		getObject("urlcalltracking_globalareacode_textbox").clear();
		getObject("urlcalltracking_channel1_local_radiobutton").click();
		getObject("urlcalltracking_channel1_local_radiobutton").isEnabled();
		getObject("urlcalltracking_channel1_globalareacode").sendKeys("859");
		getObject("urlcalltracking_channel1_globalareacode").getAttribute("value");
		getObject("urlcalltracking_channel1_entertags_textbox").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("urlcalltracking_channel1_entertags_textbox").sendKeys(Keys.TAB);
		getObject("urlcalltracking_next_button").click();
		Thread.sleep(10000);
		String source = getObject("urlcalltracking_source_name").getText();
		String type = getObject("urlcalltracking_type_name").getText();
		String name = getObject("urlcalltracking_name").getText();
		String tag = getObject("urlcalltracking_tags").getText();
		String smartnumber = getObject("urlcalltracking_smartnumber").getText();
		assertEquals(source, "URL");
		assertEquals(type, "Blog");
		assertEquals(name, "www.automationbyAshish.com");
		assertEquals(tag, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();
	}

	@Test(priority= 8)

	// Test Case ID - 9
	// Objective - Generate a smart number for URL Call Tracking-tollfree
	// @throws InterruptedException
	// @throws IOException

	public void Generate_a_smartnumber_for_URL_Call_Tracking_tollfree() throws InterruptedException, IOException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("track_menu_urlcalltracking_link").click();
		getObject("urlcalltracking_selecttype_link").sendKeys("Blog");
		getObject("urlcalltracking_enterurl_link").sendKeys("www.automationbyAshishSharma.com");
		getObject("urlcalltracking_trackthis_button").click();
		Thread.sleep(10000);
		getObject("urlcalltracking_channel1_tollfree_radiobutton").click();
		boolean isenabled = getObject("urlcalltracking_channel1_globalareacode").isEnabled();
		assertEquals(isenabled, false);
		getObject("urlcalltracking_channel1_entertags_textbox").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("urlcalltracking_channel1_entertags_textbox").sendKeys(Keys.TAB);
		getObject("urlcalltracking_next_button").click();
		Thread.sleep(10000);
		String source = getObject("urlcalltracking_source_name").getText();
		String type = getObject("urlcalltracking_type_name").getText();
		String name = getObject("urlcalltracking_name").getText();
		String tag = getObject("urlcalltracking_tags").getText();
		String smartnumber = getObject("urlcalltracking_smartnumber").getText();
		assertEquals(source, "URL");
		assertEquals(type, "Blog");
		assertEquals(name, "www.automationbyAshishSharma.com");
		assertEquals(tag, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();
	}

	@Test(priority= 9)

	// Test Case ID - 10
	// Objective - Generate a smart number for Social Media Call Tracking-local
	// @throws InterruptedException

	public void Generate_smartnumber_for_SocialMedia_CallTracking_local() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("socialmediacalltracking_link").click();
		getObject("socialmedia_calltracking_add_button").click();
		getObject("socialmedia_calltracking_add_facebook_website_name").sendKeys("www.socialmedia.com");
		getObject("socialmedia_calltracking_add_facebook_local_radiobutton").click();
		getObject("socialmedia_calltracking_add_facebook_areacode").sendKeys("859");
		getObject("socialmedia_calltracking_add_facebook_tag").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("socialmedia_calltracking_add_facebook_tag").sendKeys(Keys.TAB);
		boolean isenabled = getObject("socialmediacalltracking_Next_button").isEnabled();
		assertEquals(isenabled, true);
		getObject("socialmediacalltracking_Next_button").click();
		Thread.sleep(10000);
		String source = getObject("socialmedia_calltracking_source").getText();
		String type = getObject("socialmedia_calltracking_type").getText();
		String name = getObject("socialmedia_calltracking_name").getText();
		String website = getObject("socialmedia_calltracking_website").getText();
		String tag = getObject("socialmedia_calltracking_tag").getText();
		String smartnumber = getObject("socialmedia_calltracking_smartnumber").getText();
		assertEquals(source, "Social Media");
		assertEquals(type, "Basic");
		assertEquals(name, "facebook.com");
		assertEquals(website, "www.socialmedia.com");
		assertEquals(tag, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();		
	}

	@Test(priority= 10)

	// Test Case ID - 11
	// Objective - Generate a smart number for Social Media Call Tracking- tollfree
	// @throws InterruptedException

	public void Generate_smartnumber_for_SocialMedia_CallTracking_tollfree() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		getObject("socialmediacalltracking_link").click();
		getObject("socialmedia_calltracking_add_button").click();
		getObject("socialmedia_calltracking_add_facebook_website_name").sendKeys("www.socialmedia.com");
		getObject("socialmedia_calltracking_add_facebook_tollfree_radiobutton").click();
		boolean isenabled = getObject("socialmedia_calltracking_add_facebook_areacode").isEnabled();
		assertEquals(isenabled, false);
		getObject("socialmedia_calltracking_add_facebook_tag").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("socialmedia_calltracking_add_facebook_tag").sendKeys(Keys.TAB);
		boolean isenabled1 = getObject("socialmediacalltracking_Next_button").isEnabled();
		assertEquals(isenabled1, true);
		getObject("socialmediacalltracking_Next_button").click();
		Thread.sleep(10000);
		String source = getObject("socialmedia_calltracking_source").getText();
		String type = getObject("socialmedia_calltracking_type").getText();
		String name = getObject("socialmedia_calltracking_name").getText();
		String website = getObject("socialmedia_calltracking_website").getText();
		String tag = getObject("socialmedia_calltracking_tag").getText();
		String smartnumber = getObject("socialmedia_calltracking_smartnumber").getText();
		assertEquals(source, "Social Media");
		assertEquals(type, "Basic");
		assertEquals(name, "facebook.com");
		assertEquals(website, "www.socialmedia.com");
		assertEquals(tag, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();		
	}




	// Test Case ID - 12
	// Objective - Generate a smart number for CustomCall Tracking-local
	// @throws InterruptedException

	@Test(priority = 11)
	public void generate_smartnumberfor_Custom_CallTracking_local() throws Exception {

		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("customcalltracking_menu_link"))));		
		getObject("customcalltracking_menu_link").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("customcalltracking_trackthis_button"))));
		select = new Select(getObject("customcalltracking_source_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("Radio");
		getObject("customcalltracking_type_textbox").sendKeys("FM");
		getObject("customcalltracking_name_textbox").sendKeys("Radio City");
		assertTrue(getObject("customcalltracking_trackthis_button").isDisplayed());
		getObject("customcalltracking_trackthis_button").click();
		Thread.sleep(6000);
		getObject("custom_calltracking_website_textbox").sendKeys("www.ashish.com");
		getObject("custom_calltracking_local_radio_button").click();
		getObject("custom_calltracking_areacode_textbox").sendKeys("859");
		getObject("custom_calltracking_tag_textbox").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("custom_calltracking_tag_textbox").sendKeys(Keys.TAB);
		Thread.sleep(5000);
		getObject("customcalltracking_next_button").click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("custom_calltracking_smartnumber"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("customcalltracking_callrouting_pageheader"))));
		String source =  getObject("custom_calltracking_source").getText();
		String Type = getObject("custom_calltracking_type").getText();
		String name = getObject("custom_calltracking_name").getText();
		String website = getObject("custom_calltracking_website").getText();
		String tagname = getObject("custom_calltracking_tag").getText();
		String smartnumber = getObject("custom_calltracking_smartnumber").getText();
		assertEquals(source, "Radio");
		assertEquals(Type, "FM");
		assertEquals(name, "Radio City");
		assertEquals(website, "www.ashish.com");
		assertEquals(tagname, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();
	} 

	// Test Case ID - 13
	// Objective - Generate a smart number for CustomCall Tracking-tollfree
	// @throws InterruptedException

	@Test(priority = 12)
	public void generate_smartnumberfor_Custom_CallTracking_tollfree() throws Exception {

		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("track_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("customcalltracking_menu_link"))));		
		getObject("customcalltracking_menu_link").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("customcalltracking_trackthis_button"))));
		select = new Select(getObject("customcalltracking_source_dropdown"));
		Thread.sleep(2000);
		select.selectByVisibleText("Radio");
		getObject("customcalltracking_type_textbox").sendKeys("FM");
		getObject("customcalltracking_name_textbox").sendKeys("Radio City");
		assertTrue(getObject("customcalltracking_trackthis_button").isDisplayed());
		getObject("customcalltracking_trackthis_button").click();
		Thread.sleep(6000);
		getObject("custom_calltracking_website_textbox").sendKeys("www.ashish.com");
		getObject("custom_calltracking_tollfree_radio_button").click();
		boolean isenabled = getObject("custom_calltracking_areacode_textbox").isEnabled();
		assertEquals(isenabled, false);
		getObject("custom_calltracking_tag_textbox").sendKeys("Ashish");
		Thread.sleep(5000);
		getObject("custom_calltracking_tag_textbox").sendKeys(Keys.TAB);
		Thread.sleep(5000);
		getObject("customcalltracking_next_button").click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("custom_calltracking_smartnumber"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("customcalltracking_callrouting_pageheader"))));
		String source =  getObject("custom_calltracking_source").getText();
		String Type = getObject("custom_calltracking_type").getText();
		String name = getObject("custom_calltracking_name").getText();
		String website = getObject("custom_calltracking_website").getText();
		String tagname = getObject("custom_calltracking_tag").getText();
		String smartnumber = getObject("custom_calltracking_smartnumber").getText();
		assertEquals(source, "Radio");
		assertEquals(Type, "FM");
		assertEquals(name, "Radio City");
		assertEquals(website, "www.ashish.com");
		assertEquals(tagname, "Ashish");
		TestUtil.deleteSmartNumbers(smartnumber, driver);
		logOut();
	} 	

	@Test(priority= 13)

	// Test Case ID- 14
	// Objective - Create a new group

	public void manageGroups_create_newgroup() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("groups_link").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("manage_groups_add_button"))));
		getObject("manage_groups_add_button").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("manage_groups_cancel_button"))));
		getObject("manage_groups_groupname").clear();
		getObject("manage_groups_groupname").sendKeys("WebAutomation");
		getObject("manage_groups_adduser_button").click();
		getObject("manage_groups_adduser_search_textbox").sendKeys("Sumit Jangid");
		getObject("manage_groups_selecteduser_checkbox").click();
		getObject("manage_groups_adduser_savebutton").click();
		Thread.sleep(5000);
		getObject("manage_groups_grid_name").getText();
		getObject("manage_groups_save_button").click();
		Thread.sleep(7000);
		getObject("manage_groups_cancel_button").click();
		getObject("manage_groups_searchgroup_searchbox").clear();
		getObject("manage_groups_searchgroup_searchbox").sendKeys("WebAutomation");
		String groupname =getObject("manage_groups_main_grid_name").getText();
		if(groupname != null)
			logOut();	
	}	

	@Test(priority= 14) 

	// Test Case ID- 15
	// Objective - Add smart number to Group.

	public void manageGroups_add_smartnumber_toGroup() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("groups_link").click();
		Thread.sleep(10000);
		getObject("manage_groups_searchgroup_searchbox").clear();
		getObject("manage_groups_searchgroup_searchbox").sendKeys("WebAutomation");
		Thread.sleep(5000);
		getObject("manage_groups_details_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_edit_button").click();
		Thread.sleep(3000);
		getObject("manage_groups_addsmartnumber_button").click();
		getObject("manage_groups_add_desired_areacode").clear();
		getObject("manage_groups_add_desired_areacode").sendKeys("859");
		getObject("manage_groups_add_smartnumber_save_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_smartnumber").getText();
		getObject("manage_groups_save_button").click();
		Thread.sleep(5000);
		logOut();
	}

	@Test(priority= 15)

	// Test Case ID- 16
	// Objective - Assign members to group.

	public void manageGroups_Assignmembers_to_group() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("groups_link").click();
		Thread.sleep(10000);
		getObject("manage_groups_searchgroup_searchbox").clear();
		getObject("manage_groups_searchgroup_searchbox").sendKeys("WebAutomation");
		Thread.sleep(5000);
		getObject("manage_groups_details_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_edit_button").click();
		getObject("manage_groups_adduser_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_adduser_search_textbox").sendKeys("Neeraj Ghiya");
		getObject("manage_groups_selecteduser_checkbox").click();
		getObject("manage_groups_adduser_savebutton").click();
		Thread.sleep(5000);
		String useraddedname= getObject("manage_groups_grid_name_2nduser").getText();
		if(useraddedname != null)
		logOut();
	}

	@Test(priority= 16)

	// Test Case ID- 17
	// Objective - Confirm that user is added as member

	public void manageGroups_Confirmthat_user_added_asmember() throws InterruptedException
	{
		String startlocator = "//*[@id='userGroupsTable']/tbody/tr[";
		String endlocator ="]/td[1]";
		String tablelocator= "//*[@id='userGroupsTable']/tbody";
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("users_menu_link").click();
		Thread.sleep(10000);
		getObject("manage_groups_user_search_textbox").clear();
		getObject("manage_groups_user_search_textbox").sendKeys("Neeraj Ghiya");
		Thread.sleep(5000);
		getObject("manage_groups_user_details_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_user_edit_button").click();
		boolean userpresent =TestUtil.isuserPresent(startlocator, endlocator, tablelocator, "WebAutomation" ,driver);
		assertEquals(true,userpresent);
		logOut();
	}
	@Test(priority= 17)

	// Test Case ID- 18
	// Objective - Edit group.

	public void manageGroups_editgroup() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("groups_link").click();
		Thread.sleep(10000);
		getObject("manage_groups_searchgroup_searchbox").clear();
		getObject("manage_groups_searchgroup_searchbox").sendKeys("WebAutomation");
		getObject("manage_groups_details_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_edit_button").click();
		Thread.sleep(3000);
		getObject("manage_groups_add_description").clear();
		getObject("manage_groups_add_description").sendKeys("Automation");
		getObject("manage_groups_add_tags").sendKeys("Sharma");
		getObject("manage_groups_add_tags").sendKeys(Keys.TAB);
		getObject("manage_groups_save_button").click();
		Thread.sleep(3000);
		WebElement detail_groupname = getObject("manage_groups_groupname");
		String name =detail_groupname.getAttribute("value");
		assertEquals("WebAutomation",name);
		WebElement detail_description = getObject("manage_groups_add_description");
		String description =detail_description.getAttribute("value");
		assertEquals("Automation",description);
		WebElement detail_tagname = getObject("manage_groups_detail_tagname");
		String tagname =detail_tagname.getText();
		assertEquals("Sharma",tagname);
		logOut();
	}
	@Test(priority= 18)

	// Test Case ID- 19
	// Objective - Confirm group data under "manage smart numbers"

	public void manageGroups_Confirm_groupdata_under_managesmartnumbers() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("smartnumbers_menu_link").click();
		getObject("manage_groups_usergroupcentralsmartnumbers_radiobutton").click();
		Thread.sleep(10000);
		getObject("manage_groups_searchsmartnumber_searchbox").sendKeys("WebAutomation");
		getObject("manage_groups_searchsmartnumber_searchbox").sendKeys(Keys.RETURN);
		Thread.sleep(10000);
		getObject("manage_groups_smartnumber_details_button").click();
		Thread.sleep(5000);
		WebElement detail_groupname = getObject("manage_groups_groupname");
		String name =detail_groupname.getAttribute("value");
		assertEquals("WebAutomation",name);
		WebElement detail_description = getObject("manage_groups_add_description");
		String description =detail_description.getAttribute("value");
		assertEquals("Automation",description);
		WebElement detail_tagname = getObject("manage_groups_detail_tagname");
		String tagname =detail_tagname.getText();
		assertEquals("Sharma",tagname);
		logOut();
	}
	@Test(priority= 19)

	// Test Case ID- 20
	// Objective - Delete group.

	public void manageGroups_deletegroup() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("groups_link").click();
		Thread.sleep(8000);
		getObject("manage_groups_searchgroup_searchbox").clear();
		getObject("manage_groups_searchgroup_searchbox").sendKeys("WebAutomation");
		Thread.sleep(5000);
		getObject("manage_groups_details_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_edit_button").click();
		Thread.sleep(5000);
		getObject("manage_groups_delete_group_link").click();
		getObject("manage_groups_delete_acceptconfirmation_link").click();
		logOut();
	}

	@Test(priority = 20)
	public void manage_add_local_click_to_voicemail() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("click_to_voicemail_link").click();
		Thread.sleep(8000);
		
		
	}
	
	
	
	
	
	
	@Test(priority= 20)

	// Test Case ID- 21
	// Objective - Add a Report for specific dates to reporting grid

	public void reporting_AddReport_for_specificdates_to_reporting_grid() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("analytics_menu_link").click();
		getObject("reporting_link").click();
		getObject("reporting_start_date").click();
		getObject("reporting_start_date").sendKeys("2015-04-01");
		getObject("reporting_start_date").sendKeys(Keys.TAB);
		//getObject("reporting_select_start_date").click();
		getObject("reporting_end_date").click();
		getObject("reporting_end_date").sendKeys("2015-05-31");
		getObject("reporting_end_date").sendKeys(Keys.TAB);
		//getObject("reporting_select_end_date").click();
		getObject("reporting_report_dropdown").sendKeys("Average Call Duration");
		getObject("reporting_report_dropdown").sendKeys(Keys.TAB);
		getObject("reporting_add_button").click();
		String grid_name = getObject("reporting_grid_report_name").getText();
		String grid_date = getObject("reporting_grid_date_data").getText();
		String grid_averagecallduration_details = getObject("reporting_grid_averagecallduration_data").getText();
		assertEquals(grid_date, "2015-04-06");
		assertEquals(grid_averagecallduration_details, "322");
		assertEquals("Average Call Duration",grid_name);
		getObject("reporting_remove_button").click();
		logOut();	
	}

	@Test(priority= 21)

	// Test Case ID- 22
	// @throws InterruptedException
	// Objective - Add a Report for pre set date range to reporting grid

	public void reporting_add_reportforpreset_daterange_to_reporting_grid() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("analytics_menu_link").click();
		getObject("reporting_link").click();
		getObject("reporting_report_dropdown").sendKeys("Average Call Duration");
		getObject("reporting_pre_defined_checkbox").click();
		getObject("reporting_date_range_dropdown").sendKeys("Last 90 Days");
		getObject("reporting_add_button").click();
		Thread.sleep(10000);
		String grid_name= getObject("reporting_grid_report_name").getText();
		assertEquals("Average Call Duration", grid_name);
		String grid_averagecallduration_details = getObject("reporting_grid_averagecallduration_data").getText();
		getObject("reporting_remove_button").click();
		if (grid_averagecallduration_details != null);
		logOut();
	}

	
	@Test(priority= 22)


	//Test Case ID- 23
	//Objective - Generating graphs for between dates
	// @throws InterruptedException


	public void Dashboard_Generating_graphs_for_between_dates() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("analytics_menu_link").click();
		getObject("dashboard_menu_link").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("dashboard_predefined_checkbox"))));
		Thread.sleep(5000);
		if(getObject("dashboard_predefined_checkbox").isSelected())
		{
			getObject("dashboard_predefined_checkbox").click();
		}
		getObject("dashboard_select_start_date_textbox").clear();
		getObject("dashboard_select_start_date_textbox").sendKeys("2013-04-01");
		getObject("dashboard_select_start_date_textbox").sendKeys(Keys.TAB);
		getObject("dashboard_select_start_date_textbox").getAttribute("value");
		getObject("dashboard_select_end_date_textbox").clear();
		getObject("dashboard_select_end_date_textbox").sendKeys("2013-04-05");
		getObject("dashboard_select_end_date_textbox").getAttribute("value");
		getObject("dashboard_apply_button").click();
		Thread.sleep(15000);
		logOut();
	}

	@Test(priority = 23)
	// Profile details-Update details
	// Test Case ID - 24

	public void myProfiledetails_Updatedetails() throws Exception {

		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));

		getObject("myinformation_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_menu_link"))));
		getObject("profile_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_edit_button"))));
		getObject("profile_edit_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_save_button"))));

		fields_values[0] = getObject("profile_userfirstname_textbox").getAttribute("value");
		fields_values[1] = getObject("profile_userlastname_textbox").getAttribute("value");
		fields_values[2] = getObject("profile_title_textbox").getAttribute("value");
		fields_values[3] = getObject("profile_email_textbox").getAttribute("value");
		fields_values[4] = getObject("profile_phone_textbox").getAttribute("value");
		fields_values[5] = getObject("profile_address_textbox").getAttribute("value");
		fields_values[6] = getObject("profile_city_textbox").getAttribute("value");
		fields_values[7] = getObject("profile_state_textbox").getAttribute("value");
		fields_values[8] = getObject("profile_zip_textbox").getAttribute("value");

		getObject("profile_userfirstname_textbox").clear();
		getObject("profile_userlastname_textbox").clear();
		getObject("profile_title_textbox").clear();
		getObject("profile_email_textbox").clear();
		getObject("profile_phone_textbox").clear();
		getObject("profile_address_textbox").clear();
		getObject("profile_city_textbox").clear();
		getObject("profile_state_textbox").clear();
		getObject("profile_zip_textbox").clear();

		getObject("profile_userfirstname_textbox").sendKeys(testing_values[0]);
		getObject("profile_userlastname_textbox").sendKeys(testing_values[1]);
		getObject("profile_title_textbox").sendKeys(testing_values[2]);
		getObject("profile_email_textbox").sendKeys(testing_values[3]);
		getObject("profile_phone_textbox").sendKeys(testing_values[4]);
		getObject("profile_address_textbox").sendKeys(testing_values[5]);
		getObject("profile_city_textbox").sendKeys(testing_values[6]);
		getObject("profile_state_textbox").sendKeys(testing_values[7]);
		getObject("profile_zip_textbox").sendKeys(testing_values[8]);

		getObject("profile_save_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_edit_button"))));

		getObject("logout_link").click();
		Thread.sleep(2000);
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		Thread.sleep(5000);
		getObject("myinformation_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_menu_link"))));
		getObject("profile_menu_link").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_edit_button"))));

		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_userfirstname_textbox"), testing_values[0], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_userlastname_textbox"), testing_values[1], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_title_textbox"), testing_values[2], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_email_textbox"), testing_values[3], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_phone_textbox"), testing_values[4], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_address_textbox"), testing_values[5], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_city_textbox"), testing_values[6], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_state_textbox"), testing_values[7], driver));
		assertTrue(TestUtil.verifyTextboxValue(getObject("profile_zip_textbox"), testing_values[8], driver));

		getObject("profile_edit_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_save_button"))));

		getObject("profile_userfirstname_textbox").clear();
		getObject("profile_userlastname_textbox").clear();
		getObject("profile_title_textbox").clear();
		getObject("profile_email_textbox").clear();
		getObject("profile_phone_textbox").clear();
		getObject("profile_address_textbox").clear();
		getObject("profile_city_textbox").clear();
		getObject("profile_state_textbox").clear();
		getObject("profile_zip_textbox").clear();

		getObject("profile_userfirstname_textbox").sendKeys(fields_values[0]);
		getObject("profile_userlastname_textbox").sendKeys(fields_values[1]);
		getObject("profile_title_textbox").sendKeys(fields_values[2]);
		getObject("profile_email_textbox").sendKeys(fields_values[3]);
		getObject("profile_phone_textbox").sendKeys(fields_values[4]);
		getObject("profile_address_textbox").sendKeys(fields_values[5]);
		getObject("profile_city_textbox").sendKeys(fields_values[6]);
		getObject("profile_state_textbox").sendKeys(fields_values[7]);
		getObject("profile_zip_textbox").sendKeys(fields_values[8]);

		getObject("profile_save_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("profile_edit_button"))));
		logOut();
	}	


	@Test(priority= 24)

	// Test Case ID- 25
	// Objective - Send a request mail. 

	public void account_info_send_request_mail() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("account_menu_link").click();
		getObject("info_menu_link").click();
		getObject("account_info_add_feature_button").click();
		getObject("account_info_add_feature_select1st_checkbox").click();
		getObject("account_info_add_feature_send_button").click();
		Thread.sleep(5000);
		logOut();
	}

	@Test(priority= 25)

	//Test Case ID- 26
	//Objective - Create a new Local central number.

	public void account_Create_new_local_central_number() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("account_menu_link").click();
		getObject("info_menu_link").click();
		getObject("account_info_central_numbers_add_button").click();
		getObject("account_info_central_numbers_add_name_textbox").clear();
		getObject("account_info_central_numbers_add_name_textbox").sendKeys("Ashish");
		getObject("account_info_central_numbers_local_area_code_radio_button").click();
		getObject("account_info_central_numbers_local_area_code_textbox").clear();
		getObject("account_info_central_numbers_local_area_code_textbox").sendKeys("859");
		getObject("account_info_central_numbers_addbutton_in_popup").click();
		String grid_name = getObject("account_info_central_numbers_grid_name").getText();
		assertEquals("Ashish", grid_name);
		Thread.sleep(3000);
		getObject("account_info_central_numbers_grid_delete_(x)_link").click();
		getObject("account_info_central_numbers_grid_delete_button").click();
		logOut();

	}

	@Test(priority= 26)

	//Test Case ID- 27
	//Objective - Create a new Toll free central number.

	public void account_Create_new_Tollfree_centralnumber() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("account_menu_link").click();
		getObject("info_menu_link").click();
		getObject("account_info_central_numbers_add_button").click();
		getObject("account_info_central_numbers_add_name_textbox").clear();
		getObject("account_info_central_numbers_add_name_textbox").sendKeys("Ashish");
		getObject("account_info_central_numbers_tollfree_radio_button").click();
		getObject("account_info_central_numbers_addbutton_in_popup").click();
		String grid_name = getObject("account_info_central_numbers_grid_name").getText();
		assertEquals("Ashish",grid_name);
		Thread.sleep(3000);
		getObject("account_info_central_numbers_grid_delete_(x)_link").click();
		getObject("account_info_central_numbers_grid_delete_button").click();
		logOut();

	}


	@Test(priority= 27)

	// Test Case ID- 28
	// Objective -  Create a new call script

	public void Manage_Callscript_Create_new_callscript() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("call_script_link").click();
		getObject("manage_call_scripts_add_button").click();
		getObject("manage_call_scripts_name_textbox").sendKeys("Ashish_script");
		getObject("manage_call_scripts_Script_textbox").sendKeys("This is the script written by Ashish");
		getObject("manage_call_scripts_save_button").click();
		getObject("manage_call_scripts_search_textbox").clear();
		getObject("manage_call_scripts_search_textbox").sendKeys("Ashish_script");
		String scriptname = getObject("manage_call_scripts_grid_name").getText();
		assertEquals(scriptname, "Ashish_script");
		logOut();
	}

	@Test(priority= 28)

	// Test Case ID- 29
	// Objective - Edit call script

	public void Manage_Callscript_Edit_callscript() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("manage_menu_link").click();
		getObject("call_script_link").click();
		getObject("manage_call_scripts_search_textbox").clear();
		getObject("manage_call_scripts_search_textbox").sendKeys("Ashish_script");
		getObject("manage_call_scripts_details_button").click();
		getObject("manage_call_scripts_edit_button").click();
		getObject("manage_call_scripts_Script_textbox").clear();
		getObject("manage_call_scripts_Script_textbox").sendKeys("This is the script edited by Ashish");
		getObject("manage_call_scripts_save_button").click();
		Thread.sleep(3000);
		getObject("manage_call_scripts_details_button").click();
		getObject("manage_call_scripts_edit_button").click();
		WebElement script = getObject("manage_call_scripts_Script_textbox");
		String editedscript = script.getAttribute("value");
		assertEquals(editedscript, "This is the script edited by Ashish");
		getObject("manage_call_scripts_delete_callscript_link").click();
		getObject("manage_call_scripts_confirm_delete_button").click();
		logOut();
	}

	@Test(priority= 29)

	// Test Case ID- 30
	// Objective - Import user

	public void import_user() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		assertTrue(getObject("manage_menu_link").isDisplayed());
		getObject("manage_menu_link").click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_menu_link"))));
		assertTrue(getObject("users_menu_link").isDisplayed());	
		getObject("users_menu_link").click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_entry1_statuscell_table"))));
		assertTrue(getObject("users_add_button").isDisplayed());
		assertTrue(TestUtil.isTextPresent(getObject("users_pageheader"), "Manage Users", driver));   
		getObject("users_add_button").click();
		getObject("users_addmodelbox_search_textbox").clear();
		getObject("users_addmodelbox_search_textbox").sendKeys("test1");
		Thread.sleep(5000);
		getObject("mangaeuser_select_searched_user").click();
		getObject("users_addmodelbox_next_button").click();	
		Thread.sleep(3000);
		getObject("users_addmodelbox_samrtnumber_checkbox").click();
		getObject("users_addmodelbox_smartnumber_textbox").sendKeys("204");
		getObject("users_addmodelbox_extensionnumber_checkbox").click();
		getObject("users_addmodelbox_extensionnumber_textbox").sendKeys("999");
		getObject("users_addmodelbox_assignsmartextensionnumber_import_button").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("users_addmodelbox_importcomplete_done_button"))));
		driver.switchTo().activeElement();
		getObject("users_addmodelbox_importcomplete_done_button").click();
		Thread.sleep(5000);
		getObject("manageuser_search_textbox").clear();
		getObject("manageuser_search_textbox").sendKeys("test1");
		String isuserpresent = getObject("manageuser_user_aftersearch_present").getText();
		assertEquals(isuserpresent, "test1");
		getObject("manageuser_search_textbox").clear();
		logOut();
	}
	
	@Test(priority= 30)

	// Test Case ID- 31
	// Objective - Edit user details

	public void edit_userdetails() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		assertTrue(getObject("manage_menu_link").isDisplayed());
		getObject("manage_menu_link").click();
		Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_menu_link"))));
		assertTrue(getObject("users_menu_link").isDisplayed());	
		getObject("users_menu_link").click();
		getObject("manageuser_search_textbox").clear();
		getObject("manageuser_search_textbox").sendKeys("test1");
		String isuserpresent = getObject("manageuser_user_aftersearch_present").getText();
		assertEquals(isuserpresent, "test1");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("manageuser_user_aftersearch_detail_button"))));
		getObject("manageuser_user_aftersearch_detail_button").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_edit_button"))));
		getObject("users_edit_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_deleteuser_link"))));
		getObject("users_tag_textbox").sendKeys("Ashish");
		Thread.sleep(10000);
		getObject("users_tag_textbox").sendKeys(Keys.TAB);
		getObject("users_extensionnumber_change_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_extensionnumber_textbox"))));
		getObject("users_extensionnumber_textbox").clear();
		getObject("users_extensionnumber_textbox").sendKeys("786");
		getObject("users_extensionnumber_save_button").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("users_extensionnumber_change_button"))));
		getObject("users_save_button").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_cancel_button"))));
		Thread.sleep(2000);
		getObject("users_cancel_button").click();
		Thread.sleep(5000);
		String tag_text = getObject("mangeuser_user_tagtext").getText();
		String extension = getObject("mangeuser_user_extension").getText();
		assertEquals(tag_text, "Ashish");
		assertEquals(extension, "786");
		getObject("manageuser_user_aftersearch_present").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_edit_button"))));
		getObject("users_edit_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("users_deleteuser_link"))));
		getObject("users_deleteuser_link").click();
		getObject("manageuser_delete_button").click();
		Thread.sleep(5000);
		//String confirmation_text = getObject("manageuser_afterdelete_confirmation_text").getText();
		//assertEquals(confirmation_text, "No matching records found");
		logOut();
	}

	@Test(priority= 31)

	// Test Case ID- 39
	// Objective - Add Number for Click to Call feature

	public void click_to_call() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("tools_menu_link").click();
		getObject("click_to_call_link").click();
		getObject("clicktocall_addname_textbox").sendKeys("Sumit Jangid");
		getObject("clicktocall_addphonenumber_textbox").sendKeys("12243061941");
		getObject("clicktocall_add_button").click();
		getObject("clicktocall_generatehtml_button").click();
		getObject("clicktocall_call_button").click();
		Thread.sleep(5000);
		getObject("clicktocall_aftercall_selectuser").click();
		getObject("clicktocall_enter_number").sendKeys("918003822094");
		getObject("clicktocall_enter_name").sendKeys("Ashish");
		getObject("clicktocall_callme_button").click();
		Thread.sleep(5000);
		String confirmation_text = getObject("clicktocall_confirmation_textbox").getText();
		logOut();
	}

	@Test(priority= 32)

	// Test Case ID- 40
	// Objective - Click DNI

	public void click_DNI() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("tools_menu_link").click();
		getObject("dynamic_number_insertion_link").click();
		String header_text = getObject("dynamic_number_insertion_header_text1").getText();
		String text2 = getObject("dynamic_number_insertion_text2").getText();
		assertEquals(header_text, "Dynamic Number Insertion");
		assertEquals(text2, "1.Insert the following JavaScript snippet into the head tag on each page of your website.");
		logOut();
	}
	@Test(priority= 33)

	// Test Case ID- 41
	// Objective - Click Tag AdWords Destination Urls

	public void click_TagAdWords_Destination_Urls() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("tools_menu_link").click();
		getObject("TagAdWords_Destination_Urls").click();
		String tagAdwords_header = getObject("tagadwords_headertext").getText();
		String text2 = getObject("tagadwords_text2").getText();
		assertEquals(tagAdwords_header, "Tag AdWords Destination Urls");
		assertEquals(text2, "Your campaign and ad group names are case sensitive.");
		String text3 = getObject("tagadwords_text3").getText();
		assertEquals(text3, "illustrated guide");
		logOut();
	}

	@Test(priority= 34)

	// Test Case ID- 42
	// Objective - Click Support

	public void click_support() throws InterruptedException
	{
		doLogin(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		getObject("support_menu").click();
		Thread.sleep(10000);
		String get_title = driver.getTitle();
		assertEquals(get_title, "RingDNA Support");
		driver.navigate().back();
		Thread.sleep(6000);
		logOut();
	}		

	@Test(priority= 35)

	// Test Case ID- 43
	// Objective - Edit account informations

	public void edit_Account_informations() throws InterruptedException
	{
		doLogin_free(CONFIG.getProperty("username_free"), CONFIG.getProperty("password_free"));
		getObject("freeaccount_account_tab").click();
		getObject("freeaccount_account_edit_button").click();
		getObject("freeaccount_account_title_textbox").clear();
		getObject("freeaccount_account_title_textbox").sendKeys("Ashish Sharma");
		getObject("freeaccount_account_phone_textbox").clear();
		getObject("freeaccount_account_phone_textbox").sendKeys("918003822094");
		getObject("freeaccount_account_address_textbox").clear();
		getObject("freeaccount_account_address_textbox").sendKeys("India Gate");
		getObject("freeaccount_account_city_textbox").clear();
		getObject("freeaccount_account_city_textbox").sendKeys("Jaipur");
		getObject("freeaccount_account_state_textbox").clear();
		getObject("freeaccount_account_state_textbox").sendKeys("Raj");
		getObject("freeaccount_account_zip_textbox").clear();
		getObject("freeaccount_account_zip_textbox").sendKeys("332001");
		getObject("freeaccount_account_save_button").click();
		getObject("freeaccount_account_edit_button").click();
		String title = getObject("freeaccount_account_title_textbox").getAttribute("value");
		String phone = getObject("freeaccount_account_phone_textbox").getAttribute("value");
		String address = getObject("freeaccount_account_address_textbox").getAttribute("value");
		String city =  getObject("freeaccount_account_city_textbox").getAttribute("value");
		String state = getObject("freeaccount_account_state_textbox").getAttribute("value");
		String zip = getObject("freeaccount_account_zip_textbox").getAttribute("value");
		assertEquals(title, "Ashish Sharma");
		assertEquals(phone, "918003822094");
		assertEquals(address, "India Gate");
		assertEquals(city, "Jaipur");
		assertEquals(state, "Raj");
		assertEquals(zip, "332001");
		Thread.sleep(5000);
		getObject("freeaccount_account_title_textbox").clear();
		getObject("freeaccount_account_phone_textbox").clear();
		getObject("freeaccount_account_address_textbox").clear();
		getObject("freeaccount_account_city_textbox").clear();
		getObject("freeaccount_account_state_textbox").clear();
		getObject("freeaccount_account_zip_textbox").clear();
		getObject("freeaccount_account_save_button").click();
		Thread.sleep(10000);
		getObject("freeaccount_signout_link").click();
	}	
	@Test(priority= 36)

	// Test Case ID- 45
	// Objective - Invitation mail should be mailed to the email id mentioned.

	public void send_invitation_mail() throws InterruptedException
	{
		doLogin_free(CONFIG.getProperty("username_free"), CONFIG.getProperty("password_free"));
		getObject("freeaccount_share_tab").click();
		getObject("share_mailaddress_textarea").sendKeys("sumit.jangid@metacube.com");
		getObject("share_sendinvitation_button").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("share_confirmation_mailsent"))));
		String is_mailsent  = getObject("share_confirmation_mailsent").getText();
		assertEquals(is_mailsent, "1 invitations sent");
		getObject("freeaccount_signout_link").click();
	}

	
	@Test(priority= 37)

	// Test Case ID- 47
	// Objective - User should be able to access dashboard 

	public void User_should_able_to_access_dashboard() throws InterruptedException
	{
		doLogin_free(CONFIG.getProperty("username_free"), CONFIG.getProperty("password_free"));
		getObject("freeaccount_dashboard_tab").click();
		String text1 = getObject("dashboard_iPad_link").getText();
		assertEquals(text1, "iPad");
		String text2 = getObject("dashboard_iPadmini_link").getText();
		assertEquals(text2, "iPad Mini");
		Thread.sleep(5000);
		getObject("dashboard_share_link").click();
		getObject("freeaccount_dashboard_tab").click();

		//String text3 = getObject("dashboard_download_ringdna_link").getText();
		//assertEquals(text3, "Download RingDNA Mobile");
		// considering that there is only one tab opened in that point.
		String oldTab = driver.getWindowHandle();
		getObject("dashboard_get_support_link").click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		// Do what you want here, you are in the new tab
		String newtab_title = driver.getTitle();
		assertEquals(newtab_title, "RingDNA Support");
		driver.close();
		// change focus back to old tab
		driver.switchTo().window(oldTab);
/*
		getObject("dashboard_get_idea_link").click();
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		newTab1.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab1.get(0));
		Thread.sleep(5000);
		String newtab_title1 = driver.getTitle();
		Thread.sleep(5000);
		assertEquals(newtab_title1, "RingDNA Support : Submit a Feature Request");
		driver.close();
		// change focus back to old tab
		driver.switchTo().window(oldTab);
*/	
		// Do what you want here, you are in the old tab
		getObject("freeaccount_signout_link").click();

	}

	
	@Test(priority= 38)

	// Test Case ID- 48
	// Objective - Click Support

	public void freeaccount_Click_Support() throws InterruptedException
	{
		doLogin_free(CONFIG.getProperty("username_free"), CONFIG.getProperty("password_free"));
		String oldTab = driver.getWindowHandle();
		getObject("support_menu").click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		// Do what you want here, you are in the new tab
		String newtab_title = driver.getTitle();
		assertEquals(newtab_title, "RingDNA Support");
		driver.close();
		// change focus back to old tab
		driver.switchTo().window(oldTab);
		// Do what you want here, you are in the old tab
		getObject("freeaccount_signout_link").click();
	}

	
}
