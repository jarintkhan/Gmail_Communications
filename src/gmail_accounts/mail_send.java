package gmail_accounts;

import java.awt.Robot;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mail_send {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Compose')]")
	WebElement composeButton;
	
	@FindBy(name = "to")
	WebElement recipientEmail;
	
	@FindBy(name = "subjectbox")
	WebElement mailSubject;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Message Body')]")
	WebElement messageBody;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Attach files')]")
	WebElement attachFile;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Send ‪(Ctrl-Enter)‬')]")
	WebElement sendButton;
	
	@FindBy(xpath="//header/div[2]/div[3]/div[1]/div[2]/div[1]/a[1]/img[1]")
    WebElement profileImage;
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
    WebElement signoutButton;
	
	
	
	public mail_send(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	public void sendEmailwithFile() throws InterruptedException, IOException, AWTException {
		composeButton.click();
		Thread.sleep(1000);
		recipientEmail.sendKeys("testacc290621.2@gmail.com");
		Thread.sleep(500);
		mailSubject.sendKeys("Test Mail");
		Thread.sleep(500);
		messageBody.sendKeys("This is a test mail\n");
		Thread.sleep(500);
		attachFile.click();
		Thread.sleep(1500);
		
		
		Robot rb = new Robot();
		
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("D:\\Test_things\\Test_scripts\\Gmail_Communications\\testdata\\sampleFile.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		messageBody.click();
		Thread.sleep(500);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", sendButton);
		Thread.sleep(5000);
		}
	
	public void logoutFromGmail1() throws InterruptedException{
		
		 profileImage.click();
		 Thread.sleep(500);
		 signoutButton.click();
		 Thread.sleep(5000);
	}

}
