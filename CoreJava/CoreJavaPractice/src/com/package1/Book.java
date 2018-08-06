package com.package1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Book implements Callable{
	String name;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String name){
		this.name=name;
	}
	public Object call() throws Exception{
		String n =this.name;
		return n;
	}

	public static void main(String[] args) {
		Book b =new Book("Two States");
		Book b1 =new Book("Half a GirlFriend");
		
		ExecutorService es =Executors.newFixedThreadPool(3);
		Future f1 =es.submit(b);
		Future f2 =es.submit(b1);
		try{
			System.out.println("Book 1 :"+f1.get());
			System.out.println("Book 2 :"+f2.get());
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception ex :"+ex);
		}
		es.shutdown();

	}

}
