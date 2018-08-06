package com.javaexercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

	public CollectionDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee(104,"Aadvik",10000.00,"2024,Coolidge Hwy", 10, new Phone(245));
		Employee emp2 = new Employee(111,"Brindha",9000.00,"2020,Coolidge Hwy",20, new Phone(248));
		Employee emp3 = new Employee(105,"Muthu",10500.00,"2021,Coolidge Hwy",30, new Phone(760));
		ArrayList<Employee> arrList =new ArrayList<Employee>();
			arrList.add(emp1);
			arrList.add(emp2);
			arrList.add(emp3);
		System.out.println("Sorting ArrayList using Comparable by id..!");
			System.out.println("Before Sorting..!!");
			arrListIterator(arrList);	
			Collections.sort(arrList);
			System.out.println("After Sorting by id..!!");
			arrListIterator(arrList);
			
			System.out.println("Sorting ArrayList using ComparatorBySalary..!");
			Collections.sort(arrList, new ComparatorBySalary());
			System.out.println("After Sorting By Salary..!!");
			arrListIterator(arrList);
			System.out.println("No of Employees :"+Employee.count);
			Employee.test();
		
		HashSet<Employee> hashSet =new HashSet<Employee>();
			hashSet.add(emp1);
			hashSet.add(emp2);
			hashSet.add(emp3);
			hashSetIterator(hashSet);
			
		HashMap<String,Employee> hashMap =new HashMap<String, Employee>();
			hashMap.put("A",emp1);
			hashMap.put("B",emp2);
			hashMap.put("C",emp3);
			hashMapIterator(hashMap);
	}
	
	public static void arrListIterator(ArrayList<Employee> paraArr){
		System.out.println("ArrayList..!!");
		Iterator i =paraArr.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	public static void hashSetIterator(HashSet<Employee> paraHash){
		System.out.println("HashSet..!!");
		Iterator j =paraHash.iterator();
		while(j.hasNext()){
			System.out.println(j.next());
		}
	}
	public static void hashMapIterator(HashMap<String,Employee> paraHashMap){
		System.out.println("HashMap..!!");
		Set<Map.Entry<String,Employee>> set =paraHashMap.entrySet();
		for(Map.Entry<String,Employee> hm :set){
			System.out.println("Key :"+hm.getKey()+" -->Values :"+hm.getValue());
		}
	}
}
