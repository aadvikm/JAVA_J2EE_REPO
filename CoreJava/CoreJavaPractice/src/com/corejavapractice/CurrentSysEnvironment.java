package com.corejavapractice;
/*88. Write a Java program to get the current system environment and system properties
 * 89. Write a Java program to check whether a security manager has already been
 *  established for the current application or not.
 *  90. Write a Java program to get the value of the 
 *  environment variable PATH, TEMP, USERNAME. */
public class CurrentSysEnvironment {

	public CurrentSysEnvironment() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Current System Environment :"+System.getenv());
		System.out.println("Current System Properties :"+System.getProperties());
		System.out.println("Security manager is Established or not :"+System.getSecurityManager());
		System.out.println("Current System Environment PATH:"+System.getenv("PATH"));
		System.out.println("Current System Environment TEMP:"+System.getenv("TEMP"));
		System.out.println("Current System Environment USERNAME:"+System.getenv("USERNAME"));
	}

}
