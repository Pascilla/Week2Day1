package Week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pascilla");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("klinta");
		WebElement dropdown1=driver.findElement(By.id("dataSourceId"));
		Select select = new Select(dropdown1);
		select.selectByVisibleText("Direct mail");
		driver.findElement(By.className("smallSubmit")).click();
		
		String str=driver.getTitle();
		if(str.equalsIgnoreCase("View Lead | opentabs CRM")) {
			System.out.println("Verified the title");
		}
			else
			{
				System.out.println("Title not found");
			}
		}
		 
		 
	}


