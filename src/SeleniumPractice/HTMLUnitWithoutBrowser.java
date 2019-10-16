package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitWithoutBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("Hello00");
		driver.findElement(By.name("password")).sendKeys("hellooo");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		String warning = driver.findElement(By.xpath("//p[contains(text(),'Invalid login')]")).getText();
		System.out.println(warning);
		String expected ="Invalid login";
		if(warning.equals(expected)) {
			System.out.println("correct popup");
		}


	}

}
