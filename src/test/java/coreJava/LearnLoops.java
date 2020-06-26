package coreJava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnLoops {

	public static void main(String[] args) {
		String str = "APPLE$%&123";
		for(int i=0; i<=3;i++)
		{
			System.out.println(str.toLowerCase());
		}
		
		String output = str.replaceAll("\\D", "");
		System.out.println(output);
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement skills = driver.findElementById("Skills");
		Select select = new Select(skills);
				List<WebElement> options = select.getOptions();	
		for (WebElement ele : options) {
			System.out.println("The Elements in the dropdown are " + ele.getText());
		}
//WebElement month = driver.findElementByXPath("//select[@ng-model='monthbox']");
//Select sel = new Select(month);
//List<WebElement> mon = sel.getOptions();
//////for (WebElement ele1 : mon) {
//////	System.out.println("The Months are " + ele1.getText());
//////	
//////}
String title = driver.getTitle();
System.out.println("The Title is " + title);
if(title.equalsIgnoreCase("Register"))
{
	System.out.println("The Expected Title is Register");
//	driver.close();
}
else {
	System.out.println("The title is not Register");
}

	}

}
