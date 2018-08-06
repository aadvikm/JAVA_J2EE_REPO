package com.package1;

public class ThreadRunnableDemo implements Runnable {

	public ThreadRunnableDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		System.out.println("Runnable Interface Thread Running.!!");
	}

	public static void main(String[] args) {
		ThreadRunnableDemo trd =new ThreadRunnableDemo();
		Thread t1 =new Thread(trd);
		t1.start();
		t1.setPriority(5);
		System.out.println("Thread Priority :"+t1.getPriority());
		

	}

}
