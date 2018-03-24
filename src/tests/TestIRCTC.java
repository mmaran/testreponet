package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pages.IrctcLoginPage;
import pages.IrctcRegisterPage;

public class TestIRCTC {

	WebDriver driver;

	@BeforeTest
	@Parameters("Browser")
	public void setup(@Optional("firefox") String b) {
		switch (b) {
		case "C":
			driver = Util.initDriver(Util.Browser.Chrome);
			break;
		case "IE":
			driver = Util.initDriver(Util.Browser.IE);
			break;
		default:
			driver = Util.initDriver(Util.Browser.Firefox);

		}
		//driver.get("https://www.irctc.co.in/");
		// driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
		driver.get("https://www.irctc.co.in/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		IrctcLoginPage.signUpLink(driver).click();
	}

	@Test(dependsOnMethods= {"register2"}, dataProvider = "excel data", testName = "Register Test")
	public void register1(String firstName, String lastName) {
		// try {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		// while(!driver.getCurrentUrl().equals(IrctcLoginPage.urlString)) {
		IrctcLoginPage.signUpLink(driver).click();
		// }

		System.out.println(driver.getCurrentUrl());
		// WebElement form=driver.findElement(By.cssSelector("#userRegistrationForm"));
		// Util.takeScreenshot((TakesScreenshot)form, "IRCTC-Form", null);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		IrctcRegisterPage registerPage = new IrctcRegisterPage(driver);

		// while(driver.getCurrentUrl().equals(IrctcRegisterPage.urlString)) {
		registerPage.firstNameTextBox().sendKeys(firstName);
		registerPage.lastNameTextBox().sendKeys(lastName);
		registerPage.userIdTextBox().sendKeys("mmaran");
		registerPage.passwordTextBox().sendKeys("TestPass");
		registerPage.passwordConfirmTextBox().sendKeys("TestPass");
		registerPage.selectSecurityQuestion();
		registerPage.securityAnswerTextBox().sendKeys("Meow");

		try {
			registerPage.selectEnglish();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		registerPage.selectGender('M');
		registerPage.selectMaritalStatus(true);
		registerPage.selectDOB(16, 6, 1991);
		registerPage.selectOccupation(3);
		registerPage.aadhaarTextBox().sendKeys("3234");
		registerPage.selectIndia();
		registerPage.selectUS();
		// }

		// driver.manage().window().maximize();
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(100,250)", "");

		Util.takeScreenshot((TakesScreenshot) driver, "IRCTC", null);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * } catch(Exception e) { throw new SkipException(e.getMessage());
		 * 
		 * }
		 */

	}

	@Test
	public void register2() {

	}
	@DataProvider(name="excel data")
	public Object[][] registerData() {
		return new Object[][] {{"Mani","Maran"},{"Lokesh","R"}};
	}

	@AfterTest
	public void close() {
		// driver.close();
		driver.quit();
	}
}
