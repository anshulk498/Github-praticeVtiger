package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleLoginTest {

    // DataProvider that gives 3 sets of data
    @DataProvider(name = "loginData")
    public Object[][] loginTestData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user", "user123"},
            {"guest", "guest123"}
        };
    }

    // Test method that uses the data
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Testing login with:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        // Here you'd put your Selenium code, e.g.
        // driver.findElement(By.id("username")).sendKeys(username);
        // driver.findElement(By.id("password")).sendKeys(password);
    }
}