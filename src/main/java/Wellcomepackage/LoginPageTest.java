package Wellcomepackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTest {

	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	//Wait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

	@BeforeSuite
	public void beforesuittesting() {
		
		driver.manage().window().maximize();
		System.out.println("BeforeSuit");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@Test(priority = 0, enabled=false )  
	public void loginPageaTest() {
		driver.get("https://the-internet.herokuapp.com/login");
		// driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
		// driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[class='radius']")).click();
		// driver.findElement(By.partialLinkText("Elemental ")).click();
	}

	@Test(priority = 1, enabled=false) 
	public void SuccessAlert() {
		WebElement element=driver .findElement(By.cssSelector("a[class='button secondary radius']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String msg = driver.findElement(By.xpath("//div[contains(text(),'secure area')]")).getText();
		System.out.println(msg);
		System.out.println("Hello");
		// assertEquals(msg, " You logged into a secure area!");
	}
	
	@Test(priority = 2, enabled = false)
	public void lambdatest() {
		driver.get("https://accounts.lambdatest.com/register");
		driver.findElement(By.xpath("//input[@id='email' and @name='email']")).sendKeys(Keys.ENTER);
		String msg1=driver.findElement(By.cssSelector("p[data-testid='errors-email']")).getText();
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Keys.ENTER);
		String msg2=driver.findElement(By.cssSelector("p[data-testid='errors-password']")).getText();
		System.out.println(msg1+""+msg2);
		
	}
	
	@Test(priority = 3, enabled = false)
	public void FindWindowHandles() {
		driver.get("https://stqatools.com/demo/Windows.php");
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.xpath("//button[contains(text(),'new Tab')]")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.print("Size of handles is "+handles.size());
		for(String tab : handles) {
			if(! tab.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(tab);
				driver.findElement(By.xpath("//span[contains(text(),'Java')]")).click();
				driver.close();
				}
		}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.selenium.dev/blog/");
		
		
	}
	
	@Test(priority = 4, enabled = true)
	public void iframeTesting() {
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Hello");
		driver.switchTo().frame("frame3");
		driver.findElement(By.cssSelector("input[id='a']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.cssSelector("select[class='col-lg-3']"));
		Select select= new Select(driver.findElement(By.cssSelector("select[class='col-lg-3']")));
		select.selectByIndex(2);
		
		
		
		
		

		
	}

	@AfterSuite
	public void close() {
		driver.quit();
	}

}
