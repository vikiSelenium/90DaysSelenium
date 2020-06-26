package learnExcel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LearnJava {

	public static void main(String[] args) {
		//How to Use For Loop
		String str ="APPLE";
		for (int i=0; i<=2;i++)
		{
			System.out.println(str.toLowerCase());
		}
	}
	{
// Where to Use For Each Loop
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skills = driver.findElementById("Skills");
		Select sel = new Select(skills);
		List<WebElement> options = sel.getOptions();
for (WebElement ele : options) {
	
String text = ele.getText();
System.out.println(text);

}
String title = driver.getTitle();

System.out.println(title);

//Usage of If Condition
if(title.equalsIgnoreCase("regist"))
{
	System.out.println("Expected");
}



	}

}
