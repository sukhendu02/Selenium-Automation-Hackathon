package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class GiftCardPage extends BasePage{
	
	
	public GiftCardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	WebElement thirdCard;
	
	
	@FindBy(xpath="//*[@id=\"ip_2251506436\"]")
	WebElement inputAmount;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	WebElement nextBtn;
	
	
	
	@FindBy(xpath="//*[@id=\"ip_4036288348\"]")
	WebElement rname;
	
	@FindBy(xpath="//*[@id=\"ip_137656023\"]")
	WebElement remail;
	
	@FindBy(xpath="//*[@id=\"ip_3177473671\"]")
	WebElement rmobile;
	
	@FindBy(xpath="//*[@id=\"ip_1082986083\"]")
	WebElement myname;
	
	@FindBy(xpath="//*[@id=\"ip_4081352456\"]")
	WebElement myemail;
	
	@FindBy(xpath="//*[@id=\"ip_2121573464\"]")
	WebElement mymobile;
	
	@FindBy(xpath="//*[@id=\"ip_2194351474\"]")
	WebElement myadd;
	
	@FindBy(xpath="//*[@id=\"ip_567727260\"]")
	WebElement mypincode;
	
	@FindBy(xpath="//*[@id=\"ip_1554905400\"]")
	WebElement mycity;
	@FindBy(xpath="//*[@id=\"ip_582840596\"]")
	WebElement msg;

	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")
	WebElement submitBtn;
	
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[3]/form/div[1]/fieldset[2]/div[6]")
	WebElement pincodeError;
	
	public void chooseGiftCardType() {
		thirdCard.click();
		
	}
	
	public void EnterDetails(String amt) {
		inputAmount.sendKeys(amt);
		nextBtn.click();
	}
	
	public String EnterAllDetails(String recn, String recemail, String recmob, String myn, String myeml, String mymob, String myadd2, String mypin, String mycity) {
		rname.sendKeys(recn);
		remail.sendKeys(recemail);
		rmobile.sendKeys(mymob);
		
		
		myname.sendKeys("TestName");
		myemail.sendKeys("mytestmail@gmail.com");
		mymobile.sendKeys("8883232232");
		myadd.sendKeys("11, somewhere ");
		
		
		mypincode.sendKeys("333333");

		if(pincodeError.isDisplayed()) {
			return pincodeError.getText();
		}
		return null;
		
		
	}
	
	
	
	
	
}
