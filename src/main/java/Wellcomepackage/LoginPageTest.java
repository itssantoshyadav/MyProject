package Wellcomepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	WebDriver driver = new EdgeDriver();
	
	@BeforeSuite
	public void beforesuittesting() {
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		System.out.println("BeforeSuit");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		@Test
	public void loginPageaTest() {
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		//driver.findElement(By.className("fa fa-2x fa-sign-in")).click();
		
	}
		
		@AfterSuite
		public void close() {
			driver.close();
		}

}
