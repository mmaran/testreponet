package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import tests.Util;

//throwable error handle
//throws error information
public class MouseOverTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver wd = Util.initDriver(Util.Browser.Firefox);
		
		wd.manage().window().maximize();
		
		wd.get("http://www.doosan.com/en/");
		
		WebElement CorporateProfile = wd.findElement(By.xpath(".//*[@id='menu-gnb']/li[3]/a/span[1]"));
		
		//Link /a
		//Table /table
		
		WebElement leadership = wd.findElement(By.xpath(".//*[@id='menu-gnb']/li[3]/ul/li[1]/a"));
		
		
		WebElement executiveteam = wd.findElement(By.xpath(".//*[@id='menu-gnb']/li[3]/ul/li[1]/ul/li[2]/a"));
		
		Actions a = new Actions(wd);
		
		Thread.sleep(2000);
		
		/*a.moveToElement(CorporateProfile).build().perform();
		
		Thread.sleep(2000);
		
		a.moveToElement(leadership).build().perform();
		
		Thread.sleep(2000);
		
		//a.moveToElement(executiveteam).build().perform();
		
		a.click(executiveteam).build().perform();*/
		
		a.moveToElement(CorporateProfile).moveToElement(leadership).moveToElement(executiveteam).click().build().perform();
		
		}

}
