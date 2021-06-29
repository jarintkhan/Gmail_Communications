package gmail_accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class account2_login {
	
WebDriver driver;


	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInGmail;
	
	@FindBy(xpath = "//span[contains(text(),'‪বাংলা‬')]")
	WebElement languageSelection;
	
    @FindBy(xpath = "//body/div[1]/div[1]/footer[1]/div[1]/div[1]/div[2]/div[20]/span[1]")
	WebElement chooseLanguage;

	
	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton1;
	
	public account2_login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	public void signIn() throws InterruptedException {
		signInGmail.click();
		Thread.sleep(1000);
		languageSelection.click();
		Thread.sleep(1000);
		chooseLanguage.click();
		Thread.sleep(1500);
		email.sendKeys("testacc290621.2@gmail.com");
		nextButton.click();
		Thread.sleep(1000);
		password.sendKeys("ytrewq@321");
		Thread.sleep(1000);
		nextButton1.click();
		Thread.sleep(5000);
		}

}
