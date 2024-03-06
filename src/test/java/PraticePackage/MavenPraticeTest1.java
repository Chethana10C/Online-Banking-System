package PraticePackage;

import org.testng.annotations.Test;

public class MavenPraticeTest1 {
	@Test(groups = "smoke, regression")
	public void praticeTest()
	{
		System.out.println("----Testscript-02");
	}
	
	@Test(groups = "regression")
	public void praticeTestsample()
	{
		System.out.println("----Testscript-03");
	}

}
