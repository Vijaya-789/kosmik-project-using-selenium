package Kosmik;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registerationpage {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
	
		System.setProperty("webdriver.chrome.driver","D:\\New chrome\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	       
	      driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/index.php");
	      
	      driver.findElement(By.name("username")).sendKeys("kosmik");	
	      driver.findElement(By.name("password")).sendKeys("kosmik");
	  
	      driver.findElement(By.name("submit")).click();
	     Thread.sleep(3000);
	      driver.findElement(By.xpath("//a[text()='Registration']")).click();
	      Thread.sleep(300);
	      WebElement first= driver.findElement(By.xpath("//select[@name='PATIENT_CAT']"));
	     
	   List<WebElement> self=first.findElements(By.xpath("option"));
	   Select s=new Select(first);
	   s.selectByIndex(2);

	    Thread.sleep(3000);
	    
	      WebElement second= driver.findElement(By.xpath("//select[@name='TITLE']"));
	    
	   List<WebElement> ms=second.findElements(By.xpath("option"));
	   Select s1=new Select(second);
	   s1.selectByIndex(2);

	      driver.findElement(By.xpath("//input[@title='First Name with 4-20 chars only']")).sendKeys("sonia");
	      driver.findElement(By.xpath("//input[@name='MIDDLE_NAME']")).sendKeys("sing");	
	      driver.findElement(By.xpath("//input[@name='LAST_NAME']")).sendKeys("kolt");
	      driver.findElement(By.xpath("//input[@class='tcal tcalInput']")).click(); 
	      
	      Thread.sleep(300);
             
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Assign today's date using string variables
	      
	        String expectedDay = "21";  //  date
	        String expectedMonth = "September";  // Month is September
	        String expectedYear = "2024";  // Year is 2024

	        // Wait for the calendar element that displays the month and year to be visible
	        String expectedMonthYear = expectedMonth + " " + expectedYear;
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(), '" + expectedMonthYear + "')]")));

	        // Adjust the month and year if needed
	        while (true) {
	            WebElement monthYearElement = driver.findElement(By.xpath("//th[contains(text(), '" + expectedMonthYear + "')]"));
	            
	            if (monthYearElement.isDisplayed()) {
	                break; // If the correct month and year are displayed, stop the loop
	            }

	            // Navigate using the month and year buttons if necessary
	            WebElement prevMonthButton = driver.findElement(By.id("tcalPrevMonth"));
	            WebElement nextMonthButton = driver.findElement(By.id("tcalNextMonth"));
	            WebElement prevYearButton = driver.findElement(By.id("tcalPrevYear"));
	            WebElement nextYearButton = driver.findElement(By.id("tcalNextYear"));

	            // Adjust year if needed
	            String displayedYear = monthYearElement.getText().split(" ")[1];
	            if (expectedYear.compareTo(displayedYear) < 0) {
	                prevYearButton.click();
	            } else if (expectedYear.compareTo(displayedYear) > 0) {
	                nextYearButton.click();
	            }

	            // Adjust month if needed
	            String displayedMonth = monthYearElement.getText().split(" ")[0];
	            if (!displayedMonth.equals(expectedMonth)) {
	                if (expectedMonth.compareTo(displayedMonth) < 0) {
	                    prevMonthButton.click();
	                } else {
	                    nextMonthButton.click();
	                }
	            }
	        }

	        // Wait for the expected day element to be clickable and then click it
	        WebElement expectedDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'" + expectedDay + "')]")));
	        expectedDateElement.click();

	        // Verify if the correct date is selected
	        WebElement selectedDateElement = driver.findElement(By.xpath("//td[contains(@class, 'tcalSelected')]"));
	        String selectedDateText = selectedDateElement.getText();

	        if (selectedDateText.equals(expectedDay)) {
	            System.out.println("The selected date is correctly: " + expectedDay + " " + expectedMonth + " " + expectedYear);
	        } else {
	            System.out.println("Failed to select the correct date.");
	        }
   
	      driver.findElement(By.xpath("//input[@name='AGE']")).sendKeys("24");
	     WebElement third= driver.findElement(By.xpath("//select[@name='SEX']"));
	     
	 //  first.click();
	   List<WebElement> a=third.findElements(By.xpath("option"));
	   Select s2=new Select(third);
	   s2.selectByIndex(2);
//	   
	   WebElement fou= driver.findElement(By.xpath("//select[@name='MTRL_STATUS']"));
	     
		 //  first.click();
		   List<WebElement> b=fou.findElements(By.xpath("option"));
		   Select s3=new Select(fou);
		   s3.selectByIndex(2);
		   WebElement fiv= driver.findElement(By.xpath("//select[@name='RELIGION']"));
//		     
			 //  first.click();
			   List<WebElement> c=fiv.findElements(By.xpath("option"));
			   Select ss=new Select(fiv);
			   ss.selectByIndex(2);
			   WebElement six= driver.findElement(By.xpath("//select[@name='PLANGUAGE']"));
//			     
				 //  first.click();
				   List<WebElement> d=six.findElements(By.xpath("option"));
				   Select s4=new Select(six);
				   s4.selectByIndex(2);
	    
//    
//      driver.findElement(By.xpath("//input[@name='ADDRESS1']")).sendKeys("kosmik");	
      driver.findElement(By.xpath("//input[@name='MOBILE_NO']")).sendKeys("9754321234");	
      WebElement sev= driver.findElement(By.xpath("//select[@name='COUNTRY_CODE']"));
	     
		 //  first.click();
		   List<WebElement> e=sev.findElements(By.xpath("option"));
		   Select s5=new Select(sev);
		   s5.selectByIndex(2);
		   
		   WebElement eig= driver.findElement(By.xpath("//select[@name='RELATION']"));
//		     
			 //  first.click();
			   List<WebElement> f=eig.findElements(By.xpath("option"));
			   Select s6=new Select(eig);
			   s6.selectByIndex(2);
		   
		   WebElement nin= driver.findElement(By.xpath("//select[@name='PAT_IDENTITY']"));
//		     
			 //  first.click();
			   List<WebElement> g=nin.findElements(By.xpath("option"));
			   Select sss=new Select(nin);
			   sss.selectByIndex(2);;//("Voter ID");
			   driver.findElement(By.xpath("//input[@name='PAT_IDENTITY_PROOF']")).sendKeys("CDRPV78354");
//                                                
			   Actions aa=new Actions(driver);
			   aa.moveToElement(driver.findElement(By.xpath(" //input[@class='photo']"))).click().perform();
			   StringSelection S=new StringSelection("C:\\Users\\vijay\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-06-12 001833.png");//we given location

			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(S, null);//control c-->copy
			   Thread.sleep(2000);
			   Robot r=new Robot();                                      
			   r.keyPress(KeyEvent.VK_CONTROL);
			   r.keyPress(KeyEvent.VK_V);
			                                                              
			   r.keyRelease(KeyEvent.VK_CONTROL);                          
			   r.keyRelease (KeyEvent.VK_V);                              
		                                                                 	
			   r.keyPress(KeyEvent.VK_ENTER);                                 
			   r.keyRelease(KeyEvent.VK_ENTER);
			   
			   Thread.sleep(300);
			   
			   driver.findElement(By.xpath("//input[@name='ADDRESS1']")).sendKeys("Delhi");  
			   
			   WebElement a1= driver.findElement(By.xpath("//select[@name='NATIONALITY']"));
				   List<WebElement> a2=a1.findElements(By.xpath("option"));
				   Select a3=new Select(a1);
				  a3.selectByIndex(1);                          
				  
			   WebElement b1= driver.findElement(By.xpath(" //select[@name='IS_MLC']"));
					   List<WebElement> b2=b1.findElements(By.xpath("option"));
					   Select b3=new Select(b1);
					  b3.selectByIndex(1);                             
				   
					  WebElement c1= driver.findElement(By.xpath(" //select[@name='EDUCATION']"));
					   List<WebElement> c2=c1.findElements(By.xpath("option"));
					   Select c3=new Select(c1);
					  c3.selectByIndex(2);                            
				   
					  WebElement d1= driver.findElement(By.xpath("  //select[@name='OCCUPATION']"));
					   List<WebElement> d2=d1.findElements(By.xpath("option"));
					   Select d3=new Select(d1);
					  d3.selectByIndex(1);                            
				   
					  WebElement e1= driver.findElement(By.xpath("    //select[@name='BLOOD_GRP_CODE']"));
					   List<WebElement> e2=e1.findElements(By.xpath("option"));
					   Select e3=new Select(e1);                                                          
					  e3.selectByIndex(1);                          
				   

					  WebElement f1= driver.findElement(By.xpath(" //select[@name='CITIZENSHIP']"));
					   List<WebElement> f2=f1.findElements(By.xpath("option"));
					   Select f3=new Select(f1);                                 
					  f3.selectByIndex(2);
			   
					  WebElement g1= driver.findElement(By.xpath("//select[@name='SC_PROOF']"));
					   List<WebElement> g2=g1.findElements(By.xpath("option"));
					   Select g3=new Select(g1);                                                          
					  g3.selectByIndex(1);;//("Voter ID");  
			   
			   
					  driver.findElement(By.xpath("//input[@name='ZIP']")).sendKeys("642234");  
					  
					  Thread.sleep(300);					
					  driver.findElement(By.xpath("//input[@name='submit']")).click();


	}

}
