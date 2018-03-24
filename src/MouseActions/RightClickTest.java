package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

public class RightClickTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver wd = Util.initDriver(Util.Browser.Firefox);
		
		//wd.manage().window().maximize();
		
		wd.get("https://www.google.co.in/");
        
		WebElement gmail = wd.findElement(By.linkText("Gmail"));
		
		Actions a = new Actions (wd);
		
		a.contextClick(gmail).build().perform();
		
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(2000);
		
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		
		Thread.sleep(2000);
		
		a.sendKeys(Keys.ENTER).build().perform();
		
		//get the title and print in notepad(not in console).
		

	}

}
