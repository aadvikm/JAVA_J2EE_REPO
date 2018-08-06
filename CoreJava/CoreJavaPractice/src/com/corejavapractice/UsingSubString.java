package com.corejavapractice;
/*72. Write a Java program to create a new string taking first three characters from a given string. If the length of the given string is less than 3 use "#" as substitute characters. Go to the editor
Test Data: Str1 = " "
Sample Output:

###*/
public class UsingSubString {

	public UsingSubString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String a ="";
		int l =a.length();
		if(l>=3){
			System.out.println(a.substring(0, 3));
		}else if(l==1){
			System.out.println(a.charAt(0)+"##");
		}else{
			System.out.println("###");
		}

	}

}
