package BasicAllUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class FileWritingReading {
	ExtentReports extend;
	ExtentTest etest;
	@BeforeClass
	public void setUp() 
	{
	ExtentSparkReporter spark=new ExtentSparkReporter(("user.dir")+"\\ExtentReports\\ExtentReports.html");
	spark.config().setDocumentTitle("MyFirstProjectReports");
	spark.config().setReportName("MyFirstExtentReports");
	
	extend=new ExtentReports();
	extend.attachReporter(spark);
	
	extend.setSystemInfo("Tester", "Sandeep");
	}
	
	
	
	@Test
	public void ReadFile() throws IOException
	{
		extend.createTest("ReadFile");
		File file=new File("D:\\links.txt");
		
		FileReader fr=new FileReader(file);
		
		BufferedReader br=new BufferedReader(fr);
		int s=fr.read();
		
		//String str="";
		while(s!=-1)
		{
			
			System.out.print((char)s);
			s=br.read();
		}
		
		//System.out.println("\n=================================");
		
		
	}
	
	@Test(priority=2)
	public void BufferReadFile() throws IOException
	{	extend.createTest("BufferedFile");
		File file=new File("D:\\links.txt");
		
		FileReader fr=new FileReader(file);
		
		BufferedReader br=new BufferedReader(fr);
		String str=br.readLine();
		System.out.println(" ");
		//String str="";
		while(str!=null)
		{
			
			System.out.println(str);
			str=br.readLine();
		}
		br.close();
		System.out.println("----------------------------------------------------------------------------------------------------------");

	}
	@Test
	public void ReadWrite() throws IOException
	{
		extend.createTest("WritetoFile");
		File file=new File("D:\\links123.txt");
		
		FileWriter fr=new FileWriter(file);
		
		
		BufferedWriter br=new BufferedWriter(fr);
		
		
		br.append("sandeep kumar");
		br.flush();
		br.close();
		
		extend.flush();
	}
	@AfterClass
	public void exitedfe()
	{
		extend.flush();
	}
	
	
	
	
}
