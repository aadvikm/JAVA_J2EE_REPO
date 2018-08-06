package com.package1;

public class ThreadClassDemo extends Thread {

	public ThreadClassDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		System.out.println("Thread Class Running..!!");
	}

	public static void main(String[] args) {
		ThreadClassDemo tr =new ThreadClassDemo();
		tr.start();

	}

}
