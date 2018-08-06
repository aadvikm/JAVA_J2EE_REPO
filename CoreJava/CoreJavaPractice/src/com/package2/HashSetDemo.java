package com.package2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetDemo {

	public HashSetDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Employee e1 =new Employee("Aadvik", 1002);
		Employee e2 =new Employee("Muthu", 1004);
		Employee e3 =new Employee("Brindha", 1006);
		
		HashSet<Employee> hsSet =new HashSet<Employee>();
		hsSet.add(e1);
		hsSet.add(e2);
		hsSet.add(e3);
		
		hashSet(hsSet);
		
		TreeSet<Employee> trSet =new TreeSet<Employee>();
		trSet.add(e1);
		trSet.add(e2);
		trSet.add(e3);
		
		treeSet(trSet);
		
		LinkedHashSet<Employee> lkSet =new LinkedHashSet<Employee>();
		lkSet.add(e1);
		lkSet.add(e2);
		lkSet.add(e3);
		
		linkedHashSetIterator(lkSet);
	}
	
	public static void hashSet(HashSet<Employee> empSet){
		System.out.println("HashSet..!!");
		Iterator i =empSet.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public static void treeSet(TreeSet<Employee> emptrSet){
		System.out.println("Tree Set..!!");
		for(Employee k :emptrSet){
			System.out.println(k);
		}
	}
	

	public static void linkedHashSetIterator(LinkedHashSet<Employee> lHsPara){
	
		System.out.println("LinkedHashSet..!!");
		Iterator i = lHsPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}

}
