package com.javaexercise3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

	public ReflectionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			Class emp =Employee.class;
			System.out.println("Class Name :"+emp.getName());
			
			Class mgr =Manager.class;
			System.out.println("Class Name :"+mgr.getName());
			for(Class cl : emp.getInterfaces()){
				System.out.println("Interface Name :"+cl.getName());
				System.out.println(cl.getName()+" is interface? "+cl.isInterface());
			}
			
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
						eNewIns.setSalary(4000.00);
						eNewIns.setDOB("08/06/2016");
						System.out.println("New Emp Object :"+eNewIns);	
						eNewIns.sayHi();
						
			/*Constructor [] mgrCons =mgr.getDeclaredConstructors();	
				for(Constructor d :mgrCons){
					System.out.println(mgr.getName() +" has following declared constructors., "+d.getName());
					System.out.println("Constructor isSynthetic : " + d.isSynthetic());
					Class[] dPara =d.getParameterTypes();
						for(Class mgrCPara : dPara){
							System.out.println(emp.getName() +" Parameter are "+mgrCPara.getName());
						}
					Manager mNewIns =(Manager)mgr.newInstance();
					mNewIns.printAllEmployees();
				}*/
				
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
				
			/*Method [] mMethod=mgr.getDeclaredMethods();
				for(Method mMe :mMethod){
					System.out.println("Manager Class Method are :"+mMe.getName());
				}*/
				
			Field [] empFields =emp.getDeclaredFields();
				for(Field emF : empFields){
					System.out.println("Employee class Fields_Type :"+emF.getType());
					System.out.println("Employee class Fields_Name :"+emF.getName());
				}
				
			/*Field [] mgrFields =mgr.getDeclaredFields();
				for(Field mgF : mgrFields){
					System.out.println("Employee class Fields_Type :"+mgF.getType());
					System.out.println("Employee class Fields_Name :"+mgF.getName());
				}*/	
				
				
				System.out.println("Employee SuperClass: "+emp.getSuperclass());
		}
		catch(Exception e){
			System.out.println("Exception :"+e);
		}
	}
}
