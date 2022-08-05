package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown {

	public static void main(String[] args) throws IOException {

		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://www.redbus.in/");

		//maximize the screen
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		//create actions builder
		Actions builder = new Actions(driver);	

		//find the element
		WebElement endElement = driver.findElement(By.xpath("//h6[text()='Top Operators']"));

		//scroll down
		builder.scrollToElement(endElement).perform();

		File source = driver.getScreenshotAs(OutputType.FILE);

		File dest = new File("./redBus.png");

		FileUtils.copyFile(source, dest);

	}

}
