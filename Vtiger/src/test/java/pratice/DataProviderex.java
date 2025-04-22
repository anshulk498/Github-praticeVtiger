package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderex {

	@DataProvider
	public Object[][] dataProviderex() {
		Object[][] data=new Object[3][4];//we add data type object so that it can take any type of data like string ,int etc
		data[0][0]= "anshul";
		data[0][1]=123456;
		data[0][2]= "anshulk@498@gmail.com";
		data[0][3]="Anshul@123";
		
		data[1][0]= "shiavm";
		data[1][1]=123456;
		data[1][2]= "shivam498@gmail.com";
		data[1][3]="Test@123";
		
		data[2][0] = "john";
        data[2][1] = 789012;
        data[2][2] = "john@example.com";
        data[2][3] = "John@123";
		return data;
	}
	
	@Test(dataProvider = "dataProviderex")
	public void Registration(String name, int password, String email, String emailPassword) {
        
        System.out.println("Name: " + name + ", Password: " + password + ", Email: " + email + ", Email Password: " + emailPassword);
    }
	

}
