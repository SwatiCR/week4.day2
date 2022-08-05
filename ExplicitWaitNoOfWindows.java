package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitNoOfWindows {

	public static void main(String[] args) {
		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		//maximize the screen
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		//find the element
		WebElement findElement = driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']"));
		findElement.click();
		
		//webdriver wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

	}

}
