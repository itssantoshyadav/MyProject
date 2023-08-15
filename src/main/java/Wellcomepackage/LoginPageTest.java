package Wellcomepackage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTest {

	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	//Wait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

	@BeforeSuite
	public void beforesuittesting() {
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		System.out.println("BeforeSuit");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@Test(priority = 0, enabled=true )  
	public void loginPageaTest() {
		// driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
		// driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[class='radius']")).click();
		// driver.findElement(By.partialLinkText("Elemental ")).click();
	}

	@Test(priority = 1, enabled=true) 
	public void SuccessAlert() {
		WebElement element=driver .findElement(By.cssSelector("a[class='button secondary radius']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String msg = driver.findElement(By.xpath("//div[contains(text(),'secure area')]")).getText();
		System.out.println(msg);
		System.out.println("Hello");
		// assertEquals(msg, " You logged into a secure area!");
	}
	
	@Test(priority = 2, enabled = true)
	public void lambdatest() {
		driver.get("https://accounts.lambdatest.com/register");
		driver.findElement(By.xpath("//input[@id='email' and @name='email']")).sendKeys(Keys.ENTER);
		String msg1=driver.findElement(By.cssSelector("p[data-testid='errors-email']")).getText();
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Keys.ENTER);
		String msg2=driver.findElement(By.cssSelector("p[data-testid='errors-password']")).getText();
		System.out.println(msg1+""+msg2);
		
	}

	@AfterSuite
	public void close() {
		driver.close();
	}

}
