
package seleniumtest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver", "/home/sharathkaarthick/Downloads/Selenium/chromedriver_linux64/chromedriver");
      WebDriver driver = new ChromeDriver();
      
      String baseURL = "https://best-mobile-recommender.netlify.app/";
      
      String expectedTitle = "Best Mobile Recommender";
      String actualTitle = "";
      driver.get(baseURL);
      
      actualTitle = driver.getTitle();
      
      System.out.println("Website Title expected : "+expectedTitle+"\n");
      System.out.println("Website Title actual : "+actualTitle+"\n");
      
      if (actualTitle.contentEquals(expectedTitle))
      {
            System.out.println("Test Passed!\n");
            
            System.out.println("Finding Elements.... \n");
            findElements(baseURL, driver);
            
            System.out.println("Finding Properties.... \n");
            findProps(baseURL, driver);
            
            System.out.println("Filling Elements.... \n");
            fillElements(baseURL, driver);
        } 
      else 
      {
            System.out.println("Test Failed\n");
        }
      
      driver.close();
    }
   
    static void fillElements(String baseURL, WebDriver driver)
    {
        try {
            int sleepTimer = 3000;
            
            driver.findElement(By.id("contactName")).sendKeys("Lionel Messi");
            System.out.println("Field Name is typed" + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);

            driver.findElement(By.id("contactEmail")).sendKeys("abc@gmail.com");
            System.out.println("Field Email is typed" + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
    
            driver.findElement(By.id("contactSubject")).sendKeys("Random");
            System.out.println("Field Subject is typed"+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            driver.findElement(By.name("contactMessage")).sendKeys("Hello Google");
            System.out.println("Field Message is typed"+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
      
            driver.findElement(By.className("submit")).click();
            System.out.println("Button Clicked"+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     static void findElements(String baseURL, WebDriver driver)
    {
        try {
            int sleepTimer = 1000;
            
            driver.findElement(By.id("contactName")).isDisplayed();
            System.out.println("Field Name is Displayed" + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            driver.findElement(By.id("contactEmail")).isEnabled();
            System.out.println("Field Email is Enabled" + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            driver.findElement(By.id("contactSubject")).isSelected();
            System.out.println("Field Subject is Selected"+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            driver.findElement(By.className("submit")).getLocation();
            System.out.println("Button Located"+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            } 
        catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    static void findProps(String baseURL, WebDriver driver)
    {
        try {
            int sleepTimer = 1000;
            
            String type = driver.findElement(By.id("contactName")).getAttribute("type");
            System.out.println("Name Type : "+ type + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            String tagName = driver.findElement(By.id("contactEmail")).getTagName();
            System.out.println("Email Tagname : "+ tagName + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            Dimension size = driver.findElement(By.name("contactSubject")).getSize();
            System.out.println("Subject Dimensions : "+size+ "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            String color = driver.findElement(By.name("contactMessage")).getCssValue("color");
            System.out.println("Message Color : "+ color + "\t" + "// Wait for "+sleepTimer+"ms\n");
            Thread.sleep(sleepTimer);
            
            } 
        catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
