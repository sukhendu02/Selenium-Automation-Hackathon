package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObject.BookshelvesPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class Test_Bookshelves extends BaseClass {
	
  
	
	@Test(priority = 1) 
	public void test1() throws InterruptedException {
		
		HomePage page = new HomePage(driver);
		page.clickonBookshelves();

	}
	
	@Test (priority = 2)
	public void storageType() {
		BookshelvesPage bs = new BookshelvesPage(driver);
		bs.setStorageType();
	}
	
	@Test(priority = 3)
	public void setMaxPrice() throws Exception {
		BookshelvesPage bs = new BookshelvesPage(driver);

		bs.maxPrice();
		String filepath = captureScreenshot("Bookshelves");
	}
	
	@Test(priority = 4)
	public void printNameandPrice() throws InterruptedException {
		BookshelvesPage bs = new BookshelvesPage(driver);
		
		List<WebElement> bname = bs.getName();
	
		
		List<WebElement> bprice= bs.getPrice();
		
		System.out.println("  --Bookshelves below 15000 and Storage Type Open--  ");
		for(int i=0;i<Math.min(10, bname.size());i++) {
			String bookShelvesName=bname.get(i).getText();
			String bookShelvesPrice=bprice.get(i).getText();
			
			System.out.println((i+1)+". "+bookShelvesName+" ---- "+bookShelvesPrice);
			System.out.println();
		}
		
	
		
	}
	

	
	
}
