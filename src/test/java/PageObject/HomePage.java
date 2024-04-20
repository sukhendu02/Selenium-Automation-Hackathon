package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import TestBase.BasePage;



public class HomePage extends BasePage {
	
//	public WebDriver driver;
	
	
	Actions act;
		
//	CONSTRUCTOR
	public HomePage(WebDriver driver){
		
		super(driver);
		

	}
	
	
//	LOCATORS
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div[3]/a[5]") 
	WebElement bookshelves;
	

	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[7]/div/div/ul/li[2]/ul/li[1]") 
	WebElement studyChair;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[7]") 
	WebElement study;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/div/section[1]/a") 
	WebElement homepg;
	
	

	
	@FindBy(xpath="//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement giftCardBtn;
	
	
//	ACTIONS
	
	
	
	public void goToHome() {
		homepg.click();
	}
	
	
	public void clickonBookshelves(){
			bookshelves.click();	
	
	}
	
	public void gotogiftCard() {
		giftCardBtn.click();
	}

	
	public void clickonStudy(){
		act = new Actions(driver);
		act.moveToElement(study).perform();
		studyChair.click();
		
	}

	
}