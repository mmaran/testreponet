package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

public class SliderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver wd = Util.initDriver(Util.Browser.Firefox);
		
		wd.manage().window().maximize();
		
		wd.get("https://jqueryui.com/slider/");
		
		wd.switchTo().frame(0);
		
		WebElement Slider = wd.findElement(By.xpath(".//*[@id='slider']/span"));
		
		Actions a = new Actions(wd);
		
		int i = 0;
		
		while(true){
		
		a.dragAndDropBy(Slider, i,0).build().perform();
		
		i = i +10;
		
		Thread.sleep(2000);
		}
		
		//for loop fixed
		//while loop dynamic
		
	

	}

}
