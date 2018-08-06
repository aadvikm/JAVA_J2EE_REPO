package com.javaexercise5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DoctorSerialization {

	public DoctorSerialization() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Patient pat1 =new Patient(101,"Brindha");
			Patient pat2 =new Patient(102,"Aadvik");
			Patient pat3 =new Patient(103,"Muthu");
			
			Doctor doc = new Doctor();
			
			ArrayList<Patient> arrPat =new ArrayList<Patient>();
			arrPat.add(pat1);
			arrPat.add(pat2);
			arrPat.add(pat3);
			
			File f = new File("DocSerial.txt");
			FileOutputStream fos =new FileOutputStream(f);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(arrPat);
			System.out.println("Serialization Done.!");
			oos.flush();
			oos.close();
			fos.close();
			
			
			FileInputStream fis =new FileInputStream(f);
			ObjectInputStream ois =new ObjectInputStream(fis);
			ArrayList<Patient> arr =(ArrayList<Patient>)ois.readObject();
			Iterator i =arr.iterator();
			while(i.hasNext()){
				Patient p = (Patient)i.next();
				System.out.println("Paitent Id :"+p.getId()+" ||"+"Patient Name :"+p.getName());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception :"+ e);
		}
		

	}

}
