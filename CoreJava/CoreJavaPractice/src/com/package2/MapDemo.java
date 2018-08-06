package com.package2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public MapDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("HashMap..!!");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(101,"Aadvik");
		hm.put(102,"Muthu");
		hm.put(103,"Brindha");
		hm.put(null,"Brindha");//Accepts
		hm.put(null,null);//Accepts
		hm.put(null,null);//prints only once, duplicate null does not accepted.
		
		HashMap<Integer, String> hashm = new HashMap<Integer, String>();
		hashm.putAll(hm);
		System.out.println("To fetch the all the Entries from the Map..");
		
		Set<Map.Entry<Integer, String>> enSet =hashm.entrySet();
		for(Map.Entry<Integer, String> e : enSet){
			System.out.println(e.getKey() +" : " + e.getValue());
		}
		
		System.out.println("HashTable..!!");
		Hashtable<Integer, String> ht =new Hashtable<Integer, String>();
		ht.put(101,"Aadvik");
		ht.put(102,"Muthu");
		ht.put(103,"Brindha");
		//ht.put(null,"Brindha"); //throws .NullPointerException
		System.out.println("Hashtable elements :");
		Set<Map.Entry<Integer, String>> entSet =ht.entrySet();
		for(Map.Entry<Integer, String> e1 : entSet){
			System.out.println(e1.getKey() +" : " + e1.getValue());
		}
		
		System.out.println("Properties..!!");
		Properties p =new Properties();
		p.put(101,"Aadvik");
		p.put(102,"Brindha");
		p.put(103,"Muthu");
		System.out.println("To fetch the all the Entries from the Properties..");
		Set entySet =p.entrySet();
		
		Iterator i =entySet.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		
		TreeMap<Integer, String> tm =new TreeMap<Integer, String>();
		tm.put(101,"Aadvik");
		tm.put(103,"Muthu");
		tm.put(102,"Brindha");
		
		System.out.println("To fetch the all the Entries from the TreeMap..");
		
		Set<Map.Entry<Integer, String>> enySet =tm.entrySet();
		for(Map.Entry<Integer, String> e : enySet){
			System.out.println(e.getKey() +" : " + e.getValue());
		}

	}

}
