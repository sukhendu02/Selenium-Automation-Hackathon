package TestCases;





import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.StudyChairPage;
import TestBase.BaseClass;

public class StudyChairTestCase extends BaseClass {

	Actions ac;
	

	
	@Test(priority =1)
	public void goToStudyChair() {
		HomePage pg= new HomePage(driver);
		pg.clickonStudy();
		
	}
	
	@Test (priority =2)
	public void showStudyChair() throws Exception {
		StudyChairPage scp = new StudyChairPage(driver);
		scp.sortbyRecomendation();
		
	
		String filepath = captureScreenshot("StudyChair");
	}
	
	@Test(priority =3)
	public void printChairDetials() {
		StudyChairPage scp = new StudyChairPage(driver);
		Map<String, Double> printChair = scp.printDetials();
		
		
		System.out.println("-- Top Recommended Study Chairs -- ");
		for(Map.Entry<String, Double> entry: printChair.entrySet()) {
			System.out.println();
			System.out.println("Chair Name : "+entry.getKey()+" ---- Price : Rs."+entry.getValue());
			System.out.println();
		}
	}
}
