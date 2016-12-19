package core;

import com.beust.jcommander.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


	@Parameters(separators = "=")
	
	public class TV_CLO {
		
	       // List      -l="www.alegro.com|alegro.com", "www.alegro.com|blah blah"
	       @Parameter(names = {"-l", "--list"}, variableArity = true, description = "Your List")
	       static List<String> list = new ArrayList<String>();
	 
	      // String     -u="http://www.alegro.com"
	@Parameter(names = {"-u", "--url"}, description = "URL") //  required = true)
	       static String url = null; 

	      // String     -t=alegro.com
	@Parameter(names = {"-t", "—title_expected"}, description = "Title Expected")
	       static String title = null; 
	
	
	      // Help       --help
	       @Parameter(names = "--help", help = true, hidden = true)
	       static Boolean help = false;
	       
	       public static void main(String[] args) {
		      	
	              new JCommander(new TV_CLO(), args);
	              	
	                
			      if (help)             {new JCommander(new TV_CLO(), args).usage(); System.exit(0);}
	              if (list.size() == 0) {System.err.println("List is empty");}
	              else {for (String l : list) {System.out.println("List item = " + l);}}
	              if (url == null)     {System.err.println("URL is empty");}
	              else if (title == null) {System.err.println("Title is empty");}

	              else                  {System.out.println("URL " + url + ", Title " + title);
	              
	              WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
			      	driver.get(url);
			      	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			      	driver.quit();

	              }
	       }
	}
		
	
