package pratice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertingDataInPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		Properties pro=new Properties();
		pro.setProperty("browser", "firefox");
		pro.setProperty("url", "http://localhost:8888");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/commondata.properties");
		pro.store(fos, "common data");
		fos.close();
		
		
	}

}
