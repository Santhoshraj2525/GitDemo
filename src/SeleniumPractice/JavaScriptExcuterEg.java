package SeleniumPractice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExcuterEg {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("Hello00");
		driver.findElement(By.name("password")).sendKeys("hellooo");
		WebElement wPass =driver.findElement(By.name("password"));
		drawborder(wPass,driver);
		scrollDown(driver);
		/*File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Selenium\\Screenshots\\defect1.png"));
		generateAlert(driver, "There is an issue with password field");
		*/Thread.sleep(10000);
		driver.quit();
	}

	private static void drawborder(WebElement wPass, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border ='3px solid red'", wPass);
		
	}
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("alert('"+message+"')");
	}
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor jsr = (JavascriptExecutor) driver;
		jsr.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
