package parameter;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

public class DataProvider1 {
	WebDriver driver;
	
	  
	  @BeforeTest
	public void setup() {
         System.setProperty("webdriver.gecko.driver","geckodriver.exe");
      //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		  //driver = new ChromeDriver();
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		  driver.manage().window().maximize();
	}
	  
	  @Test(priority = 0)
	    public void testNoParameter() throws InterruptedException{
	        String author = "guru99";
	        String searchKey = "india";
	        
	         
	        
	        driver.get("https://google.com");
	        WebElement searchText = driver.findElement(By.name("q"));
	        //Searching text in google text box
	        searchText.sendKeys(searchKey);
	        
	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	                System.out.println("Thread will sleep now");
	        
	        Thread.sleep(3000);
	        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" Value given by input = "+searchKey);
	        //verifying the value in google search box
	        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}
	  @Test(dependsOnMethods = {"testNoParameter"}, priority = 1)
	
	   @Parameters({"author","searchKey"})
	    public void testParameterWithXML(@Optional("Fahim") String author, @Optional("bangladesh") String searchKey) throws InterruptedException{

	      
	       // driver.get("https://google.com");

	        WebElement searchText = driver.findElement(By.name("q"));
	        //Searching text in google text box
	        searchText.sendKeys(author);

	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	        System.out.println("Thread will sleep now");
	        Thread.sleep(3000);
	        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
	        //verifying the value in google search box
	        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

	}
	   @Test(dataProvider="SearchProvider", priority = 2)
	    public void testMethod(String author,String searchKey2) throws InterruptedException{
	    {
	        WebElement searchText = driver.findElement(By.name("q"));
	        //search value in google searchbox
	        searchText.sendKeys(searchKey2);
	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey2);
	        Thread.sleep(3000);
	        String testValue = searchText.getAttribute("value");
	        System.out.println(testValue +"::::"+searchKey2);
	        searchText.clear();
	        //Verify if the value in google search box is correct
	        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey2));
	    }
	   }
 @DataProvider(name="SearchProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "Guru99", "India" },
	            { "Krishna", "UK" },
	            { "Bhupesh", "USA" }
	        };

	    } 

}
