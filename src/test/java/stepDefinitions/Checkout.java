package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stepDefinitions.AddtoCart;

public class Checkout {
	private WebDriver driver = LoadHomePage.driver;
	private WebDriverWait wait = LoadHomePage.wait;
	private String prod1Name = AddtoCart.prod1Name;
	private String prod2Name = AddtoCart.prod1Name;
	private String finalCartCount = AddtoCart.finalCartCount;
	private int CartValueToRand = AddtoCart.CartValueToRand;
	@Test (priority=0)
	public void proceedtoCheckOutPage() throws Exception {
		WebElement HomepageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Top Deals')]")));
		 String actualText = HomepageText.getText();
		 System.out.println(actualText + "  This is the homepage text");
		 String ExpectedText = "Top Deals";
		WebElement checkouticon =	driver.findElement(By.xpath("//*[@class='cart']//a//img"));
		checkouticon.click();
		WebElement checkOutBtn = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
		String checkoutBtnText = checkOutBtn.getText();
		Assert.assertEquals(checkoutBtnText, "PROCEED TO CHECKOUT");
		checkOutBtn.click();
		WebElement checkoutpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Product Name')]")));
		String productInCart = driver.findElement(By.xpath("//tbody//tr[1]//td[2]//p")).getText();
		String chekoutpagetext = checkoutpage.getText();
		Assert.assertEquals(chekoutpagetext,"Product Name"); 
		System.out.println("prod1name value iss "+prod1Name);
		Assert.assertEquals(productInCart,"Brocolli - 1 Kg");///input value should remain as 1
	}
	@Test (priority=1)
	public void placeOrder() throws Exception {
		WebElement placeorderBtn =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Place Order')]")));
		placeorderBtn.click();
		WebElement acceptTermsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Choose Country')]")));
		String pagename = acceptTermsPage.getText();
		Assert.assertEquals(pagename,"Choose Country");
	}
	
	@Test (priority=2)
	public void acceptTermsAndConditionsNegative() throws Exception {
		WebElement placeorderBtn =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Choose Country')]")));
		WebElement selectOption = driver.findElement(By.xpath("//select[1]"));
		selectOption.click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
    	WebElement country = driver.findElement(By.xpath("//option[contains(text(),'Kenya')]"));
    	je.executeScript("arguments[0].scrollIntoView(true);",country);
    	country.click();
		WebElement proceed = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
		proceed.click();
		String sucessMsg = driver.findElement(By.xpath("//span[@class='errorAlert']//b")).getText();
		System.out.println("this is the text ***  " +sucessMsg );
		Assert.assertTrue(sucessMsg.contains("Please accept Terms & Conditions - Required"));
	}
	
	@Test(priority=3)
	public void acceptTermsAndConditionsPositive() throws InterruptedException {
		WebElement placeorderBtn =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Choose Country')]")));
		WebElement selectOption = driver.findElement(By.xpath("//select[1]"));
		selectOption.click();
		JavascriptExecutor je = (JavascriptExecutor) driver;
    	WebElement country = driver.findElement(By.xpath("//option[contains(text(),'Kenya')]"));
    	je.executeScript("arguments[0].scrollIntoView(true);",country);
    	country.click();
    	
		WebElement acceptCheckbox = driver.findElement(By.xpath("//input[@class='chkAgree']"));
		acceptCheckbox.click();
		WebElement proceed = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
		proceed.click();
		String sucessMsg = driver.findElement(By.xpath("//div[@class='wrapperTwo']//span[1]")).getText();
		System.out.println("this is the text ***  " +sucessMsg );
		Assert.assertTrue(sucessMsg.contains("Thank you, your order has been placed successfully"));
	}
}
