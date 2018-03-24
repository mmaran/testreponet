package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

public class DoubleClickTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver wd = Util.initDriver(Util.Browser.Firefox);
		
		wd.manage().window().maximize();
		
		wd.get("https://www.google.co.in/");
        
		WebElement gmail = wd.findElement(By.linkText("Gmail"));
		
		Actions a = new Actions(wd);
		a.doubleClick(gmail).build().perform();
		
		Dimension dimension = new Dimension(800, 600);
		wd.manage().window().setSize(dimension);
	}

}
