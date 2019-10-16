package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPickerUsingJS {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Date = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		String actDate = "12-12-2019";
		SelectDateUsingJS(driver, Date, actDate);
		//driver.findElement(By.xpath("//label[contains(text(),'Return date')]/preceding::button[@type='button']")).click();
		Thread.sleep(5000);
		driver.close();

	}

	public static void SelectDateUsingJS(WebDriver driver, WebElement element, String actDate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+actDate+"');", element);
	}
}
