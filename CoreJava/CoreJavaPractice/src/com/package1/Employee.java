package com.package1;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable, Externalizable {
	private String name;
	private int id;
	private String address;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeExternal(ObjectOutput oOut)throws IOException{
		oOut.writeObject(name);
		oOut.writeInt(id);
		oOut.writeObject(address);
	}
	public void readExternal(ObjectInput oIn) throws IOException, ClassNotFoundException{
		name =(String)oIn.readObject();
		id =oIn.readInt();
		address =(String)oIn.readObject();
	
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address + "]";
	}



	public static void main(String[] args) {
		Employee e =new Employee();
		e.setName("Aadvik");
		e.setId(1001);
		e.setAddress("2024,Coolidge Hwy");
		try{
			FileOutputStream fos =new FileOutputStream("fileEmp.txt");
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(e);
			oos.close();
			fos.close();
			System.out.println("Serialized data saved in fileEmp.txt File.!");
			
			
			FileInputStream fis =new FileInputStream("fileEmp.txt");
			ObjectInputStream ois =new ObjectInputStream(fis);
			Employee e1=(Employee)ois.readObject();
			ois.close();
			System.out.println("Deserialization Done.!");
			System.out.println(e.toString());
			
		}catch(Exception ex){
			System.out.println("Exception: "+ex);
			ex.printStackTrace();
		}
	}
}
