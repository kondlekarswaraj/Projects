package PractoWebsite;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class WebsiteTest {

	private WebDriver driver;
	private String baseURL;
	
	
	@Before
	public void setUp() throws Exception {
		
		 System.setProperty("webdriver.chrome.driver", "D:\\SWARAJ\\drivers\\chromedriver.exe");
	        driver = new ChromeDriver();                                                              //Create instance of Chrome
	        
//	     System.setProperty("webdriver.gecko.driver", "D:\\SWARAJ\\drivers\\geckodriver.exe");
//	        driver = new GeckoDriver();                                                               //Create instance of Mozilla Firefox 
	        
	     baseURL="https://www.practo.com/" ;                                                          //Write URL you want to Open
	        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);                           //Set Timeout     
	}

	//Write Text
	     public static void writeText(String ModuleName, String Result, String Comment) throws Exception {
		 FileWriter fw = new FileWriter("log.txt",true);
		
	     fw.write(ModuleName + Result + Comment);
	     fw.close();
	    }
	
	//Append Text
	     public static void appendText(String ModuleName1, String Result1, String Comment1) throws Exception {
		 FileWriter fw = new FileWriter("log.txt",true);
		
	     fw.write(ModuleName1 + Result1 + Comment1);
	     fw.close();
	    }
	
	
	@After
	public void tearDown() throws Exception {
		
	}

	
	@Test
	public void test() throws Exception {
		
		driver.get(baseURL);                                                                          //Open baseURL
		driver.manage().window().maximize();                                                          //Maximize Window
		
		
	//Login
		
		driver.findElement(By.xpath("//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/a")).click();    //Click on Login/Signup
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("7798862558");                                       //Write your Mobile no./Email ID
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("2525522552Spk");                                    //Write your Password
	    driver.findElement(By.xpath("//*[@id='login']")).click();                                                         //Click to Login

	    
   //Print Write Text
	    
	    String ModuleName = "Module Name: Login\t";
	    String Result = "Result: Passed\t";
   	    String Comment = "Comment: User Logged in Successfully\n\n";
	    writeText(ModuleName, Result, Comment);
  
	    
	//Search Cities(Mumbai)
	
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).clear();                    //Clear Location
		Thread.sleep(2000);                                                                                             //Time sleep for 2 seconds(2000 milliseconds)
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys("Mumbai");         //Search Location
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key one time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ENTER);       //Press Enter Key
		Thread.sleep(2000);
		
	//Search Hospitals(Mumbai)
	
     	driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys("Hospital");        //Search Hospital
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);   //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ENTER);        //Press Enter Key
		Thread.sleep(2000);
		
	//Accredited Hospitals(Mumbai)
	
    	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span")).click();       //Click on Accredited
		Thread.sleep(2000);
		
	//24x7 Open Pharmacy(Mumbai)
	
    	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span")).click();             //Click on All Filters
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[3]/span/span")).click();   //Click on 24x7 Pharmacy
		Thread.sleep(2000);
		
    //Print Top 5 Hospitals(Mumbai)
		
     	System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 1st Hospital Name    
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[3]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 2nd Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[4]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 3rd Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[5]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 4th Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[6]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 5th Hospital Name
		

		
	//Search Cities(Kolkata)
		
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).clear();                    //Clear Location
		Thread.sleep(2000);                                                                                             
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys("Kolkata");        //Search Location
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key one time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ENTER);       //Press Enter Key
		Thread.sleep(2000);
		
	//Search Hospitals(Kolkata)
		
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).clear();                     //Clear Hospital
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys("Hospital");        //Search Hospital
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);   //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ENTER);        //Press Enter Key
		Thread.sleep(2000);
	
	
    //Print Append Text
	    
	    String ModuleName1 = "Module Name: Logout\t";
	    String Result1 = "Result: Passed\t";
   	    String Comment1 = "Comment: User Logged out Successfully\n\n";
	    appendText(ModuleName1, Result1, Comment1);	
	    
	    
	//Logout
		
		driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/div/div[10]/a")).click();         //Logout
		Thread.sleep(2000);
		
		
   //Accredited Hospitals(Kolkata)
		
    	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span")).click();       //Click on Accredited
		Thread.sleep(2000);
		
   //24x7 Open Pharmacy(Kolkata)
		
    	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span")).click();             //Click on All Filters
		Thread.sleep(2000);
     	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[3]/span/span")).click();   //Click on 24x7 Pharmacy
		Thread.sleep(2000);	
				
   //Print Top 5 Hospitals(Kolkata)
		
     	System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 1st Hospital Name    
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[3]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 2nd Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[4]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 3rd Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[5]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 4th Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[6]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 5th Hospital Name
		
	
				
	//Search Cities(Hyderabad)
		
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).clear();                    //Clear Location
		Thread.sleep(2000);                                                                                             //Time sleep for 2 seconds(2000 milliseconds)
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys("Hyderabad");      //Search Location
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key one time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);  //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input")).sendKeys(Keys.ENTER);       //Press Enter Key
		Thread.sleep(2000);
				
	//Search Hospitals(Hyderabad)
				
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).clear();                     //Clear Hospital
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys("Hospital");        //Search Hospital
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ARROW_DOWN);   //Press down key another time
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input")).sendKeys(Keys.ENTER);        //Press Enter Key
		Thread.sleep(2000);
				
	//Accredited Hospitals(Hyderabad)
				
		driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span")).click();       //Click on Accredited
		Thread.sleep(2000);
				
   //24x7 Open Pharmacy(Hyderabad)
				
    	driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span")).click();             //Click on All Filters
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[3]/span/span")).click();   //Click on 24x7 Pharmacy
		Thread.sleep(2000);	
				
   //Print Top 5 Hospitals (Hyderabad)
				
     	System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 1st Hospital Name    
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[3]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 2nd Hospital Name
	    System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[4]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 3rd Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[5]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 4th Hospital Name
		System.out.println(driver.findElement(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div/div[3]/div[6]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText());    //Print 5th Hospital Name	


   //Print Append Text
	    
//	    String ModuleName1 = "Module Name: Logout\t";
//	    String Result1 = "Result: Passed\t";
//    	String Comment1 = "Comment: User Logged out Successfully\n\n";
	    appendText(ModuleName1, Result1, Comment1);

	    
   //Logout
		
//		driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/span[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/div/div[10]/a")).click();         //Logout
//		Thread.sleep(2000);
   
   
		fail("Not yet implemented");
	}

}
