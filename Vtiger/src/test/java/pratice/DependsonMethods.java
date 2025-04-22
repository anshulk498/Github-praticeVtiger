package pratice;

import org.testng.annotations.Test;

import Genric_Utility.BaseClass;
@Test
public class DependsonMethods extends BaseClass {

	
	public void play() {
		System.out.println("i m playing");
	}
	
	public void study() {
		System.out.println("i m studying");
	}
	
	public void eat() {
		System.out.println("i m eating");
		
	}

}
