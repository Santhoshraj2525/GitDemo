package SeleniumPractice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewClass {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		/*Properties prp = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumFirstProject\\src\\SeleniumPractice\\config.properties");
		prp.load(fis);
		System.out.println(prp.getProperty("name"));*/
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Good PopUp #1')]")));	
		WebElement popup = driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]"));
		popup.click();
		Set<String> windows =driver.getWindowHandles();
		Iterator it = windows.iterator();
		String Parent = (String) it.next();
		String Child = (String) it.next();
		driver.switchTo().window(Child);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(Parent);
		System.out.println(driver.getTitle());
		driver.quit();
		/*Alert alt = driver.switchTo().alert();
		String str =alt.getText();
		alt.accept();
		driver.quit();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator itr= windows.iterator();
		*/// for window popups like file uploading we can directly send the keys of pathname and the type should be file tag should be there.
	}

}
