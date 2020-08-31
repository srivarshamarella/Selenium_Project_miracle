import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scvp_Test_Scenarios {
	Scvp_Modular_Framework_Functions call_scenarios;
	@BeforeTest
	public void connect_driver_class() throws IOException{
		call_scenarios = new Scvp_Modular_Framework_Functions();
		call_scenarios=call_scenarios.return_class_context();
		call_scenarios.connect_chrome_driver();
	}
	
	@Test(priority = 0)
	private void user_login_scenario() {
		call_scenarios.user_login();
	}
	@Test(priority =1)
	private void check_Doc_Repository_Fields() {
		call_scenarios.user_login()
		.click_on_tab();
	}
//	@Test(priority = 2)
//	private void user_sign_out() throws InterruptedException {
//		call_scenarios.user_signout(obj);
//	}

}
