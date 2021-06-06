package mx.tec.exam.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStoreWebStepDefs {
    private static WebDriver driver;
    
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_91.0.4472.19\\chromedriver.exe");
    }
	
	@Given("a registered user")
	public void a_registered_user() {
		// Do nothing
	}

	@When("the client calls \\/login page with username {string} and password {string}")
	public void the_client_calls_login_page_with_username_and_password(String username, String password) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("login"));
        submitButton.click();   
	}
	
	@Then("the client is redirected to the {string} page")
	public void the_client_is_redirected_to_the_page(String pageTitle) throws InterruptedException {
        // Since this is a One Single Page application. Use the sleep to wait for the page to be updated        
        Thread.sleep(5000);
        
        String title = driver.findElement(By.className("main-header")).getText();                
        
        assertEquals(pageTitle, title);
        driver.quit();
    }
	
	@Then("the message {string} is displayed")
	public void the_message_is_displayed(String displayedMessage) throws InterruptedException {
        // Since this is a One Single Page application. Use the sleep to wait for the page to be updated        
        Thread.sleep(5000);
        
        String message = driver.findElement(By.xpath("//p[@class='mb-1']")).getText();                
        
        assertEquals(displayedMessage, message);
        driver.quit();
	}	
	
	@Then("the border color of the credential fields is red")
	public void the_border_color_of_the_credential_fields_is_red() throws InterruptedException {
        // Since this is a One Single Page application. Use the sleep to wait for the page to be updated        
        Thread.sleep(5000);
        
        WebElement usernameField = driver.findElement(By.id("userName"));
        String boderColor = usernameField.getCssValue("border-color");
        
        assertEquals("rgb(220, 53, 69)", boderColor);
        driver.quit();
	}	
}
