package com.package2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePractice {

	public DatePractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Date currentDate = new Date();
			System.out.println(currentDate);
			Long currentMilliSecond =System.currentTimeMillis();
			System.out.println(currentMilliSecond);
			currentDate = new Date(currentMilliSecond);
			System.out.println(currentDate); 
			
			SimpleDateFormat simDateFormat = new SimpleDateFormat();
			String dateFormat = "yyyy-MM-dd KK:mm";
			simDateFormat = new SimpleDateFormat(dateFormat);
			String date =  "2016-12-05 04:03";
			
			Date strToDate = simDateFormat.parse(date);
			System.out.println("String to Date --> "+strToDate);
			
			String dateToStr =simDateFormat.format(strToDate);
			System.out.println("Date to String --> "+dateToStr);
			
			java.sql.Date currentSqlDate = new java.sql.Date(currentMilliSecond);
			System.out.println("java sql date is "+currentSqlDate);
			
			System.out.println("currentDate.before(strToDate) --> "+currentDate.before(strToDate));
			System.out.println("currentDate.after(strToDate) --> "+currentDate.after(strToDate));
			System.out.println("currentDate.equals(strToDate) --> "+currentDate.equals(strToDate));
			System.out.println("currentDate.equals(currentDate) --> "+currentDate.equals(currentDate));
			System.out.println("currentDate.compareTo(strToDate) --> "+currentDate.compareTo(strToDate));
			System.out.println("currentDate.compareTo(currentDate) --> "+currentDate.compareTo(currentDate));
			
		//calendar..
			Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);
			int month = ca.get(Calendar.MONTH);      
			int day = ca.get(Calendar.DAY_OF_MONTH);
			int hour = ca.get(Calendar.HOUR_OF_DAY);
			int minute = ca.get(Calendar.MINUTE);
			int second = ca.get(Calendar.SECOND);
			System.out.println(year +" "+ (month+1) +" "+  day +" "+  hour +" "+  minute +" "+  second);
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception ex:"+ex);
		}
	}

}
