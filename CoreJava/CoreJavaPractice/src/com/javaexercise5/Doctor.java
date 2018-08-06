package com.javaexercise5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Doctor implements Speciality, Cloneable, Serializable{
	
	private int id;
	private String name;
	ArrayList<Patient> patientList;
	
	public Doctor(){
		this.patientList = new ArrayList<Patient>();
	}
	
	public Doctor(int id, String name, ArrayList<Patient> patientList){
		this.id =id;
		this.name=name;
		this.patientList=patientList;
	
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}

	public void addPatient(ArrayList<Patient> p1) throws TwoManyPatients{
		if(this.patientList.size()>5){
			throw new TwoManyPatients();
		}
		else{
			this.patientList.addAll(p1);
		}
	}
	public void doTreatment(){
		System.out.println("Doctor do treatment for Eye,Nose,throat--ENT Specialist");
	}
	
	/*public Object clone() throws CloneNotSupportedException{
		System.out.println("Deep Cloning..!");
		Doctor d = (Doctor)super.clone();
		int i =this.getId();
		String n =this.getName();
		ArrayList<Patient> pa =(ArrayList<Patient>) this.patientList.clone();
		d.id =i;
		d.name =n;
		d.patientList =pa;
		return d;
	}*/
	
	public Object clone() throws CloneNotSupportedException{
		System.out.println("Shallow Cloning..!");
		return super.clone();
	}
	public void printAllPaitent(){
		System.out.println("Printing all patient deatils..");
		Iterator i =patientList.iterator();
		while(i.hasNext()){
			Patient pati =(Patient)i.next();
			System.out.println("Paitent Id :"+pati.getId()+" || "+"Patient Name :"+pati.getName());
		}
	}
	public void printSortedAllPaitent(){
		System.out.println("Sorted PatientList..!");
		Collections.sort(patientList);
		Iterator j =patientList.iterator();
		while(j.hasNext()){
			Patient patie =(Patient)j.next();
			System.out.println("Paitent Id :"+patie.getId()+" || "+"Patient Name :"+patie.getName());
		}
	}
}
