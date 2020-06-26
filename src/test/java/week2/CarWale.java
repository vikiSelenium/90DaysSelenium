package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarWale {

	public static void main(String[] args) throws Exception {
	
////		1) Go to https://www.carwale.com/
		

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		2) Click on Used
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
//		3) Select the City as Chennai
		driver.findElementByXPath("//input[@type='text' and @id='usedCarsList']").click();
		driver.findElementByXPath("//input[@type='text' and @id='usedCarsList']").sendKeys("Chennai");
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		Thread.sleep(4000);
//		4) Select budget min (8L) and max(12L) and Click Search
//		driver.findElementById("minMaxContainer").click();
	//driver.findElementById("minMaxContainer").click();
//		driver.findElementById("minInput").sendKeys("8");
//		driver.findElementById("maxInput").sendKeys("12");
	//driver.findElementByXPath("//li[text()='8 Lakh']").click();
	driver.findElementByXPath("//input[@id='minInput']").sendKeys("8");
	driver.findElementByXPath("//input[@id='maxInput']").sendKeys("12");
		driver.findElementByXPath("//button[@id='btnFindCar']").click();
		Thread.sleep(9000);
		System.out.println(driver.getTitle());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		5) Select Cars with Photos under Only Show Cars With
		
		driver.executeScript("window.scrollBy(0, 450)");
		WebElement carPhotos = driver.findElementByXPath("//span[text()='Cars with Photos']");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(carPhotos));
		Actions ele = new Actions(driver);
		ele.moveToElement(carPhotos).build().perform();
		carPhotos.click();
		
//		6) Select Manufacturer as "Hyundai" --> Creta
		driver.executeScript("window.scrollBy(0, 850)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Hyundai ']")));
	    WebElement hyundai = driver.findElementByXPath("//span[text()=' Hyundai ']");
	    ele.moveToElement(hyundai).build().perform();
		//driver.findElementByXPath("//span[text()=' Hyundai ']").click();
	    js.executeScript("arguments[0].click();", hyundai);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Creta']")));
		WebElement creta = driver.findElementByXPath("//span[text()='Creta']");
		js.executeScript("arguments[0].click();", creta);
		
		
//		7) Select Fuel Type as Petrol
		WebElement fuelType = driver.findElementByXPath("//h3[contains(text(),'Fuel Type')]");
		js.executeScript("arguments[0].click();", fuelType);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Petrol']")));
		WebElement petrol = driver.findElementByXPath("//span[text()='Petrol']");
		js.executeScript("arguments[0].click();", petrol);
		
//		8) Select Best Match as "KM: Low to High"
		WebElement dd = driver.findElementByXPath("//select[@id='sort']");
		Select sel = new Select(dd);
		sel.selectByVisibleText("KM: Low to High");
//		9) Validate the Cars are listed with KMs Low to High
		Map<Integer,String> leastKmMap = new LinkedHashMap<Integer,String>();
		List<WebElement> totalKMs = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
		List<Integer> vehicleKm = new ArrayList<Integer>();
		for (WebElement ele1 : totalKMs) {
			System.out.println(ele1.getText());
			
			String Kms = ele1.getText();
			int finalKm = Integer.parseInt(Kms.replaceAll("\\D", ""));
			vehicleKm.add(finalKm);
			leastKmMap.put(finalKm, Kms);
			}
		
//		10) Add the least KM ran car to Wishlist
		List<Integer> leastVehicleKm = new ArrayList<Integer>(vehicleKm);
		Collections.sort(leastVehicleKm);
		if(vehicleKm.equals(leastVehicleKm))
		{
			System.out.println("Cars are Sorted");
		}
		else
		{
			System.out.println("Cars are not sorted");
		}
		Integer leastKM = leastVehicleKm.get(0);
		String strLeastKM = "";
		for (Entry<Integer, String> eachEntry : leastKmMap.entrySet())
		{
		if(eachEntry.getKey().equals(leastKM))
		{
			strLeastKM = eachEntry.getValue();
		}
		}
	System.out.println("Least Km is " + strLeastKM);
//		11) Go to Wishlist and Click on More Details
//		12) Print all the details under Overview 
//		13) Close the browser.

	}

}
