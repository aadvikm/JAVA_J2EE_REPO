package com.corejavapractice;

import java.io.Console;

/*42. Write a Java program to input and display your password. Go to the editor
Expected Output

Input your Password:                                                    
Your password was: abc@123
*/
public class DisplayPassword {

	public DisplayPassword() {
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Console con;
		con = System.console();
		if(con !=null){
			char[] pass =null;
			try{
				pass =con.readPassword("Enter your Password :");
				System.out.println("Your Password was :"+new String(pass));
				
			}finally{
				if(pass !=null){
					
					java.util.Arrays.fill(pass,' ');
				}
			}
		}
		else {
			throw new RuntimeException("Can't get password...No console");
		}
		

	}

}
