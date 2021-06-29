package gmail_accounts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class mail_receive {
	
WebDriver driver;


     @FindBy(xpath="//span[@class='bog']") 
     List<WebElement> emailThreads;
   
	
	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tr[1]/td[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[5]/div[4]/span[1]/a[1]/div[1]/div[3]/img[1]")
	WebElement attachment;
	
	@FindBy(xpath="//div[contains(@data-tooltip,'Download')]")
    WebElement downloadButton;
	
	@FindBy(xpath="//div[contains(@data-tooltip,'Close')]")
    WebElement backButton;
	
	@FindBy(xpath="//header/div[2]/div[3]/div[1]/div[2]/div[1]/a[1]/img[1]")
    WebElement profileImage;
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
    WebElement signoutButton;
	
	
	
	public mail_receive(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	public void clickEmail(String emailSubject) throws InterruptedException
	{

		for (int i = 0; i < emailThreads.size(); i++) {

			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				Thread.sleep(5000);
				System.out.println("Received email is clicked");
				break;
			}
		}
	}
	
	public void receiveEmailwithFile() throws InterruptedException{
	
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    Actions act =  new Actions(driver);
		    act.moveToElement(downloadButton).perform();
		    Thread.sleep(500);
		    downloadButton.click();
		    Thread.sleep(3000);
		}
	
	
	public void logoutFromGmail2() throws InterruptedException{
		
		 profileImage.click();
		 Thread.sleep(500);
		 signoutButton.click();
		 Thread.sleep(5000);
	}
	

}
