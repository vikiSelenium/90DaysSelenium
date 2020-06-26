package javaLearning;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		String A = "malayalam";
		String rev ="";
		Scanner obj = new Scanner(System.in);
		String output = obj.next();
		char[] ap = A.toCharArray();
		int total = output.length();
		for (int i=total-1; i>=0;i--) {
			
			rev = rev + A.charAt(i);
			
		}
		if(A.equals(rev))
		{
			System.out.println("The Given String is a palindrome");
		}
		else
		{
			System.out.println("The Given String is not a palindrome");
		}
			
	
		

	}

}
