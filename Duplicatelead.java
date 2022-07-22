package Week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicatelead {

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
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("First name");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Test analyst at teastleaf");
		driver.findElement(By.name("primaryEmail")).sendKeys("Pascilla94@gmail.com");

		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select select = new Select(state);
		select.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();

		String title1 = driver.getTitle();

		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tesleaf");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pascilla klinta");
		driver.findElement(By.className("smallSubmit")).click();
		String title2 = driver.getTitle();
		if(title1.equals("View Lead | opentaps CRM")) {
			if(title1.equals(title2)) {
				System.out.println("Title is correct = "+title1);
			}else {
				System.out.println("Title is not correct = "+title1);
			}

		}
	}

}

	