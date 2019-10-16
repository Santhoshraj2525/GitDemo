package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderHandlingDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("santhoshraj");
		driver.findElement(By.name("password")).sendKeys("crm@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		String ExpDate = "25-January-2001";
		String Spl[] = ExpDate.split("-");
		String day = Spl[0];
		String month = Spl[1];
		String year = Spl[2];
		Select select = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		select1.selectByVisibleText(year);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='slctMonth']")));
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		
		String before ="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after = "]/td[";
		
		final int totaldays =7;
		for(int i=2;i<7;i++) {
			for(int j=1;j<=totaldays;j++) {
				String actday=driver.findElement(By.xpath(before+i+after+j+"]")).getText();
				System.out.println(actday);
				if(actday.contains(day)) {
					driver.findElement(By.xpath(before+i+after+j+"]")).click();
				}
			}
		}
		
		Thread.sleep(3000);
		driver.close();
			

	}

}
