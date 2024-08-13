package Travel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Home {
	private WebDriver driver;
	private WebElement loginbutton;
	    
	    // Scroll to the top of the page
	    
	@Test  (priority=1)  //WebElement Loginbutton= driver.findElement(By.xpath(""));//Thread.sleep(Duration.ofSeconds(8));
	
	public void login () throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://traveltriangle.com/");
		Thread.sleep(Duration.ofSeconds(10));
		WebElement loginbutton= driver.findElement(By.xpath("//button[@class='relative pfc3 f12 fw7 h40 mt2 ml15 pt15 pb15 text-uppercase cursorP' and text()='Login']"));
		loginbutton.click();
		Thread.sleep(Duration.ofSeconds(10));
		WebElement UserId= driver.findElement(By.xpath("//input[@name='email']"));
		UserId.sendKeys("dar3992@gmail.com");
		WebElement Password= driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("Daksh@2023");
		WebElement Loginbutton= driver.findElement(By.xpath("//button[@class='btn-filled-pri-large radius2 wfull ripple at_loginBtn']"));
		Loginbutton.click();
		
		
	}
	   @Test (priority=2)
	    public void verifyHomepageTitle() {
	    
	    
	    //  Capture the title of the homepage
	    String actualTitle = driver.getTitle();
	    
	    // Step 3: Validate the title
	    String expectedTitle = "Sign In - TravelTriangle";//"6300+ Tour Packages From Delhi, Mumbai, Bangalore, Chennai and Other Cities of India";
	    Assert.assertEquals(actualTitle, expectedTitle, "Homepage title does not match.");
	}
	
	@Test (priority=3)
	public void searchForDestination() throws InterruptedException {
	    
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    Thread.sleep(Duration.ofSeconds(10));
    // Locate the search bar and enter a destination
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Type a Destination']"));
        searchBar.sendKeys("Manali");
	   
	    searchBar.sendKeys(Keys.ENTER);
	    Thread.sleep(Duration.ofSeconds(10));
	    
	    jse.executeScript("window.scrollBy(0,-1000)"," ");
	     Thread.sleep(Duration.ofSeconds(2));
	     WebElement monthDropdown= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div/div/input"));
	     monthDropdown.click();
	    List<WebElement>drop=driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[2]/ul/li"));
	     
	    for (WebElement selection:drop)
	    {
	    	if(selection.getText().equals("September, 2024")) 
	    	
	    	{
	    		selection.click();
	    		
	    	}
	    }
	   
	    Thread.sleep(Duration.ofSeconds(2));
	    jse.executeScript("window.scrollBy(0,-1000)"," ");
	     
	     WebElement Explorebutton= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/div/div/div[3]/button/span"));
          Explorebutton.click();
	  
	    
		jse.executeScript("window.scrollBy(0,-1000)"," ");
//	    
	    
	    
//	    // Validate search results
//	    WebElement resultHeader = driver.findElement(By.xpath("//*[@id=\"package__card__section\"]/div[1]/div/div/div[1]/div[2]/div[1]/h3"));
//	    Assert.assertTrue(resultHeader.getText().contains("Manali"), "Search results do not contain 'Manali'.");

	

//	}

	}
	@Test (priority=4)
	public void navigateToBlogSection() throws InterruptedException 
	
	{  //Scroll top up on the page
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(Duration.ofSeconds(8));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");

	    // Click on the "Blog" link in the navigation bar
		Thread.sleep(Duration.ofSeconds(8));
	    WebElement blogLink = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div[1]/div[2]/div/div/div/div/div[2]/ul/li[3]/a"));
	    blogLink.click();
	   
	    // Validate that the user is redirected to the Blog section
         String currentUrl = driver.getCurrentUrl();
         Assert.assertTrue(currentUrl.contains("blog"), "Did not navigate to the Blog section.");
         Thread.sleep(Duration.ofSeconds(8));
         driver.navigate().back();

    }

@Test (priority=5)
public void logout() throws InterruptedException 

{  //Scroll top up on the page
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Thread.sleep(Duration.ofSeconds(8));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, 0);");
	Thread.sleep(Duration.ofSeconds(8));
	
	Actions action=new Actions(driver);
	WebElement hover= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div[2]/div/div/div/div/div[2]/ul/li[7]/div/p"));
	action.moveToElement(hover);	
	hover.click();
	
	WebElement signout= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/div[2]/div/div/div/div/div[2]/ul/li[7]/div/ul/li[3]/a"));
	signout.click();
	Thread.sleep(Duration.ofSeconds(10));
	js.executeScript("window.scrollTo(0, 0);");
	
	//Assert.assertTrue(loginbutton.isDisplayed(), "Logout failed. User is still logged in.");
}
}