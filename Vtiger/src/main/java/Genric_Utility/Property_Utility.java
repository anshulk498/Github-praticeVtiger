package Genric_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility {
	
	public String getKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}

}
