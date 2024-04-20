package PageObject;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BasePage;

public class BookshelvesPage extends BasePage{
	
	
	Actions act ;
	
//	CONSTRUCTORS
	public BookshelvesPage(WebDriver driver) {
		super(driver);
	}
	
	
//	LOCATORS
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]") 
	WebElement StorageBtn;
	
	@FindBy(xpath="//*[@id=\"filters_storage_type_Open\"]") 
	WebElement openCheck;
	
	@FindBy(xpath="//*[@id=\"price_limit_9000-15999\"]")
	WebElement setPrice;
//	ACTIONS
	
	
	
//	SET STORAGE TYPE TO OPEN
	public void setStorageType() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authentication_popup")));
		
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")).click();
	
		act= new Actions(driver);
		act.moveToElement(StorageBtn).build().perform();
	
		openCheck.click();

	}
	
	
//	SET SLIDER TO MAX 15000
	public void maxPrice() {
		
		
		act = new Actions(driver);
		
//		WebElement cl = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]"));
//		act.moveToElement(cl).perform();
//
//		
//		setPrice.click();
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000);");
	}
	

	
	
//	GET NAMES OF THE BOOKSHELVES
	public List<WebElement> getName(){
		List<WebElement> bookshelvesElements = driver.findElements(By.className("product"));
		List<WebElement> BookshelvesNames = new ArrayList<WebElement>();

//		List<WebElement> BookshelvesNames=driver.findElements(By.xpath("//div//span[@class='name' and @itemprop='name']"));

		
		
//		System.out.println(BookshelvesNames.size());
		for(int i=1;i<=Math.min(10, bookshelvesElements.size());i++) {
			WebElement bs = driver.findElement(By.xpath("//*[@id='content']/div[3]/ul/li["+i+"]/div/div[5]/a/div[1]/span"));
//			System.out.println(bs.getText());
			BookshelvesNames.add(bs);
		}

		
		return BookshelvesNames;
	}
	
	
	
//	GET PRICE OF THE BOOKSHELVES
	public List<WebElement> getPrice(){
		

		List<WebElement> BookshelvesPrices=driver.findElements(By.xpath("//div[@class='price-number']//span"));
//		System.out.println(BookshelvesPrices.size());
		
		return BookshelvesPrices;
	}
	
	
	
	

	

	

	
}
