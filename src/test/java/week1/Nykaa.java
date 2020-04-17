package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement brands = driver.findElementByXPath("//li[@class='menu-dropdown-icon']/a[text()='brands']");
		action.moveToElement(brands).build().perform();
		WebElement popular = driver.findElementByXPath("//div[@class='BrandsCategoryHeading']/a[text()='Popular']");
		action.moveToElement(popular).perform();
		popular.click();
		WebElement loreal = driver.findElementByXPath("//div[@id='brandCont_Popular']/ul/li[5]/a/img");
		action.moveToElement(loreal).perform();
		loreal.click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		Set<String> windowHandles = driver.getWindowHandles();
		int totalWindows = windowHandles.size();
		System.out.println(totalWindows);
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(windowHandles);
		String windows2 = listOfWindows.get(totalWindows-1);
		driver.switchTo().window(windows2);
		System.out.println(driver.getTitle());
		WebElement sortBy = driver.findElementByXPath("//span[@class='pull-left']");
		action.moveToElement(sortBy).perform();
		sortBy.click();
		WebElement customerRated = driver.findElementByXPath("//span[text()='customer top rated']/../div");
		action.moveToElement(customerRated).perform();
		customerRated.click();
		Thread.sleep(3000);
		WebElement category = driver.findElementByXPath("//div[text()='Category']");
		action.moveToElement(category).perform();
		category.click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[@for='chk_Shampoo_undefined']/div").click();
		WebElement shampoo = driver.findElementByXPath("//div[@class='m-content__product-list__title']/h2/span[contains(text(),'Paris Colour Protect Shampoo')]");
		shampoo.click();
		Thread.sleep(3000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listOfWindows1 = new ArrayList<String>(windowHandles2);
		int windows1 = listOfWindows1.size();
		//listOfWindows1.addAll(windowHandles);
		//String windows3 = listOfWindows.get(windows1-1);
		Thread.sleep(3000);
		driver.switchTo().window(listOfWindows1.get(2));
		Thread.sleep(3000);
		WebElement selectQuantity = driver.findElementByXPath("//span[text()='175ml']");
		//action.moveToElement(selectQuantity).perform();
		selectQuantity.click();
		String MRP = driver.findElementByXPath("//span[text()='MRP:']/../parent::div").getText();
		String Value = MRP.replaceAll("\\D", "");
		int rate = Integer.parseInt(Value);
		System.out.println(rate);
		driver.findElementByXPath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ' and text()='ADD TO BAG']").click();
		driver.findElementByXPath("//div[@class='AddToBagbox']/div[@class='AddBagIcon']").click();
		String grandTotal = driver.findElementByXPath("//div[@class='first-col' and text()='Grand Total:']/div").getText();
		String total = grandTotal.replaceAll("\\D","");
		int output = Integer.parseInt(total);
		System.out.println(output);
		driver.findElementByXPath("//button[@type='button' and @class='btn full fill no-radius proceed ']").click();
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		String warningMessage = driver.findElementByXPath("//div[@class='message']").getText();
		System.out.println(warningMessage);
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
