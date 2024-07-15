package autoIt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

// TODO Auto-generated method stub

		String downloadPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/");

		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\user\\Documents\\check\\fileupload.exe");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();

	//	@SuppressWarnings("deprecation")
	//	WebDriverWait wait = new WebDriverWait(driver, 10);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='g-btn g-btn--primary g-btn--medium']")));

	//	driver.findElement(By.xpath("//button[@class='g-btn g-btn--primary g-btn--medium']")).click();

	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		
		Thread.sleep(10000);
		driver.findElement(By.linkText("Download Now")).click();

		//Thread.sleep(5000);

		File f = new File(downloadPath + "/converted.zip");

		if (f.exists())

		{

			Assert.assertTrue(f.exists());

			if (f.delete())

				System.out.println("file deleted");

		}

	}

}