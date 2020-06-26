package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zalando {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://zalando.com/");
		//driver.manage().window().maximize();
        //Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.alertIsPresent());
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		driver.switchTo().alert().accept();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[contains(text(),'Zalando.uk')]").click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("document.getElementById('uc-btn-accept-banner').click()");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'That’s OK ')]"))).click();
	    //driver.findElementByXPath("//button[contains(text(),'That’s OK ')]").click();
		driver.findElementByXPath("//span[text()='Women']").click();
		
//		try {
//			driver.findElementByXPath("//button[contains(text(),'That’s OK ')]").click();
//			
//		}
//		catch(Exception e){
//			System.out.println(e);
//			
//		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clothing']")));
		WebElement clothing = driver.findElementByXPath("//span[text()='Clothing']");
		Actions action = new Actions(driver);
		action.moveToElement(clothing).build().perform();
		WebElement coats = driver.findElementByXPath("//span[text()='Coats']");
		action.moveToElement(coats).build().perform();
		coats.click();
		driver.findElementByXPath("//span[@data-label='Material']").click();
		driver.findElementByXPath("//span[text()='cotton (100%)']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='filter by Length']"))).click();;
		//driver.findElementByXPath("//button[@aria-label='filter by Length']").click();
		driver.findElementByXPath("//span[text()='thigh-length']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='MANTEL - Parka - navy']"))).click();
//		WebElement mantelCoat = driver.findElementByXPath("//div[text()='Q/S designed by']");
//		jse.executeScript("arguments[0].scrollIntoView(true);",mantelCoat);
//		driver.findElementByXPath("//img[@alt='MANTEL - Parka - navy']").click();
		driver.findElementByXPath("(//img[@alt='olive' ])[2]").click();
		driver.findElementByXPath("//button[@aria-haspopup='listbox']").click();
		driver.findElementByXPath("//span[text()='M']").click();
		String errMsg = driver.findElementByXPath("//h2[text()='Out of stock']").getText();
		if(errMsg.contains("Out of stock")) {
			
			driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
			
		}
		driver.findElementByXPath("//button[@aria-haspopup='listbox']").click();
		driver.findElementByXPath("//span[text()='M']").click();
		driver.findElementByXPath("//span[text()='Add to bag']").click();
		String deliveryMessage = driver.findElementByXPath("//span[text()='Standard delivery']/..").getText();
		if(deliveryMessage.equalsIgnoreCase("free"))
		{
			driver.findElementByXPath("//span[text()='Add to bag']").click();
		}
		WebElement iconBag = driver.findElementByXPath("//a[@href='/cart/' and @class='z-navicat-header_navToolItemLink']");
		action.moveToElement(iconBag).build().perform();
		driver.findElementByXPath("//div[text()='Go to bag']").click();
		String deliveryDate = driver.findElementByXPath("//div[@data-id='delivery-estimation']").getText();
		
		System.out.println("The Expected Date is  - " + deliveryDate);
		WebElement freeDelivery = driver.findElementByXPath("//a[text()='Free delivery & returns*']");
		action.moveToElement(freeDelivery).build().perform();
		freeDelivery.click();
		String toolTip = driver.findElementByXPath("//h4[@class='title']/..").getText();
		System.out.println(toolTip);
		WebElement startChat = driver.findElementByXPath("//span[text()='Start chat']/..");
		action.moveToElement(startChat).build().perform();
		startChat.click();
		Set<String> windowHandles = driver.getWindowHandles();
		int totalWindows = windowHandles.size();
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(windowHandles);
		String win = listOfWindows.get(totalWindows-1);
		driver.switchTo().window(win);
		//Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='prechat_customer_name_id']")));
		driver.findElementByXPath("//input[@id='prechat_customer_name_id']").sendKeys("Babu");
		driver.findElementByXPath("//input[@id='prechat_customer_email_id']").sendKeys("Babu@gmail.com");
		driver.findElementByXPath("//button[@id='prechat_submit']").click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='liveAgentChatTextArea']")));
		driver.findElementByXPath("//textarea[@id='liveAgentChatTextArea']").sendKeys("Hi");
		driver.findElementByXPath("//button[text()='Send']").click();
		Thread.sleep(5000);
		String chatBox = driver.findElementByXPath("//span[@class='client']/following::span").getText();
        System.out.println(chatBox);
        driver.quit();
		
		
		}

}

