package pratice;

import org.testng.annotations.Test;

import Genric_Utility.BaseClass;
@Test
public class ProiortyMethod extends BaseClass {

	
	@Test
	public void play() {
		int[] arr= {1,2,3};
		System.out.println(arr[5]);
		System.out.println("i m playing");
	}
	@Test(dependsOnMethods="play")
	public void study() {
		System.out.println("i m studying");
	}
	
	@Test(dependsOnMethods="study")
	public void eat() {
		System.out.println("i m eating");
		
	}
	
	
}
