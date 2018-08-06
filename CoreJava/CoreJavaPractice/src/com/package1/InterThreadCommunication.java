package com.package1;

public class InterThreadCommunication extends Thread{
	
	static String pen ="I am pen";
	static String paper ="I am paper";
	 
	public InterThreadCommunication() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				synchronized(pen){
					System.out.println("Thread 1 is holding Pen..!");
					try{
						pen.wait();
						System.out.println(1000);
					}catch(Exception ex){
						ex.printStackTrace();
						System.out.println("exception ex:"+ex);
					}
					pen.notifyAll();
					synchronized(paper){
						System.out.println("Requesting for Paper..!");
					}
				}
			}
		};
		
		Thread t2 =new Thread(){
			public void run(){
				synchronized(paper){
					System.out.println("Thread 2 is holding Paper..!");
					try{
						paper.notifyAll();
					}catch(Exception ex1){
						ex1.printStackTrace();
						System.out.println("Excepiton ex1:"+ex1);
					}
					synchronized(pen){
						System.out.println("Requesting for pen..!");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
