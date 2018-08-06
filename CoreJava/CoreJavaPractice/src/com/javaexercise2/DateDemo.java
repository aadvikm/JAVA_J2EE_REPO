package com.javaexercise2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public DateDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
		//1) Convert java.util.Date to String ("Eg. 08/23/2017")
				Date d =new Date();
				System.out.println("Date : "+d);
				SimpleDateFormat sdf =new SimpleDateFormat("08/23/2017");
				String s =sdf.format(d);
				System.out.println("Date to String :"+s);
				
				//2) Convert java.util.Date to String ("Eg. 1st August 2017")
				SimpleDateFormat sdf2 =new SimpleDateFormat("23/08/2017");
				String s2 =sdf2.format(d);
				System.out.println("Date to String :"+s2); 
				
				//3) Convert java.util.Date to String ("Eg. 23-AUG-2017")
				SimpleDateFormat sdf3 =new SimpleDateFormat("23-08-2017");
				String s3 =sdf3.format(d);
				System.out.println("Date to String :"+s3); 
				
				//4) Convert String ("Eg. 08/23/2017") to Date
				SimpleDateFormat sim =null;
				String dateFormat ="MM/dd/yyyy";
				sim =new SimpleDateFormat(dateFormat);
				String s4 ="08/23/2017";
				Date d1 =sim.parse(s4);
				System.out.println("String to date :"+d1);
				
				//5) Convert String ("Eg. 1st August 2017") to Date
				String dateFormat2 ="dd/MM/yyyy";
				SimpleDateFormat sim2 =new SimpleDateFormat(dateFormat2);
				String s5 ="15/08/2017";
				Date d2 =sim2.parse(s5);
				System.out.println("String to date :"+d2);
				
				//6) Convert String ("Eg. 23-AUG-2017") to Date
				String dateFormat3 ="dd-MM-yyyy";
				SimpleDateFormat sim3 =new SimpleDateFormat(dateFormat3);
				String s6 ="15-08-2017";
				Date d3 =sim3.parse(s6);
				System.out.println("String to date :"+d3);
				
				//7) Convert Date to String (08/23/2017 HH:MM:SEC)
				SimpleDateFormat sim4 =new SimpleDateFormat("MM/dd/yyyy HH:mm:SS");
				String s7 =sim4.format(d);
				System.out.println("Date to String :"+ s7);
				
				/*8) Using Calendar, get me the java.util.date of following values Date: 19 Month: 04 Year: 1987. And compare this date with today date (new Date()) 
				(use all the following to compare before, after, compareTo, and equals in Date class)*/
				SimpleDateFormat sim5 =new SimpleDateFormat("dd/MM/yyyy");
				String s8 ="19/04/1987";
				Date d4 =sim5.parse(s8);
				System.out.println("String to date :" +d4);
				
				Date toDate =new Date();
				System.out.println("Today's Date :"+toDate);
				
				System.out.println("toDate.before(d4) :"+toDate.before(d4));
				System.out.println("toDate.After(d4) :"+toDate.after(d4));
				System.out.println("toDate.equals(d4) :"+toDate.equals(d4));
				System.out.println("toDate.equals(toDate) :"+toDate.equals(toDate));
				System.out.println("toDate.compareTo(d4) :"+toDate.compareTo(d4));
				System.out.println("toDate.compareTo(toDate) :"+toDate.compareTo(toDate));
				
				//9) Add 5 days to today date and print the value
				Calendar c =Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, 5);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
