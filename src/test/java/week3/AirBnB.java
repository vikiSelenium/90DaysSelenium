package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirBnB {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.airbnb.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='OK']"))).click();
		driver.findElementByXPath("//input[@placeholder='Where are you going?']").click();
		driver.findElementByXPath("//input[@placeholder='Where are you going?']").sendKeys("Coorg, Karnataka");
		driver.findElementByXPath("//div[text()='Coorg, Karnataka']").click();
		driver.findElementByXPath("//div[text()='Check in / Check out']/..").click();
		driver.findElementByXPath("//div[text()='Check in / Check out']/..").click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='June 2020']/../following::table/tbody/tr/td[2]")));
		driver.findElementByXPath("//div[text()='June 2020']/../following::table/tbody/tr/td[2]").click();
		driver.findElementByXPath("//div[text()='June 2020']/../following::table/tbody/tr/td[6]").click();
		driver.findElementByXPath("//div[text()='Guests']/..").click();
		WebElement addIcon = driver.findElementByXPath("//button[@aria-label='increase value' and @aria-describedby='searchFlow-subtitle-label-stepper-adults']");
		for(int i=1; i<=6;i++)
		{
			addIcon.click();
		}

		WebElement childAddIcon = driver.findElementByXPath("//button[@aria-label='increase value' and @aria-describedby='searchFlow-subtitle-label-stepper-children']");

		for(int j=1; j<=3;j++)
		{
			childAddIcon.click();
		}
		driver.findElementByXPath("//button[@type='submit']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='Cancellation flexibility']/.."))).click();
		driver.findElementByXPath("//button[@id='filterItem-switch-flexible_cancellation-true']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		driver.findElementByXPath("//span[text()='Type of place']").click();
		driver.findElementByXPath("//input[@id='filterItem-checkbox-room_types-Entire_home/apt']/../span[@data-checkbox='true']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		driver.findElementByXPath("//span[text()='Price']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='price_filter_min']")));
		//driver.findElementByXPath("//input[@id='price_filter_min']").click();
		//		WebElement minField = driver.findElementByXPath("//input[@id='price_filter_min']");
		//		minField.sendKeys(Keys.CONTROL + "a");
		//		minField.sendKeys(Keys.DELETE);
		//		minField.sendKeys("3000",Keys.ENTER);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"3000");
		//driver.findElementByXPath("//input[@id='price_filter_min']").clear();
		//driver.findElementByXPath("//input[@id='price_filter_min']")
		//Thread.sleep(4000);
		//driver.findElementByXPath("//input[@id='price_filter_max']").click();
		//		driver.findElementByXPath("//input[@id='price_filter_max']").clear();
		//		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys("5000");
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"5000");
		driver.findElementByXPath("//button[text()='Save']").click();
		driver.findElementByXPath("//span[text()='More filters']/..").click();
		WebElement bedRooms = driver.findElementByXPath("//button[@aria-describedby='subtitle-label-filterItem-stepper-min_bedrooms-0'and @aria-label='increase value']");
		for(int k=1; k<=3;k++)
		{
			bedRooms.click();
		}
		WebElement bathRooms = driver.findElementByXPath("//button[@aria-describedby='subtitle-label-filterItem-stepper-min_bathrooms-0'and @aria-label='increase value']");
		for(int l=1; l<=3; l++)
		{
			bathRooms.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Kitchen']/.."))).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Free parking on premises']/.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='House']/.."))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='English']/.."))).click();
		driver.findElementByXPath("//button[contains(text(),'stays')]").click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Prahari Nivas, the complete house']"))).click();
		Set<String> windowHandles = driver.getWindowHandles();
		int totalWindows = windowHandles.size();
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(windowHandles);
		String win = listOfWindows.get(totalWindows-1);
		driver.switchTo().window(win);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'amenities')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Not included']/../following::div")));
		String text = driver.findElementByXPath("//div[text()='Not included']/../following::div").getText();
		System.out.println(text);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']"))).click();


		String text2 = driver.findElementByXPath("//div[text()='Check-in']/../div[2]").getText();
		if(text2.contains("06/01/2020"))
		{
			System.out.println("CheckIn Date is as Expected");
		}
		String text3 = driver.findElementByXPath("//div[text()='Checkout']/../div[2]").getText();
		if(text3.contains("06/05/2020"))
		{
			System.out.println("Checkout Date is as Expected");
		}

	}


}
