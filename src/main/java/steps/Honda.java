package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Honda {
	
	public ChromeDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	@Given("Launch //www.honda2wheelersindia.com/")
	public void openUrl() {
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	driver= new ChromeDriver();
	driver.get("https://www.honda2wheelersindia.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@And("Click on scooters and click dio")
	public void clickDio() { 
	driver.findElementByXPath("//button[text()='×']").click();
	driver.findElementByXPath("//a[text()='Scooter']").click();
	wait = new WebDriverWait ( driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dio-BS-VI/']/img")));
	driver.findElementByXPath("//a[@href='/dio-BS-VI/']/img").click();
	}
	@And("Click on Specifications and mouseover on Engine")
	public void clickSpecifications() throws Exception {
	driver.findElementByXPath("//a[text()='Specifications']").click();
	Thread.sleep(5000);
	WebElement engine =driver.findElementByXPath("//a[text()='ENGINE']");
	action = new Actions(driver);
	action.moveToElement(engine).build().perform();
	}
	@And(" Go to Scooters and click Activa 125")
	public void clickActiva() throws Exception {
	String displacement = driver.findElementByXPath("//span[text()='Displacement']/../span[2]").getText();
	String dispacementdio = displacement.replaceAll("[^0-9.]", "");
    float dioDisplacement = Float.parseFloat(dispacementdio);
	System.out.println(dioDisplacement);
	driver.findElementByXPath("//a[text()='Scooter']").click();
	driver.findElementByXPath("//a[@href='/activa125-BS-VI/']/img").click();
	driver.findElementByXPath("//a[text()='Specifications']").click();
	Thread.sleep(5000);
	WebElement engine1 =driver.findElementByXPath("//a[text()='ENGINE']");
	action.moveToElement(engine1).build().perform();
	String displacementActiva125 = driver.findElementByXPath("//span[text()='Displacement']/../span[2]").getText();
	String finalValueActiva = displacementActiva125.replaceAll("\\D", "");
	float activaDisplacement = Float.parseFloat(finalValueActiva);
	System.out.println(activaDisplacement);
	if(dioDisplacement<activaDisplacement) {
		System.out.println("Activa has greater");
	}
	else {
		
		System.out.println("Dio has greater");
	}
	}
	@And("Click FAQ from Menu and Click dio under Browse By Product")
	public void clickFAQ() {
	driver.findElementByXPath("//a[text()='FAQ']").click();
	driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
	driver.findElementByXPath("//a[@href='#6a']").click();
	}
	@And("Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit")
	public void clickPriceMaster() {
	driver.findElementByXPath("//button[contains(@onclick,'validateformPriceMaster')]").click();
	driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
	}
	@And("click the price link,  Go to the new Window and select the state, city")
	public void NavigateWindow() {
	Set<String> windowHandles =driver.getWindowHandles();
	int windows = windowHandles.size();
	List<String> listOfWindows = new ArrayList<String>();
	listOfWindows.addAll(windowHandles);
	String window2 = listOfWindows.get(windows-1);
	driver.switchTo().window(window2);
	WebElement dd = driver.findElementById("StateID");
	Select option = new Select(dd);
	option.selectByVisibleText("Tamil Nadu");
	WebElement dd1 = driver.findElementById("CityID");
	Select option1 = new Select(dd1);
	option1.selectByVisibleText("Chennai");
	}
	@And("Print the price and model ")
	public void printPrice() {
	driver.findElementByXPath("//button[text()='Search']").click();
	List<WebElement> priceTable = driver.findElementsByXPath("//tbody[@style='background-color:white']/tr/td");
	for (WebElement ele : priceTable) {
		
		System.out.println(ele.getText());
	}
	}
@And ("Close the Browser")
public void closeBrowser() {
	driver.quit();
	
}
}

