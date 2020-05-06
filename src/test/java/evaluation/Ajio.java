package evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		driver.findElementByXPath("//input[@placeholder='Search AJIO']").sendKeys("Bags");
		driver.findElementByXPath("//button[@type='submit']").click();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='Women']")));
		driver.findElementByXPath("//label[@for='Women']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='Women - Handbags']")));
		driver.findElementByXPath("//label[@for='Women - Handbags']").click();
		driver.findElementByXPath("//div[@class='five-grid-container ']/div").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='price']")));
		driver.executeScript("window.scrollBy(0, 200)");
		driver.findElementByXPath("//span[text()='price']").click();
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("2000");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("//span[@class='ic-price-separator']/following::button[@type='submit']").click();
		driver.findElementByXPath("//div[@class='filter-dropdown']/select").click();
		WebElement dd = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select sel = new Select(dd);
		sel.selectByVisibleText("What's New");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Ferrari LS Shoulder Bag']/..")));
		Thread.sleep(4000);
		driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']/..").click();
		Set<String> windowHandles = driver.getWindowHandles();
		int totalWindows = windowHandles.size();
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(windowHandles);
		String win = listOfWindows.get(totalWindows-1);
		driver.switchTo().window(win);
		String couponCode = driver.findElementByXPath("//div[@class='promo-desc']").getText();
		System.out.println(couponCode);
		String codeEpic = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String onlyCode = codeEpic.replace("Use Code", "");
		System.out.println(onlyCode);
		driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("560043");
		driver.findElementByXPath("//button[@type='submit' and text()='CONFIRM PINCODE']").click();
		System.out.println(driver.findElementByXPath("//ul[@class='edd-message-success-details']").getText());
		driver.findElementByXPath("//div[text()='Other information']").click();
		System.out.println(driver.findElementByXPath("//span[text()='Customer Care Address']/following::span/following::span").getText());
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='GO TO BAG']"))).click();
		driver.findElementByXPath("//input[@id='couponCodeInput']").sendKeys("EPIC");
		driver.findElementByXPath("//button[text()='Apply']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Coupon savings']/following::span[@class='price-value discount-price']")));
		String couponSavings = driver.findElementByXPath("//span[text()='Coupon savings']/following::span[@class='price-value discount-price']").getText();
		String finalValue = couponSavings.replaceAll("[a-zA-Z]", "");
		System.out.println(finalValue);
		String price = "832.72";
		if(finalValue.contains(price)) {
			System.out.println("Discount Value Successful");
			driver.findElementByXPath("//div[text()='Delete']").click();
		}
		
		
	}

}
