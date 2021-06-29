package setup_execution;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import gmail_accounts.mail_send;
import gmail_accounts.account1_login;
import gmail_accounts.account2_login;
import gmail_accounts.mail_receive;


public class test_execution {
	
	WebDriver driver;
	account1_login objacc1Login;
	account2_login objacc2Login;
	mail_send objMailSend;
	mail_receive objMailReceive;
	

	@BeforeSuite
	public void setup() {
		
	System.setProperty("webdriver.chrome.driver","D://Test_things/Test_scripts/Gmail_Communications/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.google.com/intl/en/gmail/about/");
	
	}
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException{
		
     TakesScreenshot scrShot =((TakesScreenshot)webdriver);
     File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
     File DestFile=new File(fileWithPath);
     FileHandler.copy(SrcFile, DestFile);

    }


	
	@Test(priority = 1)
	public void gmail11SignIn() throws InterruptedException, IOException {
		
	objacc1Login = new account1_login(driver);
	objacc1Login.signIn();
	takeSnapShot(driver, "D://test1.png") ; 
	}
	
	@Test(priority = 2)
	public void gmail1SendMail() throws InterruptedException, IOException, AWTException {
		
	objMailSend = new mail_send(driver);
	objMailSend.sendEmailwithFile();
	this.takeSnapShot(driver, "D://test2.png") ; 
	}
	
	
	
	@Test(priority = 3)
	public void gmail21SignIn() throws InterruptedException, IOException {
		
	setup();
	objacc2Login = new account2_login(driver);
	objacc2Login.signIn();
	this.takeSnapShot(driver, "D://test3.png") ; 
	
	}
	
	@Test(priority = 4)
	public void gmail2ReceiveMail() throws InterruptedException, IOException {
		
	objMailReceive = new mail_receive(driver);
	objMailReceive.clickEmail("Test Mail");
	objMailReceive.receiveEmailwithFile();
	this.takeSnapShot(driver, "D://test4.png") ; 
	
	}
	
	@Test(priority=5)
	public void logoutFromAllGmailAcoounts() throws InterruptedException {
		
		objMailReceive.logoutFromGmail2();
		driver.close();
		objMailSend.logoutFromGmail1();
	}
	
	@AfterSuite
	public void tearDown() {
	   driver.quit();
	}
	
	
}
	
	
	
	
	
	


