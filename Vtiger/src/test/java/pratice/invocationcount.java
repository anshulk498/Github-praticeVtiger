package pratice;

import org.testng.annotations.Test;

public class invocationcount {

	@Test(invocationCount = 2)
	public void play() {
		System.out.println("i m playing");
	}
	@Test(invocationCount = 2)
	public void study() {
		System.out.println("i m studying");
	}
	
	@Test(invocationCount = 2)
	public void eat() {
		System.out.println("i m eating");
		
	}

}
