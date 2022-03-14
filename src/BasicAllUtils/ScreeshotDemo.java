package BasicAllUtils;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScreeshotDemo {
	@Test
	public void TakeScreenShot()
	{
		System.setProperty("webdriver.chrome.driver", "c:/WEBDRIVERS/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.google.co.in");
		By searchfield= By.name("q");
		
		//driver.findElement(searchfield).click();
		
		//File srcfile=new File("./Screenshot/Sceenshot.png");
		
		WebElement search=driver.findElement(searchfield);
		Actions action=new Actions(driver);
		
		
		action.moveToElement(search).click().sendKeys("selenium").build().perform();
		
		 Calendar cal=Calendar.getInstance();
		
		System.out.println(cal.getTime().toString());
		TakesScreenshot tss=(TakesScreenshot)driver;
		File srcfile=tss.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./Screenshot/Sceenshot"+ cal.getTime().toString().replace(" ", "_").replace(":", "_")+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		driver.quit();
	}

	
	}
	
	

