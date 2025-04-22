package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAsserts {
@Test
	public void m1() {
		String actdata="qspider";
		String ExpData="qspider";
		System.out.println("step 1");
		Assert.assertEquals(actdata, ExpData);
		System.out.println("step 2");
	}

}
