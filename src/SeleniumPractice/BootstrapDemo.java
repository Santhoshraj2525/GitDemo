package SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDemo {

	public static void main(String[] args) throws Exception {
		
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	List<WebElement> lst = driver.findElements(By.xpath("//ul//li//a//label"));
	for(int i=0;i<lst.size();i++) {
		String allValues = lst.get(i).getText();
		System.out.println(allValues);
		if(lst.get(i).isSelected()) {
			System.out.println("Its already selected");
		}else {
			lst.get(i).click();
		}
	}
	Thread.sleep(5000);
	driver.close();
	

	}

}
