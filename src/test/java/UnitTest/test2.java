package UnitTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class test2 {
	public Properties prop;
	 public void readFile(String args[]) throws IOException
	 {
		if(prop==null) {
			prop= new Properties();
	 
			FileInputStream inputStream=null;
	 
	  try {
	   // Getting ClassLoader obj
	   ClassLoader classLoader = this.getClass().getClassLoader();
	   // Getting resource(File) from class loader
	   File configFile=new File(classLoader.getResource("projectConfig.properties").getFile());
	  
	   inputStream = new FileInputStream(configFile);
	   BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	prop.load(reader);
	System.out.println(prop.getProperty("email"));
	 
	  } catch (FileNotFoundException e) {
	 
	   e.printStackTrace();
	  }catch (IOException e) {
	 
	   e.printStackTrace();
	  }
	  finally {
	   inputStream.close();
	  }
	 
		}	 }
}
