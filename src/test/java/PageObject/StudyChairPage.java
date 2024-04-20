package PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BasePage;

public class StudyChairPage extends BasePage{
	
	Actions act;
	
	public StudyChairPage(WebDriver driver) {
		super(driver);
	}
	
//	LOCATORS
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]") 
	WebElement sortBox;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[1]") 
	WebElement recomend;
	
	
	
//	ACTION METHODS
	
	
//	SORT ACCORDING TO THE RECOMMENDATIONS
	public void sortbyRecomendation() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authentication_popup")));
		
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")).click();
		
		act = new Actions(driver);
		act.moveToElement(sortBox).perform();
		recomend.click();
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		
	}
	
	
//	RETURN THE TOP 3 RECOMMANDED STUDY CHAIR
	public Map<String,Double> printDetials() {
		
		Map<String,Double> topChair = new HashMap<String,Double>();
		
		List<WebElement> studyChairElements = driver.findElements(By.className("product"));
		
	
		
		for(int i= 1;i<Math.min(4, studyChairElements.size());i++) {
	
			WebElement chairElement = studyChairElements.get(i);
			
			WebElement n = chairElement.findElement(By.className("name"));
			WebElement pc = chairElement.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li["+i+"]/div/div[5]/a/div[2]/span"));
			
			String name = n.getText().trim();
			String prc = pc.getText().trim();		
			
			double price=Double.parseDouble(prc.replaceAll("[^0-9.]", ""));

			topChair.put(name,price);
		
		}
		
		return topChair;

	}
	
}
