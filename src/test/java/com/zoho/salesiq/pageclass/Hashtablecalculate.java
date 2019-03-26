	//$Id$
package com.zoho.salesiq.pageclass;

import java.util.Hashtable;
import java.util.Set;


public class Hashtablecalculate {


	@SuppressWarnings("rawtypes")
	public static Hashtable report = new Hashtable();
	@SuppressWarnings("rawtypes")
	Hashtable res = new Hashtable();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateReport(Hashtable result, long timetaken) {

		{
	        try
	        {
	        	System.out.print("Result Size"+result.size());
	            timetaken = timetaken/1000;
	            String time = "";

	            if(timetaken > 60)
	            {
	                //long s = timetaken % 60;
	                long m = (timetaken / 60) % 60;
	                long h = (timetaken / (60 * 60)) % 24;
	                if(h > 0)
	                {
	                    if(h == 1)
	                    {
	                        time += h+" hour ";
	                    }
	                    else
	                    {
	                        time += h+" hours ";
	                    }
	                }
	                if(m > 0)
	                {
	                    if(m == 1)
	                    {
	                        time += m+ " min ";
	                    }
	                    else
	                    {
	                        time += m+" mins ";
	                    }
	                }
	                // if(s > 0)
	                // {
	                //     if(s == 1)
	                //     {
	                //         time += s +" sec";
	                //     }
	                //     else
	                //     {
	                //         time += s +" secs";
	                //     }
	                // }
	            }
	            else
	            {
	                time = timetaken + " secs";
	            }

	            report.put("TimeTaken", time);

	            int size = result.size();
	            int size1 = ZohoSalesiq.total;
	            int success = 0;
	            report.put("TotalUseCases", size);
	            Set<String> keys = result.keySet();
	            for(String key: keys){
	                if((boolean) (""+result.get(key)).equals("true"))
	                {
	                    success++;
	                }
	            }
// 	            System.out.println("overall sucess"+success);
// 	            System.out.println("overall failure"+(size-success));
	            System.out.println("Overall success"+success);
	            report.put("Success", success);
	            report.put("Failure", size-success);
	            int success_per = (success*100)/size;
	            report.put("Success_per", success_per);
	            report.put("Failure_per", 100-success_per);

	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}



}
