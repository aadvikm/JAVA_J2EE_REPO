package com.package2;

public class EnumPractice {
		public enum Directions {NORTH, SOUTH, EAST, WEST;}
		public enum Weekdays{SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;}

	public EnumPractice() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		for(Directions d : Directions.values()){
			System.out.println("Directions :"+d);
		}
		Weekdays monday = Weekdays.MONDAY;
		System.out.println(" wk is "+monday);
		
		Weekdays tuesday = Weekdays.TUESDAY;
		switch(tuesday){
			case MONDAY :
				System.out.println("This is MONDAY");
				break;
			case TUESDAY :
				System.out.println("This is TUESDAY");
				break;
			default :
				System.out.println("Invalid..");
				break;
		}
		Weekdays wk[] = Weekdays.values();
		for(Weekdays days : wk){
			System.out.println("Its " + days + " & "  +"Ordinal : " + days.ordinal());
		}
		Weekdays weekdaysEnum = Weekdays.MONDAY;
		System.out.println("weekdaysEnum  -> "+weekdaysEnum);
	}

}
