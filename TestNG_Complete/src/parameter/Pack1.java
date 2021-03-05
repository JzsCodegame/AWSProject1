package parameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Pack1 {
	@Test(dataProvider="testdata")
	public void TestChrome(String uname,String password){
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	// Maximize browser
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// Load application
	driver.get("https://twitter.com/login");
	// clear email field
	driver.findElement(By.name("session[username_or_email]")).clear();
	// Enter username
	driver.findElement(By.name("session[username_or_email]")).sendKeys(uname);
	// Clear password field
	driver.findElement(By.name("session[password]")).clear();
	// Enter password
	driver.findElement(By.name("session[password]")).sendKeys(password);
	}
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed(){

	// Create object array with 2 rows and 2 column- first parameter is row and second is //column
	Object [][] twitterdata=new Object[2][2];

	// Enter data to row 0 column 0
	twitterdata[0][0]="username1@gmail.com";
	
	// Enter data to row 0 column 1
	twitterdata[0][1]="Password1";
	
	// Enter data to row 1 column 0
	twitterdata[1][0]="username2@gmail.com";
	
	// Enter data to row 1 column 0
	twitterdata[1][1]="Password2";
	
	// return arrayobject to testscript
	return twitterdata;
	}
	}

