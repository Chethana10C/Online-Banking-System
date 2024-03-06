package com.GenericUtilies;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	public int getRandomNo() {
		/**
		 * 
		 */

		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;	
	}
	
	public String getSystemDateInFormate()
	{
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt1 =  new Date();
	       String date = dateformate.format(dt1);
	       return date;
	}
}
