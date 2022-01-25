package stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import stepDefinitions.LoadHomePage;

public class AddtoCart {
	private WebDriver driver = LoadHomePage.driver;
	private WebDriverWait wait = LoadHomePage.wait;
	public static String finalCartCount;
	public static int CartValueToRand;
	public static String prod1Name;
	public static String prod2Name;
	@Test (priority=0)
	public void reduceitemsOnCartToZero() throws Exception {
		WebElement addbutton1 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product'][1]//a[@class='decrement'][1]")));
		WebElement inputvalue = driver.findElement(By.xpath("//div[@class='product'][1]//input"));
		String value1 = inputvalue.getAttribute("value");
		addbutton1.click();
		finalCartCount = inputvalue.getAttribute("value");
		Assert.assertEquals(finalCartCount,value1); ///input value should remain as 1
	}
	@Test (priority=1)
	public void AddItemsToCartViaClick() throws Exception {
		WebElement addbutton1 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product'][1]//a[@class='increment'][1]")));
		WebElement inputvalue = driver.findElement(By.xpath("//div[@class='product'][1]//input"));
		String value1 = inputvalue.getAttribute("value");
		addbutton1.click();
		finalCartCount = inputvalue.getAttribute("value");
		Assert.assertEquals(finalCartCount,"2");
	}
	@Test (priority=2)
	public void AddItemsToCartviaInput() throws Exception {
	WebElement addbutton1 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product'][1]//a[@class='increment'][1]")));
	WebElement inputvalue = driver.findElement(By.xpath("//div[@class='product'][1]//input"));
	String value1 = inputvalue.getAttribute("value");
	inputvalue.clear();
	inputvalue.sendKeys("6");
	finalCartCount = inputvalue.getAttribute("value");
	CartValueToRand = Integer.parseInt(driver.findElement(By.xpath("//div[@class='product'][1]//p")).getText());
	System.out.println("this is the value here1111111" + CartValueToRand);
	CartValueToRand = CartValueToRand*6; // do math on total value of items in cart
	System.out.println(finalCartCount + "this is the final value");
	Assert.assertEquals(finalCartCount,"6"); 
	
	}
	@Test (priority=3)
	public void clickAddToCart() throws Exception {
		
	WebElement addbutton1 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product'][1]//button")));
	WebElement addbutton2 =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product'][2]//button")));
	System.out.println(finalCartCount + "this is the final value");
	addbutton1.click();
	addbutton2.click();
	prod1Name = driver.findElement(By.xpath("//div[@class='product'][1]//h4")).getText();
	prod2Name = driver.findElement(By.xpath("//div[@class='product'][2]//h4")).getText();
	System.out.println("this is prod 1 name value as at before checkount  " + prod1Name);
	int cart2ValueToRand = Integer.parseInt(driver.findElement(By.xpath("//div[@class='product'][2]//p")).getText());
	System.out.println("this is the vaue as at here22222" +CartValueToRand );
	CartValueToRand = CartValueToRand + (cart2ValueToRand *1);
	finalCartCount = Integer.toString(Integer.parseInt(finalCartCount)+1);//total cart value is sum of cart one amount and cart 2 amount
	WebElement itemsincartCount = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
	WebElement ValueOfitemsincart = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
	String finalitemsinCart = itemsincartCount.getText();
	String finalValueOfItemsInCart = ValueOfitemsincart.getText();
	Assert.assertEquals(finalitemsinCart,"2");
//	Assert.assertEquals(finalValueOfItemsInCart,CartValueToRand);
	
	}
}
