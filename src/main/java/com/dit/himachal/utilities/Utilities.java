package com.dit.himachal.utilities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	
	public static  Date convertStringToDate(String date) throws ParseException {
		String sDate1= date;  
	    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  
	    
	    return date1;
	}

}
