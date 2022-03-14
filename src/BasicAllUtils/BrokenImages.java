package BasicAllUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.plaf.basic.BasicArrowButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenImages {
	ExtentReports extend;
	ExtentTest etest;
	@BeforeMethod
	public void setUp() 
	{
	ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/index.html");
	spark.config().setDocumentTitle("MyFirstProjectReports");
	spark.config().setReportName("MyFirstExtentReports");
	
	extend=new ExtentReports();
	extend.attachReporter(spark);
	
	extend.setSystemInfo("Tester", "Sandeep");
	}
	
	
	
	@Test
	
	public  void LinksCheck() throws Exception {
		// TODO Auto-generated method stub
		etest=extend.createTest("LinksCheck");
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		//Boolean res;
		driver.get("https://www.google.co.in");
		
		Thread.sleep(5000);
	//	By anchorsde = By.tagName("a");
		//By imgsrc = By.tagName("img");
		
		
		List<WebElement> imgs =driver.findElements(By.tagName("a"));
		imgs.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("The total number of links are "+imgs.size());
		
		
		for(WebElement cb:imgs)
		{
			//System.out.println("The link is "+cb.getAttribute("href"));
			if (cb.getAttribute("href")!=null)
			{
			 Boolean res =this.LinksCheck(cb.getAttribute("href").toString());
			
			
				 if(res==false)
			 {
					 System.out.println(cb.getTagName()); 
			 }
			}
			else	
				 System.out.println(cb.getTagName());
			
			}
			
		
			
		
		//etest.
		extend.flush();
		
	}

	public Boolean LinksCheck(String link) throws MalformedURLException,Exception
	{		
		Boolean res=false;
		URL url=new URL(link);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(0);
		conn.connect();
					
		
		
		
		if(link.contains("http")||link.contains("https"))
		{
			
		
			
		
			if(conn.getResponseCode()==200)
			{
				File file=new File("./Links/activelinks1235.txt");
				
				FileWriter fw=new FileWriter(file,true);
				BufferedWriter br= new BufferedWriter(fw);
				
				br.append(link+"---->"+conn.getResponseCode());
				br.newLine();
				br.flush();
				br.close();
				res=true;
				System.out.println("Working link is ---->"+link+"----->"+conn.getResponseCode());
				return res;
			}
			
			
		
			}	
		System.out.println("Incorrect URl---->"+link+conn.getResponseCode());
		
				
	
		return res;		
}
}
