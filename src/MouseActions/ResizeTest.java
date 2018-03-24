package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

public class ResizeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver wd = Util.initDriver(Util.Browser.Firefox);
			
			wd.manage().window().maximize();
			
			wd.get("https://jqueryui.com/resizable/");
            
			wd.switchTo().frame(0);
			
			WebElement resize =wd.findElement(By.xpath(".//*[@id='resizable']/div[3]"));
			
			Actions a = new Actions(wd);
			
			a.clickAndHold(resize).build().perform();
			
			// Click and Hold , Release are to be paired
			
			a.moveToElement(resize, 80, 80).build().perform();
			
			a.release(resize).build().perform();
			
	}

}
