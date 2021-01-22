package sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class day1 {
    public String baseUrl = "http://automationpractice.com/index.php";
    String driverPath = "C:\\Users\\jzo_0\\eclipse-workspace\\SElenium_4\\chromedriver.exe";
    String keyPath = "webdriver.chrome.driver";
    public WebDriver driver; 
    //private WebElement element;
    
@BeforeTest
public void setup() {
    System.out.println("launching browser"); 
    System.setProperty(keyPath, driverPath);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
 }


@Test(priority = 0)
public void getUrl() {
	 driver.manage().window().maximize();
	 driver.get(baseUrl);
	 
}

@Test(priority = 0)
public void verifyHomepageTitle() {
    String expectedTitle = "My Store";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
}


 
@Test(priority = 1)

public void verifySigninPage() {
	driver.findElement(By.xpath("//*[@class='login']")).click();
	String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String actualURL = driver.getCurrentUrl();
    Assert.assertEquals(actualURL, expectedURL);
}

@Test(priority = 2)
public void verifySignupForm() {
    String expectedForm = "create-account_form";
    String actualForm = driver.findElement(By.cssSelector("#create-account_form")).getAttribute("id");
    Assert.assertEquals(actualForm, expectedForm);
    
}

@Test(priority = 3)
public void verifyAuthentificForm() {
	String expectedForm = "login_form";
    String actualForm = driver.findElement(By.cssSelector("#login_form")).getAttribute("id");
    Assert.assertEquals(actualForm, expectedForm);
}


@AfterTest
public void closeBrowser(){
    driver.close();
}

}


