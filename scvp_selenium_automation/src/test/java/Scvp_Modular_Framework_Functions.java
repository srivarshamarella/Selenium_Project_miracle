import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scvp_Modular_Framework_Functions {
	WebDriver driver = null;
	Scvp_POM_Functions objLogin;
	Properties load_configuration_details;
	public  Scvp_Modular_Framework_Functions return_class_context() {
		// Create Login Page object
		return this;
	}
	protected WebDriver connect_chrome_driver() throws IOException {
		
		load_configuration_details = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\application.properties");
		load_configuration_details.load(file);
		WebDriverManager.chromedriver().driverVersion("85.0.4183.83").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(load_configuration_details.getProperty("Url"));
		this.objLogin=new Scvp_POM_Functions(driver);
		return driver;
	}
	public Scvp_Modular_Framework_Functions user_login() {
		// Verify login page title
		objLogin.implicit_wait(50)
				.setUserName(load_configuration_details.getProperty("username"),
						load_configuration_details.getProperty("username_xpath"))
				.implicit_wait(50)
				.setPassword(load_configuration_details.getProperty("password"),
						load_configuration_details.getProperty("password_xpath"))
				.click_button_by_xpath(load_configuration_details.getProperty("login_button_xpath")).implicit_wait(5000);
		// objLogin.close_driver(driver);
		return this;
	}
	
	public Scvp_Modular_Framework_Functions click_on_tab() {
		objLogin.verify_page_title(load_configuration_details.getProperty("verify_title"))
		.implicit_wait(50)
		.click_button_by_xpath(load_configuration_details.getProperty("doc_repository_tab_xpath"))
		.implicit_wait(50)
		.click_button_by_xpath(load_configuration_details.getProperty("database_radio_button_xpath"))
		.implicit_wait(50)
		;
		return this;
	}
	public Scvp_Modular_Framework_Functions user_signout()
			throws InterruptedException {
		Thread.sleep(2000);
		objLogin.click_logo(load_configuration_details.getProperty("user_logo_xpath")).implicit_wait(10)
		.click_button_by_xpath(load_configuration_details.getProperty("user_logout_button")).close_driver(driver);
		return this;
	}
}
