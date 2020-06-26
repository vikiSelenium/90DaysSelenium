package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PepperFry {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);       
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement furniture = driver.findElementByXPath("//a[text()='Furniture']");
		Actions action = new Actions(driver);
		action.moveToElement(furniture).build().perform();
		WebElement officeChairs = driver.findElementByXPath("//a[text()='Office Chairs']");
		Thread.sleep(3000);
		action.moveToElement(officeChairs).click().perform();
		driver.findElementByXPath("//h5[text()='Executive Chairs']").click();
		driver.findElementByXPath("//input[@type='number']").clear();
		driver.findElementByXPath("//input[@type='number']").sendKeys("50");
		WebElement chairs = driver.findElementByXPath("//a[text()='Poise Executive Chair in Black Colour' and @title='Poise Executive Chair in Black Colour']");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(chairs));
		Thread.sleep(3000);
		//WebElement wishList =
		//action.moveToElement(wishList).build().perform();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']").click();
		Thread.sleep(8000);
		driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour' and @id='clip_wishlist_']").click();
		//wait.until(ExpectedConditions.elementToBeClickable(wishList));
		Thread.sleep(3000);
        // driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']").click();
		WebElement homeWare = driver.findElementByXPath("//a[text()='Homeware']");
		action.moveToElement(homeWare).build().perform();
		WebElement pressureCookers = driver.findElementByXPath("//a[text()='Pressure Cookers']");
		action.moveToElement(pressureCookers).build().perform();
		Thread.sleep(3000);
		pressureCookers.click();
		driver.findElementByXPath("//label[@for='brandsnamePrestige']").click();
		driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']").click();
		

	}

}
