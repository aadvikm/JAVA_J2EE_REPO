package com.javaexercise1;
//32)Create a HashMap, insert student id as key, student name as value.

//33)Iterate the HashMap using EntrySet and for each. Print the details.
//34)Insert null key and value. See it accecpts. 
//35)Intert multiple null key and see it works.
//36)Inter the same data set in HashTable. 
//37)Interate it and print the values. 
//38)Create a Property and load the same key value pair data and iterate and print the values. 
//39)Create a TreeMap and load the same data. Now iterate the list and see if insertion order is maintained or sorted based on Key. 
/*40)Write the difference between HashMap, HashTable, Properties, and TreeMap.
	Ans: HashMap : it will store the key, value pair of object in the Map using hash logic.it accepts only one null key and value.
		 HashTable : its legacy collection, which is thread safe,its does not allow the null value.
		 Properties : its also legacy collection, it does not follow the sorting order.
		 TreeMap: by default it will do the sorting of the object
	
*/
//41)Create a HashMap variable using putAll load all the values from old HM variable to new one. 
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class HashMapDemo {

	public HashMapDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
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
		
		Properties p =new Properties();
		p.put(101,"Aadvik");
		p.put(102,"Brindha");
		p.put(103,"Muthu");
		System.out.println("To fetch the all the Entries from the Properties..");
		Set eSet =p.entrySet();
		
		Iterator i =eSet.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		TreeMap<Integer, String> tm =new TreeMap<Integer, String>();
		tm.put(101,"Aadvik");
		tm.put(103,"Muthu");
		tm.put(102,"Brindha");
		
		System.out.println("To fetch the all the Entries from the TreeMap..");
		
		Set<Map.Entry<Integer, String>> eeSet =tm.entrySet();
		for(Map.Entry<Integer, String> e : eeSet){
			System.out.println(e.getKey() +" : " + e.getValue());
		}
		
	}

	

}
