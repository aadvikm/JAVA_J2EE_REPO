package com.javaexercise1;
/*19)Create a HashSet of Student. Add all the Student objects including the duplicate Student. Iterate and print the details.
See if HashSet accecpted duplicated. It should replaced the duplicate. */
/*20)Iterate and print the HashSet, see if Insertion order is mainted or not like ArrayList. If not, answer why insertion order was not maintained. 
Ans: Insertion order didn't maintained.Because, in hashset object are stored by hashCode method, which means every object has different identity in the hash bucket.*/
//21)Now, insert the same set of objects in SortedSet (TreeSet). Iterate and print the details. Ensure objects are sorted based on compare logic.
//22)Now, use LinkedHashSet and insert same set of Objects. Iterate and print the details. See if insersation order is maintained or not.
/*23)Now, write the difference between HashSet, SortedSet (TreeSet), and LinkedHashSet. 
Ans: HashSet : do not follow the insertion Order
	 SortedSet : by default it will sort the object.
	 LinkedHashset : It follows the insertion order*/
//29)Insert null in HashSet and see if it works. If works, insert duplicate nulls and check that too.
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSet {

	public HashSet() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Student s1 =new Student(100,"Brindha", 26);
		Student s2 =new Student(101,"Aadvik", 1);
		Student s3 =new Student(102,"Muthu", 30);
		
		LinkedHashSet<Student> hs = new LinkedHashSet<Student>();
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(null);
		hs.add(null);//it accepts null only once, second time it prints only one null.
		hashSetIterator(hs);
		
		Student s4 = new Student(104, "Tintu", 3);
		Student s5 = new Student(104, "Tintu", 3);// it does not allow duplicate values..
		LinkedHashSet<Student> hse = new LinkedHashSet<Student>();
		hse.add(s4);
		hse.add(s5);
		hs.addAll(hse);
		hashSetIterator(hs);
		
		TreeSet<Student> trs =new TreeSet<Student>();
		trs.add(s1);
		trs.add(s2);
		trs.add(s3);
		treeSetIterator(trs);
		
		LinkedHashSet<Student> lhs =new LinkedHashSet<Student>();
		lhs.add(s1);
		lhs.add(s2);
		lhs.add(s3);
		linkedHashSetIterator(lhs);
		
	}
	
	
	public static void hashSetIterator(LinkedHashSet<Student> hsPara){
		System.out.println("Using Iterator (hashset)..!!");
		Iterator i = hsPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public static void treeSetIterator(TreeSet<Student> tsPara){
		System.out.println("Using for each (treeset)..!!");
		for(Student k :tsPara){
			System.out.println(k);
		}
	}
	
	public static void linkedHashSetIterator(LinkedHashSet<Student> lHsPara){
		System.out.println("Using Iterator (linkedhashset)..!!");
		Iterator i = lHsPara.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}

}
