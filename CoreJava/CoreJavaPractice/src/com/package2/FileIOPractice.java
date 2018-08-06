package com.package2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIOPractice {

	public FileIOPractice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try{
			File f=new File("C:/Java_Lessons/FileTemp/msg.txt");
			f.getParentFile().mkdirs();
			f.createNewFile();
			String str ="Hello World!!!";
			FileWriter fw =new FileWriter(f);
			fw.write(str);
			fw.flush();
			System.out.println("Writing in a file is done.!");
			System.out.println("Absolute path :"+f.getAbsolutePath());
			System.out.println("Canonical path :"+f.getCanonicalPath());
			System.out.println("Path :"+f.getPath());
			
			FileReader fr =new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String s;
			while((s=br.readLine()) !=null){
				System.out.println(s);
			}
			
			//Using System Input stream, get value from command promt and print the same. 
			Scanner scan =new Scanner(System.in);
			System.out.println("Pls Enter the Input Stream :");
			String input =scan.nextLine();
			System.out.println("Given Input Stream :"+input);
			
			// Using Buffered Reader, create a file and read and display the same. 
			File f1 =new File("C:/Java_Lessons/FileTemp/Hi.txt");
			f1.createNewFile();
			String in ="Hi..!!!";
			FileWriter fw1 =new FileWriter(f1);
			BufferedWriter bw =new BufferedWriter(fw1);
			bw.write(in);
			bw.flush();
			
			FileReader fr1 =new FileReader(f1);
			BufferedReader br1 =new BufferedReader(fr1);
			String out;
			while((out=br1.readLine())!=null){
				System.out.println(out);
			}
			
			//to copy the content in a msg.file to new file NewMsg.txt
			File f2 =new File("C:/Java_Lessons/FileTemp/NewMsg.txt");
			f2.createNewFile();
			
			FileReader fiRead =new FileReader(f);
			FileWriter fiWrite =new FileWriter(f2);
			int x;
			while((x=fiRead.read())!=-1){
				fiWrite.write(x);
				fiWrite.flush();
				System.out.print((char)x); 
			}
			System.out.println(" ");
			
			//to check if file is already open/close.(Exists or not)
			boolean res =false;
			if(res=f.exists()){
				System.out.println("File f is Exists :"+res);
			}
			else{
				System.out.println("File f is Not Exists :"+res);
			}
			
			//to detele folder and file
			System.out.println(f2.delete());
			if(f.delete()){
				System.out.println(f.getName()+" is deleted.!");
			}
			else{
				System.out.println("Deletion process is failed..!");
			}
			
			//to get a size of a file
			System.out.println("Size of the file f :"+f.length());
		}
		catch(Exception e){
			System.out.println("Exception :"+e);
		}

	}

}
