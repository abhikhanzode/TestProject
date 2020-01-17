package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	public static WebDriver driver;
	@Given("^Open chrome browser and Start Applciation$")
	public void open_chrome_browser_and_Start_Applciation() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "http://localhost/LogicInvoice/upload/admin/index.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("^I enter valid username and valid password$")
	public void I_enter_valid_username_and_valid_password() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys("admin");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")).sendKeys("admin123");
	}

	@Then("^User should be login successfully$")
	public void user_should_be_login_successfully() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();
	}
}
