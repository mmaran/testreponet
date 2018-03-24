package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcLoginPage {
	
	public static String urlString="https://www.irctc.co.in/eticketing/loginHome.jsf";
	private static WebElement element =null;
	
	public static WebElement signUpLink(WebDriver driver) {
		element = driver.findElement(By.linkText("Sign up"));
		return element;
	}
	
	public static WebElement signUpXPath(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='loginFormId']/div[1]/div[2]/table[1]/tbody/tr[2]/td[2]/input"));
	}
}
