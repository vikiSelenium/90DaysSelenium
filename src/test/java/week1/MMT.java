package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMT {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='Hotels']").click();
		driver.findElementByXPath("//span[contains(text(),'City / Hotel / Area / Building')]/../input").click();
		driver.findElementByXPath("//input[@type='text' and @placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa",Keys.ENTER);
		driver.findElementByXPath("//p[@data-cy='checkInDate']").click();
	    driver.findElementByXPath("//div[@aria-label='Fri May 15 2020']").click();
	    driver.findElementByXPath("//div[@aria-label='Tue May 19 2020']").click();
	    driver.findElementByXPath("//input[@data-cy='guest' and @id='guest']").click();
	    driver.findElementByXPath("//li[@data-cy='children-1' and  text()='1']").click();
	    WebElement dd = driver.findElementByXPath("//select[@class='ageSelectBox']");
	    Select dd1 = new Select(dd);
	    dd1.selectByVisibleText("12");
	    driver.findElementByXPath("//button[text()='APPLY']").click();
	    driver.findElementByXPath("//button[text()='Search']").click();
	    driver.findElementByXPath("//div[@id='root']").click();
	    driver.findElementByXPath("//label[contains(@for,'mmLocality_checkbox') and text()='Baga']").click();
	    driver.findElementByXPath("//label[text()='4 Star']").click();
	    driver.findElementById("hlistpg_hotel_name").click();
	    Set<String> windowHandles = driver.getWindowHandles();
		int totalWindows = windowHandles.size();
		System.out.println(totalWindows);
		List<String> listOfWindows = new ArrayList<String>();
		listOfWindows.addAll(windowHandles);
		String windows2 = listOfWindows.get(totalWindows-1);
		driver.switchTo().window(windows2);
		System.out.println(driver.getTitle());
		String hotelName = driver.findElementById("detpg_hotel_name").getText();
		System.out.println(hotelName);
		driver.findElementByXPath("//span[@class='latoBold font10 blueText pointer' and text()='MORE OPTIONS']").click();
		WebElement select = driver.findElementByXPath("//td[text()='3']/../td[6]/span[text()='SELECT']");
		select.click();
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeSelected(select));
		
		//WebElement select = driver.findElementByXPath("//td[text()='3 months']/../td[6]/span[text()='SELECT']");
		driver.findElementByXPath("//span[@class='close']").click();
		driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();
		String payableAmount = driver.findElementByXPath("//div[@id='totalPaymentRow']/div[2]/span").getText();
		String amount = payableAmount.replaceAll("\\D", "");
		int totalAmount = Integer.parseInt(amount);
		System.out.println(totalAmount);
		
	    
	    
	    
	    
	    
	    
	}

}
