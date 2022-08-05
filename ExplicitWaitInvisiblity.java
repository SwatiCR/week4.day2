package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitInvisiblity {

	public static void main(String[] args) {

		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://www.leafground.com/pages/disapper.html");

		//maximize the screen
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
		//find the element
		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));		
		
		//webdriver wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(findElement));
		
		String text = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/p")).getText();
		
		System.out.println(text);

	}

}
