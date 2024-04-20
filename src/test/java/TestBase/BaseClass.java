package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;





public class BaseClass {
	
	public static WebDriver driver;
	public WebDriver wait;
	
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	
	@BeforeClass
	@Parameters({"Browser"})
	public void setup(String browser) throws IOException {
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		if(driver== null) {
			
		FileReader fr = new FileReader("C:\\Users\\2318177\\eclipse-workspace\\HackathonProject\\src\\test\\resources\\ConfigFiles\\config.properties");
		
		
		prop.load(fr);
		
		}
		
		switch(browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
			
		default: 
			System.out.println("No matching browser found");
			return;
		
	}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
		

		
	}
	
	
	public String captureScreenshot(String tname)throws Exception {
		try {
			
		String timeStamp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
				
		FileUtils.copyFile(sourceFile, targetFile);
	
		
		return targetFilePath;
		}catch(Exception e) {
			return null;
		}
	}
	
	
	
	@AfterClass
	public void close() {
		if(driver!=null) {
		
			driver.quit();
		}
	}

}
