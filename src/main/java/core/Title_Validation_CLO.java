package core;

import com.beust.jcommander.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;


	@Parameters(separators = "=")
	
	public class Title_Validation_CLO {
		
	       // List      -l="www.alegro.com|alegro.com", "www.alegro.com|blah blah"
	       @Parameter(names = {"-l", "--list"}, variableArity = true, description = "Your List")
	       static List<String> list = new ArrayList<String>();
	 
	      // String     -u="http://www.alegro.com"
	@Parameter(names = {"-u", "--url"}, description = "URL") //  required = true)
	       static String url = null; 

	      // String     -t=alegro.com
	@Parameter(names = {"-t", "—title_expected"}, description = "Title Expected")
	       static String title_expected = null; 
	
	
	      // Help       --help
	       @Parameter(names = "--help", help = true, hidden = true)
	       static Boolean help = false;
	       
	       public static void main(String[] args) {
		      	
	              new JCommander(new Title_Validation_CLO(), args);
	              	
	                
			      if (help)             {new JCommander(new Title_Validation_CLO(), args).usage(); System.exit(0);}
	              if (list.size() == 0) {System.err.println("List is empty");}
	              else {for (String l : list) {System.out.println("List item = " + l);}}
	              if (url == null)     {System.err.println("URL is empty");}
	              else if (title_expected == null) {System.err.println("Title is empty");}

	              else                  {System.out.println("URL " + url + ", Title " + title_expected);
	              
	              WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
			      	driver.get(url);
			      	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			      	String text_case_id = "TC-001.01";
			      	String useragentregex = "(?:Mozilla/5.0)\\s(?:\\(.*\\))\\s(?:Gecko/\\d{8})\\s(\\w+)/(\\d+.\\d+)";
			      	String useragent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
			      	Matcher m_browser = Pattern.compile(useragentregex).matcher(useragent);m_browser.find();

			      	String title_actual = driver.getTitle();

			      	if (title_expected.equals(title_actual)) {
			      	System.out.println("Test Case ID: \t\t" + text_case_id);
			      	System.out.println("Browser: \t\t" + m_browser.group(1) + " " + m_browser.group(2));
			      	System.out.println("URL: \t\t\t" + url);
			      	System.out.println("Title Expected: \t" + title_expected);
			      	System.out.println("Title Actual: \t\t" + title_actual);
			      	System.out.println("Test Case Result: \t" + "PASSED");

			      	} else {
			      	System.out.println("Test Case ID: \t\t" + text_case_id);
			      	System.out.println("Browser: \t\t" + m_browser.group(1) + " " + m_browser.group(2));
			      	System.out.println("URL: \t\t\t" + url);
			      	System.out.println("Title Expected: \t" + title_expected);
			      	System.out.println("Title Actual: \t\t" + title_actual);
			      	System.out.println("Test Case Result: \t" + "FAILED");
			      	}
			      	
			      	System.out.println("\nUserAgent: \t\t" + (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));

			      	driver.quit();

			      	}

			      	}
			      	
	              }
	       
	
