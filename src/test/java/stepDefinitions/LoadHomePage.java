package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoadHomePage {
	
			public static WebDriver driver = new ChromeDriver();
			public static WebDriverWait wait = new WebDriverWait(driver, 5);
			public String baseUrl= "https://rahulshettyacademy.com/seleniumPractise/#/";
			
//	@BeforeSuite(alwaysRun=true)
//	public void beforeSuite() {
//			 WebDriver driver = new ChromeDriver();
//			 WebDriverWait wait=new WebDriverWait(driver, 5);
//			 baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
//	}
//
//	@AfterSuite(alwaysRun=true)
//	public void afterSuite() {
//				driver.quit();
//	}

	 
		 @Test (priority=0)
		 public void LoadBaseUrl() throws InterruptedException {
			 driver.get(baseUrl);
			 driver.manage().window().maximize();
			 wait = new WebDriverWait(driver, 10);
			 WebElement HomepageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Top Deals')]")));
			 String actualText = HomepageText.getText();
			 System.out.println(actualText + "  This is the homepage text");
			 String ExpectedText = "Top Deals";
			 Assert.assertEquals(actualText, ExpectedText);

			 
		
		 
	}
}
