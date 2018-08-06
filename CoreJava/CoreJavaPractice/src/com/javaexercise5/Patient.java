package com.javaexercise5;

import java.io.Serializable;

public class Patient implements Cloneable, Serializable, Comparable {
	
	private int id;
	private String name;

	
	public Patient(){
	
	}
	
	public Patient(int id, String name){
		this.id=id;
		this.name=name;
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
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public boolean equals(Object ob){
		if(ob instanceof Patient){
			Patient pat=(Patient)ob;
			if(this.id==pat.id){
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public int hashCode(){
		return 2*this.id;
	}
	
	public int compareTo(Object obj){
		if(obj instanceof Patient){
			Patient p=(Patient)obj;
			if(this.id<p.id){
				return -1;
			}
			else if(this.id>p.id){
				return 1;
			}
			else 
				return 0;
		}
		return 0;
	}
}
