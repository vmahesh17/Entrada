package Entrada.MobileApp;

import java.io.IOException;

import org.testng.annotations.Test;

public class Testcases extends Keywords {
//	@Test
	public static void tc_001() throws IOException {
		
		
		TC1.CreatePIN_Login();
		TC3.testcase3();
		
		
	}
	@Test
	public static void testData() throws IOException {
		
		String s =Utils.getData("Username");
		
		System.out.println(s);
	}
	

}
