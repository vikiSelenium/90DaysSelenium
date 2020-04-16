package week1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//creating Actions Class
		Actions action = new Actions(driver);
		WebElement women = driver.findElementByXPath("//a[text()='Women']");
		action.moveToElement(women).build().perform();
		WebElement jCoats = driver.findElementByXPath("//a[text()='Jackets & Coats']");
		action.moveToElement(jCoats).perform();
		jCoats.click();
		String totalCount = driver.findElementByClassName("title-count").getText();
		String expectedNum = totalCount.replaceAll("\\D", "");
		int num  = Integer.parseInt(expectedNum);
System.out.println(num);		
String jacketsCount = driver.findElementByXPath("//label[text()='Jackets']/span").getText();
String totalJackets = jacketsCount.replaceAll("\\D", "");
int jackets = Integer.parseInt(totalJackets);
System.out.println(jackets);
String coatsCount = driver.findElementByXPath("//label[text()='Coats']/span").getText();
String totalCoats = coatsCount.replaceAll("\\D", "");
int coats = Integer.parseInt(totalCoats);
System.out.println(coats);
int actual = jackets + coats;
System.out.println(actual);
if(actual==num)
{
	System.out.println("The Comparison is successful");
	
}
WebElement coatCheckBox = driver.findElementByXPath("//input[@type='checkbox' and @value='Coats']/../div[@class='common-checkboxIndicator']");
coatCheckBox.click();
driver.findElementByClassName("brand-more").click();
driver.findElementByXPath("//input[@placeholder='Search brand' and @type='text']").sendKeys("Mango",Keys.ENTER);
driver.findElementByXPath("(//input[@type='checkbox' and @value='MANGO']/../div[@class='common-checkboxIndicator'])[2]").click();
driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
int count = 0;
List<WebElement> listOfBrands = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
int totalBrands = listOfBrands.size();
System.out.println(totalBrands);
for (WebElement ele : listOfBrands) {
	String allBrands = ele.getText();
	System.out.println("The Required Brand Name is "+ allBrands );
	if(allBrands.equalsIgnoreCase("MANGO"))
	{
		System.out.println("Brand matches");
		count=count+1;
	}
}

if (count==totalBrands) {
	
	System.out.println("***************All Products are mango*************");
}
else {
	System.out.println("There are no Mango products");
}
WebElement dd = driver.findElementByClassName("sort-sortBy");
action.moveToElement(dd).perform();
WebElement dd2 = driver.findElementByXPath("//label[@class='sort-label ' and text()='Better Discount']");
action.moveToElement(dd2).perform();
dd2.click();
WebElement firstEle = listOfBrands.get(0);
action.moveToElement(firstEle).perform();
//8driver.fine8dEleimentByClassName("product-discount9edPrice")pe0
driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();




}

	
		
			

	}

