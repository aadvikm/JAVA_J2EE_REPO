package com.javaexercise2;

public class AnonymousDemo {

	public AnonymousDemo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		AnonymousInnerClass ai = new AnonymousInnerClass(){
			public void methodB(){
				System.out.println("From Anonymous Class Method B");
			}
		};
		
		ai.methodA();
		ai.methodB();
		ai.methodC();
		
		AnonymousInnerClass ai2 = new AnonymousInnerClass();
		ai2.methodA();
		ai2.methodB();
		ai2.methodC();
		

	}

}
