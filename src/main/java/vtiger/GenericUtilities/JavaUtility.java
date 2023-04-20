package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java.
 * @author ADMIN
 *
 */

public class JavaUtility {
	/**
	 * This method will run Random number after every run
	 * @return
	 */

	public int getRandomNumber()
	{
		Random r= new Random();
		 return r.nextInt(1000);
	}
	/**
	 * This method will run  system Date after every run
	 * @return
	 */
	public String getSystemDate()
	{
		 Date d= new Date();
		 return d.toString();
		 
	}
	/**
	 * This method will run DateInFormat after every run
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		Date d =new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month =dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateValue = date+"-"+month+"-"+year+"-"+time;
		return dateValue;
		
	
	
	}

}
