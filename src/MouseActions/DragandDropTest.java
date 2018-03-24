package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

public class DragandDropTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver wd = Util.initDriver(Util.Browser.Firefox);
		
		wd.manage().window().maximize();
		
		wd.get("https://www.jqueryui.com/droppable/");
		
		wd.switchTo().frame(0);
		
		//drag xpath
		WebElement Drag = wd.findElement((By.xpath(".//*[@id='draggable']")));
		
		//drop xpath
		
		WebElement Drop = wd.findElement((By.xpath(".//*[@id='droppable']")));
		//Actions
		Actions a =  new Actions(wd);
		
		//drag and drop 
        a.dragAndDrop(Drag, Drop).build().perform();
        
        
	}

}
