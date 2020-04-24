package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Honda {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//button[text()='×']").click();
		driver.findElementByXPath("//a[text()='Scooter']").click();
		driver.findElementByXPath("//a[@href='/dio-BS-VI/']/img").click();
		driver.findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(5000);
		WebElement engine =driver.findElementByXPath("//a[text()='ENGINE']");
		Actions action = new Actions(driver);
		action.moveToElement(engine).build().perform();
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
		
		driver.findElementByXPath("//a[text()='FAQ']").click();
		driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
		driver.findElementByXPath("//a[@href='#6a']").click();
		driver.findElementByXPath("//button[contains(@onclick,'validateformPriceMaster')]").click();
		driver.findElementByXPath("//a[text()='Click here to know the price of Activa 125 BS-VI.']").click();
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
		driver.findElementByXPath("//button[text()='Search']").click();
		List<WebElement> priceTable = driver.findElementsByXPath("//tbody[@style='background-color:white']/tr/td");
		for (WebElement ele : priceTable) {
			
			System.out.println(ele.getText());
		}
		
	
		driver.quit();
		
		
		
		

	}

}

