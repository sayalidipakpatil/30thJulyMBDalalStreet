package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class UtilityPage extends TestBase{
	public UtilityPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void scroll()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1400)");
	}
	public static void screenshot(String filename)
	{
	  try 
	   {	
	    String path="C:\\Users\\compro\\eclipse-workspace\\DalalStreetTDD\\screenshot\\";
        TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File(path+filename+".png");
		FileHandler.copy(src, des);
	   }
	  catch(IOException e)
	  {
		  System.out.println("IO Exception -file not found");
		  e.printStackTrace();
	  }
	   
	}

}
