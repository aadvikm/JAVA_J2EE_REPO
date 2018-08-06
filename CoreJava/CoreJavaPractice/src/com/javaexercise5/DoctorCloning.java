package com.javaexercise5;

import java.util.ArrayList;

public class DoctorCloning {

	public DoctorCloning() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Patient pat1 =new Patient();
				pat1.setId(101);
				pat1.setName("Brindha");
			Patient pat2 =new Patient();
				pat2.setId(102);
				pat2.setName("Aadvik");
			Patient pat3 =new Patient();
				pat3.setId(103);
				pat3.setName("Muthu");
			
			Doctor doc = new Doctor();
			ArrayList<Patient> arrPat =new ArrayList<Patient>();
			arrPat.add(pat1);
			arrPat.add(pat3);
			arrPat.add(pat2);
			
			doc.addPatient(arrPat);
			System.out.println("Before Sorting..!");
			doc.printAllPaitent();
			System.out.println("After Sorting..!");
			doc.printSortedAllPaitent();
			
			Doctor doc2 = (Doctor)doc.clone();
			
			System.out.println("Original Doc Address :"+doc);
			System.out.println("Cloned Doc Address :"+doc2);
			System.out.println("Original Patient details..!");
			doc.printAllPaitent();
			System.out.println("Cloned Patient details..!");
			doc2.printAllPaitent();
			System.out.println("After changes in the Patient details..!");
			pat3.setName("Harshu");
			System.out.println("Original Patient details..!");
			doc.printAllPaitent();
			System.out.println("Cloned Patient details..!");
			doc2.printAllPaitent();
			
			
		
		}
		catch(TwoManyPatients tmp){
			System.out.println("TwoManyPatients :"+tmp);
		}
		catch(CloneNotSupportedException cse){
			System.out.println("CloneNotSupportedException :"+cse);
		}
		
	}

}
