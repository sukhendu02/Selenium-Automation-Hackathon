package TestCases;

import org.testng.annotations.Test;

import PageObject.GiftCardPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class Test_GiftCard extends BaseClass{
	
	@Test(priority=1)
	public void goToGiftCard() {
		HomePage pg = new HomePage(driver);
		pg.goToHome();
		pg.gotogiftCard();
	}
	
	@Test(priority=2)
	public void getgiftCard() throws Exception {
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.chooseGiftCardType();
		
		
		String amt = prop.getProperty("amt");
				
		gcp.EnterDetails(amt);
		
		
	}
	
	@Test(priority = 3)
	public void allDetailsGiftCard() throws Exception {
		
		GiftCardPage gcp = new GiftCardPage(driver);
		
		String recn = prop.getProperty("recn");
		String recemail  = prop.getProperty("recemail");
		String recmob = prop.getProperty("recmob");
		
		
		String myn = prop.getProperty("myn");
		String myeml = prop.getProperty("myeml");
		String mymob = prop.getProperty("mymob");
		
		String myadd = prop.getProperty("myadd");
		String mypin = prop.getProperty("mypin");
		String mycity = prop.getProperty("mycity");
		
		
		
		String errMsg= gcp.EnterAllDetails(recn,recemail,recmob,myn,myeml,mymob,myadd,mypin,mycity);
		System.out.println();
		System.out.println("Error Message :"+errMsg);
		System.out.println();
		
		Thread.sleep(3000);
		String filepath = captureScreenshot("InvalidPincode");
	}
	
	
	
}
