package tests;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;

import pageUIMap.DriverClass;
import pageUIMap.Parallelized;
import pageUIMap.TricSqlLoadTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.omg.CORBA.portable.InputStream;

import com.thoughtworks.selenium.Selenium;

//@RunWith(Parallelized.class)
public class LoadTest {

//	private Selenium selenium;
//	private  String browser;
//	private String browserVersion;
//	private String os;
//	public static Properties browserProps = new Properties();
//	private Properties parallelProps = new Properties(); 
//	private String json;
	
//	@Parameters
//    public static LinkedList browsersStrings() throws Exception { 
//      LinkedList browsers = new LinkedList();
// 
//      InputStream is = (InputStream) LoadTest.class.getResourceAsStream("/browser.properties");
//      browserProps.load(is);
// 
//      String[] rawBrowserStrings = browserProps.getProperty("browsers").split(",");
//      for (String rawBrowserString : rawBrowserStrings) {
//        if (rawBrowserString.indexOf(";") != -1) {
//          String[] browserParts = rawBrowserString.split(";");
//          browsers.add(new String[] { browserParts[0], browserParts[1], browserParts[2] });
//        } else {
//          browsers.add(new String[] { rawBrowserString, "", "" });
//        }
//      }
//      return browsers;
//    }
	
	public static void main(String[] args) {
		
//		DriverClass driver = new DriverClass();
//		driver.SetHTMLUnitDriver();
		
	}
		@Test
		  public void testClasaLogin() throws Exception {
			DriverClass driver = new DriverClass();
			
			driver.SetHTMLUnitDriver();
			
			TricSqlLoadTest tric = new TricSqlLoadTest(driver);
			
			tric.SearchforMakeAndModel();
		
	}
		 @After
		  public void tearDown() throws Exception {
				DriverClass driver = new DriverClass();
			 driver.quitDriver();
		    
		    }
		  }
		

