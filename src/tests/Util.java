package tests;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.beust.jcommander.internal.Nullable;

public class Util {

	public enum Browser {
		Chrome, Firefox, IE
	}
	
	public static void resizeBrowser(WebDriver driver, int width, int height) {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}
	

	// Browser whichBrowser=Browser.Chrome;

	public static WebDriver initDriver(Browser whichBrowser) {
		WebDriver driver;

		switch (whichBrowser) {
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	static void takeScreenshot(TakesScreenshot driver, @Nullable String prefix, @Nullable String suffix) {

		File snapshotFile = driver.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		StringBuilder screenshotName = new StringBuilder("");
		if (prefix != null)
			screenshotName.append(prefix + "_");
		screenshotName.append(timestamp);
		if (suffix != null)
			screenshotName.append("_" + suffix);
		try {
			System.out.println("Saving screenshot: " + screenshotName);
			FileUtils.copyFile(snapshotFile, new File("Screens\\" + screenshotName + ".jpg"));
		} catch (IOException e) {
			System.out.println("Cant save Screenshot file");
			e.printStackTrace();
		}
	}
}
