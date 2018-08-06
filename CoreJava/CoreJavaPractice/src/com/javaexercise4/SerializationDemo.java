package com.javaexercise4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public SerializationDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee(104,"Aadvik",10000.00,"2024,Coolidge Hwy", 10, new Phone(245));
		Employee emp2 = new Employee(111,"Brindha",9000.00,"2020,Coolidge Hwy",20, new Phone(248));
		Employee emp3 = new Employee(105,"Muthu",10500.00,"2021,Coolidge Hwy",30, new Phone(760));
		try{
			File f =new File("Serial.txt");
			FileOutputStream fos =new FileOutputStream(f);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(emp1);
			oos.writeObject(emp2);
			oos.writeObject(emp3);
			oos.flush();
			System.out.println("Serialization done..!");
			
			FileInputStream fis =new FileInputStream(f);
			ObjectInputStream ois =new ObjectInputStream(fis);
			Employee e1 =(Employee)ois.readObject();
			Employee e2 =(Employee)ois.readObject();
			Employee e3 =(Employee)ois.readObject();
			System.out.println(e1);
			System.out.println(e2);
			System.out.println(e3);
			System.out.println("Deserialization done..!");
		}
		catch(Exception e){
			System.out.println("Exception :"+e);
		}
	}

}
