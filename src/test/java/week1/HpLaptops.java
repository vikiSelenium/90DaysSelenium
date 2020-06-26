package week1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HpLaptops {
	
	public static void main(String[] args) throws Exception {
	
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver=new ChromeDriver(options);
	driver.get("https://store.hp.com/in-en/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement laptops=driver.findElementByXPath("//a[@class='level-top ui-corner-all has-dropdown-menu']//span[text()='Laptops']");
	Actions action = new Actions(driver);
	action.moveToElement(laptops).build().perform();
	WebElement pavilion = driver.findElementByXPath("//a[@class='ui-corner-all']//span[text()='Pavilion']");
	action.moveToElement(pavilion).build().perform();
	pavilion.click();
	Thread.sleep(6000);
	driver.findElementByXPath("//button[text()='Accept Cookies']").click();
	WebElement processor = driver.findElementByXPath("(//dt[@class='filter-options-title']/span[text()='Processor'])[2]");
	action.moveToElement(processor).build().perform();
	processor.click();
	try {
		driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
	}
	catch(Exception exception) {
		System.out.println("Exception Occured");
	}
	driver.findElementByXPath("//span[text()='Intel Core i7']/../input").click();
	try {
		driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
	}
	catch(Exception exception) {
		System.out.println("Exception Occured");
	}
	WebElement hardDrive = driver.findElementByXPath("//span[text()='More than 1 TB']/../input");
	action.moveToElement(hardDrive).build().perform();
	hardDrive.click();
	Thread.sleep(5000);
	driver.findElementByXPath("//select[@id='sorter']").click();
	WebElement sortByField = driver.findElementByXPath("//select[@id='sorter']");
	Select dd = new Select(sortByField);
	dd.selectByVisibleText("Price : Low to High");
	String laptopName = driver.findElementByXPath("//a[@class='product-item-link']").getText();
	System.out.println(laptopName);	
	String laptopPrice = driver.findElementByXPath("//span[contains(@id,'product-price')]//span[@class='price']").getText();
	String price = laptopPrice.replaceAll("\\D", "");
	int abc = Integer.parseInt(price);
	System.out.println(abc);	
	Thread.sleep(5000);
	WebElement addToCart = driver.findElementByXPath("//span[text()='Add To Cart']/..");
	action.moveToElement(addToCart).build().perform();
	addToCart.click();
	Thread.sleep(5000);
	driver.findElementByXPath("//a[@class='action showcart']").click();
	driver.findElementByXPath("//a[@class='action primary viewcart']").click();
	driver.findElementByXPath("//input[@name='pincode']").sendKeys("600091",Keys.ENTER);
	driver.findElementByXPath("//button[text()='check']").click();
	String orderTotal = driver.findElementByXPath("//td[@data-th='Order Total']").getText();
	
	

}
}

