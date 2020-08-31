import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scvp_POM_Functions {

	WebDriver driver;
	// Username field
	By userName;
	// Password field
	By password;
	// Click on Submit login button
	By login;
	// click on the user logo button
	By user_logo;
	// click on the logout button
	By left_tab;
	// Search string
	String search_string = null;
	// Selecting dropdown value;
	By drop_down;

	public Scvp_POM_Functions(WebDriver driver) {
		this.driver = driver;
	}

	public Scvp_POM_Functions setUserName(String strUserName, String username_xpath) {
		this.userName = By.xpath(username_xpath);
		this.driver.findElement(this.userName).sendKeys(strUserName);
		return this;

	}

	// Set password in password textbox

	public Scvp_POM_Functions setPassword(String strPassword, String password_xpath) {
		// Password field
		this.password = By.xpath(password_xpath);
		this.driver.findElement(password).sendKeys(strPassword);
		return this;

	}


	// Get the title of Login Page

	public String getLoginTitle() {

		return this.driver.getTitle();

	}

	// Get the user logo after sign in on the top right corner of the page
	public Scvp_POM_Functions click_logo(String user_logo_xpath) {
		// click on the user logo button
		this.user_logo = By.xpath(user_logo_xpath);
		this.driver.findElement(user_logo).click();
		return this;
	}
	public Scvp_POM_Functions click_button_by_xpath(String left_tab_xpath) {
		// click on the logout button
		this.left_tab = By.xpath(left_tab_xpath);
		this.driver.findElement(left_tab).click();
		return this;
	}

	public Scvp_POM_Functions implicit_wait(int time_seconds) {
		this.driver.manage().timeouts().implicitlyWait(time_seconds, TimeUnit.SECONDS);
		return this;
	}

	public Scvp_POM_Functions navigate_back() {

		this.driver.navigate().back();
		return this;
	}

	public Scvp_POM_Functions verify_page_title(String Expectedtitle) {
		// TODO Auto-generated method stub
		String Actualtitle = this.getLoginTitle();
		System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
		// it will compare actual title and expected title
		Assert.assertEquals(Actualtitle, Expectedtitle);
		// print out the result
		System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
		return this;
	}

	public Scvp_POM_Functions select_dropdown(String selected_Value, String dropdown_xpath) {
		drop_down = By.xpath(dropdown_xpath);

		Select dropdown = new Select(this.driver.findElement(drop_down));
		dropdown.selectByValue("Database");
		return this;
	}

	public Scvp_POM_Functions close_driver(WebDriver driver) {
		driver.close();
		return this;
	}

}