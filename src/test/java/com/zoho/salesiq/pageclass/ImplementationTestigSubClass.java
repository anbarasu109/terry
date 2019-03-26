//$Id$
package com.zoho.salesiq.pageclass;
import java.time.Duration;
import java.time.Instant;
import com.zoho.salesiq.pageclass.ImplementationTestig;

public class ImplementationTestigSubClass {

	public Instant end;
	
	public static void main(String args[]) throws Exception
	{
		ImplementationTestig test= new ImplementationTestig();
		ImplementationTestigSubClass test1= new ImplementationTestigSubClass();
		
		test.testingmethod1();
		Thread.sleep(5000);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(test.start, end);
// 		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
				
	}


}
