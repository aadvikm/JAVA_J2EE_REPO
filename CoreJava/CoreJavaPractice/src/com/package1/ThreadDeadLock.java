package com.package1;

public class ThreadDeadLock extends Thread{
	
	static String firstName ="Aadvik";
	static String lastName ="Muthukumaran";
	
	public ThreadDeadLock() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
			Thread t1 =new Thread(){
				public void run(){
					synchronized(firstName){
						System.out.println("Thread 1 locked "+firstName);
						try{
							Thread.sleep(1000);
						}catch(Exception ex){
							ex.printStackTrace();
							System.out.println("Exception ex:"+ex);
						}
						System.out.println("Thread 1 is waiting for " +lastName+" to be relased");
						synchronized(lastName){
							System.out.println("Thread 1 is locked "+lastName);
						}
					}
				}
			};
		
			Thread t2 =new Thread(){
				public void run(){
					synchronized(lastName){
						System.out.println("Thread 2 is locked "+lastName);
						try{
							Thread.sleep(1000);
						}catch(Exception ex1){
							ex1.printStackTrace();
							System.out.println("Exception ex1 :"+ex1);
						}
						System.out.println("Thread 2 is waiting for " +firstName+" to be released.");
						synchronized(firstName){
							System.out.println("Thread 2 is locked "+firstName);
						}
					}
				}
			};
			
			t1.start();
			t2.start();

	}

}
