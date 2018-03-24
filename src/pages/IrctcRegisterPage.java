package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class IrctcRegisterPage {
	WebDriver driver;
	public String urlString = "https://www.irctc.co.in/eticketing/userSignUp.jsf";

	public IrctcRegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement userIdTextBox() {
		return driver.findElement(By.id("userRegistrationForm:userName"));
	}

	public WebElement passwordTextBox() {
		return driver.findElement(By.id("userRegistrationForm:password"));
	}

	public WebElement passwordConfirmTextBox() {
		return driver.findElement(By.id("userRegistrationForm:confpasword"));
	}

	public WebElement securityAnswerTextBox() {
		return driver.findElement(By.id("userRegistrationForm:securityAnswer"));
	}

	public WebElement firstNameTextBox() {
		return driver.findElement(By.id("userRegistrationForm:firstName"));
	}

	public WebElement lastNameTextBox() {
		return driver.findElement(By.id("userRegistrationForm:lastName"));
	}

	public void selectEnglish() throws InterruptedException {
		WebElement lang = driver.findElement(By.xpath("//*[@id='userRegistrationForm:prelan']"));
		Select langSelect = new Select(lang);
		langSelect.selectByIndex(1);
		// Thread.sleep(2000);
		langSelect.selectByVisibleText("English");

	}

	public void selectSecurityQuestion() {
		WebElement q = driver.findElement(By.cssSelector("select[id$='securityQ']"));
		Select qSelect = new Select(q);
		System.out.println("No. of questions: " + qSelect.getOptions().size());
		qSelect.selectByIndex(1);
	}

	public void selectGender(char gender) {
		// List<WebElement>
		// genders=driver.findElements(By.cssSelector("input[type='radio'][name*='gender']"));
		List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio' and contains(@name,'gender')]"));
		// List<WebElement>
		// genders=driver.findElements(By.xpath("//input[@type='radio'][ends-with(@name,'gender')]"));
		// ends-with available only from Xpath v2 // Usually xpath in browers will be v1
		switch (gender) {
		case 'F':
			genders.get(1).click();
			break;
		case 'T':
			genders.get(2).click();
			break;
		default:
			genders.get(0).click();

		}
	}

	public void selectMaritalStatus(boolean isMarried) {
		List<WebElement> mStatuses = driver.findElements(By.xpath("//table[contains(@id,'marital')]/*/*/*/input"));
		if (isMarried)
			mStatuses.get(0).click();
		else
			mStatuses.get(1).click();

	}

	public void selectDOB(int day, int month, int year) {
		// do some validation of input data

		WebElement e = driver.findElement(By.xpath("//select[contains(@id,'dobDay') or contains(@name, 'dobDay')]"));
		Select eSelect = new Select(e);
		eSelect.selectByIndex(day - 1);

		e = driver.findElement(By.xpath("//select[contains(@id,'dobMonth') or contains(@name, 'dobMonth')]"));
		eSelect = new Select(e);
		eSelect.selectByIndex(month - 1);

		e = driver.findElement(By.xpath("//select[contains(@id,'dateOfBirth') or contains(@name, 'dateOfBirth')]"));
		eSelect = new Select(e);
		eSelect.selectByVisibleText(Integer.toString(year));

	}

	public void selectOccupation(int occupationCode) {
		// some validation of input data
		assert occupationCode >= 0 && occupationCode <= 6;

		WebElement q = driver.findElement(By.id("userRegistrationForm:occupation"));
		Select qSelect = new Select(q);
		qSelect.selectByValue(Integer.toString(occupationCode));
	}

	public WebElement aadhaarTextBox() {
		WebElement e = driver
				.findElement(By.xpath("//select[contains(@id,'countries')]/../../preceding::tr[5]//input"));
		// or = //select[contains(@id,'countries')]//preceding::tr[5]//input
		return e;
	}

	public void selectIndia() {
		WebElement e = driver.findElement(By.id("userRegistrationForm:countries"));
		Select select = new Select(e);
		select.selectByIndex(1);
		e = driver.findElement(By.xpath("//*[@id='userRegistrationForm:countries']/following::label[3]"));
		assert !e.isDisplayed();
	}

	public void selectUS() {
		String usa = "United States of America";

		WebElement e = driver.findElement(By.id("userRegistrationForm:countries"));
		Select select = new Select(e);
		select.selectByVisibleText(usa);

		e = driver.findElement(By.xpath("//*[@id='userRegistrationForm:countries']/following::label[3]"));
		Assert.assertEquals(e.getText(),
				"International/NRI users with ISD code other than 91 have to pay Registration fees after successful registration i.e. on first login. Please note that the Registration fee for International/NRI users is Rs. 100 + GST.");
		assert e.isDisplayed();
		assert e.getText().equals(
				"International/NRI users with ISD code other than 91 have to pay Registration fees after successful registration i.e. on first login. Please note that the Registration fee for International/NRI users is Rs. 100 + GST.");

	}

}
