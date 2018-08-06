package com.corejavapractice;
/*85. Write a Java program to check if a string starts with a specified word. Go to the editor
Sample Data: string1 = "Hello how are you?"
Sample Output:

true*/
public class StringStartsWithWord {

	public StringStartsWithWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s ="Hello How Are You..??";
		
		System.out.println("s.startsWith(\"Hello\") :"+s.startsWith("Hello"));
		System.out.println("s.startsWith(\"you\") :"+s.startsWith("you"));
		System.out.println("s.endsWith(\"you\") :"+s.endsWith("You"));
		System.out.println("s.endsWith(\"?\") :"+s.endsWith("?"));
	}

}
