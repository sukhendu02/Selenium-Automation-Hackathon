import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HackathonProject {

	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		

			
		
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		
		
		
		WebElement clickBookShelves = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[5]"));
		clickBookShelves.click();
		
//		WebElement priceBtn = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]"));
		
		Actions actions = new Actions(driver);
		
	
//		actions.moveToElement(priceBtn).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authentication_popup")));
		
		driver.findElement(By.xpath("//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")).click();
		
		
		WebElement cl = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]"));
		actions.moveToElement(cl).perform();

		
		
//		SLIDER PART HERE
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"price_limit_9000-15999\"]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.findElement(By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[7]/div/div/ul/li[2]/ul/li[1]")).click();
//		
//		List<WebElement> studyChairElements = driver.findElements(By.className("product hovercard psticker"));
//		
////		List<StudyChair> studychairs= new ArrayList<>();
//		
//		for(WebElement chairElement :studyChairElements) {
////			String name = chairElement.findElement(By.xpath("//span[@class ='name' and itemprop='name']")).getText();
////			double price = chairElement.findElement(By.xpath("//span[@class ='name' and itemprop='name']")).getText();
//			WebElement n = chairElement.findElement(By.xpath("//span[@class ='name' and itemprop='name']"));
//			WebElement pc = chairElement.findElement(By.xpath("//div[@class='price-number']//span"));
//			
//			
//			String name = n.getText().trim();
//			String prc = pc.getText().trim();
//			
//			String npr=prc.replaceAll("[^0-9.]", "");
//			double price=Double.parseDouble(npr);
//			
//			System.out.println(name);
//			System.out.println(price);
//			
//		
//		}
		
//		List<WebElement> BookshelvesName=driver.findElements(By.xpath("//div[@class='price-number']//span"));
//		System.out.println(BookshelvesName.size());
		
//		WebElement slider = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]"));
//		int xoffset = 100;;
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttrubute('value', '"+ xoffset+" ');", slider);
		
		
	
		WebElement Slider = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div"));
		
		WebElement Slider2 = driver.findElement(By.xpath("//div[@class=\"range-slider noUi-target noUi-ltr noUi-horizontal noUi-background\"]"));
//		WebElement Slider2 = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
//		
		
//		WebElement maxValueInput = driver.findElement(By.id("filters_price_max"));
		
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].setAttribute('data-selected-max','15000');", Slider2);
		
		
//		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
      
        actions.dragAndDropBy(Slider, 30, 0).build().perform();

		
		
//
		/////////////////////////////////////////
//		int minValue = Integer.parseInt(driver.findElement(By.cssSelector(".range-min")).getText().replaceAll("[^\\d]",""));
//		
//		int maxValue = Integer.parseInt(driver.findElement(By.cssSelector(".range-max")).getText().replaceAll("[^\\d]",""));
//		
		int sliderWidth = Slider.getSize().getWidth();
//		
		
		
		
		double xOffset=(15000/107400.0)*sliderWidth;
		actions.clickAndHold(Slider2).moveByOffset((int)xOffset,0).release().perform();
		
		Thread.sleep(5000);
		int position =(int)(((15000/107400)*sliderWidth));
		
		int newposition = (sliderWidth/174000)*15000;
//		actions.clickAndHold(Slider).moveByOffset((int)(sliderWidth*position/100.0), 0).release().build().perform();
//		actions.clickAndHold(Slider2).moveByOffset(sliderWidth, newposition).release().build().perform();
//		
		
//		js.executeScript(Slider2, args)
//		js.executeScript("arguments[0].setAttribute('style','left: ;"+position+"px;')", Slider.findElement(By.cssSelector(".noUi-handla-upper")));
//		
//		
		
//		SET STORAGE TYPE OPEN
		WebElement storageType = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]"));
		actions.moveToElement(storageType).perform();
		
		
		
//		CLICK ON THE CHECKBOX OPEN
		WebElement checkOpen = driver.findElement(By.xpath("//*[@id=\"filters_storage_type_Open\"]"));
		checkOpen.click();
		
		
		
		
		
}
}
