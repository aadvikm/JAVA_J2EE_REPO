package com.package2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionPractice {

	public ReflectionPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Class emp = Employee.class;
			System.out.println("Class Name :"+emp.getName());
			
			//Constructors
			Constructor [] cons =emp.getDeclaredConstructors();
				for(Constructor c :cons){
					System.out.println(emp.getName() +" has following declared constructors., "+c.getName());//constructor name
					System.out.println("Constructor isSynthetic : " + c.isSynthetic());
					Class[] cPara =c.getParameterTypes(); //constructor parameters
						for(Class empCPara : cPara){
							System.out.println(emp.getName() +" Parameter are "+empCPara.getName());
						}
					int i =c.getModifiers(); //to get constructor Access Specifiers
					System.out.println(emp.getName() +" Parameter Access Modifiers are "+Modifier.toString(i));
				}
						//to instantiate new instance/Object of the class
						Employee eNewIns =(Employee)emp.newInstance();
						eNewIns.setId(304);
						eNewIns.setName("Harshu");
						System.out.println("New Emp Object :"+eNewIns);	
						

				
			Method [] eMethod =emp.getDeclaredMethods();
				for(Method em :eMethod){
					System.out.println("Employee Class Methods are :"+em.getName());//to get method name
					Parameter[] parameters = em.getParameters();
					for(Parameter param : parameters){
					 System.out.println("Param Name: "+param.getName());
					}
					Class[] paraType =em.getParameterTypes(); //to get method para type
						for(Class mp : paraType){
							System.out.println("Method Para Type :"+mp.getName());
						}
					Class[] mExcep =em.getExceptionTypes();//to get the methods which throws exception
						for(Class mex :mExcep){
							System.out.println("Exception Methods :"+mex.getName());
						}
					//to invoke a method
					if(em.getName().equals("getId")){
						System.out.println("Before Invoking..!");
						System.out.println(em.invoke(eNewIns));
						System.out.println("After Invoking.!!");
					}
						
				}
				
		
			Field [] empFields =emp.getDeclaredFields();
				for(Field emF : empFields){
					System.out.println("Employee class Fields_Type :"+emF.getType());
					System.out.println("Employee class Fields_Name :"+emF.getName());
				}
		
				System.out.println("Employee SuperClass: "+emp.getSuperclass());
		}
		catch(Exception e){
			System.out.println("Exception :"+e);
		}

	}

}
